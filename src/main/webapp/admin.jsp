<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.entities.Account" %><%--
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

        table {
            width: 700px;
            margin: 0 auto;
        }

        form {
            width: 500px;
            height: fit-content;
            border: 1px solid black;
            padding: 30px;
            margin: 0 auto;
        }

        button {
            width: 100px;
            height: 30px;
            margin: 10px;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            height: 25px;
            margin-top: 2px;
            margin-bottom: 10px;
        }
	</style>
</head>

<body>
<table id="table">
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

<div style="margin: 0 auto; width: 700px;">
	<p style="color: red;" id="notice">*</p>
</div>
<%
	String noti = request.getAttribute("noti")+"";
%>
<form action="ControllerServlet" , method="post", name = "getAccount">
	<h2>Account</h2>
	<label for="accountID">Account ID:</label><br>
	<input type="text" id="accountID" name="accountID" value=""><br>
	<label for="password">Password:</label><br>
	<input type="password" id="password" name="password" value=""><br>
	<label for="fullName">Full name:</label><br>
	<input type="text" id="fullName" name="fullName" value=""><br>
	<label for="email">Email:</label><br>
	<input type="text" id="email" name="email" value=""><br>
	<label for="phone">Phone:</label><br>
	<input type="text" id="phone" name="phone" value=""><br> <br>
	<div>
		<button type="button" onclick="create()" value="createAccount" name="action">Create</button>
		<button type="button" onclick="update()" value="updateAccount" name="action">Update</button>
		<button type="submit" onclick="deletee()" value="deleteAccount" name="action">Delete</button>
		<br>
	</div>
</form>
<%
	if (!noti.equals("null")){
%>
<div> <%=noti%></div>
<%}%>
<%--<% ArrayList<Account> listAcc = (ArrayList<Account>) request.getAttribute("listAcc"); %>--%>
<%--<script>var arr =<%= listAcc%>;</script>--%>
</body>

<script>
    var arr = ${listAcc};

    function setListAccountOnTable() {
        arr.forEach((obj) => {
            var tr = document.createElement("tr");
            document.getElementById("table").appendChild(tr)
            var td = document.createElement("td");
            var radio = document.createElement("input");
            radio.setAttribute("type", "radio");
            radio.setAttribute("name", "radio");
            radio.setAttribute("value", obj.accountID);
            radio.setAttribute("onclick", "setAccount()")

            document.getElementById("table").appendChild(tr)
            tr.appendChild(td)
            td.appendChild(radio)

            document.getElementById("table").appendChild(createContent(obj.accountID, tr))
            document.getElementById("table").appendChild(createContent(obj.fullName, tr))
            document.getElementById("table").appendChild(createContent(obj.email, tr))
            document.getElementById("table").appendChild(createContent(obj.phone, tr))
            document.getElementById("table").appendChild(createContent(obj.status, tr))
        });
    }

    setListAccountOnTable();
    disableInput();

    function createContent(string, tr) {
        var td = document.createElement("td");
        td.innerText = string;
        tr.appendChild(td);
        return tr;
    }

    // set account on form
    function setAccount() {
        var value = document.querySelector('input[name="radio"]:checked').value;
        var obj = arr.find((obj) => {
            if (obj.accountID == value) {
                return obj;
            }
        })
        document.getElementById("accountID").value = obj.accountID;
        document.getElementById("password").value = obj.password;
        document.getElementById("fullName").value = obj.fullName;
        document.getElementById("email").value = obj.email;
        document.getElementById("phone").value = obj.phone;
    }

    // create account
    function create() {
        if (document.getElementById("accountID").disabled == true) {
            enableInput();
            document.getElementById("notice").innerText = "*Please fill in the form and click `Done` button to create account!";
            return;
        } else {
            var obj = getAccountInTable();
            if (checkIDIfExist(obj.accountID)) {
                alert("ID existed, please choose another ID!")
                return;
            }
            console.log(obj);
            document.getElementsByName('getAccount')[0].submit();
            // document.forms.getAccount.submit();
        }
    }

    // update account
    function update() {
        enableInput();
        document.getElementById("accountID").disabled = true;
        document.getElementById("notice").innerText = "*Please fix information in the form below and click `Done` button to update account!";
    }

    // delete account
    function deletee() {
        // var radio = document.querySelector('input[name="radio"]:checked');
        // if (radio == null) {
        //     alert("Please choose an account to delete!");
        //     return;
        // }
        // var value = radio.value;

    }

    function done() {
        if (document.getElementById("accountID").disabled == true && document.getElementById("password").disabled == true) {
            // when not choose `Create` or `Update` before
            alert("Please choose choose `Create` or `Update` before!");
            return;
        }
        if (document.getElementById("accountID").disabled == false) {
            // create
            var obj = getAccountInTable();
            if (checkIDIfExist(obj.accountID)) {
                alert("ID existed, please choose another ID!")
                return;
            }
            arr.push(obj);
        } else {
            // check if radio is checked
            var radio = document.querySelector('input[name="radio"]:checked');
            if (radio == null) {
                alert("Please choose an account to update!");
                return;
            }
            var value = radio.value;
            var obj = getAccountInTable();
            arr.forEach((item) => {
                if (item.accountID == value) {
                    item.accountID = obj.accountID;
                    item.password = obj.password;
                    item.fullName = obj.fullName;
                    item.email = obj.email;
                    item.phone = obj.phone;
                }
            })
        }
        clearTable();
        setListAccountOnTable();
        clearInput();
        disableInput();
        document.getElementById("notice").innerText = "*Successfully!";
    }

    // Function for CRUD
    function getAccountInTable() {
        if (document.getElementById("accountID").value == "" || document.getElementById("password").value == "" || document.getElementById("fullName").value == "" || document.getElementById("email").value == "" || document.getElementById("phone").value == "") {
            alert("Please fill all information!");
            return;
        }
        var obj = {
            accountID: document.getElementById("accountID").value,
            password: document.getElementById("password").value,
            fullName: document.getElementById("fullName").value,
            email: document.getElementById("email").value,
            phone: document.getElementById("phone").value,
            status: 1,
        }
        return obj;
    }

    function clearTable() {
        var table = document.getElementById("table");
        var rowCount = table.rows.length;
        for (var i = rowCount - 1; i > 0; i--) {
            table.deleteRow(i);
        }
    }

    function checkIDIfExist(id) {
        var obj = arr.find((obj) => {
            if (obj.accountID == id) {
                return obj;
            }
        })
        if (obj == undefined) {
            return false;
        }
        return true;
    }

    function enableInput() {
        document.getElementById("accountID").disabled = false;
        document.getElementById("password").disabled = false;
        document.getElementById("fullName").disabled = false;
        document.getElementById("email").disabled = false;
        document.getElementById("phone").disabled = false;
    }

    function disableInput() {
        document.getElementById("accountID").disabled = true;
        document.getElementById("password").disabled = true;
        document.getElementById("fullName").disabled = true;
        document.getElementById("email").disabled = true;
        document.getElementById("phone").disabled = true;
    }

    function clearInput() {
        document.getElementById("accountID").value = "";
        document.getElementById("password").value = "";
        document.getElementById("fullName").value = "";
        document.getElementById("email").value = "";
        document.getElementById("phone").value = "";
    }
</script>
</html>
