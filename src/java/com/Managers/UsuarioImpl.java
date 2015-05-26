package com.Managers;

import com.Dao.IUsuario;
import com.Models.Usuarios;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.criterion.Restrictions;

public class UsuarioImpl extends CrudImpl<Usuarios> implements IUsuario<Usuarios> {

    @Override
    public boolean isUnique(Class o, Object val) {
        conectar();
        Object ob = session.createCriteria(Usuarios.class).add(Restrictions.eq("nombre", val)).uniqueResult();
        terminar();
        return ob == null;
    }

    @Override
    public Object buscar(Class o, Object data) {
        conectar();
        Usuarios u = (Usuarios) data;
        Map m = new HashMap<>();
        m.put("nombre", u.getNombre());
        m.put("clave", u.getClave());
        Object ob = session.createCriteria(o).add(Restrictions.allEq(m)).uniqueResult();
        terminar();
        return ob;
    }

    @Override
    public Object verTodos(Class c) {
        conectar();
        Object res = session.createCriteria(c).list();
        return res;
    }

    @Override
    public Usuarios verUusuario(Object data) {
        conectar();
        Object ob = session.createCriteria(Usuarios.class).add(Restrictions.idEq(data)).uniqueResult();
        terminar();
        return (Usuarios) ob;
    }
    
    

}
