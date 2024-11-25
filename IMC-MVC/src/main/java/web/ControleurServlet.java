package web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ImcMetierImpl;

public class ControleurServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImcMetierImpl metier;
	@Override
	public void init() throws ServletException {
		metier=new ImcMetierImpl();

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException {
		req.setAttribute("ImcModel", new ImcModel());
		req.getRequestDispatcher("VueImc.jsp").forward(req,rep);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException {
		
		/*lire les données de la req*/
		int poids = Integer.parseInt(req.getParameter("poids"));
		double taille = Double.parseDouble(req.getParameter("taille"));
		
		/*stocker dans le model*/
		ImcModel model= new ImcModel();
		model.setPoids(poids);
		model.setTaille(taille);
		
		/*faire le trait (appel metier)*/
		double res=metier.calculerImc(poids, taille);
		
		/*stocker le res dans le model */
		model.setImc(res);
		
		/*stocker le model dans l'objet req*/
		req.setAttribute("ImcModel", model);
		
		/*faire le forward vers la vue jsp*/
		req.getRequestDispatcher("VueImc.jsp").forward(req, rep);
	}
}