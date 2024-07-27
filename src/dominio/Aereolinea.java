
package dominio;


import tads.Lista;
import tads.Nodo;

public class Aereolinea<T> implements IAereolinea {

    
//    String nombre, String pais, int cantMaxAviones
            
    String nombre;
    String pais;
    int cantMaxAviones;        
    Lista<T> aviones;
            
            
    public Aereolinea (String nombre, String pais, int cantMaxAviones){
        
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;    
        this.aviones = new Lista<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getCantMaxAviones() {
        return cantMaxAviones;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCantMaxAviones(int cantMaxAviones) {
        this.cantMaxAviones = cantMaxAviones;
    }


    public Lista<T> getAviones() {
        return aviones;
    }
    
     public Avion obtenerAvionPorCodigo(String codigoAvion) {
         
    Nodo<Avion> actual = (Nodo<Avion>) aviones.getCabeza();
    
    while (actual != null) {
        
        Avion avion = actual.getDato();
        
        if (avion.getCodigo().equals(codigoAvion)) {
            
            return avion;
        }
        actual = actual.getSiguiente();
    }
    return null; // Si no se encuentra un avión con el código especificado
}
    

    @Override
     public boolean equals(Object obj){
          Aereolinea<T> aereolinea = (Aereolinea<T>) obj;
    return aereolinea.nombre.equals(this.nombre);
      }
    
    @Override
    public boolean existeAvion(Avion avion) {
        return this.aviones.existeElemento((T)avion);
    }     
        
    @Override
    public String toString(){
        return this.nombre+"-"+this.pais+"-"+ this.cantMaxAviones; 
    }

    @Override
    public boolean contieneAviones() {
        return !this.aviones.esVacia();// 
    }
    
    
 }