<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SpringMVC</title>
    </head>
    <body>
        ${annotate}
        <br/>
        ${requestScope.annotate}
        <br/>
        ${sessionScope.annotate}
        <br/>
        ${applicationScope.annotate}
    </body>
</html>