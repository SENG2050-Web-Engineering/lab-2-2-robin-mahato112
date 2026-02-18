<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
  <title>UniX — Login</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
  <div class="topbar">
    <div class="brand">UniX</div>
    <div class="muted">Student Course Enrolment</div>
  </div>

  <div class="container">
    <div class="card" style="max-width:520px;margin:0 auto;">
      <h1 class="title">Login</h1>

      <c:if test="${not empty error}">
        <div class="alert danger">${error}</div>
      </c:if>

      <form method="post" action="${pageContext.request.contextPath}/login" class="grid">
        <div class="grid">
          <label for="username">Username / Student ID</label>
          <input id="username" name="username" type="text" placeholder="e.g., student1" />
        </div>

        <div class="grid">
          <label for="password">Password</label>
          <input id="password" name="password" type="password" placeholder="password" />
          <div class="small">Demo accounts: <b>student1</b>/<b>password</b> or <b>s123456</b>/<b>password</b></div>
        </div>

        <div class="row" style="justify-content:space-between;">
          <a class="btn" href="#" onclick="alert('Not implemented in Sprint 2 mock-up'); return false;">Forgot password?</a>
          <button class="btn primary" type="submit">Login</button>
        </div>
      </form>
    </div>
  </div>

  <script>
    // tiny progressive enhancement: show/hide password on double click
    const pw = document.getElementById('password');
    pw.addEventListener('dblclick', () => {
      pw.type = (pw.type === 'password') ? 'text' : 'password';
    });
  </script>
</body>
</html>
