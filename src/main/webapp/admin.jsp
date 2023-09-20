<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/20/2023
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>List Account</h2>
<a href="viewDetail.jsp" id=1></a>
<a href="viewDetail.jsp" id=2> </a>

<p>${listAcc}</p>
</body>
<script>
	<%--console.log(${listAcc})--%>
    var obj = ${listAcc};
    for (let i = 1; i < 3; i++){
        document.getElementById(i).innerHTML = obj[i-1].full_name;
	}
</script>
</html>
