package ecole;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="matiere")
public class Matiere {
	@Id
	@Column(name="codeMat", length=6)
	private String code;
	@Column(name="libelleMat", length=100)
	private String libelle;
	
	@ManyToMany
	private Set<Enseignant> enseignants=new HashSet<>();
	
	public Matiere(String code, String libelle) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.libelle=libelle;
	}
	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	public void ajouterEnseigant(Enseignant ens){
		this.enseignants.add(ens);
	}
	//les getters et les setters
	public void setCode(String c) {
		code=c;
	}
	public void setLibelle(String l) {
		libelle = l;
	}
	public String getCode() { return code; }
	public String getLibelle() {return libelle;}
}

