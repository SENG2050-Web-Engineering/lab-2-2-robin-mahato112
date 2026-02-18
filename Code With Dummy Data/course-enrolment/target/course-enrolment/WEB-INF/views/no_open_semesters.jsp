<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
  <title>UniX — No Open Semesters</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
  <div class="topbar">
    <div class="brand">UniX</div>
    <div class="row">
      <div class="muted">Welcome, <b>${sessionScope.username}</b></div>
      <a class="btn" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
  </div>

  <div class="container">
    <div class="card">
      <h1 class="title">No Semesters Open</h1>
      <div class="alert danger">No semesters are currently open for enrolment.</div>

      <div class="row" style="justify-content:flex-end;">
        <a class="btn" href="${pageContext.request.contextPath}/semesters">Refresh</a>
        <a class="btn" href="${pageContext.request.contextPath}/logout">Logout</a>
      </div>
    </div>
  </div>
</body>
</html>
