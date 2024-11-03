package ecole;
import javax.persistence.*;
@Entity
@Table(name="etudiant")
public class Etudiant {
	@Id
	@Column(name="apogeeEtd")
	private int apogee;
	@Column(name="nomEtd", length=30)
	private String nom;
	@Column(name="prenomEtd", length=30)
	private String prenom;
	@Embedded
	private Coordonnees coordonnées;
	// Constructeurs
	public Etudiant() {}
	public Etudiant(int a, String n, String pr, Coordonnees crd) {
		// TODO Auto-generated constructor stub
		apogee=a;
		nom=n;
		prenom=pr;
		coordonnées=crd;
		
	}
	// getters et setters 
}

