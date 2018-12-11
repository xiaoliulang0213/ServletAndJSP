<%@tag description="html自定义标签" pageEncoding="UTF-8" %>
<%@attribute name="title" %>
<html>
    <head>
        <title>${title}</title>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    </head>
    <body>
        <jsp:doBody/>
    </body>
</html>