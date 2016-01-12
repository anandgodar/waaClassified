<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title><tiles:insertAttribute name="title"/></title>

</head>

<body>

<div class="container">


    <div class="jumbotron">
        <c:if test="${USER.roleName eq 'admin'}">
        <h1>
            <tiles:insertAttribute name="header"/>
        </h1>
        </c:if>
        <c:if test="${USER.roleName != 'admin'}">
            <h1>
                <tiles:insertAttribute name="header1"/>
            </h1>
        </c:if>
        <p>
            <tiles:insertAttribute name="menu"/>
        </p>
    </div>

    <div class="row">
        <tiles:insertAttribute name="body"/>
    </div>

    <div class="footer">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>
</body>
</html>
