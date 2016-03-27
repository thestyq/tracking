<%--
  Created by IntelliJ IDEA.
  User: styqq
  Date: 04.01.16
  Time: 22:00
--%>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/md5.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="js/data-collector.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AlphaOne</title>
</head>
<body>

<script>

    infoArray = {};

    getResolutionData();
    getBrowserData();

    window.onload = function(){
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