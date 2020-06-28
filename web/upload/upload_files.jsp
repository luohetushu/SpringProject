<%--
  Created by IntelliJ IDEA.
  User: murongyunge
  Date: 2020/5/27
  Time: 下午2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
  <head>
      <title>上传单个文件</title>
  </head>
  <body>
      <form action="${pageContext.request.contextPath}/upload/files.form" method="post" enctype="multipart/form-data">
          文件：<input type="file" name="file"/>
          <br/>
          文件：<input type="file" name="file"/>
          <br/>
          文件：<input type="file" name="file"/>
          <br/>
          <input type="submit" value="upload"/>
      </form>
  </body>
</html>
