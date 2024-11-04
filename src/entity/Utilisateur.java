package entity;

import javax.persistence.*;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Codeut")
	private long Codeut;
	@Column(name="Nomut")
	private String Nomut;
	@Column(name="Prenomut")
	private String Prenomut;
	@Column(name="Fonction")
	private String Fonction;
	
	public Utilisateur() {}

	public Utilisateur( String nomut, String prenomut, String fonction) {
		super();
		Nomut = nomut;
		Prenomut = prenomut;
		Fonction = fonction;
	}

	public long getCodeut() {
		return Codeut;
	}
	public void setCodeut(long codeut) {
		Codeut = codeut;
	}
	public String getNomut() {
		return Nomut;
	}
	public void setNomut(String nomut) {
		Nomut = nomut;
	}
	public String getPrenomut() {
		return Prenomut;
	}
	public void setPrenomut(String prenomut) {
		Prenomut = prenomut;
	}
	public String getFonction() {
		return Fonction;
	}
	public void setFonction(String fonction) {
		Fonction = fonction;
	}
	
}
