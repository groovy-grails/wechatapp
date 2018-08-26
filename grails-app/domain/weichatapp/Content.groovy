package weichatapp

class Content {

	String content
    static constraints = {
		content(nullable:false,blank:false,size:0..8000,widget:'textarea',display:true)
    }
	@Override
	public String toString() {
		String subContent="";
		if(!null.equals(content)){
			subContent=content.substring(0, content.length()>200?200:content.length())+"...";
		}
		return subContent;
	}
}
