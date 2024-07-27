package sistemaAutogestion;

import dominio.ListaAereolineas;
import dominio.Aereolinea;
import dominio.Avion;
import dominio.Cliente;
import dominio.Fecha;
import dominio.ListaVuelos;
import dominio.Pasaje;
import tads.Nodo;
import dominio.Vuelo;
import tads.Lista;




public class Sistema<T> implements IObligatorio {

 public ListaAereolineas aereolineas; 
 public ListaVuelos vuelos;
 public Lista<Cliente> clientes;
    

    @Override
    public Retorno crearSistemaDeGestion() {
        this.aereolineas = new ListaAereolineas();
        this.vuelos = new ListaVuelos();
        this.clientes = new Lista<>();
        return Retorno.ok();
    }

    
@Override
 public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {

        Aereolinea nuevaAereolinea = new Aereolinea(nombre, pais, cantMaxAviones);
        
        
        if(nuevaAereolinea.getCantMaxAviones()<=0){
             
             return Retorno.error1();
             
         }else if(aereolineas.aereolineas.existeElemento(nuevaAereolinea)){             
                        
            return Retorno.error2();
            
         }else{
             
             aereolineas.aereolineas.agregar(nuevaAereolinea);
             return Retorno.ok();             
         }
        

 }

  @Override
    public Retorno eliminarAerolinea(String nombre) {
        Aereolinea buscadora = new Aereolinea<>(nombre,"-",0); 
        Nodo<Aereolinea<T>>aereoLineaObtenida = aereolineas.aereolineas.
                obtenerElemento(buscadora);


        if(aereoLineaObtenida.getDato()==null){
             return Retorno.error1();
        }else{
          Aereolinea areoLineaCasteada = aereoLineaObtenida.getDato(); 
          if(areoLineaCasteada.contieneAviones()){
            return Retorno.error2();
        }else{
            aereolineas.aereolineas.borrarElemento(areoLineaCasteada);
            return Retorno.ok();
        }
        } 

    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        
        Avion<T> nuevoAvion = new Avion<>(codigo, capacidadMax, nomAerolinea);
        Aereolinea aereolineaEncontrada = new Aereolinea(nomAerolinea,"",0);
        
        Nodo<Aereolinea<T>> aerolineaBuscar = aereolineas.aereolineas.obtenerElemento(aereolineaEncontrada);
    
        if(capacidadMax < 9 || capacidadMax % 3 != 0){
            
            return Retorno.error1(); //capacidad maxima debe ser mayor a 9 y multiplo de 3
        }
            
        
        if (aerolineaBuscar.getDato() == null) {
       
            return Retorno.error2();//La aerolínea no existe en el sistema
        }else{
            aereolineaEncontrada = aerolineaBuscar.getDato();
            
            if(aereolineaEncontrada.getAviones().cantElementos() == aereolineaEncontrada.getCantMaxAviones()){
                
                return Retorno.error4();
            }
            
            if(aereolineaEncontrada.existeAvion(nuevoAvion)){
                return Retorno.error3();
            }else{
                aereolineaEncontrada.getAviones().agregar(nuevoAvion);
                return Retorno.ok();
            }
            
        }
    }

