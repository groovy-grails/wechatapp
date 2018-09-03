import weichatapp.WebPage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_wechatapp_webPage_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/webPage/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: webPageInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("webPage.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textArea','g',10,['name':("title"),'cols':("40"),'rows':("5"),'maxlength':("255"),'required':(""),'value':(webPageInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: webPageInstance, field: 'content', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("webPage.content.label"),'default':("Content")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("content"),'name':("content.id"),'from':(weichatapp.Content.list()),'optionKey':("id"),'value':(webPageInstance?.content?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: webPageInstance, field: 'pages', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("webPage.pages.label"),'default':("Pages")],-1)
printHtmlPart(5)
invokeTag('select','g',28,['name':("pages"),'from':(weichatapp.WebPage.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(webPageInstance?.pages*.id),'class':("many-to-many")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: webPageInstance, field: 'images', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("webPage.images.label"),'default':("Images")],-1)
printHtmlPart(8)
for( i in (webPageInstance?.images) ) {
printHtmlPart(9)
createTagBody(2, {->
expressionOut.print(i?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("image"),'action':("show"),'id':(i.id)],2)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'image.label', default: 'Image')]))
})
invokeTag('link','g',43,['controller':("image"),'action':("create"),'params':(['webPage.id': webPageInstance?.id])],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1535184753293L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
