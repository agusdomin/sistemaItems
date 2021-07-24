/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author agus
 */
public class Estado {
    private String nombre;
    private ArrayList<Estado> estados_siguientes = new ArrayList<>();
    
    public Estado(String nombre){
        this.nombre=nombre;
    }
    public Estado(String nombre,Estado estado){
        this.nombre=nombre;
        this.estados_siguientes.add(estado);
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public void addEstadoSig(Estado estado){
        this.estados_siguientes.add(estado);
        System.out.println("add"+estados_siguientes);
    }
    
    public ArrayList<Estado> getEstadosSig(){
        System.out.println("extract"+estados_siguientes);
        return this.estados_siguientes;
    }
    
}
