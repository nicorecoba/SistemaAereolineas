package tads;

public class Lista<T> implements ILista<T> {

    public Nodo<T> cabeza;
    int contador;

    //constructor
    public Lista() {
        this.cabeza = null;
        this.contador=0;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public void agregarInicio(T dato) {
       
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        nuevoNodo.siguiente = cabeza;
        
        cabeza = nuevoNodo;    
        
        }
    @Override
    public void agregarFinal(T dato) {
        Nodo nuevoNodo = new Nodo<>(dato);
        if(this.esVacia()){
            cabeza = nuevoNodo;
        }else{    
                Nodo actual = cabeza;
                
                while (actual.siguiente != null){
                    
                    actual=actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
        }
    }
    
    @Override
    public boolean existeElemento(T dato) {
        
        boolean ret = false;
        
        if(!this.esVacia()){
            
            Nodo<T> aux = cabeza;
            
            while( aux != null && !ret){
            
                if(aux.getDato().equals(dato)){                    
                    ret = true;                    
                }
                aux = aux.siguiente;
            } 
        }
        
        return ret;
    }
    
    
    
    @Override
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (this.esVacia()) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            
            nuevoNodo.anterior = actual;
            
        }
        this.contador++;
    }
    
    @Override
    public boolean esVacia() {
          return this.cabeza == null;
    }    
    
    @Override
    public String mostrarElementos() {
        String mostrar="";
        if(!this.esVacia()){
            
        Nodo<T> aux = cabeza;
        while(aux !=null){
            mostrar+= aux.toString()+ "|\n ";
            aux= aux.siguiente;
        }
        
        }
        return mostrar;
    }

    
    
    @Override
    public Nodo<T> obtenerElemento(T dato) {
        
        Nodo<T> nuevo = new Nodo<T> (null); 
        
        Nodo<T> encontrarNodo = cabeza;
        
        boolean encontrado = false;
        while(encontrarNodo != null && !encontrado){
            if(encontrarNodo.dato.equals(dato)){
                encontrado = true;
                
                nuevo = encontrarNodo;
            } else{
              encontrarNodo= encontrarNodo.siguiente;  
            }
            
        }
        return nuevo;
    }
    
    @Override
    public void borrarElemento(T dato) {
        Nodo<T> nodoObtenido = obtenerElemento(dato);
        Nodo<T> nodoSiguiente = nodoObtenido.siguiente;
        Nodo<T> nodoAnterior = nodoObtenido.anterior;
        if(contador == 1){
            vaciar();
        }else if(nodoAnterior == null){
            cabeza = nodoSiguiente;
            
        }else if(nodoSiguiente == null){
            nodoAnterior.siguiente =null;
            
        }else{
           nodoSiguiente.setAnterior(nodoObtenido.anterior);
           nodoAnterior.setSiguiente(nodoObtenido.siguiente);
            
        }
        contador--;
        
        
    }
    @Override
    public void vaciar() {
        cabeza = null;
    }
    
    @Override
    public void borrarInicio() {
        
        if(!this.esVacia()){
            //mensaje de error
            
        }else{
            
            cabeza = cabeza.siguiente;
        }
        
        }

    @Override
    public int cantElementos() {
       
        return contador;
    }

    @Override
    public int tamaño() {
        return this.contador;
    }

    @Override
    public T obtener(int indice) {
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    @Override
    public String mostrarElementosRecursivamente(Nodo<T> nodo) {
        
        if (nodo == null){
            
            return "";
        }
        
        return nodo.getDato().toString()+"|\n"+mostrarElementosRecursivamente(nodo.getSiguiente() );
    }

    @Override
    public void agregarOrdenado(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarFinal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

    
    

    

