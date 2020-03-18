package br.com.zup.velorean.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//import br.com.zup.velorean.factory.ConnectionFactory;
import br.com.zup.velorean.pojo.Carro;

public class CarrosDAO {

//	private static final int PLACA = 1;
//	private static final int NOME = 2;
//	private static final int COR = 3;
//	private static final int FABRICANTE = 4;
//	private static final int VELMAX = 5;
//	private static final int PESO = 6;
	//Connection conexao;
	
	EntityManagerFactory factory;
	EntityManager manager;

	public CarrosDAO() {
		this.factory = Persistence.createEntityManagerFactory("carros");
		this.manager = factory.createEntityManager();
	}

	public void insereCarro(String nome,String placa, String cor, String fabricante, float velocidadeMaxima, float peso) {
		
		Carro carro = new Carro();
		
		carro.setPlaca(placa);
		carro.setNome(nome);
		carro.setCor(cor);
		carro.setFabricante(fabricante);
		carro.setPeso(peso);
		carro.setVelMax(velocidadeMaxima);
		carro.setPeso(peso);
		
		manager.getTransaction().begin();
		manager.persist(carro);
		manager.getTransaction().commit();
	}
	
	public Map<String,Carro> listaCarro() {
		Map<String,Carro> carros = new HashMap<String,Carro>();
		
		Query query = manager.createQuery("select c from Carro as c");
		List<Carro> carroL = query.getResultList();
		for (Carro carro : carroL) {
			carros.put(carro.getPlaca(), carro);
			
		}
		return carros;
	}
	
	public void removeCarro(String placa) {
		
		Carro carro = manager.find(Carro.class, placa);
		
		manager.getTransaction().begin();
		manager.remove(carro);
		manager.getTransaction().commit();
	}
	
	public void alteraCarro(String placa, String nome) {
		Carro carro = manager.find(Carro.class, placa);
		carro.setNome(nome);
		
		manager.getTransaction().begin();
		manager.merge(carro);
		manager.getTransaction().commit();
	}

	public Carro exibeCarro(String placa) {
		Carro carro = manager.find(Carro.class, placa);
		
		return carro;
	}
	
	
//	public CarrosDAO() {
//		this.conexao = new ConnectionFactory().getConnection();
//	}
//	
//	public void insereCarro(String nome,String placa, String cor, String fabricante, float velocidadeMaxima, float peso) {
//		
//		String sql = "insert into carro "
//				+ "values (?,?,?,?,?,?)";
//		
//		try {
//			PreparedStatement stmt = conexao.prepareStatement(sql);
//			stmt.setString(PLACA, placa);
//			stmt.setString(NOME,nome);
//			stmt.setString(COR, cor);
//			stmt.setString(FABRICANTE, fabricante);
//			stmt.setFloat(VELMAX, velocidadeMaxima);
//			stmt.setFloat(PESO, peso);
//			
//			stmt.execute();
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public Map<String,Carro> listaCarro() {
//		Map<String,Carro> carros = new HashMap<String,Carro>();
//		
//		String sql = "select * from carro";
//		try {
//			PreparedStatement stmt = conexao.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				Carro carro = new Carro();
//				carro.setNome(rs.getString("nome"));
//				carro.setPlaca(rs.getString("placa"));
//				carro.setCor(rs.getString("cor"));
//				carro.setFabricante(rs.getString("fabricante"));
//				carro.setVelMax(rs.getFloat("vel_max"));
//				carro.setPeso(rs.getFloat("peso"));
//				
//				carros.put(carro.getPlaca(), carro);
//			}
//			rs.close();
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return carros;
//	}
//
//	public void removeCarro(String placa) {
//		String sql = "delete from carro "
//				+ "where placa = ?";
//		
//		try {
//			PreparedStatement stmt = conexao.prepareStatement(sql);
//			stmt.setString(PLACA, placa);
//			stmt.execute();
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void alteraCarro(String placa, String nome) {
//		
//		String sql = "update carro "
//				+ "set nome = ? "
//				+ "where placa = ?";
//		
//		PreparedStatement stmt;
//		try {
//			stmt = conexao.prepareStatement(sql);
//			stmt.setString(1, nome);
//			stmt.setString(2, placa);
//			
//			stmt.execute();
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
