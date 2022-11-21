package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Adresse;
import dao.AdresseDao;
import dao.PersonneDao;

/**
 * Servlet implementation class GestionAffectationServlet
 */
@WebServlet(urlPatterns = {"/AjouterAdresse","/ajouterParPerso","/ListeAdressesAssociees","/ListeAdressesU","/editAdresse","/updateAdresse","/ListeAdressesNonAssociees","/supprimerAdresse"})
public class GestionAffectationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdresseDao aMetier = new AdresseDao(); 
	private PersonneDao pMetier = new PersonneDao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAffectationServlet() {
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
			if (request.getServletPath().equals("/ajouterParPerso")) {
				System.out.println(5);
				
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("id", pMetier.findById(id));
				
				System.out.println(6);
				this.getServletContext().getRequestDispatcher("/AjouterAdresse.jsp").forward(request, response);
	            System.out.println(55);
			}
			if (request.getServletPath().equals("/AjouterAdresse")) {
				int num = Integer.parseInt(request.getParameter("idPerso"));
				
				Adresse a = new Adresse();
				a.setIdPersonne(num);
				a.setRue(request.getParameter("rue"));
				a.setCodePostal(request.getParameter("codePostal"));
				a.setVille(request.getParameter("ville"));
				
				aMetier.save(a);
				
				this.getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
				
			}
			if(request.getServletPath().equals("/editAdresse")) {
				int numU = Integer.parseInt(request.getParameter("id"));
				this.getServletContext().getRequestDispatcher("/editAdresse.jsp").forward(request, response);
			}
			
			if(request.getServletPath().equals("/updateAdresse")) {
				
				String id =request.getParameter("id");
				System.out.println(id);
				Adresse user = aMetier.findById(Integer.parseInt(id));
				String rue = request.getParameter("rue");
				String codePostal = request.getParameter("codePostal");
				String ville = request.getParameter("ville");
				
				user.setRue(rue);
				user.setCodePostal(codePostal);
				user.setVille(ville);
				
				aMetier.update(user);
				
				this.getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
			}
			if (request.getServletPath().equals("/ListeAdressesAssociees")) {
				int num = Integer.parseInt(request.getParameter("idPersonne"));
				request.setAttribute("AdressesAssociees", aMetier.findByIdPersonne(num));	
				
				this.getServletContext().getRequestDispatcher("/AdressesAssociees.jsp").forward(request, response);
				
			}
			if (request.getServletPath().equals("/ListeAdressesU")) {
				int num = Integer.parseInt(request.getParameter("idPersonne"));
				request.setAttribute("AdressesAssociees", aMetier.findByIdPersonne(num));	
				
				this.getServletContext().getRequestDispatcher("/AdressesUtilisateur.jsp").forward(request, response);
				
			}
			if (request.getServletPath().equals("/ListeAdressesNonAssociees")) {
				int num = Integer.parseInt(request.getParameter("idPersonne"));
				request.setAttribute("AdressesnonAssociees", aMetier.findByIdPersonneNotEqual(num));	
				
				this.getServletContext().getRequestDispatcher("/AdressesnonAssociees.jsp").forward(request, response);
				
			}
			if (request.getServletPath().equals("/supprimerAdresse")) {
				int num = Integer.parseInt(request.getParameter("id"));
				aMetier.remove(num);
				System.out.println(99);
				this.getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
				
			}
		}
	}

}
