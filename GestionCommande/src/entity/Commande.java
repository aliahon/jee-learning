package entity;

import javax.persistence.*;

@Entity
@Table(name="Commande")
public class Commande {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="Numcom")
			private long Numcom;
			
			@Column(name="DateCom")
			private String DateCom;
			
			@ManyToOne
			@JoinColumn(name="NumCl")
			private Client client;
		
			public Commande() {}
	
			public Commande( String dateCom, Client client) {
				super();
			
				DateCom = dateCom;
				this.client = client;
			}
	
			public Client getClient() {
				return client;
			}
		
			public void setClient(Client client) {
				this.client = client;
			}
			
			public long getNumcom() {
				return Numcom;
			}
		
			public void setNumcom(long numcom) {
				Numcom = numcom;
			}
		
			public String getDateCom() {
				return DateCom;
			}
		
			public void setDateCom(String dateCom) {
				DateCom = dateCom;
			}

}
