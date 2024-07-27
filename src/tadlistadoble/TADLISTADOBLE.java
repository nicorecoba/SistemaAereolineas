
package tadlistadoble;

public class TADLISTADOBLE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Listadoble ld= new Listadoble(5);
        
        System.out.println("ES VACIA = "+ ld.esVacia());
        System.out.println("ES LLENA = "+ ld.esLLena());
        ld.agregarFinal(1);
        ld.agregarFinal("2 - pepe");
        ld.agregarInicio("3 - juan");
        ld.agregarFinal("4 - carlos");
        ld.agregarFinal(5);
        System.out.println("ES VACIA = "+ ld.esVacia());
        System.out.println("ES LLENA = "+ ld.esLLena()); 
        ld.agregarFinal("Andres");
        
        
        ld.mostrar();
        
        ld.eliminarelemento("2 - pepe");
        
        ld.mostrar();
    }
    
}
