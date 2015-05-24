<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
    <section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customer</h1>
				<p>All our customers</p>
				</div>
			</div>
	</section>
	<section class="container">
            <div class="row">
                <c:forEach items="${customers}" var="customer">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class= "caption">
							<h3>${customer.customerId} ${customer.name}</h3>
							<p>${customer.noOfOrderMade} Items</p>
						</div>
					</div>
				</div>
                </c:forEach> 
            </div>
	</section>
</body>
</html>