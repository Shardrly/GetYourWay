<%@page import="java.util.Iterator"%>
<%@page import="com.qa.paymentPlans.PaymentPlan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qa.paymentPlans.PaymentPlanService"%>
<jsp:include page="/header.jsp"/>
<h2>Choose your plan</h2>

<% ArrayList<PaymentPlan> planList = (ArrayList<PaymentPlan>) request.getAttribute("PlanList"); 
	planList.get(0);%>
	
<script type="text/javascript">
function toggleDiv(divId) {
	$(".planDesc").hide();
   	$("#"+divId).toggle();
}
</script>

<FORM method="POST" action="registerplan.spr" name="planForm">
<Table>
<TR>
<TD width="200" align="left"><B>Plan: </B></TD>
<%
	for (int i = 0; i < planList.size(); i++) { 
		PaymentPlan p = planList.get(i); %>
		<TR>
			<TD><input type="radio" name="planType" value="<%=p.getName()%>" onclick="toggleDiv('<%=p.getName() %>')"><%=p.getName().toUpperCase()%></TD>
			<TD><DIV id="<%=p.getName() %>" class="planDesc"><%=p.getDescription() %><BR>Costs: £<%=p.getPrice() %></DIV></TD>
		</TR>
<%	} %>
</TD>
<TR>
<TD><INPUT type="submit" value="Add Plan" name="submit"></TD>
</TR>
</Table>
</FORM>

<script type="text/javascript" src="javaScripts/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="javaScripts/ninjaScript.js"></script>

<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>