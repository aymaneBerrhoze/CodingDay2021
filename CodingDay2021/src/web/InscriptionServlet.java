package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Personne;
import dao.PersonneDao;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(urlPatterns = {"/Inscription"})
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneDao pMetier = new PersonneDao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getServletPath()!=null) {
		if(request.getServletPath().equals("/Inscription")){
			Personne p = new Personne();
			p.setPrenom(request.getParameter("prenom"));
			p.setNom(request.getParameter("nom"));
			p.setSexe(request.getParameter("sexe"));
			
			pMetier.save(p);
			
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}}
	}

}
