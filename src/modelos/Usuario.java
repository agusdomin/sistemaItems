/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.util.*;
import modelos.Equipo;
/**
 *
 * @author agus
 */
public class Usuario {
    private String nombre;
    private String rol;
    private Equipo equipo;
    
    public Usuario(String nombre, String rol, Equipo equipo){
        this.nombre=nombre;
        this.rol=rol;
        this.equipo=equipo;
    }
    
    public String getRol(){
        return rol;
    } 
    
    public void setRol(String rol){
        this.rol=rol;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public Equipo getEquipo(){
        return equipo;
    }
    public void setEquipo(Equipo equipo){
        this.equipo=equipo;
    }
    
}
