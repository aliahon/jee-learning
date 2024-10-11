
public class Imc {
	
	private float poids;
	private float taille;
	
	public Imc(float p, float t) {
		poids=p;
		taille=t;
	}
	
	public float getPoids() {
		return poids;
	}
	public float getTaille() {
		return taille;
	}
	public float calcul() {
		return poids*10000/(taille*taille);
	}

}
