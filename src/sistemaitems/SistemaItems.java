package sistemaitems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import modelos.Proyecto;
import Panels.Login;
import javax.swing.JFrame;
import java.awt.*;
/**
 *
 * @author agus
 */
public class SistemaItems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Frame frame= new Frame();
        //frame.setVisible(true)
        Login login=new Login();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //frame.setVisible(true);
                login.setVisible(true);
            }
        });
    }    
    
}
