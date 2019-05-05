<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nurse</title>
</head>
<body>
<form action="NurseSubmit" method=post enctype='multipart/form-data'>
<center><table>
<tr><caption><h3><i>Add Nurse</i></h3></caption></tr>
<tr><td><b><i>Nurse Id:</i></b></td><td><input type=text size=10 name=nid></td></tr>
<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=nname></td></tr>
<tr><td><b><i>Email:</i></b></td><td><input type=text size=30 name=nemail></td></tr>
<tr><td><b><i>Password</i></b></td><td><input type="password" size=30 name=npwd></td></tr>
<tr><td><b><i>Address:</i></b></td><td><textarea rows="4" cols="30" name=nadd></textarea></td></tr>
<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=nph></td></tr>
<tr><td><b><i>Image:</i></b></td><td><input type=file size=40 name=nicon></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</form>
</center>
</body>
</html>