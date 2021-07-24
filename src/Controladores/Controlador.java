/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import modelos.Usuario;
import modelos.Equipo;
import modelos.Proyecto;
import modelos.Item;
import modelos.TipoItem;
import java.util.*;
import modelos.Estado;
/**
 *
 * @author agus
 */
public class Controlador {
    private Usuario usuario_logged;
    
    private ArrayList<Usuario> usuarios= new ArrayList<>();
    private ArrayList<Equipo> equipos= new ArrayList<>();
    private ArrayList<TipoItem> tipos= new ArrayList<>();
    private ArrayList<Item> items= new ArrayList<>();
    
    public Controlador(){
        Proyecto proy1= new Proyecto("proyecto1");
        
        Equipo eq1=new Equipo("Desarrollo",proy1);
        equipos.add(eq1);
        
        Usuario usr1=new Usuario("agustin","lider",eq1);
        Usuario usr2=new Usuario("sebastian","responsable",eq1);
        
        usuarios.add(usr1);
        usuarios.add(usr2);
        
        
        Estado est1= new Estado("Desarrollo");
        Estado est2= new Estado("Validcaion");
        Estado est3= new Estado("Terminado");
        
        TipoItem tipo1= new TipoItem("reporte de bug",new Estado("Creado"));
        TipoItem tipo2= new TipoItem("error",new Estado("Creado"));
        TipoItem tipo3= new TipoItem("validacion",new Estado("Creado"));
        
        tipo1.addEstado(est1);
        tipo1.addEstado(est2);
        tipo1.addEstado(est3);
        
        tipos.add(tipo1);
        tipos.add(tipo2);
        tipos.add(tipo3);
        
        Item item1= new Item("item1",tipo1,"1",usr2);
        Item item2= new Item("item2",tipo2,"1",usr1);
        Item item3= new Item("item3",tipo3,"3",usr1);
        
        items.add(item1);
        items.add(item2);
        items.add(item3);
        
    }
    
    //Devuelve la instancia del estado brindado en forma de String
    public Estado getEstado(String e,TipoItem t){
        ArrayList<Estado> estados=t.getSecuencia();
        for(Estado estado: estados){
            if(e==estado.getNombre()){
                System.out.println("encontrado");
                return estado;
            }
        }
        return null;
    }
    
    public ArrayList<Estado> getSiguientesEstados(Item item){
        ArrayList<Estado> estados= new ArrayList<>();        
        
        if(((item.getTipo().getSiguiente(    item.getEstadoActual()  ))!=null)||(item.getEstadoActual().getEstadosSig()!=null)){
            //obtengo el siguiente estado lineal de la secuencia del item que se esta trabajando
            estados.add((   item.getTipo().getSiguiente(    item.getEstadoActual()  ) ));    
            //obtengo los estados que implican volver a estados anteriores
            estados.addAll( item.getEstadoActual().getEstadosSig() );
            return estados;
        }
        return null;
    }
    
    
    
    public void crearTipo(String nombre, ArrayList<Estado> estados){
        TipoItem nuevo_tipo= new TipoItem(nombre, new Estado("Creado"));
        for(Estado e: estados){
            nuevo_tipo.addEstado(e);
        }
        tipos.add(nuevo_tipo);
    }
    
    public TipoItem getTipo(String nombre){
        for(TipoItem tipo: tipos){
            if(tipo.getNombre().equals(nombre)){
                return tipo;
            }
        }
        return null;
    }
    public ArrayList getTiposItem(){
        return tipos;
    }
    
    public String getResponsable(Item item){
        return item.getResponsable();
    }
    public ArrayList getResponsables(){
        Equipo equipo= usuario_logged.getEquipo();
        ArrayList<Usuario> compas= new ArrayList<>();
        for(Usuario r: usuarios){
            if(r.getEquipo()==equipo){
                compas.add(r);
            }
        }
        return compas;
    }
   
    public Item crearItem(String nombre,String t, String prior, String r){
        TipoItem tipo = null;
        Usuario responsable = null;
        
        for(TipoItem i: tipos){
            if(i.getNombre().equals(t)){
                tipo=i;
                break;
            }
        }
        
        for(Usuario i: usuarios){
            if(i.getNombre().equals(r)){
                responsable=i;
                break;
            }
        }
        
        Item nuevo_item = new Item(nombre,tipo,prior,responsable);
        System.out.println(nuevo_item.toString());
        
        items.add(nuevo_item);
        
        System.out.println("Item añadido con exito");
        
        return nuevo_item;
        
    }
    
    
    
    //Retorna todos los items existentes
    public ArrayList getItems(){
        return items;
    }
    
    //Retorna los items del usuario logeado
    public ArrayList getItemsUsuario(){
        ArrayList<Item> listaItems= new ArrayList<>();
        for(Item i: items){
            if(i.getResponsable()==usuario_logged.getNombre()){
                listaItems.add(i);
            }
        }
        return listaItems;
    } 
    
    //Retorna el item especifico buscado
    public Item getItem(String nombre){
        for(Item item: items){
            if(item.getNombre().equals(nombre)){
                return item;
            }
        }
        return null;
    }
    
    //Login y usuario
    
    // Retorna si el usuario existe o no
    public boolean buscarUsuario(String s){
        //usuarios.contains()
        for (Usuario usr : usuarios){ 
          System.out.println(usr.getNombre());
          if (usr.getNombre().equals(s)){
              return true;
          }
        }
        return false;
    }
    
    public String getUserLogged(){
        return usuario_logged.getNombre();
    }
    
    //Cuando el usuario se logea, devuelve true si es usuario lider de proyecto
    // si es responsable retorna false para luego en el login poder visualizar un panel u otro
    public boolean LogearUsuario(String usr){
        usuario_logged=getUsuario(usr);
        if(usuario_logged.getRol().equals("lider")){
            return true;
        }else{
            return false;
        }
    }
    public void DesloggearUsuario(){
        usuario_logged=null;
    }
    
    // Retorna la instancia de objeto Usuario buscada segun el nombre
    public Usuario getUsuario(String s){
        for (Usuario usr : usuarios){ 
          if (usr.getNombre().equals(s)){
              return usr;
          }
        }
        return null;
    }
    
    public String getRol(Usuario usr){
        return usr.getRol();
    }
}