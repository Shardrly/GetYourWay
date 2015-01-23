<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

</head>

<BODY>
<DIV align="center">
<TABLE width="90%" border="1" cellpadding="5">
<tr>

<% if (session.getAttribute("userid") != null){
	%>
<td align="center" valign="center" width="25%"><A href="home">Home</A></td>
<td align="center" valign="center" width="25%"><A href="logout">Logout <%=session.getAttribute("userid") %></A></td>
<td align="center" valign="center" width="25%"><A href="feedback">Feedback</A></td>
<td align="center" valign="center" width="25%"><A href="about">About</A></td>

<%} 
else {
%>
<td align="center" valign="center" width="25%"><A href="home">Home</A></td>
<td align="center" valign="center" width="25%"><A href="logout">Login>
<td align="center" valign="center" width="25%"><A href="register">Register</A></td>
<td align="center" valign="center" width="25%"><A href="about">About</A></td>

<% 
}
%>	
	



<%--
		QA To do: Exercise 3 step 7
		
		Amend the scriptlet. If the username doesn't exist, the 
		navigational links should include 'Register'. If is exists, 
		then the navigational link should be 'View Details'.
--%>


</tr>
</TABLE>
</DIV>

<DIV align="center">
<H1>Festival of Culture</H1>
</DIV>

