package ecole;

import javax.persistence.*;

@Entity
@Table(name="noter")
public class Noter {
	@Id
	private Noter_PK pk;
	private double note;
	public Noter() {super();}
	public Noter(int apogee, String matiere, double note) {
		this.pk = new Noter_PK(matiere,apogee);
		this.note = note;
	}
	public Noter_PK getPk() {return pk;}
	public void setPk(Noter_PK pk) {this.pk = pk;}
	public double getNote() {return note;}
	public void setNote(double note) {this.note = note;}
	
}