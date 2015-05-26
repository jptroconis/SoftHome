
package com.Managers;

import com.Dao.IInmueble;
import com.Models.Inmuebles;
import java.util.List;
import org.hibernate.criterion.Restrictions;

public class InmuebleImpl extends CrudImpl<Inmuebles> implements IInmueble<Inmuebles>{

    @Override
    public List<Inmuebles> BuscarInmuebles(String par) {
        conectar();
        List<Inmuebles> li = 
                session.createCriteria(Inmuebles.class).add(Restrictions.eq("direccion", par)).list();
        return li;
    }

    
    
    
}
