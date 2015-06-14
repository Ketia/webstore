<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
				<p>All the available products in our store</p>
				</div>
			</div>
	</section>
	
	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class= "caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>$${product.unitPrice} USD</p>
							<p>Available ${product.unitsInStock} units in stock</p>
                                                        <p>
                                                            <%--<spring:url value="/products/product?id=${product.productId}" />
                                                            This <spring:url> tag is used to construct a valid Spring URL.we can note that
                                                            for the id URL parameter, we assigned the expression ${product.productId}. So, while
                                                            rendering this link, Spring MVC will assign the corresponding product ID in that expression.
                                                            For example, while rendering the link of the first product, Spring MVC will assign the value
                                                            P1234 for the product ID. So, the final URL value within <spring:url> will become
                                                            /products/product?id=P1234, which is nothing but the request mapping path of
                                                            the product details page. So, when you click on this link, you land on the details page ofthat product.--%>
                                                            <a href=" <spring:url value="/products/product?id=${product.productId}"/>" class="btn btn-primary">
                                                            <%--Note that the span tag is just for styling the button with the icon,--%>
                                                            <span class="glyphicon-info-sign glyphicon"/></span> Details
                                                            </a>
                                                        </p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>