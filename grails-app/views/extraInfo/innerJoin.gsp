<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.04.2021
  Time: 3:16
--%>
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
        <h2 style="margin-left: 20px">Запрос с Inner Join</h2>
    </div>

    <form class="form" style="margin-left: 20px">
        Вывести всех пользователей, заинтерисованных в паре в своем городе
        <input type="submit" value="Обновить">
    </form>

    <div id="list-users" class="content scaffold-list" role="main">
        <h1><g:message code="default.list.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <f:table collection="${results}" />

        <div class="pagination">
            <g:paginate total="${resultCount ?: 0}" />
        </div>
    </div>
</div>
</body>
</html>