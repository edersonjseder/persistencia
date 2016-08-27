package br.com.fiap.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.persistencia.bean.Patio;
import br.com.fiap.persistencia.factory.ConnectionFactory;

public class PatioDAO {

	private Connection connection;
	
	public PatioDAO (){
		try {
			this.connection = ConnectionFactory.openConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integer insert(Patio patio){
		
		PreparedStatement stmt;
		String sql = "insert into patio(nome) values (?)";
		String key[] = {"idpatio"};
		Integer idGerado = 0;
		
		try {
			
			stmt = connection.prepareStatement(sql, key);
			stmt.setString(1, patio.getNome());
			
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			
			while(rs.next()){
				idGerado = rs.getInt(1);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		return idGerado;
	}

	public void update(Patio patio){
		PreparedStatement stmt;

		try {
			
			stmt = connection.prepareStatement("update patio set nome=? idpatio = " + patio.getIdPatio() + ";");
			stmt.setString(1, patio.getNome());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
	public void delete(Patio patio){
		PreparedStatement stmt;
		
		try {
			
			stmt = connection.prepareStatement("delete from patio where idpatio=?");
			stmt.setInt(1, patio.getIdPatio());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Patio retrieve(Integer primaryKey){
		PreparedStatement stmt;
		Patio patio = null;
		
		try{
			stmt = connection.prepareStatement("select * from patio where idpatio = " + primaryKey);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				patio = new Patio();
				
				patio.setIdPatio((rs.getInt("idpatio")));
				patio.setNome(rs.getString("nome"));
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return patio;
	}
	
	public List<Patio> listar(){   
		PreparedStatement stmt;
		List<Patio> lista = null;

		try {
			stmt = connection.prepareStatement("select * from patio");
			ResultSet rs = stmt.executeQuery();
			
			lista = new ArrayList<Patio>();
			
			while(rs.next()){
				Patio patio = new Patio();
				
				patio.setIdPatio((rs.getInt("idpatio")));
				patio.setNome(rs.getString("nome"));
				
				lista.add(patio);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    return lista;
	    
	}
	
}
