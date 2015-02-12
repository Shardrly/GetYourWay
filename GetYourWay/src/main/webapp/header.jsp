<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="NewFile.css" rel="stylesheet" type="text/css">
</head>

<BODY>
<body>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function HtmlEncode(s)
{
  var el = document.createElement("div");
  el.innerText = el.textContent = s;
  s = el.innerHTML;
  return s.replace(/"/g, "&quot;").replace(/'/g, "&apos;")
}
</script>

<div id="dolphincontainer">
<div id="dolphinnav">
 <ul>
  <li><a href="Frontpage.spr" title="" class="current"><span>Home</span></a></li>
  <li><a href="Search.uspr" title="" class="current"><span>Search</span></a></li>
  <sec:authorize access="isAuthenticated()" var="isLoggedIn" />
  <c:if test="${isLoggedIn}">
  <li><a href="choosePlan.spr" title="" class="current"><span>Choose Payment Plan</span></a></li>
  <li><a href="logout.spr" title="" class="current"><span>Logout <sec:authentication property="principal.username"/></span></a></li>
  </c:if>
  <c:if test="${! isLoggedIn}">
  <li><a href="register.spr" title="" class="current"><span>Register</span></a></li>
  <li><a href="login.spr" title="" class="current"><span>Login</span></a></li>
  </c:if>
  <li><a href="about.spr" title="" class="current"><span>About Us</span></a></li>

 </ul>
</div>
</div>

