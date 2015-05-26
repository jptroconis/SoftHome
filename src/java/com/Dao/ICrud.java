
package com.Dao;


public interface ICrud<T> {
    
    void conectar();
    void terminar();
    void guardar(T data);
    void eliminar(T data);
    Object buscar(Class o, Object data);
    boolean isUnique(Class o, Object val);
    Object verTodos(Class c);
    void actualizar(T data);
    
}
