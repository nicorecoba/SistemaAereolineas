/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import tads.Lista;
import tads.Nodo;


public class ListaVuelos<T> {
    
    public Lista<T> vuelos; 
    

    public ListaVuelos() {
        
       this.vuelos = new Lista<>();
    }
    
    
    public String ListaVuelosUnCliente(Cliente cliente) {
        
        Lista<Vuelo> vuelosCliente = new Lista<>();
        
        Nodo<T> cabeza = vuelos.getCabeza();
        
        Nodo<T> actual = cabeza;
        
        while(actual != null){
            
            Vuelo vuelo = (Vuelo) actual.getDato();
            
            Pasaje pasaje = vuelo.buscarPasajePorPasaporte(cliente.getPasaporte());
            
            if(pasaje != null){
                
                vuelosCliente.agregar(vuelo);
            }
            
            actual = actual.getSiguiente();
            
        }
        
        return vuelosCliente.mostrarElementos();
    }
    
     
    public Vuelo buscarVueloPorCodigo(String codigoVuelo) {
        
        Nodo<T> cabeza = vuelos.getCabeza();
        
        Nodo<T> actual = cabeza;
        
        while (actual != null) {
            
            Vuelo vuelo = (Vuelo) actual.getDato(); 
            
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                
                return vuelo;
            }
            
            actual = actual.getSiguiente();
        }
        return null; // Si no se encuentra un vuelo con el código especificado
    }
     
     public boolean existeVueloEnFecha(Fecha fecha){
         
         Nodo<Vuelo> cabeza = (Nodo<Vuelo>) vuelos.getCabeza();
        
        Nodo<Vuelo> actual = cabeza;
        
         while (actual != null) {
            
            if (actual.getDato().fecha.equals(fecha)) {
                
                return true;
            }
            
            actual = actual.getSiguiente();
        }
         
        return false; // Si no se encuentra ningun vuelo en dicha fecha
         
     }
          
      
    public boolean existeVuelo(Vuelo vuelo) {
                   
      return this.vuelos.existeElemento((T)vuelo);
    }  
              
 
    public Lista<T> getVuelos() {
        return this.vuelos;
    }
    
}
