<%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/5/18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src = "../../js/jquery-3.2.1.js"></script>
    <body>
        <button id="button" type="button" onclick="test()">Click</button>
    </body>
<script type="text/javascript">
    function test(){
        $.ajax({
            type: 'get',
            url: '/ServletAndJSP/ajax',
            success: function (data) {
                //获取值
                var name = data.name;
                //获取键
                for (var key in data){
                    var key = key
                }
            }
        })
    }
</script>
</html>
