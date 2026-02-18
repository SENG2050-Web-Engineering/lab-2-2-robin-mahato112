<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
  <head>
    <title>UniX — Session Expired</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/style.css"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  </head>
  <body>
    <div class="topbar">
      <div class="brand">UniX</div>
      <div class="muted">Student Course Enrolment</div>
    </div>

    <div class="container">
      <div class="card" style="max-width: 720px; margin: 0 auto">
        <h1 class="title">Session expired / Access denied</h1>
        <div class="alert danger">
          Your session has expired or you are not logged in.
        </div>
        <div class="row" style="justify-content: flex-end">
          <a class="btn primary" href="${pageContext.request.contextPath}/login"
            >Go to Login</a
          >
        </div>
        <div class="small" style="margin-top: 10px">
          For security, please log in again.
        </div>
      </div>
    </div>
  </body>
</html>
