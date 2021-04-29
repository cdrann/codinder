<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.05.2021
  Time: 4:01
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'queries.label', default: 'Query')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>
<div>
    <div>
        <h2>Запрос с HAVING и подзапросом</h2>
    </div>
    <form class="form">
        Вывести пользователей из каждого города, у которых возраст выше среднего по городу
        <input type="submit" value="Обновить">
    </form>

    <div id="list-users" class="content scaffold-list" role="main">
        <h1><g:message code="default.list.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <g:each in="${results}" var="result">
            <div style="background-color: #FFFFFF">
                City: <a href="/department/show/${result.key.id}">${result.key}</a>
            </div>
            <f:table collection="${result.value}"/>
            <br>
        </g:each>
    </div>
</div>
</body>
</html>