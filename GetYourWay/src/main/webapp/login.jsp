<jsp:include page="/header.jsp"/>


<P>

<H2>Please type in your username and password:</H2>

<FORM method="POST" action="j_spring_security_check">
<TABLE border="0" align="left" >
<TR>
<TD width="100" align="right"><B>Username: </B></TD>
<TD><INPUT type="text" name="j_username"></TD>
</TR>
<TR>
<TD width="100" align="right"><B>Password: </B></TD>
<TD><INPUT type="password" name="j_password"></TD>
<TD><i>Password may only contain alpha-numeric characters, and must be between 6 and 20 characters in length.</i></TD>
</TR>
</TR>
<TR>
<TD><INPUT type="submit" value="LOGIN" name="submit"></TD><TD></TD>
</TR>

</TABLE>
</FORM>
</P>

<BR><BR><BR>

<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>