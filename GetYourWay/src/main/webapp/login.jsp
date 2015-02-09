<jsp:include page="/header.jsp"/>


<P>

<H2>Please type in your username and password:</H2>

<FORM method="post" action="trylogin">
<TABLE border="0" align="left" >
<TR>
<TD width="100" align="right"><B>Username: </B></TD>
<TD><INPUT type="text" name="username"></TD>
</TR>
<TR>
<TD width="100" align="right"><B>Password: </B></TD>
<TD><INPUT type="password" name="password"></TD>
</TR>
</TR>
<TR>
<TD><INPUT type="submit" value="LOGIN"></TD><TD></TD>
</TR>

</TABLE>
</FORM>
</P>

<BR><BR><BR>

<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>