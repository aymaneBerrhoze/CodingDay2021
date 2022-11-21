package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Personne;
import dao.PersonneDao;

/**
 * Servlet implementation class GestionCompteServlet
 */
@WebServlet(urlPatterns = {"/supprimerPerso","/edit","/update","/afficherPerso"})
public class GestionCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneDao pMetier = new PersonneDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCompteServlet() {
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
		HttpSession session =request.getSession(); 
		if(request.getServletPath()!=null) {
			if (request.getServletPath().equals("/supprimerPerso")) {
				int num = Integer.parseInt(request.getParameter("id"));
				pMetier.remove(num);;
				session.invalidate();
				System.out.println(99);
				this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
				
			}
			if(request.getServletPath().equals("/edit")) {
				int numU = Integer.parseInt(request.getParameter("id"));
				this.getServletContext().getRequestDispatcher("/editCompte.jsp").forward(request, response);
			}
			
			if(request.getServletPath().equals("/update")) {
				
				String id =request.getParameter("id");
				System.out.println(id);
				Personne user = pMetier.findById(Integer.parseInt(id));
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String sexe = request.getParameter("sexe");
				
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setSexe(sexe);
				
				pMetier.update(user);
				
				this.getServletContext().getRequestDispatcher("/afficherPerso").forward(request, response);
			}
			if (request.getServletPath().equals("/afficherPerso")) {
				System.out.println(5);
				
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("idPersonne", pMetier.findById(id));
				System.out.println(6);
				this.getServletContext().getRequestDispatcher("/gestionCompte.jsp").forward(request, response);
	            System.out.println(55);
			}
			
		}
	}

}
