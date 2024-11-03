package ecole;
import javax.persistence.*;
@Embeddable
public class Coordonnees {
	@Column(name="adresse_Crd")
	private String adresse;
	@Column(name="ville_Crd")
	private String ville;
	@Column(name="email_Crd")
	private String email;
	@Column(name="tel_Crd")
	private String tel;
	public Coordonnees() {}
	public Coordonnees(String adresse, String ville, String tel, String email) {
		this.adresse = adresse;
		this.ville = ville;
		this.tel = tel;
		this.email = email;
	}
}
