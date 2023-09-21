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
	<style>
        table,
        th,
        td {
            border: 1px solid black;
            border-collapse: collapse;
			height: 30px;
        }

        form {
            width: 700px;
        }

        button {
            width: 100px;
            height: 30px;
        }
	</style>
</head>
<body>
<form>
	<table style="width:100%" id="table">
		<tr>
			<th></th>
			<th>Account ID</th>
			<th>Full name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Status</th>
		</tr>
		<tr>
		</tr>
	</table>

	<br>
	<button type="button" onclick="add()">Add</button>
	<button type="button" onclick="edit()">Edit</button>
	<button type="button" onclick="deletee()">Delete</button>
</form>

</body>

<script>
    var arr = ${listAcc};
    arr.forEach((obj) => {
        var tr = document.createElement("tr");
        document.getElementById("table").appendChild(tr)

        var td = document.createElement("td");
        var checkbox = document.createElement("input");
        checkbox.setAttribute("type", "checkbox");
        document.getElementById("table").appendChild(tr)
        tr.appendChild(td)
        td.appendChild(checkbox)

        document.getElementById("table").appendChild(createContent(obj.accountID, tr))
        document.getElementById("table").appendChild(createContent(obj.fullName, tr))
        document.getElementById("table").appendChild(createContent(obj.email, tr))
        document.getElementById("table").appendChild(createContent(obj.phone, tr))
        document.getElementById("table").appendChild(createContent(obj.status, tr))
    });

    function createContent(string, tr) {
        var td = document.createElement("td");
        td.innerText = string;
        tr.appendChild(td);
        return tr;
    }
</script>
</html>
