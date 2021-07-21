<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details </h3>

        <form action="all" method="GET">
                <table width=60%>
                    <tr>
                        <td>ID: </td>
                        <td><input type="text" name="id"></td>

                        <td>Data: </td>
                        <td><input type="text" name="data"></td>

                        <td>Suma: </td>
                        <td><input type="text" name="suma"></td>

                        <td>Furnizor: </td>
                        <td><select name="firma">
                          <option value="Electrica">Electrica</option>
                          <option value="RCS&RDS">RCS&RDS</option>
                          <option value="UPC">UPC</option>
                          <option value="Vodafone">Vodafone</option>
                        </select></td>

                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Save"></td>
                    </tr>
                </table>
            </form>

            <form action="all" method="GET">
                <td colspan="2"><input type="submit" value="View all"></td>
            </form>

            <form action="vodafone" method="GET">
                <td colspan="2"><input type="submit" value="View Vodafone"></td>
            </form>

    </body>
</html>