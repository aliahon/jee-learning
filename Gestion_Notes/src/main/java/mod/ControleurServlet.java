package mod;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.bean.NoteForm;
import mod.sco.Scolarite;

@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
			Scolarite sco=new Scolarite();
			NoteForm nf=new NoteForm();
			
			nf.setNum_Ins(request.getParameter("num_Ins"));
			nf.setLesNots(sco.getNotes(nf.getNum_Ins()));
			
			HttpSession session=request.getSession();
			session.setAttribute("nf",nf);
			response.sendRedirect("Notes.jsp");
			
	}

}
