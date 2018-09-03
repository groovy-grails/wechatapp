import weichatapp.Image
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_wechatapp_imageedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/image/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'image.label', default: 'Image'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(15)
expressionOut.print(error.field)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',26,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',27,['bean':(imageInstance),'var':("error")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',29,['bean':(imageInstance)],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('hiddenField','g',31,['name':("version"),'value':(imageInstance?.version)],-1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: imageInstance, field: 'name', 'error'))
printHtmlPart(22)
invokeTag('message','g',35,['code':("image.name.label"),'default':("Name")],-1)
printHtmlPart(23)
invokeTag('textField','g',38,['name':("name"),'maxlength':("255"),'value':(imageInstance?.name),'readonly':("readonly")],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: imageInstance, field: 'webPage', 'error'))
printHtmlPart(25)
invokeTag('message','g',44,['code':("image.webPage.label"),'default':("Web Page")],-1)
printHtmlPart(23)
invokeTag('select','g',47,['id':("webPage"),'name':("webPage.id"),'from':(weichatapp.WebPage.list()),'optionKey':("id"),'required':(""),'value':(imageInstance?.webPage?.id),'class':("many-to-one")],-1)
printHtmlPart(26)
invokeTag('actionSubmit','g',52,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(27)
})
invokeTag('form','g',54,['url':([resource:imageInstance, action:'update']),'method':("PUT")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1535213904644L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
