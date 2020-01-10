<%@page import="demo.test1.model.Patient"%>
<%@page import="demo.test1.model.Medicine"%>
<%@page import="demo.test1.model.Prescription"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		Patient Id: <input type= 'number' name= 'Patient Id' />
		<br>
		Patient Name: <input type= 'text' name= 'Patient Name' />
		<br>
		Patient Email: <input type= 'text' name= 'Patient Email' />
		<br>
		Patient Date: <input type= 'text' name= 'Patient Date' />
		<br>
		<br>
		<button type='submit' name = 'regBtn'>Register</button>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>Patient Id</th><th>Patient Name</th><th>Patient Email</th><th>Registration date</th>
			</tr>
		</thead>
		<tbody>
		
		<%
		
			List<Patient> p = null;
			p = (List<Patient>)request.getAttribute("p");
			
			if(p!=null){
				for(Patient s : p){
					out.write("<form method='get' action='register'>");
					out.write("<tr>");
					out.write("<td>"+s.getPatientId()+"</td>");
					out.write("<td>"+s.getPatientName()+"</td>");
					out.write("<td>"+s.getPatientEmail()+"</td>");
					out.write("<td>"+s.getPatientDate()+"</td>");
					
					out.write("<td>"+"<input type='hidden' name='del_name' value="+s.getPatientName()+">"+"<button type='submit' name='delBtn'>Delete</button>"+"</td>");
					out.write("<td>"+ "<input type='hidden' name='edit_name' value="+s.getPatientName()+">" +"<button type='submit' name='editBtn'>Edit</button>"+"</td>");
					out.write("</tr>");
					out.write("</form>");
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>