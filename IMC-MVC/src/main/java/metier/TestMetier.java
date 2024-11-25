package metier;
public class TestMetier {
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			ImcMetierImpl metier=new ImcMetierImpl();
			double taille=1.2;
			int poids=65;
			double imc=metier.calculerImc(poids, taille);
			System.out.println(imc);
	}
}