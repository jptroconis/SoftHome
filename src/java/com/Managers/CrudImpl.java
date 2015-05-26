package com.Managers;

import com.Dao.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public abstract class CrudImpl<T> implements ICrud<T> {

    protected Session session = null;
    protected Transaction tx = null;
    protected Query q = null;

    @Override
    public void conectar() {
        if (session == null) {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
        }else{
            if(!session.isOpen()){
                session = NewHibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();
            }
        }
    }

    @Override
    public void guardar(T data) {
        conectar();
        session.save(data);
        terminar();
    }

    @Override
    public boolean isUnique(Class o, Object val) {
        conectar();
        Object ob = session.createCriteria(o).add(Restrictions.idEq(val)).uniqueResult();
        terminar();
        return ob == null;
    }

    @Override
    public Object buscar(Class o, Object data) {
        conectar();
        Object res = session.createCriteria(o).add(Restrictions.idEq(data)).uniqueResult();
        terminar();
        return res;
    }

    @Override
    public void terminar() {
        tx.commit();
        session.close();
    }

    @Override
    public Object verTodos(Class c){
        conectar();
        Object res = session.createCriteria(c).list();
        terminar();
        return res;
    }

    @Override
    public void actualizar(T data) {
        conectar();
        session.update(data);
        terminar();
    }

    @Override
    public void eliminar(T data) {
        conectar();
        session.delete(q);
        terminar();
    }
    
    
    
    
    
}
