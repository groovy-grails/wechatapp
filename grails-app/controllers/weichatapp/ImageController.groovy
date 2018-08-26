package weichatapp


import org.springframework.web.multipart.commons.CommonsMultipartFile
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ImageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Image.list(params), model:[imageInstanceCount: Image.count()]
    }

    def show(Image imageInstance) {
        respond imageInstance
    }

    def create() {
        respond new Image(params)
    }

    @Transactional
    def save() {
//        if (imageInstance == null) {
//            notFound()
//            return
//        }
//
//        if (imageInstance.hasErrors()) {
//            respond imageInstance.errors, view:'create'
//            return
//        }

		//sunjhui add at 20180825
//		request.properties.each{name,value->
//			println name+"="+value
//		   }
		
		Image imageInstance=new Image()
		def errorflag=false
		def errormsg="文件不是图片文件！"
		CommonsMultipartFile downloadedfile = request.getFile('name');
		def path=request.getSession().getServletContext().getRealPath("/")
		def filePath=path+"/uploads/"
		def dir=new File(filePath)
		if(!dir.isDirectory()){
			dir.mkdir()
		}
		Random rand = new Random()
		def randStr=rand.nextInt(1000000)
		def fileName=new Date().getTime()+"-"+randStr
		def oFileName=downloadedfile.getOriginalFilename()
		
		if(oFileName.lastIndexOf(".")!=-1){
			imageInstance.ext=oFileName.substring(oFileName.lastIndexOf(".")+1).toLowerCase()
			def ext=imageInstance.ext.toLowerCase()
			if("png".equals(ext)||"jpg".equals(ext)||"jpeg".equals(ext)||"gif".equals(ext)||"bmp".equals(ext)){}else{
				errorflag=true
			}
		}else{
			errorflag=true
		}
		if(errorflag){
			flash.message = errormsg
			redirect imageInstance
		}else{
		
		def lastfileName=filePath+fileName+"."+imageInstance.ext
		imageInstance.name=fileName+"."+imageInstance.ext
		WebPage webpage=WebPage.get(params.webPage.id)
		webpage.addToImages(imageInstance)
		
		def fos= new FileOutputStream(new File(lastfileName))
		downloadedfile.getBytes().each{ fos.write(it) }
		
        imageInstance.save flush:true
		if (!imageInstance.save()) {
			imageInstance.errors.each {
				System.out.println( it )
			}
		}
		}
		
        render(view: "show", model: [imageInstance: imageInstance])
    }

    def edit(Image imageInstance) {
        respond imageInstance
    }

    @Transactional
    def update(Image imageInstance) {
        if (imageInstance == null) {
            notFound()
            return
        }

        if (imageInstance.hasErrors()) {
            respond imageInstance.errors, view:'edit'
            return
        }
		
        imageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Image.label', default: 'Image'), imageInstance.id])
                redirect imageInstance
            }
            '*'{ respond imageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Image imageInstance) {

        if (imageInstance == null) {
            notFound()
            return
        }

        imageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Image.label', default: 'Image'), imageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'image.label', default: 'Image'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
