package entity;
import javax.persistence.*;
@Entity
@Table(name="Client")
public class Client {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="NumCl")
		private long NumCl;
		
		@Column(name="NomCl")
		private String NomCl;
		
		@Column(name="PrenomCl")
		private String PrenomCl;
		
		@Column(name="TelCl")
		private String TelCl;
		
		@Column(name="AdresseCl")
		private String AdresseCl;
		public Client() {}
		public Client( String nomCl, String prenomCl, String telCl, String adresseCl) {
			super();
			NomCl = nomCl;
			PrenomCl = prenomCl;
			TelCl = telCl;
			AdresseCl = adresseCl;
		}
		
		public long getNumCl() {
			return NumCl;
		}
		public void setNumCl(long numCl) {
			NumCl = numCl;
		}
		public String getNomCl() {
			return NomCl;
		}
		public void setNomCl(String nomCl) {
			NomCl = nomCl;
		}
		public String getPrenomCl() {
			return PrenomCl;
		}
		public void setPrenomCl(String prenomCl) {
			PrenomCl = prenomCl;
		}
		public String getTelCl() {
			return TelCl;
		}
		public void setTelCl(String telCl) {
			TelCl = telCl;
		}
		public String getAdresseCl() {
			return AdresseCl;
		}
		public void setAdresseCl(String adresseCl) {
			AdresseCl = adresseCl;
		}
		
	
}
