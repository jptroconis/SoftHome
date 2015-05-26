
package com.Managers;

import java.util.List;


public class ObjectImpl<T> extends CrudImpl<T>{

    @Override
    public List<T> verTodos(Class c) {
        return (List<T>) super.verTodos(c);
    }
    
    
    
}
