import weichatapp.Image
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_wechatapp_image_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/image/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: imageInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("image.name.label"),'default':("Name")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: imageInstance, field: 'webPage', 'error'))
printHtmlPart(3)
invokeTag('message','g',16,['code':("image.webPage.label"),'default':("Web Page")],-1)
printHtmlPart(4)
invokeTag('select','g',19,['id':("webPage"),'name':("webPage.id"),'from':(weichatapp.WebPage.list()),'optionKey':("id"),'required':(""),'value':(imageInstance?.webPage?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1535204172943L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
