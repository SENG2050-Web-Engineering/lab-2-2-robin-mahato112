<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
  <title>UniX — Select Semester</title>
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
      <h1 class="title">Select a Semester (Open for Enrolment)</h1>

      <c:if test="${not empty error}">
        <div class="alert danger">${error}</div>
      </c:if>

      <form method="post" action="${pageContext.request.contextPath}/semesters">
        <table>
          <thead>
            <tr>
              <th>Select</th>
              <th>Semester</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="s" items="${semesters}">
              <tr>
                <td>
                  <input type="radio" name="semesterId" value="${s.id}" ${s.open ? "" : "disabled"} />
                </td>
                <td>${s.name}</td>
                <td>
                  <span class="badge ${s.open ? "open" : "closed"}">${s.open ? "Open" : "Closed"}</span>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>

        <div class="row" style="margin-top:12px;justify-content:flex-end;">
          <button class="btn primary" type="submit">Continue</button>
        </div>
      </form>

      <div class="small" style="margin-top:10px;">
        Note: This is a Sprint 2 mock-up using dummy data (no database yet).
      </div>
    </div>
  </div>
</body>
</html>
