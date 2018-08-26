package weichatapp

import javax.servlet.ServletOutputStream

class UploadController {

	static allowedMethods = [index: "GET"]
	
    def index() { 
		def filename=params["filename"]
		println "filename="+filename
		def path=request.getSession().getServletContext().getRealPath("/")
		def filePath=path+"/uploads/"
		def url=new File(filePath+filename)
		response.setContentType("image/jpeg;");
		BufferedInputStream bis = null;
		ServletOutputStream sout = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(url));
			byte[] buffer = new byte[1024*8];
			int result = -1;
			sout = response.getOutputStream();
			while((result = bis.read(buffer)) != -1){
				sout.write(buffer,0,result);
			}
			sout.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(bis!=null)bis.close();
				if(sout!=null)sout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}
}
