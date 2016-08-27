package br.com.fiap.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.persistencia.bean.Veiculo;
import br.com.fiap.persistencia.factory.ConnectionFactory;

public class VeiculoDAO {

	private Connection connection;
	
	public VeiculoDAO (){
		try {
			this.connection = ConnectionFactory.openConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integer insert(Veiculo veiculo){
		PreparedStatement stmt;
		String sql = "insert into veiculo(marca,modelo,anofabricacao,anomodelo,patio_idpatio) values (?, ?, ?, ?, ?)";
		String key[] = {"idveiculo"};
		Integer idGerado = 0;
		
		try {
			
			stmt = connection.prepareStatement(sql, key);
			
			stmt.setString(1, veiculo.getMarca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setInt(3, veiculo.getAnoFabricacao());
			stmt.setInt(4, veiculo.getAnoModelo());
			stmt.setInt(5, veiculo.getPatio().getIdPatio());
			
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

	public boolean update(Veiculo veiculo){
		PreparedStatement stmt;
		try {
			
			stmt = connection.prepareStatement("update veiculo set marca=?, modelo=?, anofabricacao=?, anomodelo=?, patio_idpatio=? where idveiculo=?");
			stmt.setString(1, veiculo.getMarca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setInt(3, veiculo.getAnoFabricacao());
			stmt.setInt(4, veiculo.getAnoModelo());
			stmt.setInt(5, veiculo.getPatio().getIdPatio());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void delete(Veiculo veiculo){
		PreparedStatement stmt;
		
		try {
			
			stmt = connection.prepareStatement("delete from veiculo where idveiculo=?");
			stmt.setInt(1, veiculo.getIdVeiculo());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Veiculo retrieve(Integer primaryKey){
		PreparedStatement stmt;
		Veiculo veiculo = null;
		
		try{
			stmt = connection.prepareStatement("select * from veiculo where idveiculo = " + primaryKey);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				veiculo = new Veiculo();
				
				veiculo.setIdVeiculo(rs.getInt("idveiculo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setAnoFabricacao(rs.getInt("anofabricacao"));
				veiculo.setAnoModelo(rs.getInt("anomodelo"));
				veiculo.getPatio().setIdPatio(rs.getInt("patio_idpatio"));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		return veiculo;
	}
	
	public List<Veiculo> listar(){   
		PreparedStatement stmt;
		List<Veiculo> lista = null;
		
		try {
			stmt = connection.prepareStatement("select * from veiculo");
			ResultSet rs = stmt.executeQuery();
			
			lista = new ArrayList<Veiculo>();
			
			while(rs.next()){
				Veiculo veiculo = new Veiculo();
				
				veiculo.setIdVeiculo(rs.getInt("idveiculo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setAnoFabricacao(rs.getInt("anofabricacao"));
				veiculo.setAnoModelo(rs.getInt("anomodelo"));
				veiculo.getPatio().setIdPatio(rs.getInt("patio_idpatio"));
				
				lista.add(veiculo);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    return lista;
	}
}
