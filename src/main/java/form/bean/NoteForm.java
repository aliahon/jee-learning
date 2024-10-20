package form.bean;

import java.util.Vector;

import mod.sco.Note;

public class NoteForm {

	private String num_Ins;
	private Vector<Note> lesNotes;
	
	//getters
	public String getNum_Ins() {
		return num_Ins;
	}
	public Vector<Note> getLesNotes(){
		return lesNotes;
	}
	
	//setters
	public void setNum_Ins(String ni) {
		num_Ins=ni;
	}
	public void setLesNots(Vector<Note> ln) {
		lesNotes=ln;
	}
}
