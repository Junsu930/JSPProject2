<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 조회</title>
<style>
table {
  border-collapse: separate;
  border-spacing: 0;
  border: 0;
}
th,
td {
  padding: 6px 15px;
  border: 0;
}
th {
  background: black;
  color: white;
}
tr:first-child th:first-child {
  border-top-left-radius: 6px;
}
tr:first-child th:last-child {
  border-top-right-radius: 6px;
}

tr:nth-child(odd) td {
  background-color:silver;
}
tr:last-child td:first-child {
  border-bottom-left-radius: 6px;
}
tr:last-child td:last-child {
  border-bottom-right-radius: 6px;
}
</style>
</head>
<body>
		
		<h1>[${param.department}]학과 검색 결과</h1>
		<c:if test="${!empty stdList}">
		<table border="1">
			<tr>
				<th>순서</th>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>주소</th>
			</tr>
			<c:forEach var="student" items="${stdList}" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${student.studentNo}</td>
					<td>${student.studentName}</td>
					<td>${student.departmentName}</td>
					<td>${student.studentAddress}</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<c:if test="${empty stdList}">
		<h2>검색 결과가 없습니다.</h2>
		</c:if>
</body>
</html>