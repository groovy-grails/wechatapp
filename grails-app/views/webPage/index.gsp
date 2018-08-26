
<%@ page import="weichatapp.WebPage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'webPage.label', default: 'WebPage')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-webPage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-webPage" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'webPage.title.label', default: 'Title')}" />
					
						<th><g:message code="webPage.content.label" default="Content" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'webPage.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${webPageInstanceList}" status="i" var="webPageInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${webPageInstance.id}">${fieldValue(bean: webPageInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: webPageInstance, field: "content")}</td>
					
						<td><g:formatDate date="${webPageInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${webPageInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
