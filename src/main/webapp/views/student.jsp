<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: HongPinky
  Date: 09 /11/2024
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <h1>Student Management</h1>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Student Id</th>
                <th>Student Name</th>
                <th>Phone Number</th>
                <th>BirthDate</th>
                <th>Address</th>
                <th>Image</th>
                <th>Sex</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentList}" var="student" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${student.studentId}</td>
                    <td>${student.studentName}</td>
                    <td>${student.phoneNumber}</td>
                    <td>${student.birthday}</td>
                    <td>${student.address}</td>
                    <td><img src="${student.imageUrl}" height="50" width="50" alt="${student.studentName}"></td>
                    <td>${student.sex?"Male":"Female"}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/studentController/initUpdate?id=${student.studentId}">Edit</a>
                        <a href="<%=request.getContextPath()%>/studentController/delete?id=${student.studentId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<%=request.getContextPath()%>/studentController/initCreate">Create new student</a>
</body>
</html>