/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author agus
 */
public class Estado {
    private String nombre;
    
    public Estado(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
}
