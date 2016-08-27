package br.com.fiap.persistencia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.fiap.persistencia.bean.Veiculo;
import br.com.fiap.persistencia.hibernate.HibernateUtility;

public class VeiculoDAO {

	private Session session;
	
	public VeiculoDAO () {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
	}
	
	public Integer insert(Veiculo veiculo){
		try {
			
			session.beginTransaction();
			session.save(veiculo);
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			e.printStackTrace();
			return 0;
		}
		
		return veiculo.getIdVeiculo();
	}
	
	public void delete(Veiculo veiculo){
		try{
			
			session.beginTransaction();
			session.delete(veiculo);
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public Veiculo retrieve(Integer primaryKey){
		try{
			session.beginTransaction();
			return (Veiculo) session.get(Veiculo.class, primaryKey);
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean update(Veiculo veiculo){
		try{
			
			session.beginTransaction();
			session.update(veiculo);
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listar(){
		List<Veiculo> list = null;
		
		try{
			session.beginTransaction();
			Criteria selectAll = session.createCriteria(Veiculo.class);   
			list = selectAll.list();
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
		
		return list;
	}
}
