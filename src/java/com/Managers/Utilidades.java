

package com.Managers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;


public class Utilidades {
    
    public static String Fechalimite(Date fd, int l){
        String f = fechaDia(fd);
        StringTokenizer st = new StringTokenizer(f, "-");
        int a = 0,m = 0,d = 0;
            a = (new Integer((String)st.nextElement())-l);
            m = new Integer((String)st.nextElement())-1;
            d = new Integer((String)st.nextElement());
        return fechaDia(new GregorianCalendar(a,m,d).getTime());
    }
    
    public static String fechaDia(Date f){
        DateFormat df = new SimpleDateFormat("yyy-MM-dd");
        return df.format(f);
    }
    
    
    
    public static Date crear_fecha(String data){
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            return df.parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static Date crear_fechaA(String data){
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }
}
