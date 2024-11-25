package mod.sco;

import java.sql.*;
import java.util.Vector;

public class Scolarite {
    public Vector<Note> getNotes(String num_Ins) {
        Vector<Note> notes = new Vector<>();
        String query = "SELECT matiere, note FROM Notes WHERE num_ins = ?";

        try (Connection conn = DatabaseConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, num_Ins);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Note note = new Note();
                note.setMatiere(rs.getString("matiere"));
                note.setNote(rs.getFloat("note"));
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }
}
