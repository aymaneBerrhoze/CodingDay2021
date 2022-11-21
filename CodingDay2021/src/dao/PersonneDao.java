package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Personne;

public class PersonneDao implements Dao<Personne> {

	@Override
	public Personne findById(int id) {
		// TODO Auto-generated method stub
		Personne p = null ; 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement( 
					" select * from personne where id=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p  = new Personne();
				p.setIdPersonne(rs.getInt("id"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setSexe(rs.getString("sexe"));
				
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		List<Personne> personnes = new ArrayList<Personne>(); 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement(" select * from personne ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Personne p = new Personne();
				p.setIdPersonne(rs.getInt("id"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setSexe(rs.getString("sexe"));
				personnes.add(p);
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personnes;
	}

	@Override
	public void save(Personne t) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into personne(nom,prenom,sexe) values(?,?,?)");
				
			ps.setString(1,t.getNom());
			ps.setString(2, t.getPrenom());
			ps.setString(3, t.getSexe());

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void update(Personne t) {
		// TODO Auto-generated method stub
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("update personne \r\n" + 
					"set  nom=? , prenom=? , sexe=? WHERE id=? ;");
			
			ps.setString(1, t.getNom());
			ps.setString(2, t.getPrenom());
			ps.setString(3, t.getSexe());
			ps.setInt(4, t.getIdPersonne());
			
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
			PreparedStatement ps = conn.prepareStatement("delete from personne where id=?");
			
			ps.setInt(1,id);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	
	public Personne findByNomAndPrenom(String nom, String prenom) {
		
		Personne p = null ; 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement( 
					" select * from personne where nom=? and prenom=? ");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				p  = new Personne();
				p.setIdPersonne(rs.getInt("id"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setSexe(rs.getString("sexe"));
				
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
		
	}
	
	public boolean login(String nom, String prenom) {
		boolean a=false;		
		Connection connection = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT nom FROM personne WHERE prenom=? ");
			ps.setString(1, prenom);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("nom")).equals(nom) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
