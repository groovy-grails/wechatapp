package weichatapp

class Image {

	static belongsTo = [webPage: WebPage]
	String name
	String middle
	String small
	String ext
    static constraints = {
		name(nullable:false,blank:false,size:0..255,display:true)
		middle(nullable:true,blank:true,size:0..255,display:false)
		small(nullable:true,blank:true,size:0..255,display:false)
		ext(nullable:true,blank:true,size:0..32,display:false)
    }
	@Override
	public String toString() {
		return name
	}
}
