
package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestOb2 {

    private Sistema miSistema;

    public TestOb2() {
    }
    
    

    @Before
    public void setUp() {
        miSistema = new Sistema();
		//Coloca aquí cualquier otra inicialización de listas necesaria
    }

     @Test
    public void testCrearSistemaDeGestion() {
        //Completar para primera entrega
        Retorno r = miSistema.crearSistemaDeGestion();

    }

    //Gestión de clintes (No se incluyen en estas pruebas ERROR_1, ERRROR_2 y ERROR_3)
    @Test
    public void testCrearClienteOK() {
        
        testCrearSistemaDeGestion();
        
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("AM11111", "Alfonso Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testListarClienteOK() {

        testCrearSistemaDeGestion();
        
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("AM11111", "Alfonso Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.listarClientes();
        assertEquals("CB34555-Camila Barcos-54|\nAM11111-Alfonso Miguez-34|\nMF34111-Martina Fernandez-1|\n", r.valorString);
    }

    //Gestión de vuelos (No se incluyen en estas pruebas ERROR_1, ERRROR_2, ERROR_3, ERROR_4, ERROR_5, ERROR_6)
    @Test
    public void testCrearVueloOK() {
        
         testCrearSistemaDeGestion();
        //Creación de aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("AA2341", "Aerolineas Argentinas", "FLY300", "Brasil", 1, 11, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testListarVuelosOK() {
    
        testCrearSistemaDeGestion();
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Uruguay", 2, 10, 2024, 6, 9);
        assertEquals(Retorno.ok().resultado, r.resultado);
//        
        r = miSistema.crearVuelo("AA3333", "Aerolineas Argentinas", "FLY221", "Uruguay", 5, 9, 2024, 3, 12);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.listarVuelos();
        assertEquals("AA1111-Aerolineas Argentinas-FLY221-0-0-15|\n AA2222-Aerolineas Argentinas-FLY221-0-0-15|\n AA3333-Aerolineas Argentinas-FLY221-0-0-15|\n ", r.valorString);


//        //Compra de pasajes
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("VM32132", "AA2222", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.listarVuelos();
        assertEquals("AA1111-Aerolineas Argentinas-FLY221-1-0-14|\n AA2222-Aerolineas Argentinas-FLY221-0-1-14|\n AA3333-Aerolineas Argentinas-FLY221-0-0-15|\n ", r.valorString);
    }

    @Test
    public void testComprarPasajeOK() {
    
        testCrearSistemaDeGestion();
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
//        Creación de aviones

        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testDevolverPasajeOK() {
        
        testCrearSistemaDeGestion();
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Devolución de pasaje 
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("CB34555", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testListarVuelosDeClientesOK() {

        testCrearSistemaDeGestion();
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Uruguay", 11, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("AA3333", "Aerolineas Argentinas", "FLY221", "Uruguay", 14, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);

        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("MF34111", "AA2222", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("MF34111", "AA3333", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Devolución de pasaje (se deberían otorgar a los dos clientes que están esperando)
        r = miSistema.devolverPasaje("MF34111", "AA2222");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.vuelosDeCliente("MF34111");
        assertEquals("AA1111-CPR\nAA2222-DEV\nAA3333-CPR\n", r.valorString);

    }

    @Test
    public void testPasajesDevueltosOK() {

        testCrearSistemaDeGestion();
        
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA9999", "Aerolineas Argentinas", "FLY221", "Uruguay", 11, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA9999", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);

        //Devolución de pasaje
        r = miSistema.devolverPasaje("MF34111", "AA9999");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("VM32132", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("CB34555", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.pasajesDevueltos("Aerolineas Argentinas");
        assertEquals("CB34555-AA1111|\nVM32132-AA1111|\nMF34111-AA9999", r.valorString);
    }

    @Test
    public void testVistaDeVueloOK() {

        /* Esta prueba no es imprescindible validarla mediante pruebas unitarias, pudiendo hacer una impresión de pantalla con la vista
        del avión, tal como se muestra en la letra del obligatorio */
    }

}
