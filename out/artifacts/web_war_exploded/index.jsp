<%--
  Created by IntelliJ IDEA.
  User: styqq
  Date: 04.01.16
  Time: 22:00
--%>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/md5.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AlphaOne</title>
</head>
<body>
<script>
  var resolutionArray = {
    window_screen_height: window.screen.height,
    window_screen_width: window.screen.width,
    window_screen_availHeight: window.screen.availHeight,
    window_screen_availWidth: window.screen.availWidth,
    window_innerHeight: window.innerHeight,
    window_innerWidth: window.innerWidth,
    window_screenLeft: window.screenLeft,
    window_screenTop: window.screenTop
  };

  $.ajax({
    url: '/save',
    type: 'POST',
    data: resolutionArray
  });
</script>
Thanks!
</body>
</html>