   @Override
public Retorno eliminarAvion(String nombreAerolinea, String codigoAvion) {
    
    Aereolinea buscadoraAerolinea = new Aereolinea<>(nombreAerolinea, "-", 0);
    
    Nodo<Aereolinea<T>> nodoAerolinea = aereolineas.aereolineas.obtenerElemento(buscadoraAerolinea);

    if (nodoAerolinea.getDato() == null) {
        return Retorno.error1(); // La aerolínea no existe en el sistema
    } else {
        
        Aereolinea<T> aerolinea = nodoAerolinea.getDato();
        Avion<T> avionBuscado = new Avion<>(codigoAvion, 0, ""); // Creamos un avión con el código buscado

        if (!aerolinea.existeAvion(avionBuscado)) {
            return Retorno.error2(); // El avión no existe en la aerolínea
        }
        
        if(tieneVuelosConPasajesVendidos(avionBuscado)){
            
            return Retorno.error3();
        }
 
        
        else {
            aerolinea.getAviones().borrarElemento((T) avionBuscado); // Borramos el avión de la aerolínea
            return Retorno.ok();
        }
    }
}

private boolean tieneVuelosConPasajesVendidos(Avion<T> avion) {
    
    Nodo<Vuelo> actual = vuelos.getVuelos().getCabeza();

    while (actual != null) {
        
        Vuelo vuelo = actual.getDato();
        
        if (vuelo.getCodAvion().equals(avion.getCodigo())) {
            
            if (!vuelo.getPasajes().esVacia()) {
                return true; // El avión tiene vuelos con pasajes vendidos
            }
        }
        actual = actual.getSiguiente();
    }
    return false; // El avión no tiene vuelos con pasajes vendidos
}
       


    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        
        if(edad < 0){
            
            return Retorno.error1();
        }
        
        if(pasaporte.length() != 7){
            
            return Retorno.error2();
        }
        
        if(clienteExistente(pasaporte)){
            
            return Retorno.error3();
        }
        
        Cliente nuevoCliente = new Cliente (pasaporte, nombre, edad);
        clientes.agregarInicio(nuevoCliente); 
                
