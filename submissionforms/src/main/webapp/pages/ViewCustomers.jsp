<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Edureka Customers</title>
    </head>

    <body>
        <h1>View Customer Details</h1>
        <h2>Details as submitted as follows: </h2>
        <form action="getdetails" method="post">
            <input type="number" name="cid">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>