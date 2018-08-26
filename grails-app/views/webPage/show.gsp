
<%@ page import="weichatapp.WebPage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'webPage.label', default: 'WebPage')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-webPage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-webPage" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list webPage">
			
				<g:if test="${webPageInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="webPage.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${webPageInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${webPageInstance?.content}">
				<li class="fieldcontain">
					<span id="content-label" class="property-label"><g:message code="webPage.content.label" default="Content" /></span>
					
						<span class="property-value" aria-labelledby="content-label"><g:link controller="content" action="show" id="${webPageInstance?.content?.id}">${webPageInstance?.content?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${webPageInstance?.pages}">
				<li class="fieldcontain">
					<span id="pages-label" class="property-label"><g:message code="webPage.pages.label" default="Pages" /></span>
					
						<g:each in="${webPageInstance.pages}" var="p">
						<span class="property-value" aria-labelledby="pages-label"><g:link controller="webPage" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${webPageInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="webPage.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${webPageInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${webPageInstance?.images}">
				<li class="fieldcontain">
					<span id="images-label" class="property-label"><g:message code="webPage.images.label" default="Images" /></span>
					
						<g:each in="${webPageInstance.images}" var="i">
						<span class="property-value" aria-labelledby="images-label"><g:link controller="image" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:webPageInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${webPageInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
