<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CALCULADORA</title>
</head>
<body>
<h1>CALCULADORA</h1>
	<form action="calculadora.jsp "method="post">
		<input type="text" id="01" name="numero1"><br><br>
		<input type="text" id="02" name="numero2"><br><br>
		
		<table >
			<tr>
				<td >Escoja operación</td>
			</tr>
			<tr>
				<td>
					<select name="operacion" size="1">
					<option value="suma">suma</option>
					<option value="resta">resta</option>
					<option value="producto">producto</option>
					<option value="division">divison</option>
					</select>
				</td>
			</tr>
			<tr>
				<td >
					<input type="submit" value="CALCULAR">
				</td>
			</tr>
		</table>
	</form>

	<%
	
	String resultado = (String)request.getSession().getAttribute("resultado");
	if(resultado == null){resultado = "NO RESULTADO";}
	
	
	String numero1 = request.getParameter("numero1");
	String numero2 = request.getParameter("numero2");
	int n1 = 0;
	int n2 = 0;
	
	try{
		n1 = Integer.parseInt(numero1);
		n2 = Integer.parseInt(numero2); 
	}
	catch(NumberFormatException e){
		n1=-99999;
		n2=-99999;
	}
	
	
	String operacion = request.getParameter("operacion");
	
	if ( operacion != null ){
		if(operacion.equals("suma")){
			resultado = Integer.toString(n1+n2);
			System.out.println(resultado);
		}
		else if(operacion.equals("resta")){
			resultado = Integer.toString(n1-n2);
		}
		else if(operacion.equals("producto")){
			resultado = Integer.toString(n1*n2);
		}
		else if(operacion.equals("division")){
			resultado = Integer.toString(n1/n2);
		}
		else{
			resultado = "SIN RESULTADO";
		}
	}
	
	
	request.getSession().setAttribute("resultado",resultado);
	
	%>
	<p><%=request.getParameter("resultado")%></p>
 	
	

</body>
</html>