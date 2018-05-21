<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet" type="text/css" href="${path}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${path}/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${path}/css/demo.css">
<link rel="stylesheet" type="text/css" href="${path}/themes/default/pagination.css">

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<base href="<%=basePath%>">