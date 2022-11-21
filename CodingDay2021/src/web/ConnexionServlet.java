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
 * Servlet implementation class ConnexionServlet
 */
@WebServlet(urlPatterns = {"/Connexion","/logout"})
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneDao pMetier = new PersonneDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
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
			System.out.println(4);
			if (request.getServletPath().equals("/Connexion")) {
			if(pMetier.login(request.getParameter("nom"), request.getParameter("prenom"))){
				Personne p= pMetier.findByNomAndPrenom(request.getParameter("nom"), request.getParameter("prenom"));
				System.out.println(p.getSexe());
				String sexee="Monsieur";
				
				if(p.getSexe()=="F") {
					sexee="Madame";
					
				}
				session.setAttribute("sexe", sexee);
				session.setAttribute("personne", request.getParameter("prenom"));
				session.setAttribute("idPersonne", p.getIdPersonne());
				System.out.println("hey");
				
				request.getRequestDispatcher("/Home.jsp").forward(request, response); 		    	 
			}
			else {
				session.setAttribute("personne", null);
				int testA = 1 ; 
				String erreurA = "Prenom ou nom d'utilisateur incorrect ! ";
				session.setAttribute("testA", testA);
				session.setAttribute("eA", erreurA);
				System.out.println(erreurA);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			}
		}
			if(request.getServletPath().equals("/logout")) {
				System.out.println(00);
				session.invalidate();
				System.out.println(99);
				response.sendRedirect("index.jsp");
			
		}
	}

}
