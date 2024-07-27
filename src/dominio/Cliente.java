
package dominio;


public class Cliente {
    
    String pasaporte;
    String nombre;
    int edad;
    
    
    public Cliente(String pasaporte, String nombre, int edad){
        
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return pasaporte + "-" + nombre + "-" + edad;
    }
    
    
}



