<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>Spring MVC Hello World</title>
</head>

<body>
	<h2>Datalist: Vodafone</h2>
    <form action="/springmvcexample" method="GET">
        <td colspan="2"><input type="submit" value="Back"></td>
    </form>
	<table border="1" width=100%>
		<tr>
			<th>Id</th>
			<th>Data</th>
			<th>Suma</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.data}</td>
				<td>${employee.suma}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>