<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>

<html>
<head>
    <title>Phase one</title>

    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>
    <script type="text/javascript" src="js/data-collector.js"></script>
    <script type="text/javascript" src="js/font-detect.js"></script>
    <script type="text/javascript" src="js/evercookie/js/evercookie.js"></script>
    <script type="text/javascript" src="js/PluginDetect.js"></script>
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

    // plugins
    plugins = {};
    <c:import var="plugins_data" url="data/plugins.txt"/>
    <c:set var="plugins" value="${fn:split(plugins_data, newLineChar)}" />
    <c:forEach var="plugin" items="${plugins}">
    detectPlugin("${plugin}");
    </c:forEach>

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
        addons["addons"] = addonArray;
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
        infoArray["plugins"] = JSON.stringify(plugins, null, 2);

        // cookie from evercookie
        var ec = new Evercookie({phpuri: "/evercookie/php", asseturi: "/evercookie/assets", history: false});
        var cookieId = "tracking";
        var cookiePrefix = "TC_";
        ec.get(cookieId, function (value) {
            if (value.startsWith(cookiePrefix)) {
                infoArray["oldCookie"] = value.substring(cookiePrefix.length);
            }
            var ctx = "${pageContext.request.contextPath}";
            $.ajax({
                url: ctx + "/save",
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

<noscript>
    Please enable JavaScript.
</noscript>
</body>
</html>