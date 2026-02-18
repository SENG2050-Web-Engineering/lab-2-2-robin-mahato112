<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
  <title>UniX — Enrol in Courses</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
  <div class="topbar">
    <div class="brand">UniX</div>
    <div class="row">
      <div class="muted">Semester: <b>${semester.name}</b></div>
      <a class="btn" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
  </div>

  <div class="container">
    <div class="card">
      <h1 class="title">Enrol in Courses</h1>

      <c:if test="${not empty error}">
        <div class="alert danger">${error}</div>
      </c:if>

      <c:choose>
        <c:when test="${empty courses}">
          <div class="alert danger">No courses are offered for this semester (dummy data).</div>
          <div class="row" style="justify-content:flex-end;">
            <a class="btn" href="${pageContext.request.contextPath}/semesters">Back to Semesters</a>
          </div>
        </c:when>
        <c:otherwise>
          <form method="post" action="${pageContext.request.contextPath}/enrol">
            <div class="row" style="margin-bottom:12px;">
              <input id="q" type="search" placeholder="Search by code or name…" oninput="filterCourses(this.value)" />
              <span class="small">Tip: search is client-side only (mock-up)</span>
            </div>

            <table id="courseTable">
              <thead>
                <tr>
                  <th>Select</th>
                  <th>Code</th>
                  <th>Course</th>
                  <th>Units</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="c" items="${courses}">
                  <tr>
                    <td><input type="checkbox" name="courseCode" value="${c.code}" /></td>
                    <td>${c.code}</td>
                    <td>${c.name}</td>
                    <td>${c.units}</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>

            <div class="row" style="margin-top:12px;justify-content:space-between;">
              <a class="btn" href="${pageContext.request.contextPath}/semesters">Back to Semesters</a>
              <button class="btn primary" type="submit">Enrol</button>
            </div>

            <div class="small" style="margin-top:10px;">
              Server-side validation in this mock-up: you must select at least one course; maximum 12 units.
            </div>
          </form>
        </c:otherwise>
      </c:choose>
    </div>
  </div>

  <script>
    function filterCourses(q) {
      q = (q || "").toLowerCase();
      const rows = document.querySelectorAll("#courseTable tbody tr");
      rows.forEach(r => {
        const txt = r.innerText.toLowerCase();
        r.style.display = txt.includes(q) ? "" : "none";
      });
    }
  </script>
</body>
</html>
