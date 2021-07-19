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
    
    public ArrayList getSecuencia(){
        return this.secuencia;
    }
    
    public Estado getPrimerEstado(){
        return this.secuencia.get(0);
    }
}
