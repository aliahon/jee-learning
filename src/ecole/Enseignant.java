package ecole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="enseignant")

public class Enseignant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codeEns")
	private int code;
	@Column(name="nomEns", length=30)
	private String nom;
	@Column(name="prenomEns", length=30)
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name="codeDep")
	private Departement departement;
	
	public Enseignant() {}
	
	public Enseignant(String n, String pr, Departement dep) {
		// TODO Auto-generated constructor stub
		nom=n;
		prenom=pr;
		departement=dep;
	}

	public Departement getDepartement() {
		return departement;
	}
	
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	// les getters et les setters
	public void setCode(int c) {
		code=c;
	}
	public void setNom(String n) {
		nom=n;
	}
	public void setPrenom(String pr) {
		prenom=pr;
	}
	
	public int getCode() {
		return code;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
}
