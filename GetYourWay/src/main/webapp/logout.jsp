<jsp:include page="/header.jsp"/>

<P>

<H2><sec:authentication property="principal.username"/>, you are about to logout.</H2>

<FORM method="POST" action="j_spring_security_logout" name="logoutForm">
<TABLE border="0" align="left" >
<TR>

<TD><INPUT type="submit" value="LOGOUT" name="submit"></TD><TD></TD>
</TR>

</TABLE>
</FORM>
</P>

<BR><BR><BR>

<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>