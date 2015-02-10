<jsp:include page="/header.jsp"/>

<script type="text/JavaScript" src="javaScripts/LoginAuthentication.js"></script>

<P>

<H2>Please type in your username and password:</H2>

<FORM method="POST" action="j_spring_security_check" onsubmit="return loginFormValidator()" name="loginForm">
<TABLE border="0" align="left" >
<TR>
<TD width="100" align="right"><B>Username: </B></TD>
<TD><INPUT type="text" name="j_username" onChange="usernameCheck()"></TD>
<TD><div id="usernameText"></div></TD>
</TR>
<TR>
<TD width="100" align="right"><B>Password: </B></TD>
<TD><INPUT type="password" name="j_password" onChange="passwordCheck(this.form)"></TD>
<TD><div id="passwordText"></div></div></TD>
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