
package tads;

public interface ILista<T> {
    public boolean esVacia();
    public void agregarInicio(T dato);
    public void agregarOrdenado(T dato);
    public void agregarFinal(T dato);
    public void borrarInicio();
    public void borrarFinal();
    public void borrarElemento(T dato);
    public void vaciar();
    public void mostrar();
    public int cantElementos();
    public Nodo obtenerElemento(T dato);
    public boolean existeElemento(T dato);
    
    // metodos para el ejemplo avion vuelos
    public void agregar(T dato);
    public int tamaño();
    public T obtener(int indice);
    public String mostrarElementos();
    public String mostrarElementosRecursivamente(Nodo<T> nodo);
       
}
