package ecole;
import javax.persistence.*;

@Entity
@Table(name="departement")
public class Departement {

	@Id
	@Column(name="codeDep", length=6)
	private String code;
	@Column(name="libelleDep", length=100)
	private String libelle;
	
	public Departement(String c, String l) {
		// TODO Auto-generated constructor stub
		code=c;
		libelle=l;
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
