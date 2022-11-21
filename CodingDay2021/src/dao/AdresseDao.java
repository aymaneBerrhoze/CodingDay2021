package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Adresse;

public class AdresseDao implements Dao<Adresse> {

	@Override
	public Adresse findById(int id) {
		// TODO Auto-generated method stub
		Adresse a = null ; 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement( 
					" select * from adresse where id=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				a  = new Adresse();
				a.setRue(rs.getString("rue"));
				a.setCodePostal(rs.getString("codePostal"));
				a.setVille(rs.getString("ville"));
				
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Adresse> findAll() {
		// TODO Auto-generated method stub
		List<Adresse> adresses = new ArrayList<Adresse>(); 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement(" select * from adresse ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Adresse p = new Adresse();
				p.setIdAdresse(rs.getInt("id"));
				p.setRue(rs.getString("rue"));
				p.setCodePostal(rs.getString("codePostal"));
				p.setVille(rs.getString("ville"));
				adresses.add(p);
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adresses;
	}

	@Override
	public void save(Adresse t) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into adresse(rue,codePostal,ville,idPersonne) values(?,?,?,?)");
				
			ps.setString(1,t.getRue());
			ps.setString(2, t.getCodePostal());
			ps.setString(3, t.getVille());
			ps.setInt(4, t.getIdPersonne());

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void update(Adresse t) {
		// TODO Auto-generated method stub
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("update adresse \r\n" + 
					"set  rue=? , codePostal=? , ville=? WHERE id=? ;");
			
			ps.setString(1, t.getRue());
			ps.setString(2, t.getCodePostal());
			ps.setString(3, t.getVille());
			ps.setInt(4, t.getIdAdresse());
			
			ps.executeUpdate();
	        ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from adresse where id=?");
			
			ps.setInt(1,id);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	
	public List<Adresse> findByIdPersonne(int id) {
		List<Adresse> adresses = new ArrayList<Adresse>(); 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement( 
					" select * from adresse where idPersonne=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Adresse a  = new Adresse();
				a.setIdAdresse(rs.getInt("id"));
				a.setRue(rs.getString("rue"));
				a.setCodePostal(rs.getString("codePostal"));
				a.setVille(rs.getString("ville"));
				adresses.add(a);
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adresses;
	}
	
	public List<Adresse> findByIdPersonneNotEqual(int id) {
		List<Adresse> adresses = new ArrayList<Adresse>(); 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement( 
					" select * from adresse where idPersonne!=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Adresse a  = new Adresse();
				a.setIdAdresse(rs.getInt("id"));
				a.setRue(rs.getString("rue"));
				a.setCodePostal(rs.getString("codePostal"));
				a.setVille(rs.getString("ville"));
				adresses.add(a);
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adresses;
	}
	
	public void updatePersonne(Adresse adresse) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("update personne p \r\n" + 
					"set  p.nom=? , p.prenom=? , p.sexe=? INNER JOIN adresse a WHERE a.idPersonne=p.id and a.id=? ;");
			
			ps.setString(1, adresse.getPersonne().getNom());
			ps.setString(2, adresse.getPersonne().getPrenom());
			ps.setString(3, adresse.getPersonne().getSexe());
			ps.setInt(4, adresse.getIdAdresse());
			
			ps.executeUpdate();
	        ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}
	

}
