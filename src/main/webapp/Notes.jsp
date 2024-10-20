<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notes Table</title>
    <style>
        table {
        	border: 1px solid black;
            width: 50%;
            margin-top: 10px;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>
<body>

    <form action="#">
        <label for="numInscription">Num Inscription :</label>
        <input type="text" id="numInscription" name="numInscription">
        <button type="submit">OK</button>
    </form>

    <table>
        <tr>
            <th>Matière</th>
            <th>Note</th>
        </tr>
        <tr>
            <td>GL</td>
            <td>16.0</td>
        </tr>
        <tr>
            <td>SR</td>
            <td>14.5</td>
        </tr>
        <tr>
            <td>Moyenne</td>
            <td>15.25</td>
        </tr>
    </table>

</body>
</html>
