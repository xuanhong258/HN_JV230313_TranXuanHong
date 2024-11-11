<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HongPinky
  Date: 09 /11/2024
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Update</title>
</head>
<body>
<form:form modelAttribute="studentUpdateDTO" action="${pageContext.request.contextPath}/studentController/update" method="post" enctype="multipart/form-data">
    <form:label path="studentId" for="studentId">Student Id</form:label>
    <form:input path="studentId" id="studentId" readonly=""/><br>

    <form:label path="studentName" for="studentName">Student Name</form:label>
    <form:input path="studentName" id="studentName"/>
    <form:errors path="studentName" cssClass="error"/><br>

    <form:label path="phoneNumber" for="phoneNumber">Phone Number</form:label>
    <form:input type="text" path="phoneNumber" id="phoneNumber"/><br>

    <form:label path="birthday" for="birthday">Birthday</form:label>
    <input type="date" name="birthday" id="birthday"/><br>

    <form:label path="address" for="address">Address</form:label>
    <form:input type="text" path="address" id="address"/><br>

    <form:label path="imageUrl" for="imageUrl">Image</form:label>
    <form:input type="file" path="imageUrl" id="imageUrl"/><br>


    <label for="male">Sex</label>
    <input type="radio" id="male" name="sex" value="true" checked/><label for="male">Male</label>
    <input type="radio" id="female" name="sex" value="false"/><label for="female">Female</label><br>

    <input type="submit" value="Update"/>
</form:form>
</body>
</html>
