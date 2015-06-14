<%-- 
    Document   : addProduct
    Created on : Jun 1, 2015, 4:32:36 PM
    Author     : Ketia
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="<%= request.getContextPath() %>/bootstrap.min.css" type="text/css" rel="stylesheet" />
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Products</h1>
                    <p>Add products</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newProduct" class="form-horizontal">
                <fieldset>
                    <legend>Add new product</legend>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                            <spring:message code="addProduct.form.productId.label"/>
                        </label>
                        <div class="col-lg-10">
                            <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
                        <div class="col-lg-10">
                            <form:input id="name" path="name" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit price</label>
                        <div class="col-lg-10">
                            <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                        </div>
                    </div>    
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
                        <div class="col-lg-10">
                            <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                        </div>
                    </div> 
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
                        <div class="col-lg-10">
                            <form:input id="category" path="category" type="text" class="form:input-large"/>
                        </div>
                    </div> 
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Units in Stock</label>
                        <div class="col-lg-10">
                            <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <!--<div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">Units in order</label>
                        <div class="col-lg-10">
                            <form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large"/>
                        </div>
                    </div>-->
                    <!-- Similarly bind <%--<form:input>--%> tag for name,unitPrice,manufacturer,category,unitsInStock andunitsInOrder fields-->
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="description">Description</label>
                        <div class="col-lg-10">
                            <form:textarea id="description" path="description" rows = "2"/>
                        </div>
                    </div>
                    <!--<div class="form-group">
                        <label class="control-label col-lg-2" for="discontinued">Discontinued</label>
                        <div class="col-lg-10">
                            <form:checkbox id="discontinued" path="discontinued"/>
                        </div>
                    </div>-->
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="condition">Condition</label>
                        <div class="col-lg-10">
                            <form:radiobutton path="condition" value="New" />New
                            <form:radiobutton path="condition" value="Old" />Old
                            <form:radiobutton path="condition" value="Refurbished" />Refurbished
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>