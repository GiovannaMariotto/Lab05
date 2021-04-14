package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;

public class AnagrammaDAO {

	public boolean isCorrect(String parola) {
		String sql="SELECT p.nome,p.id "
				+ "FROM parola p "
				+ "WHERE p.nome=?";
		Parola p=null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, parola);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				p = new Parola(rs.getString("nome"));
				p.setId(rs.getInt("id"));
				p.setCorrect(true);
				
		
			}
			
			rs.close();
			ps.close();
			rs.close();
			
			
		} catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		
		if(p==null) {
			return false;
		}
		
		
		return true;
		
	}
	
	
}