        return Retorno.ok();
      }
    
    
    private boolean clienteExistente(String pasaporte){
        
        Nodo<Cliente> actual = clientes.getCabeza();
        
        while(actual != null){
            
            if(actual.getDato().getPasaporte().equals(pasaporte)){
                
                return true;
            }
            
            actual = actual.getSiguiente();
        }
        
        return false;
        
    }
    
    
    
    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        
        
        if(cantPasajesEcon % 3 != 0 || cantPasajesEcon < 3 || cantPasajesPClase % 3 != 0 || cantPasajesPClase < 3){ //no cumple condiciones de pasajes
            
            return Retorno.error1();
        }
        
        Aereolinea aereo = aereolineas.buscarAereolineaPorNombre(aerolinea);
        
        
        if (aereo == null) { //no existe la aereolinea
            
            return Retorno.error2();
        }       
        
        Avion avionBuscado = aereo.obtenerAvionPorCodigo(codAvion);        
 
        
        if(avionBuscado == null){
            
            return Retorno.error3(); // el avion no existe dentro de la aereolinea
        }
        
        int totalPasajes = cantPasajesEcon + cantPasajesPClase;
        
        if (totalPasajes > avionBuscado.getCapacidadMax()) {
            return Retorno.error4();//pasajes totales mayor a capacidad maxima del avion
        }
        
        
     
        if(vuelos.buscarVueloPorCodigo(codigoVuelo)!= null){
            
            return Retorno.error5(); //ya existe un vuelo con ese codigo
        }        
        
         Fecha fechaVuelo = new Fecha(dia, mes, año);
         
         
        if (vuelos.existeVueloEnFecha(fechaVuelo)) {
            
            return Retorno.error6(); //ya existe un vuelo para ese avion con esa fecha
        }
                       
        int pasajesRestantes = avionBuscado.getCapacidadMax() - totalPasajes;
        
         if(pasajesRestantes>0){
             
             cantPasajesEcon = cantPasajesEcon + pasajesRestantes;             
             
         }
         
        Vuelo nuevoVuelo = new Vuelo(codigoVuelo, aerolinea, codAvion, paisDestino, fechaVuelo, cantPasajesEcon, cantPasajesPClase, 0, 0);
         
        vuelos.vuelos.agregar(nuevoVuelo);
        
        return Retorno.ok();
    }
    
    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje) {
       
        Cliente cliente = buscarClientePorPasaporte(pasaporteCliente);             
        
        if(cliente == null){
            
            return Retorno.error1(); //el cliente no existe
        }
        
       Vuelo vuelo = vuelos.buscarVueloPorCodigo(codigoVuelo);
       
       if(vuelo == null){
           
           return Retorno.error2(); //el codigo de vuelo no existe
       }
       
       if(categoriaPasaje != 1 && categoriaPasaje != 2){
           
           return Retorno.error3();
           
       }
       
       Pasaje pasaje = new Pasaje(pasaporteCliente, codigoVuelo, categoriaPasaje, false);
       
       
       if(vuelo.hayDisponibilidad(categoriaPasaje)){
           
           vuelo.agregarPasaje(pasaje);
           
       }else{
           
           vuelo.agregarPasajeListaEspera(pasaje);
       }
               
        return Retorno.ok();
     }
    
    
    private Cliente buscarClientePorPasaporte(String pasaporte){
        
        Nodo<Cliente> actual = clientes.getCabeza();
        
        while(actual != null){
            
            if(actual.getDato().getPasaporte().equals(pasaporte)){
                
                return actual.getDato();
            }
            
            actual = actual.getSiguiente();
        }
        
        return null;
    }
    
    
    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        
        Cliente cliente = buscarClientePorPasaporte(pasaporteCliente);
        
        if(cliente == null){
            
            return Retorno.error1(); //no existe el cliente
        }
        
        Vuelo vuelo = vuelos.buscarVueloPorCodigo(codigoVuelo);
        
        if(vuelo == null){
            
            return Retorno.error2(); //no existe el codigo de vuelo
        }
        
        Pasaje pasaje = vuelo.buscarPasajePorPasaporte(pasaporteCliente);
        
        if(pasaje == null){
            
            return Retorno.error3(); //no existe un pasaje comprado por el cliente
        }
                
        vuelo.eliminarPasaje(pasaporteCliente);
        
        return Retorno.ok();

        
    }
    

    @Override
    public Retorno listarAerolineas() {
        //El metodo está creado en la clase Lista
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        String mostrarAereolineas=aereolineas.aereolineas.mostrarElementos();
        ret.valorString = mostrarAereolineas;
        return ret;
    }
    
     @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Aereolinea<T> aereolineaAux = new Aereolinea<>(nombre,"-",0);
        Nodo<Aereolinea<T>> obtenerAereolinea= aereolineas.aereolineas.
                obtenerElemento(aereolineaAux);
        
        if(obtenerAereolinea == null){
            return Retorno.error1();
        }
            aereolineaAux = obtenerAereolinea.getDato();
            String mostrarAereolineas = aereolineaAux.getAviones().mostrarElementos();
        ret.valorString = mostrarAereolineas;
        return ret;
    }

    

    @Override
    public Retorno listarClientes() {
    
         Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        String mostrarClientes = clientes.mostrarElementosRecursivamente(this.clientes.getCabeza());
        ret.valorString = mostrarClientes;
        return ret;
        
    }

    @Override
    public Retorno listarVuelos() {
    
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        String mostraVuelos = vuelos.vuelos.mostrarElementos();
       
        
        ret.valorString = mostraVuelos;
        
        return ret;
    }
    
    @Override
    public Retorno vuelosDeCliente(String pasaporte) {

        Retorno ret = new Retorno(Retorno.Resultado.OK);
        StringBuilder resultado = new StringBuilder();

        listarVuelosDeClienteRecursivo(vuelos.vuelos.getCabeza(), pasaporte, resultado);

        if (resultado.length() == 0) {

            ret = Retorno.error1();
            
        } else {
            ret.valorString = resultado.toString();
        }

        return ret;
    }

    private void listarVuelosDeClienteRecursivo(Nodo<Vuelo> nodo, String pasaporte, StringBuilder resultado) {

        if (nodo == null) {
            return;
        }

        Vuelo vuelo = nodo.getDato();
        

        Nodo<Pasaje> pasajeNodo = vuelo.getPasajes().getCabeza();

        while (pasajeNodo != null) {

            Pasaje pasaje = pasajeNodo.getDato();

            if (pasaje.getPasaporteCliente().equals(pasaporte)) {
                
                resultado.append(vuelo.getCodigoVuelo());

                if (pasaje.isIsDevuelto()) {

                    resultado.append("-DEV\n");

                } else {

                    resultado.append("-CPR\n");

                }
                break; // Salir del bucle si encontramos un pasaje para este vuelo
            }
            pasajeNodo = pasajeNodo.getSiguiente();
        }

        listarVuelosDeClienteRecursivo(nodo.getSiguiente(), pasaporte, resultado);
    }


     @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Aereolinea aereo = aereolineas.buscarAereolineaPorNombre(nombreAerolinea);

        if (aereo == null) {
            
            return Retorno.error1();
           
        }

        StringBuilder resultado = new StringBuilder();
        
        Nodo<Vuelo> actualVuelo = vuelos.vuelos.getCabeza();
        
        while (actualVuelo != null) {
            
            Vuelo vuelo = actualVuelo.getDato();
            
            if (vuelo.getAereolinea().equals(nombreAerolinea)) {
                
                Lista<Pasaje> pasajesDevueltos = vuelo.getPasajesDevueltos();
                Nodo<Pasaje> actualPasaje = pasajesDevueltos.getCabeza();
                
                while (actualPasaje != null) {
                    
                    Pasaje pasaje = actualPasaje.getDato();
                    
                    resultado.append(pasaje.getPasaporteCliente())
                             .append("-")
                             .append(vuelo.getCodigoVuelo())
                             .append("|\n");
                    
                    actualPasaje = actualPasaje.getSiguiente();
                }
            }
            actualVuelo = actualVuelo.getSiguiente();
        }

        if (resultado.length() > 0) {
            // Remove the last "|"
            resultado.setLength(resultado.length() - 2);
        }

        ret.valorString = resultado.toString();
        return ret;
    }

   
    
    
  @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Vuelo vuelo = vuelos.buscarVueloPorCodigo(codigoVuelo);
        
        if (vuelo == null) {
            
            return Retorno.error1();
        }

        Lista<Pasaje> pasajesPrimeraClase = vuelo.getPasajesPorCategoria(2);
        Lista<Pasaje> pasajesEconomica = vuelo.getPasajesPorCategoria(1);

        StringBuilder resultado = new StringBuilder();
        resultado.append("**********************************\n");
        resultado.append("* PRIMERA *\n");
        resultado.append("**********************************\n");
        resultado.append(generarVistaCategoria(pasajesPrimeraClase, vuelo.getCantPasajesPClase()));
        resultado.append("**********************************\n");
        resultado.append("* ECONÓMICA *\n");
        resultado.append("**********************************\n");
        resultado.append(generarVistaCategoria(pasajesEconomica, vuelo.getCantPasajesEcon()));
        resultado.append("**********************************\n");

        ret.valorString = resultado.toString();
        return ret;
    }

    private String generarVistaCategoria(Lista<Pasaje> pasajes, int totalAsientos) {
        StringBuilder vista = new StringBuilder();
        Nodo<Pasaje> actualPasaje = pasajes.getCabeza();

        int filas = (int) Math.ceil((double) totalAsientos / 3);
        int asientoActual = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 3; j++) {
                if (asientoActual < totalAsientos) {
                    if (actualPasaje != null) {
                        vista.append(" * ").append(actualPasaje.getDato().getPasaporteCliente()).append(" * ");
                        actualPasaje = actualPasaje.getSiguiente();
                    } else {
                        vista.append(" * XXXXXXXX * ");
                    }
                    asientoActual++;
                } else {
                    vista.append(" * XXXXXXXX * ");
                }
            }
            vista.append("\n**********************************\n");
        }

        return vista.toString();
    }
}