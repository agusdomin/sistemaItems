/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.util.*;
import modelos.Estado;
/**
 *
 * @author agus
 */
public class TipoItem {
    private String nombre;
    private ArrayList<Estado> secuencia = new ArrayList<>();
    
    public TipoItem(String nombre, Estado inicial){
        this.nombre=nombre;
        this.secuencia.add(inicial);
    }
    //resolver asignacion de secuencia
    public String getNombre(){
        return this.nombre;
    }
    
    public void addEstado(Estado estado){
        this.secuencia.add(estado);
    }
    
    //permite a travez del tipo item, establecer otra posible ruta de un estado a otro estado ya existente en la secuencia
    public void setRollback(String seleccionado, Estado estado_sig){
        for(Estado estado:this.secuencia){
            if(estado.getNombre().equals(seleccionado)){
                System.out.println("añadido");
                estado.addEstadoSig(estado_sig);
            }
        }
        
    }
    
    //Retorna el siguiente estado lineal por defecto en la secuencia
    public Estado getSiguiente(Estado estado){
        
            for(int i=0;i<this.secuencia.size()-1;i++){
                if(this.secuencia.get(i)==estado){   
                    return this.secuencia.get(i+1);
                }
            }
            
        return null;
    }
    public ArrayList getSecuencia(){
        return this.secuencia;
    }
    
    public Estado getPrimerEstado(){
        return this.secuencia.get(0);
    }
}
