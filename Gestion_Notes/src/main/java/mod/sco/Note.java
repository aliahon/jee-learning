package mod.sco;

public class Note {

	private int id_note;
	private String num_Ins;
	private String matiere;
	private float note;
	
	//getters
	public int getId_note() {
		return id_note;
	}
	
	public String getNum_Ins() {
		return num_Ins;
	}
	
	public String getMatiere() {
		return matiere;
	}
	
	public float getNote() {
		return note;
	}
	
	//setters
	public void setId_note(int sn) {
		id_note=sn;
	}
	
	public void setNum_Ins(String ni) {
		num_Ins=ni;
	}
	
	public void setMatiere(String m) {
		matiere=m;
	}
	
	public void setNote(float n) {
		note=n;
	}
}
