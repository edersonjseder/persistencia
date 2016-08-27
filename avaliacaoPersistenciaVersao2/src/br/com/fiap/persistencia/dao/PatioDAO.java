package br.com.fiap.persistencia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.fiap.persistencia.bean.Patio;
import br.com.fiap.persistencia.hibernate.HibernateUtility;

public class PatioDAO {

	private Session session;
	
	public PatioDAO () {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
	}
	
	public Integer insert(Patio patio){
		try {
			
			session.beginTransaction();
			session.save(patio);
			session.flush();
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			e.printStackTrace();
			return 0;
		}
		
		return patio.getIdPatio();
	}
	
	public void delete(Patio patio){
		try{
			
			session.beginTransaction();
			session.delete(patio);
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public Patio retrieve(Integer primaryKey){
		try{
			session.beginTransaction();
			return (Patio) session.get(Patio.class, primaryKey);
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void update(Patio patio){
		try{
			
			session.beginTransaction();
			session.update(patio);
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Patio> listar(){
		
		List<Patio> list = null;
		
		try{
			session.beginTransaction();
			Criteria selectAll = session.createCriteria(Patio.class);   
			list = selectAll.list();
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
		
		return list;
	}	
}
