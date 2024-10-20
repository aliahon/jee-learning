<%@ page import="form.bean.NoteForm" %>
<%@ page import="mod.sco.Note" %>
<%@ page import="java.util.Vector" %>

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

    <form action="notes.php" method="post">
        <label for="numInscription">Num Inscription :</label>
        <input type="text" id="numInscription" name="num_Ins" required>
        <button type="submit">OK</button>
    </form>

    <table>
        <tr>
            <th>Matière</th>
            <th>Note</th>
        </tr>
        <%
        	NoteForm nf = (NoteForm) session.getAttribute("nf");
        	Vector<Note> notes = nf.getLesNotes();
        	float moy = 0;
        	for(Note note : notes){
        		moy+=note.getNote();
       		}
     		moy/=notes.size();
        	for(Note note : notes){
        %>
        <tr>
            <td><%=note.getMatiere() %></td>
            <td><%=note.getNote() %></td>
        </tr>
        <% }%>
        <tr>
            <td style="font-weight: bold; color: green;">Moyenne</td>
            <td style="font-weight: bold; color: green;"><%= moy %></td>
        </tr>
    </table>

</body>
</html>
