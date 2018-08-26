<%@ page import="weichatapp.WebPage" %>



<div class="fieldcontain ${hasErrors(bean: webPageInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="webPage.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="title" cols="40" rows="5" maxlength="255" required="" value="${webPageInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: webPageInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="webPage.content.label" default="Content" />
		
	</label>
	<g:select id="content" name="content.id" from="${weichatapp.Content.list()}" optionKey="id" value="${webPageInstance?.content?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: webPageInstance, field: 'pages', 'error')} ">
	<label for="pages">
		<g:message code="webPage.pages.label" default="Pages" />
		
	</label>
	<g:select name="pages" from="${weichatapp.WebPage.list()}" multiple="multiple" optionKey="id" size="5" value="${webPageInstance?.pages*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: webPageInstance, field: 'images', 'error')} ">
	<label for="images">
		<g:message code="webPage.images.label" default="Images" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${webPageInstance?.images?}" var="i">
    <li><g:link controller="image" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="image" action="create" params="['webPage.id': webPageInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'image.label', default: 'Image')])}</g:link>
</li>
</ul>


</div>

