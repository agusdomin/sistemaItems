/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.text.DateFormat;
import java.util.*;
import modelos.Estado;
import modelos.Usuario;
import modelos.TipoItem;
/**
 *
 * @author agus
 */
public class Item {
    private String nombre;
    private String prioridad;
    private TipoItem tipo;
    private Usuario responsable;
    
    DateFormat Date = DateFormat.getDateInstance();
    Calendar cals = Calendar.getInstance();
    private String fecha;
    //private Estado estado_actual;
   
    
    private Estado estado_actual;
    private ArrayList<Estado> secuencia_pasada= new ArrayList<>();
    
    
    
    public Item(String nombre, TipoItem tipo, String prioridad, Usuario responsable){
        this.nombre=nombre;
        this.tipo=tipo;
        this.prioridad=prioridad;
        this.responsable=responsable;
        this.fecha=Date.format(cals.getTime());
        this.estado_actual=this.tipo.getPrimerEstado();
    }
    
    public String getNombre(){
        return nombre;
    }
            
    public String getTipo(){
        return tipo.getNombre();
    }
    
    public String getResponsable(){
        return responsable.getNombre();
    }
    public void setResponsable(Usuario usr){
        this.responsable=usr;
    }
    
    public String getPrioridad(){
        return prioridad;
    }
    public String toString(){
        return "Creacion de nuevo item\nNombre: "+this.getNombre()+"\nTipo: "+this.getTipo()+"\nResponsable: "+this.getResponsable()+"\nNivel de prioridad: "+this.getPrioridad();
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public String getEstadoActual(){
        return this.estado_actual.getNombre();
    }
    
    public void setEstadoActual(){
        this.estado_actual= this.secuencia_pasada.get(this.secuencia_pasada.size());
    }
    
    public void pasarEstado(){
        this.addHistorial(estado_actual);
       
        //consultar el proximo estado posible
        //setear ese estado como el actual
        //this.estado_actual= ...
    }
    
    public void addHistorial(Estado estado){
        this.secuencia_pasada.add(estado);
    }
    
    public ArrayList getHistorial(){
        return this.secuencia_pasada;
    }
}
