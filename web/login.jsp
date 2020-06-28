<%--
  Created by IntelliJ IDEA.
  User: murongyunge
  Date: 2020/5/27
  Time: 下午2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>首页</title>
  </head>
  <body>
      <h3>假面骑士迷测试现场！！！</h3>
      <p>请输入 Kamen Rider Drive 男女主：</p>
      <form action="${pageContext.request.contextPath}/admin/login.form" method="post">
          男主：<input type="text" name="maleOwner"/><br/>
          女主：<input type="text" name="femaleOwner"/><br/>
          <input type="submit" value="submit"/>
      </form>
  </body>
</html>
