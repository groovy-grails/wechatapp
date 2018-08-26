<%@ page import="weichatapp.Content" %>



<div class="fieldcontain ${hasErrors(bean: contentInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="content.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="content" cols="40" rows="5" maxlength="8000" required="" value="${contentInstance?.content}"/>

</div>

