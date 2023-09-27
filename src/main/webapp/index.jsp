<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Week01</title>
	<style>
        .row {
            height: 50px;
            display: flex;
            align-items: center;
        }
        .col1 {
            width: 80px;
        }

        .col2 {
            width: 150px;
        }

	</style>
</head>

<body>
<br />
<form action="ControllerServlet", method="post", style="border: 1px solid black; width: 300px; height: 250px; border-radius: 5%; padding: 20px;">
	<h1 align="center">Login</h1>
	<div class="row">
		<label class="col1">AccountID: </label>
		<input type="text" name="accountID" placeholder="Account ID" value="met" /><br><br>
	</div>
	<div class="row">
		<label class="col1">Password: </label>
		<input type="password" name="password" placeholder="Password" value="123" /><br><br>
	</div>
	<div class="row">
		<input type="submit" value="login" name = "action" style="margin: 80px"/>
	</div>
</form>
</body>
</html>