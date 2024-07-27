/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tadlistadoble;

public interface IListadoble {
    public boolean esVacia();
  public boolean esLLena();  
  public void agregarFinal(Object dato); 
  public void borrarFinal(); 
  public void agregarInicio(Object dato);   
  public void borrarInicio();     
  public int cantidad();    
  public void mostrar();  
  public boolean buscarelemento(Object dato);
  public NodoDoble obtenerelemento(Object dato); 
  public void eliminarelemento(Object dato); 
  public void agregarOrdenado(Object dato);
  public void mostrardelultimoalprimero();
  public void mostrardelprimeroalultimo();
  public void mostrarRec();   
}
