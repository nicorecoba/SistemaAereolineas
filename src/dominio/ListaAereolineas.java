package dominio;

import tads.Lista;
import tads.Nodo;


public class ListaAereolineas<T>{
       
    public Lista<T> aereolineas; 
    

    public ListaAereolineas() {
        
       this.aereolineas = new Lista<>();
    }

    
    public Aereolinea buscarAereolineaPorNombre(String nombre) {
        
        Nodo<Aereolinea> cabeza = (Nodo<Aereolinea>) this.aereolineas.getCabeza();
        
        Nodo<Aereolinea> actual = cabeza;
        
        while (actual != null) {
            
            if (actual.getDato().getNombre().equals(nombre)) {
                
                return actual.getDato();
            }
            
            actual = actual.getSiguiente();
        }
        return null; // Si no se encuentra ninguna aerolínea con el nombre especificado
        }
    
    
}



