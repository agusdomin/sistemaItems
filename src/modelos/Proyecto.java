/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.*;
import modelos.Item;
/**
 *
 * @author agus
 */
public class Proyecto {
    private String nombre;
    private ArrayList<Item> items = new ArrayList<>();
    
    public Proyecto(String nombre){
        this.nombre=nombre;
    }
    
}
