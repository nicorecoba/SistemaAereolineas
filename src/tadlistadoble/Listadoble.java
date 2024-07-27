package tadlistadoble;

public class Listadoble implements IListadoble {

    NodoDoble inicio = null;
    NodoDoble fin = null;
    int cantidad = 0;
    int maximoaceptado;

    public Listadoble(int maximoaceptado) {
        this.maximoaceptado = maximoaceptado;
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getFin() {
        return fin;
    }

    public void setFin(NodoDoble fin) {
        this.fin = fin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMaximoaceptado() {
        return maximoaceptado;
    }

    public void setMaximoaceptado(int maximoaceptado) {
        this.maximoaceptado = maximoaceptado;
    }
//------------------------------------------
// implementacion de metodos abstractos
//------------------------------------------

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public boolean esLLena() {
        return this.cantidad == this.maximoaceptado;
    }

    @Override
    public void agregarFinal(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (this.esVacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
            this.cantidad++;
        } else {
            if (!this.esLLena()) {
                this.fin.siguiente = nuevo;
                nuevo.anterior = this.fin;
                this.fin = nuevo;
                this.cantidad++;
            } else {
                System.out.println("Lista llena");
            }
        }
    }

    @Override
    public void borrarFinal()  {       
        if (!this.esVacia()){
            this.fin.anterior.siguiente=null;
            this.fin=this.fin.anterior;
            this.cantidad--;
            
        }else{
            System.out.println("no hay elementos a borrar");
        }


    }


    @Override
    public void agregarInicio(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (this.esVacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
            this.cantidad++;
        } else {
            if (!this.esLLena()) {
                nuevo.siguiente = this.inicio;
                this.inicio.anterior = nuevo;
                this.inicio = nuevo;
                this.cantidad++;
            } else {
                System.out.println("Lista llena");
            }
        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            this.inicio.siguiente.anterior=null;
            this.inicio=this.inicio.siguiente;
            this.cantidad--;
            
        }else{
            System.out.println("no hay elementos a borrar");
        }


    }

    @Override
    public int cantidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrar() {
        NodoDoble aux = this.getInicio();
        while (aux != null) {
            System.out.print(aux.getDato() + " - ");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public boolean buscarelemento(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NodoDoble obtenerelemento(Object dato) {
        NodoDoble buscado=null;
        NodoDoble aux=this.getInicio();
        
        while (aux!=null && buscado==null){
            if (aux.getDato()==dato){
                buscado=aux;
                
            }
            aux=aux.getSiguiente();
        }
        return buscado;
    }

    @Override
    public void eliminarelemento(Object dato) {
        NodoDoble Nodoaeliminar=obtenerelemento(dato);
        
        
        if (Nodoaeliminar!= null){
            if (Nodoaeliminar == this.inicio){
                this.borrarInicio();
            }else{
               if (Nodoaeliminar==this.fin){
                   this.borrarFinal();
               }else{
                    Nodoaeliminar.anterior.siguiente=Nodoaeliminar.siguiente;
                    Nodoaeliminar.siguiente.anterior=Nodoaeliminar.anterior;               
                    this.cantidad--;
               }
            
            }            
        }
    }

    @Override
    public void agregarOrdenado(Object dato) {
//    
//            NodoDoble nuevo = new NodoDoble(dato);
//
//            if(this.esVacia() || dato < this.getInicio().getDato()){
//                
//                this.agregarInicio(dato);
//            
//            }else{
//                
//                if(dato > this.getFin().getDato()){
//                    
//                    this.agregarFinal(0);
//                
//                }else{
//                    
//                    NodoDoble actual = this.getInicio();
//                }
//            }
    }

    @Override
    public void mostrardelultimoalprimero() {
    
        NodoDoble actual = this.fin;
        
        while(actual != null){
            
            System.out.print(actual.getDato() + " - ");
            
            actual = actual.anterior;
        }
    
        System.out.println();
    }

    @Override
    public void mostrardelprimeroalultimo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
