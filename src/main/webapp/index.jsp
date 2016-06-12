<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>
<script src="js/data-collector.js"></script>
<script src="js/font-detect.js"></script>
<script src="evercookie/js/evercookie.js"></script>

<html>
<head>
    <title>AlphaOne</title>
</head>
<body>
Please wait...
<script>
    infoArray = {};

    // resolution
    resolution = {};
    getResolutionData();

    // browser model
    browserData = {};
    getBrowserData();

    // fonts
    fonts = {};
    fontArray = [];
    <c:import var="fonts_data" url="data/fonts.txt"/>
    <c:set var="fonts" value="${fn:split(fonts_data, newLineChar)}" />
    <c:forEach var="font" items="${fonts}">
    detectFont("${font}");
    </c:forEach>
    fonts["fonts"] = fontArray;

    // addonArray
    addons = {};
    addonArray = [];
    if (browserData["isFirefox"]) {
        <c:import var="firefox_addons_data" url="data/firefox_addons.txt"/>
        <c:set var="firefox_addons" value="${fn:split(firefox_addons_data, newLineChar)}" />
        <c:forEach var="firefox_addon" items="${firefox_addons}">
        detectFirefoxAddon("${firefox_addon}");
        </c:forEach>
        fonts["addons"] = addonArray;
    }

    // geo localisation
    localisation = {};
    getLocalisation();

    window.onload = function () {
        infoArray["resolution"] = JSON.stringify(resolution, null, 2);
        infoArray["browserData"] = JSON.stringify(browserData, null, 2);
        infoArray["fonts"] = JSON.stringify(fonts, null, 2);
        infoArray["addons"] = JSON.stringify(addons, null, 2);
        infoArray["localisation"] = JSON.stringify(localisation, null, 2);

        // cookie from evercookie
        var ec = new Evercookie({phpuri: "/evercookie/php", asseturi: "/evercookie/assets", history: false});
        var cookieId = "tracking_test4";
        var cookiePrefix = "TC_";
        ec.get(cookieId, function (value) {
            if (value.startsWith(cookiePrefix)) {
                infoArray["oldCookie"] = value.substring(cookiePrefix.length);
            }
            $.ajax({
                url: '/save',
                type: 'POST',
                data: infoArray,
                success: function(data) {
                    document.open();
                    document.write(data);
                    document.close();
                }
            });
        });

    }

</script>
</body>
</html>