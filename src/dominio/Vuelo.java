
package dominio;

import tadCola.Cola;
import tads.Lista;
import tads.Nodo;

public class Vuelo<T> {
    
    String codigoVuelo;
    String aereolinea;
    String codAvion;
    String paisDestino;
    Fecha fecha;
    
    int cantPasajesEcon;
    int cantPasajesPClase;
    
    int pasajesEmitidosEcon = 0;
    int pasajesEmitidosPClase = 0;
    
    Lista<Pasaje> pasajes;
    Lista<Pasaje> pasajesDevueltos;
    
    Cola<Pasaje> listaEsperaEcon;
    Cola<Pasaje> listaEsperaPClase;
    
    
    //constructor

    public Vuelo(String codigoVuelo, String aereolinea, String codAvion, String paisDestino, Fecha fecha, int cantPasajesEcon, int cantPasajesPClase, int pasajesEmitidosEcon, int pasajesEmitidosPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aereolinea = aereolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.fecha = fecha;
        
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
        
        this.pasajesEmitidosEcon = pasajesEmitidosEcon;
        this.pasajesEmitidosPClase = pasajesEmitidosPClase;
        
        this.pasajes = new Lista<>();
        this.pasajesDevueltos = new Lista<>();
        
        this.listaEsperaEcon = new Cola<>(100);
        this.listaEsperaPClase = new Cola<>(100);
       
    }
    
   
    
     public boolean hayDisponibilidad(int categoria) {
         
        if (categoria == 1) {
            
            return pasajesEmitidosEcon < cantPasajesEcon;
            
        } else if (categoria == 2) {
            
            return pasajesEmitidosPClase < cantPasajesPClase;
            
        }
        return false;
    }
    
     
    public void agregarPasaje(Pasaje pasaje) {
        
        if (pasaje.getCategoriaPasaje() == 1) {
            
            pasajesEmitidosEcon++;
            
        } else if (pasaje.getCategoriaPasaje() == 2) {
            
            pasajesEmitidosPClase++;
        }
        pasajes.agregarInicio(pasaje);
    }
    
    
    
    
    public void agregarPasajeListaEspera(Pasaje pasaje) {
        
        if (pasaje.getCategoriaPasaje() == 1) {
            
            listaEsperaEcon.encolar(pasaje);
            
        } else if (pasaje.getCategoriaPasaje() == 2) {
            
           listaEsperaPClase.encolar(pasaje);
        }
        
    }
    
      public Pasaje buscarPasajePorPasaporte(String pasaporte) {
          
        Nodo<Pasaje> actual = pasajes.getCabeza();
        while (actual != null) {
            if (actual.getDato().getPasaporteCliente().equals(pasaporte)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
      
      
      public void eliminarPasaje(String pasaporte) {
          
        Nodo<Pasaje> actual = pasajes.getCabeza();
        
        
        while (actual != null) {
            
            if (actual.getDato().getPasaporteCliente().equals(pasaporte)) {
                
                int categoria = actual.getDato().getCategoriaPasaje();
                
                if (categoria == 1) {
                    
                    pasajesEmitidosEcon--;                                    
                    
                } else if (actual.getDato().getCategoriaPasaje() == 2) {
                    
                    pasajesEmitidosPClase--;
                }                
             
                actual.getDato().isDevuelto = true;
                this.pasajesDevueltos.agregarInicio(actual.getDato());
                
                reasignarPasajeDesdeListaEspera(categoria);
                
            }
            
            actual = actual.getSiguiente();
        }
    }
    
      public void reasignarPasajeDesdeListaEspera(int categoriaPasaje) {
          
        if (categoriaPasaje == 1 && !listaEsperaEcon.esVacia()) {
            
            Pasaje pasajeListaEspera = listaEsperaEcon.fondo().getDato();
            
            agregarPasaje(pasajeListaEspera);
            
        } else if (categoriaPasaje == 2 && !listaEsperaPClase.esVacia()) {
            
            Pasaje pasajeListaEspera = listaEsperaPClase.fondo().getDato();            
                        
            agregarPasaje(pasajeListaEspera);
        }
    }

    public Lista<Pasaje> getPasajesDevueltos() {
        return pasajesDevueltos;
    }

    public void setPasajesDevueltos(Lista<Pasaje> pasajesDevueltos) {
        this.pasajesDevueltos = pasajesDevueltos;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public String getAereolinea() {
        return aereolinea;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    public int getPasajesEmitidosEcon() {
        return pasajesEmitidosEcon;
    }

    public int getPasajesEmitidosPClase() {
        return pasajesEmitidosPClase;
    }

    public Lista<Pasaje> getPasajes() {
        return pasajes;
    }

    public Cola<Pasaje> getListaEsperaEcon() {
        return listaEsperaEcon;
    }

    public Cola<Pasaje> getListaEsperaPClase() {
        return listaEsperaPClase;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public void setAereolinea(String aereolinea) {
        this.aereolinea = aereolinea;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }

    public void setPasajesEmitidosEcon(int pasajesEmitidosEcon) {
        this.pasajesEmitidosEcon = pasajesEmitidosEcon;
    }

    public void setPasajesEmitidosPClase(int pasajesEmitidosPClase) {
        this.pasajesEmitidosPClase = pasajesEmitidosPClase;
    }

    public void setPasajes(Lista<Pasaje> pasajes) {
        this.pasajes = pasajes;
    }

    public void setListaEsperaEcon(Cola<Pasaje> listaEsperaEcon) {
        this.listaEsperaEcon = listaEsperaEcon;
    }

    public void setListaEsperaPClase(Cola<Pasaje> listaEsperaPClase) {
        this.listaEsperaPClase = listaEsperaPClase;
    }

    
     @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vuelo vuelo = (Vuelo) obj;
        return this.codigoVuelo != null && this.codigoVuelo.equals(vuelo.codigoVuelo);
    }
    
    private int cantDisponible(){
        
        int dispE = this.cantPasajesEcon-this.pasajesEmitidosEcon;
        
        int dispPClase = this.cantPasajesPClase-this.pasajesEmitidosPClase;
        
        return dispE + dispPClase;
    }
    
    @Override
    public String toString() {
        return codigoVuelo + "-" + aereolinea + "-" + codAvion + "-" + pasajesEmitidosEcon + "-" + pasajesEmitidosPClase + "-" + this.cantDisponible();
    }
    
    public String prueba() {
        return codigoVuelo ;
    }
    
     public Lista<Pasaje> getPasajesPorCategoria(int categoria) {
        Lista<Pasaje> pasajesCategoria = new Lista<>();
        Nodo<Pasaje> actual = pasajes.getCabeza();

        while (actual != null) {
            if (actual.getDato().getCategoriaPasaje() == categoria) {
                pasajesCategoria.agregarFinal(actual.getDato());
            }
            actual = actual.getSiguiente();
        }

        return pasajesCategoria;
    }
    
}