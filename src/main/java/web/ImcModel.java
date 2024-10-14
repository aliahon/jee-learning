package web;

public class ImcModel {
	
	private int poids;
	private double taille;
	private double imc;
	
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	public ImcModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImcModel(int poids, double taille, double imc) {
		super();

		this.poids = poids;
		this.taille = taille;
		this.imc = imc;
	}
}