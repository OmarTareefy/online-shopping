<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />



<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
	<title>Online Shopping - ${title}</title>
	
	<script type="text/javascript">
		window.menu = '${title}';
		window.contextRoot='${contextRoot}'; 
	</script>


	
	<!-- Bootstrap Core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">
	
	<!-- Bootstrap Solar theme CSS -->
	<link href="${css}/bootstrap-slate-theme.css" rel="stylesheet">
	
	<!-- DataTables Bootstrap -->
	<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="${css}/myapp.css" rel="stylesheet">
	
	
	
	
	<!-- angular js -->
	<script src="${js}/angular.min.js"/>
	
	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- jQuery validator-->
	<script src="${js}/jquery.validate.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

	<!-- datatable plugin-->
	<script src="${js}/jquery.dataTables.js"></script>

	<!-- datatable plugin Bootstrap JavaScript -->
	<script src="${js}/dataTables.bootstrap.js"></script>

	<!--Bootbox JavaScript -->
	<script src="${js}/bootbox.min.js"></script>
	
	<!-- Self Coded Java Script -->
	<script src="${js}/myapp.js"></script>

	


</head>

<body>
	<div class="wrapper">
		<!-- Navigation comes here-->

		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content -->
		<div class="content">
			
			<div ng-app>
				10 + 30 = {{ 10 + 30 }}
			</div>
			<!-- Loading the home content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<c:if test="${userClickCategoryProducts == true or userClickAllProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>			
			
		</div>
		
		
		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

	</div>
</body>

</html>
