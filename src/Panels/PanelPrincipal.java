/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import javax.swing.*;
import modelos.Item;

/**
 *
 * @author agus
 */
public abstract class PanelPrincipal extends JFrame{
    
    public abstract void actualizarItems(Item item);
    public abstract void actualizarEstados(Item item);
    
}
