<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ param.department} 학과 조회</title>
<style>


#result-table{
	border-collapse : collapse;
}
thead th{
	background-color : black;
	color : white;
	padding : 5px 30px;
}

tbody td:not(:nth-child(5)){
	text-align : center;
}

tbody > tr:nth-child(2n) td{
	background-color: #ddd;
}

tbody > tr:hover > td {
	background-color: #B1AFFF;
	cursor : pointer
}
</style>
</head>
<body>
		
		<h1>[${param.department}]학과 검색 결과</h1>
		<c:if test="${!empty stdList}">
		<table id="result-table">
			<thead>
				<tr>
					<th>순서</th>
					<th>학번</th>
					<th>이름</th>
					<th>학과</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${stdList}" varStatus="vs">
					<tr>
						<td>${vs.count}</td>
						<td>${student.studentNo}</td>
						<td>${student.studentName}</td>
						<td>${student.departmentName}</td>
						<td>${student.studentAddress}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${empty stdList}">
		<h2>검색 결과가 없습니다.</h2>
		</c:if>
</body>
</html>