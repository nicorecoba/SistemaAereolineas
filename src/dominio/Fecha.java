
package dominio;

public class Fecha {
    int dia;
    int mes;
    int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fecha fecha = (Fecha) obj;
        return dia == fecha.dia && mes == fecha.mes && año == fecha.año;
    }
    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
}