<%@ page import="com.liuxiaonian.demo.data.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/11/20
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="util" uri="http://com.liuxiaonian.El.Util" %>
<%--<%@ page isELIgnored="false" %>--%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        ${param.a}+${param.b}=${param.a+param.b}
        ${pageContext.request.remoteAddr}<br/>
        <%
            User user = new User();
            user.setUserName("张飞");
            request.setAttribute("user",user);
        %>
        第一种方式:${user.userName}<br/>
        第二种方式:${user["userName"]}<br/>

        <%
            Map<String,String> param = new HashMap<>();
            param.put("name","关羽");
            request.setAttribute("parameter",param);
        %>
        第一种方式:${parameter.name}<br/>
        第二种方式:${parameter["name"]}<br/>

        <%
            String[] arr =new String[1];
            arr[0] = "刘备";
            List<String> list = new ArrayList<>();
            list.add("曹操");
            request.setAttribute("arr",arr);
            request.setAttribute("list",list);
        %>
        数组:${arr[0]}<br/>
        列表:${list[0]}<br/>
        <!--EL自定义标签库-->
        ${util:getLength(requestScope.list)}
    </body>
</html>
