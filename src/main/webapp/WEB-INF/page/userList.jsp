<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Management</title>
<link rel="stylesheet"
	href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/productList.css"/>">
</head>
<body>
<sql:setDataSource
        var="myDS"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/ecommerce"
        user="Mayur" password="admin"
    />
    
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM users where roleType like '%ROLE_USER%' ;
        
    </sql:query>
    <sql:query var="listAdminUsers"   dataSource="${myDS}">
        SELECT * FROM users ;
        
    </sql:query>
<!-- 	navigation Bar -->
<%@ include file="navbar.jsp"%>
	<div class="container" id="productTable" style="width:1145px;margin-bottom: 180px;"><br>
		<h2>User Management</h2><br>
		<p>The List of Users in our Database</p><br>
		<table class="table table-hover" id="productList">
			<thead>
				<tr>
					<th>User Id</th>
					<!-- <th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Gender</th>
					<th>State</th>
					<th>City</th>
					<th>Phone Number</th> -->
					<th>emailId</th>
					<th>password</th>
					<th>RoleType</th>
				</tr>
			</thead>
			<tbody>
			<security:authorize access="hasAnyRole('ROLE_USER')">
				<c:forEach items="${listUsers.rows}" var="user">
					<tr>
						<td>${user.userId}</td>
						<%-- <td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.address}</td>
						<td>${user.gender}</td>
						<td>${user.state}</td>
						<td>${user.city}</td>
						<td>${user.phNumber}</td> --%>
						<td>${user.emailId}</td>
						<td>${user.password}</td>
						<td>${user.roleType}</td>						
						<td>
						    <a href="user/delete/${user.userId}"> <span
								class="glyphicon glyphicon-trash"></span></a></td>  
					</tr>
				</c:forEach>
				</security:authorize>
				<security:authorize access="hasAnyRole('ROLE_ADMIN')">
				<c:forEach items="${listAdminUsers.rows}" var="user">
					<tr>
						<td>${user.userId}</td>
						<%-- <td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.address}</td>
						<td>${user.gender}</td>
						<td>${user.state}</td>
						<td>${user.city}</td>
						<td>${user.phNumber}</td> --%>
						<td>${user.emailId}</td>
						<td>${user.password}</td>
						<td>${user.roleType}</td>						
						<td>
						    <a href="user/delete/${user.userId}"> <span
								class="glyphicon glyphicon-trash"></span></a></td>  
					</tr>
				</c:forEach>
				</security:authorize>
			</tbody>
		</table>
	</div>
<%@ include file="footer.jsp"%>
</body>
</html>