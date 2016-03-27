<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="js/data-collector.js"></script>
<script src="js/fontdetect.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<html>
<head>
    <title>AlphaOne</title>
</head>
<body>

<script>
    infoArray = {};

    // resolution
    getResolutionData();

    // browser model
    getBrowserData();

    // fonts
    fontArray = [];
    <c:import var="data" url="fonts.txt"/>
    <c:set var="fonts" value="${fn:split(data, newLineChar)}" />
    <c:forEach var="font" items="${fonts}">
        detectFont("${font}");
    </c:forEach>
    infoArray["fonts"] = fontArray.toString();
    console.log(infoArray["fonts"]);

    window.onload = function () {
        $.ajax({
            url: '/save',
            type: 'POST',
            data: infoArray
        });
    }

</script>
Thanks!
</body>
</html>