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
    <c:import var="fonts_data" url="data/fonts.txt"/>
    <c:set var="fonts" value="${fn:split(fonts_data, newLineChar)}" />
    <c:forEach var="font" items="${fonts}">
        detectFont("${font}");
    </c:forEach>
    infoArray["fonts"] = fontArray.toString();

    // addons
    addons = [];
    if (infoArray["isFirefox"]) {
        <c:import var="firefox_addons_data" url="data/firefox_addons.txt"/>
        <c:set var="firefox_addons" value="${fn:split(firefox_addons_data, newLineChar)}" />
        <c:forEach var="firefox_addon" items="${firefox_addons}">
            detectFirefoxAddon("${firefox_addon}");
        </c:forEach>
    }

    window.onload = function () {
        infoArray["addons"] = addons.toString();
        console.log(addons);
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