<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
  <title>UniX — Enrolment Confirmation</title>
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
      <h1 class="title">Enrolment Successful</h1>
      <div class="alert ok">Your enrolment has been recorded (mock-up).</div>

      <div class="muted" style="margin-bottom:10px;">
        Semester: <b>${sessionScope.selectedSemester.name}</b>
      </div>

      <c:choose>
        <c:when test="${empty sessionScope.enrolledCourses}">
          <div class="alert danger">No enrolled courses found in session.</div>
        </c:when>
        <c:otherwise>
          <table>
            <thead>
              <tr>
                <th>Code</th>
                <th>Course</th>
                <th>Units</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="c" items="${sessionScope.enrolledCourses}">
                <tr>
                  <td>${c.code}</td>
                  <td>${c.name}</td>
                  <td>${c.units}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:otherwise>
      </c:choose>

      <div class="row" style="margin-top:12px;justify-content:flex-end;">
        <a class="btn" href="${pageContext.request.contextPath}/enrol">Enrol in More Courses</a>
        <a class="btn" href="${pageContext.request.contextPath}/semesters">Back to Semesters</a>
      </div>
    </div>
  </div>
</body>
</html>
