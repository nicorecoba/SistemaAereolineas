/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tadCola;

public interface ICola<T> {
    boolean esVacia();
    boolean esLlena();
    void encolar(T dato);
    void desencolar();
    Nodo<T> frente();
    Nodo<T> fondo();
    int tamanio();
}