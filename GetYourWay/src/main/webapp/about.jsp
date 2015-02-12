<jsp:include page="/header.jsp"/>
<title>About Us</title>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

About Page
<p>3 guys designed this website because they were told to.</p>
<p> Enjoy :)</p>

<BR><BR>
<sec:authorize access="isAuthenticated()" var="isLoggedIn" />
 <c:if test="${isLoggedIn}">
We welcome your <a href="Feedback.uspr">feedback!</a>
</c:if>
 
<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>