<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cd Drives</title>
<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
</head>
<body>
	<div>
		<table align="center" border="1" class="gridtable">
			<tr>
				<th colspan="4">Cd</th>
				<th colspan="9">Purchase Order</th>
				<th colspan="2">Visit event</th>
			</tr>
			<tr>
				<th>Cd Id</th>
				<th>Title</th>
				<th>Price</th>
				<th>Category</th>
				<th>Lastname</th>
				<th>Firstname</th>
				<th>Status</th>
				<th>Street</th>
				<th>Province</th>
				<th>Country</th>
				<th>Zip</th>
				<th>Phone</th>
				<th>Price</th>
				<th>Day</th>
				<th>Eventtype</th>
			</tr>
			<c:forEach var="cdDrive" items="${cdDriveList}">
				<tr>
					<td><c:out value="${cdDrive.cdId}"></c:out></td>
					<td><c:out value="${cdDrive.title}"></c:out></td>
					<td><c:out value="${cdDrive.price}"></c:out></td>
					<td><c:out value="${cdDrive.category}"></c:out></td>
					<c:forEach var="poi" items="${cdDrive.purchaseOrderItem}">
						<c:if test="${not empty poi.poId.purchaseOrder.lastName}">
							<td><c:out value="${poi.poId.purchaseOrder.lastName}"></c:out></td>
						</c:if>
						<c:if test="${not empty poi.poId.purchaseOrder.firstName}">
							<td><c:out value="${poi.poId.purchaseOrder.firstName}"></c:out>
							</td>
						</c:if>
						<td><c:out value="${poi.poId.purchaseOrder.status}"></c:out>
						</td>
						<td><c:out value="${poi.poId.purchaseOrder.address.street}"></c:out>
						</td>
						<td><c:out value="${poi.poId.purchaseOrder.address.province}"></c:out>
						</td>
						<td><c:out value="${poi.poId.purchaseOrder.address.country}"></c:out>
						</td>
						<td><c:out value="${poi.poId.purchaseOrder.address.zip}"></c:out>
						</td>
						<td><c:out value="${poi.poId.purchaseOrder.address.phone}"></c:out>
						</td>
						<td><c:out value="${poi.price}"></c:out></td>
					</c:forEach>
					<td><c:forEach var="ve" items="${cdDrive.visitEventList}">
							<span> <c:out value="${ve.day}"></c:out>
							</span>
							</br>
						</c:forEach></td>
					<td><c:forEach var="ve" items="${cdDrive.visitEventList}">
							<span> <c:out value="${ve.eventType}"></c:out>
							</span>
							</br>
						</c:forEach></td>
			</c:forEach>
		</table>
	</div>
</body>
</html>