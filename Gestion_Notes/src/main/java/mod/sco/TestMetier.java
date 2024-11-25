package mod.sco;

import java.util.Vector;

public class TestMetier {
    public static void main(String[] args) {
        Scolarite scolarite = new Scolarite();
        String numIns = "10214"; 

        Vector<Note> notes = scolarite.getNotes(numIns);
        if (notes.isEmpty()) {
            System.out.println("Aucune note trouvée pour l'étudiant avec le numéro d'inscription: " + numIns);
        } else {
            System.out.println("Notes pour l'étudiant avec le numéro d'inscription: " + numIns);
            for (Note note : notes) {
                System.out.println("Matière: " + note.getMatiere() + ", Note: " + note.getNote());
            }
        }
    }
}
