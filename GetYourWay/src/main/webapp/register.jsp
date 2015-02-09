<jsp:include page="/header.jsp"/>

<DIV align="left">
<H2>Please type in your details:</H2>

<FORM method="POST" action="registerdetails.spr">
<TABLE border="0">
<TR>
<TD width="100" align="right"><B>Email Address: </B></TD>
<TD><INPUT type="text" name="username"></TD>
</TR>
<TR>
<TD width="100" align="right"><B>Password: </B></TD>
<TD><INPUT type="password" name="password"></TD>
<TD><i>Password may only contain alpha-numeric characters, and must be between 6 and 20 characters in length.</i></TD>
</TR>
</TABLE>
<BR><BR>
</DIV>
<DIV align="left">
<H2>Would you like to enter a default departure location?</H2>

</DIV>
<DIV align="left">
<INPUT type="submit" value="REGISTER"></TD><TD></TD>
</FORM>
</DIV>

<BR><BR><BR>

<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>