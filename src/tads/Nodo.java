package tads;

public class Nodo<T> { //<T>: clase generica y ouede almaccenar cualquier tipo de dato
    T dato; //dato es el valor que el nodo almacena
    Nodo<T> siguiente; //siguiente nodo en la lista
    Nodo<T> anterior;// anterior nodo en la lista
    
    public Nodo(T dato) { //constructor
        this.dato = dato;
        this.siguiente =null;
        this.anterior = null;
    }
    
    //setter && getters

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
    
    @Override
    public String toString() {
        return dato.toString();
    }
    
    @Override
    public boolean equals(Object obj){
        Nodo<T> objecto = (Nodo<T>) obj;
        return this.dato.equals(objecto.dato);
    }
}
