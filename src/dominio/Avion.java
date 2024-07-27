
package dominio;

public class Avion<T> {
    String codigo;
    int capacidadMax;
    String nomAerolinea;   
    
    
    
    public Avion(String codigo, int capacidadMax, String nomAerolinea) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
        this.nomAerolinea = nomAerolinea;
                
    }
    
    @Override
      public String toString(){
          return codigo+"-"+capacidadMax;
      }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public String getNomAerolinea() {
        return nomAerolinea;
    }

    public void setNomAerolinea(String nomAerolinea) {
        this.nomAerolinea = nomAerolinea;
    }
      
        @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Avion avion = (Avion) obj;
        return this.codigo != null && this.codigo.equals(avion.codigo);
    }

}
