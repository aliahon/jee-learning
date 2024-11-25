package entity;

import javax.persistence.*;

@Entity
@Table(name="Facture")

public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Numfact")
	private long Numfact;
	@Column(name="Datefact")
	private String Datefact;
	@Column(name="Montant")
	private double Montant;
	
	@ManyToOne
	@JoinColumn(name="Codeut")
	private Utilisateur utilisateur;
	
	public Facture() {}

	public Facture(String datefact, double montant, Utilisateur utilisateur) {
		super();
		Datefact = datefact;
		Montant = montant;
		this.utilisateur = utilisateur;
	}

	public long getNumfact() {
		return Numfact;
	}
	public void setNumfact(long numfact) {
		Numfact = numfact;
	}
	public String getDatefact() {
		return Datefact;
	}

	public void setDatefact(String datefact) {
		Datefact = datefact;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
