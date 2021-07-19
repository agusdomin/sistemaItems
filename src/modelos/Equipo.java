/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.util.*;
// import modelos.Usuario;
/**
 *
 * @author agus
 */
public class Equipo {
    private String nombre;
    private Proyecto proyecto;
//    private ArrayList<Usuario> miembros = new ArrayList<>();
    
    public Equipo(String nombre,Proyecto proy){
        this.nombre=nombre;
        this.proyecto=proy;
    }
    
    
    
}
