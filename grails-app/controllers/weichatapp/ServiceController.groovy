package weichatapp

//import grails.converters.JSON

class ServiceController {

    def index() {
		
		WebPage page=null
		if(null.equals(params.id)){//首页
			page=WebPage.first()
		}else{//子页面
			page=WebPage.get(params.id)
		}
		
		render(contentType: "application/json") {
			id=page.id
			title=page.title
		    images = array {
	            for (b in page.images) {
	                element b.name
	            }
	        }
		    content = page.content?.content
		    pages = array {
	            for (b in page.pages) {
	               subpage id : b.id , title : b.title , images : array {
					   for (p in b.images) {
						   element p.name
					   }
				   }
				    
	            }
	        }
		}
	
	}
}
