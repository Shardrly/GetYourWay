<jsp:include page="/header.jsp"/>
<h2>Choose your plan</h2>

<script>

</script>

<FORM method="POST" action="registerplan.spr" onsubmit="return planFormValidator()" name="planForm">
<Table>
<TR>
<TD width="100" align="right"><B>Plan: </B></TD>
<TD> <select id="planSelect" onChange="">
  <option value="singleSession">Single Session</option>
  <option value="monthly">Monthly</option>
  <option value="yearly">Yearly</option>
</select>
</TD> 
<TD><DIV id="planDescription">Appropriate for a single journey planning session lasting a maximum of 3 hours</DIV></TD>
</TR>
</Table>
</FORM>

<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>