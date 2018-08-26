<%@ page import="weichatapp.Image" %>



<div class="fieldcontain ${hasErrors(bean: imageInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="image.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<input type=file name="name" size="25" />

</div>

<div class="fieldcontain ${hasErrors(bean: imageInstance, field: 'webPage', 'error')} required">
	<label for="webPage">
		<g:message code="image.webPage.label" default="Web Page" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="webPage" name="webPage.id" from="${weichatapp.WebPage.list()}" optionKey="id" required="" value="${imageInstance?.webPage?.id}" class="many-to-one"/>

</div>

