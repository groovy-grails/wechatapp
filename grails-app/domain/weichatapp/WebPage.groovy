package weichatapp

import java.util.Date;

class WebPage {

	static hasMany = [pages:WebPage,images: Image]
	String title
	Content content
	Date dateCreated
    static constraints = {
		title(nullable:false,blank:false,size:0..255,display:true)
		content(nullable:true,blank:true,display:true)
		pages(nullable:true,blank:true)
    }
	@Override
	public String toString() {
		return title
	}
}
