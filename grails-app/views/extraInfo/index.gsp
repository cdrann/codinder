<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.04.2021
  Time: 2:54
--%>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="go back" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>


<div style="margin-left: 40px">
    <div class="fieldcontain required">
        <a href="filteringAndSorting">Фильтры и сортировка</a>
    </div>
    <div>
        <a class="fieldcontain required" href="groupBy">Group by</a>
    </div>
    <div>
        <a class="fieldcontain required" href="having">Having</a>
    </div>
    <div>
        <a class="fieldcontain required" href="innerJoin">Inner Join</a>
    </div>
    <div>
        <a class="fieldcontain required" href="outerJoin">Outer Join</a>
    </div>
</div>
</body>
</html>