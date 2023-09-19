<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<style>
        html {
            min-height: 80%;
            display: grid;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
        }

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

        .btn {
            width: 100px;
            height: 30px;
        }
	</style>
</head>

<body>
<form style="border: 1px solid black; width: 50%; height: 50%; border-radius: 5%; padding: 30px;">
	<h2>User Information</h2>
	<div class="row">
		<label class="col1">Fullname: </label>
		<label for="" class="col2">Ngoc Bich</label>
	</div>
	<div class="row">
		<label class="col1">Email: </label>
		<label for="" class="col2">abc@gmail.com</label>
	</div>
	<div class="row">
		<label class="col1">Phone: </label>
		<label for="" class="col2">0379 xxx xxx</label>
	</div>
	<br>
	<input type="submit" value="Logout" class="btn">
</form>

</body>