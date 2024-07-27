/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tadCola;


public class Cola<T> implements ICola<T> {
    private Nodo<T> frente;
    private Nodo<T> fondo;
    private int tamanio;
    private int maximonodosaceptados;

    public Cola(int maximonodosaceptados) {
        this.frente = null;
        this.fondo = null;
        this.tamanio = 0;
        this.maximonodosaceptados = maximonodosaceptados;
    }

    @Override
    public boolean esVacia() {
        return tamanio == 0;
    }

    @Override
    public boolean esLlena() {
        return tamanio == maximonodosaceptados;
    }

    @Override
    public void encolar(T dato) {
        if (!esLlena()) {
            Nodo<T> nuevo = new Nodo<>(dato);
            if (esVacia()) {
                frente = nuevo;
                fondo = nuevo;
            } else {
                fondo.setSiguiente(nuevo);
                fondo = nuevo;
            }
            tamanio++;
        }
    }

    @Override
    public void desencolar() {
        if (!esVacia()) {
            frente = frente.getSiguiente();
            tamanio--;
        }
    }

    @Override
    public Nodo<T> frente() {
        return frente;
    }

    @Override
    public Nodo<T> fondo() {
        return fondo;
    }

    @Override
    public int tamanio() {
        return tamanio;
    }

    public void setTamanio(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}