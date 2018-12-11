<%@ tag description="显示错误信息" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.value==123}">
    <h1>错误信息:</h1>
    <ul style="color: red">
        ${param.value}
    </ul>
</c:if>

