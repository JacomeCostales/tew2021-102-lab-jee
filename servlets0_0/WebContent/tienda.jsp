<%@ page language="java" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; utf-8">
	<title>Mi Tienda!</title>
</head>
<body>
	<h1>Tienda Virtual</h1>
	<br>
	<form action="Logica" method="post">
		<br>
		<table >
			<tr>
				<td >escoja el artículo que desea:</td>
			</tr>
			<tr>
				<td>
					<select name="producto" size="1">
					<option value="010">la trampa</option>
					<option value="345">los pájaros</option>
					<option value="554">matrix reloaded</option>
					</select>
				</td>
			</tr>
			<tr>
				<td >
					<input type="submit" value="añadir al carrito...">
				</td>
			</tr>
		</table>
	</form>
	
	
	
	<br>
		<br>
			<H2>Carrito de la compra</h2>
		<br>
			<ul>
 				<c:forEach var="entry" items="${carrito}">
 					<li>
 						<c:out value="Del producto ${entry.key}, ${entry.value} unidades"/>
 					</li>
 				</c:forEach>
			</ul>
			
	
		
</body>
<html>