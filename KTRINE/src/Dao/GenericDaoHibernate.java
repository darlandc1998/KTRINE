package Dao;

import UtilConnection.UtilHibernate;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDaoHibernate<E> {
    
	protected Session session;
	protected Transaction transaction;
	protected Criteria criteria;
	protected Query query;	
	
	public void save() throws Exception {
		session = UtilHibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(this);
		transaction.commit();
		session.close();
	}
	
	public void delete() throws Exception {
		session = UtilHibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(this);
		transaction.commit();
		session.close();
	}
	
	public void update() throws Exception {
		session = UtilHibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(this);
		transaction.commit();
		session.close();
	}
        
	@SuppressWarnings("unchecked")	
	public E findById(Integer userId) throws Exception {
		session = UtilHibernate.getSessionFactory().openSession();
		return (E) session.get(this.getClass(), userId);
	}
        
	@SuppressWarnings("unchecked")	
	public List<E> findAll() throws Exception {
		session = UtilHibernate.getSessionFactory().openSession();
		criteria = session.createCriteria(this.getClass());
		return criteria.list();
	}
        
}
