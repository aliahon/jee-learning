package entity;

import javax.persistence.*;

@Entity
@Table(name="Article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Codeart")
	private long Codeart;
	@Column(name="Desart")
	private String Desart;
	@Column(name="Couleur")
	private String Couleur;
	@Column(name="Puart")
	private double Puart;
	@Column(name="Qtestock")
	private double Qtestock;
	
	public Article() {}
	
	public Article( String desart, String couleur, double puart, double qtestock) {
		super();
		Desart = desart;
		Couleur = couleur;
		Puart = puart;
		Qtestock = qtestock;
	}
	public long getCodeart() {
		return Codeart;
	}
	public void setCodeart(long codeart) {
		Codeart = codeart;
	}
	public String getDesart() {
		return Desart;
	}
	public void setDesart(String desart) {
		Desart = desart;
	}
	public String getCouleur() {
		return Couleur;
	}
	public void setCouleur(String couleur) {
		Couleur = couleur;
	}
	public double getPuart() {
		return Puart;
	}
	public void setPuart(double puart) {
		Puart = puart;
	}
	public double getQtestock() {
		return Qtestock;
	}
	public void setQtestock(double qtestock) {
		Qtestock = qtestock;
	}
	
}
