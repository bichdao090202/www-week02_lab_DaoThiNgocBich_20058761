<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Week01</title>
	<style>
        .row {
            height: 30px;
            display: flex;
            align-items: center;
        }

        .col1 {
            min-width: 80px;
        }

        .col2 {
            width: 150px;
        }

	</style>
</head>

<body>
<br />
<form action="ControllerServlet", method="post">
	<div class="row">
		<label class="col1">Username: </label>
		<input type="text" name="Username" placeholder="Username" /><br><br>
	</div>
	<div class="row">
		<label class="col1">Password: </label>
		<input type="password" name="Password" placeholder="Password" /><br><br>
	</div>
	<div class="row">
		<input type="submit" value="Login"/>
		<input type="reset" value="Reset" />
	</div>
</form>
</body>
</html>