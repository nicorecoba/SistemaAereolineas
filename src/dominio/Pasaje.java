
package dominio;

public class Pasaje {
    
    String pasaporteCliente;
    String codigoVuelo;
    int categoriaPasaje;    
    boolean isDevuelto;
    
    
    public Pasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje, boolean isDevuleto) {
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
        this.categoriaPasaje = categoriaPasaje;
        this.isDevuelto = isDevuleto;
        
    }

    public boolean isIsDevuelto() {
        return isDevuelto;
    }

    public void setIsDevuelto(boolean isDevuelto) {
        this.isDevuelto = isDevuelto;
    }
    
    public String getPasaporteCliente() {
        return pasaporteCliente;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public int getCategoriaPasaje() {
        return categoriaPasaje;
    }

    public void setPasaporteCliente(String pasaporteCliente) {
        this.pasaporteCliente = pasaporteCliente;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public void setCategoriaPasaje(int categoriaPasaje) {
        this.categoriaPasaje = categoriaPasaje;
    }
    
    @Override
    public String toString(){
        
        return "Pasaporte: " + this.pasaporteCliente + "Categoria : " + this.categoriaPasaje;
    }
 
    
}
