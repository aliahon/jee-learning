package entity;
import javax.persistence.*;

@Entity
@Table(name="Concerner")
public class Concerner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Concerner_tab Con;
	private double Qtecom;
	
	public Concerner() {}
	
	public Concerner(Concerner_tab con, double qtecom) {
		super();
		Con = con;
		Qtecom = qtecom;
	}

	public Concerner_tab getCon() {
		return Con;
	}
	public void setCon(Concerner_tab con) {
		Con = con;
	}
	public double getQtecom() {
		return Qtecom;
	}
	public void setQtecom(double qtecom) {
		Qtecom = qtecom;
	}
	

}
