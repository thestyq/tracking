<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>
<script src="../evercookie/js/evercookie.js"></script>

<html>
<head>
    <title>AlphaTwo</title>
</head>
<body>
<script>
    // save cookie
    var ec = new Evercookie({phpuri:"/evercookie/php", asseturi:"/evercookie/assets", history:false});
    var cookieId = "tracking";
    var cookiePrefix = "TC_";
    var cookie = "${param.cookie}";
    ec.set(cookieId, cookiePrefix + cookie);
    document.write("Thanks! <br>");
    document.write("Your fingerprint: " + cookie);
</script>
</body>
</html>
