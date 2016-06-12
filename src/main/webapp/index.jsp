<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>
<script src="js/data-collector.js"></script>
<script src="js/font-detect.js"></script>
<script src="evercookie/js/evercookie.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<html>
<head>
    <title>AlphaOne</title>
</head>
<body>
Please wait...
<script>
    infoArray = {};

    // resolution
    getResolutionData();

    // cookie from evercookie
    var ec = new Evercookie({phpuri: "/evercookie/php", asseturi: "/evercookie/assets", history: false});
    var cookieId = "tracking_test4";
    var cookiePrefix = "TC_";

    // browser model
    getBrowserData();

    // fonts
    fontArray = [];
    <c:import var="fonts_data" url="data/fonts.txt"/>
    <c:set var="fonts" value="${fn:split(fonts_data, newLineChar)}" />
    <c:forEach var="font" items="${fonts}">
    detectFont("${font}");
    </c:forEach>

    // addons
    addons = [];
    if (infoArray["isFirefox"]) {
        <c:import var="firefox_addons_data" url="data/firefox_addons.txt"/>
        <c:set var="firefox_addons" value="${fn:split(firefox_addons_data, newLineChar)}" />
        <c:forEach var="firefox_addon" items="${firefox_addons}">
        detectFirefoxAddon("${firefox_addon}");
        </c:forEach>
    }

    // geo localisation
    var localisation;
    $.getJSON('//www.geoplugin.net/json.gp?jsoncallback=?', function (data) {
        localisation = JSON.stringify(data, null, 2);
    });

    window.onload = function () {
        infoArray["fonts"] = fontArray.toString();
        infoArray["addons"] = addons.toString();
        infoArray["localisation"] = localisation;
        ec.get(cookieId, function (value) {

            if (value.startsWith(cookiePrefix)) {
                infoArray["oldCookie"] = value.substring(cookiePrefix.length);
            }
            console.log(value);
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