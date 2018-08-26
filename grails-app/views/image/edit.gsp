<%@ page import="weichatapp.Image" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'image.label', default: 'Image')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-image" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-image" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${imageInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${imageInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form  url="[resource:imageInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${imageInstance?.version}" />
				<fieldset class="form">
					<div class="fieldcontain ${hasErrors(bean: imageInstance, field: 'name', 'error')} required">
						<label for="name">
							<g:message code="image.name.label" default="Name" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="name" maxlength="255" value="${imageInstance?.name}" readonly="readonly" />
					
					</div>
					
					<div class="fieldcontain ${hasErrors(bean: imageInstance, field: 'webPage', 'error')} required">
						<label for="webPage">
							<g:message code="image.webPage.label" default="Web Page" />
							<span class="required-indicator">*</span>
						</label>
						<g:select id="webPage" name="webPage.id" from="${weichatapp.WebPage.list()}" optionKey="id" required="" value="${imageInstance?.webPage?.id}" class="many-to-one"/>
					
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
