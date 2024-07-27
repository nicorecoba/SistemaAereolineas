
package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IObligatorioTest {

    private Sistema miSistema;

    public IObligatorioTest() {
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
    
    
    @Test
    public void testCrearAerolineaOK() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testCrearAerolineaERROR2() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR1() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 0);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", -3);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaOK() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR1() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("TAP Portugal");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR2() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionOK() {
        testCrearSistemaDeGestion();

        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
    }

    @Test
    public void testRegistrarAvionERROR3() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA700", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 18, "Aerolineas Argentinas");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR1() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 3, "Aerolineas Argentinas");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 14, "Aerolineas Argentinas");
        assertEquals(Retorno.error1().resultado, r.resultado);
        
     
    }
    
       @Test
    public void testRegistrarAvionERROR4() {
        
        testCrearSistemaDeGestion();
        
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("AA3456", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.error4().resultado, r.resultado);
        
        r = miSistema.registrarAvion("AA34564", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.error4().resultado, r.resultado);
    }
    

    @Test
    public void testRegistrarAvionERROR2() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Porter Airlines");
        assertEquals(Retorno.error2().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionOK() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
       assertEquals(Retorno.ok().resultado, r.resultado);
        
        r= miSistema.registrarAvion("34EDS", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionERROR1() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Gol Brasil", "AA345");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR2() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "YY111");
        assertEquals(Retorno.error2().resultado, r.resultado);

    }
    
    
    @Test
    public void crearVuelo() {
        
        testCrearSistemaDeGestion();
         
        Retorno r = miSistema.crearVuelo("V73" ,"Aerolineas Argentinas","AA345" , "Portugal" , 24, 06, 2024, 1, 3);
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V73" ,"Aerolineas Argentinas","AA345" , "Portugal" , 24, 06, 2024, 3, 3);
        assertEquals(Retorno.error2().resultado, r.resultado);
        
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V73" ,"Iberia","AA345" , "Portugal" , 24, 06, 2024, 3, 3);
        assertEquals(Retorno.error3().resultado, r.resultado);
        
        r = miSistema.registrarAvion("A737", 9, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V73" ,"Iberia","A737" , "Portugal" , 24, 06, 2024, 9, 3);
        assertEquals(Retorno.error4().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V73" ,"Iberia","A737" , "Portugal" , 24, 06, 2024, 3, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V73" ,"Iberia","A737" , "Portugal" , 24, 06, 2024, 3, 3);
        assertEquals(Retorno.error5().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 24, 06, 2024, 3, 3);
        assertEquals(Retorno.error6().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 25, 06, 2024, 3, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    
 @Test
    public void registrarCliente() {
        
        testCrearSistemaDeGestion();
       
        Retorno r = miSistema.registrarCliente("123456", "Nicolas", -10);
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.registrarCliente("123456", "Nicolas", 23);
        assertEquals(Retorno.error2().resultado, r.resultado);
        
        r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.error3().resultado, r.resultado);
        
        r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
}
    
    @Test
    public void comprarPasaje() {
        
        testCrearSistemaDeGestion();
       
        Retorno r = miSistema.comprarPasaje("123456", "A737", 1); //ERROR 1
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234567", "A737", 1);
        assertEquals(Retorno.error2().resultado, r.resultado); //ERROR 2
        
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("A737", 9, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 25, 06, 2024, 3, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234567", "V731", 1); //OK
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        //revisar
        r = miSistema.comprarPasaje("1234567", "V731", 3);
        assertEquals(Retorno.error3().resultado, r.resultado); //ERROR 3
}

    
    
    @Test
    public void devolverPasaje() {
        
        testCrearSistemaDeGestion();
       
        Retorno r = miSistema.devolverPasaje("123456", "A737");
        assertEquals(Retorno.error1().resultado, r.resultado); //ERROR1
        
        r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.devolverPasaje("1234567", "A737");
        assertEquals(Retorno.error2().resultado, r.resultado); //ERROR2
        
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("A737", 9, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 25, 06, 2024, 3, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.devolverPasaje("1234567", "V731");
        assertEquals(Retorno.error3().resultado, r.resultado); //ERROR 3
        
        r = miSistema.comprarPasaje("1234567", "V731", 1); 
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.devolverPasaje("1234567", "V731");
        assertEquals(Retorno.ok().resultado, r.resultado); //OK
        
        
        
    }
    
    @Test
    public void testListarAerolineas() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.listarAerolineas();
        assertEquals("Aerolineas Argentinas-Argentina-10|\n Iberia-España-20|\n Delta Air Lines-Estados Unidos-30|\n Copa Airlines-Panamá-30|\n ", r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolinea() {
        testCrearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345",12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB563",21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("AA345-12|\n AA311-21|\n " , r.valorString);
            
    }
    
    @Test
    public void testListarClientes() {
        
        testCrearSistemaDeGestion();
        
        //String pasaporte, String nombre, int edad
        
        Retorno r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("1234568", "Matias", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.listarClientes();
        assertEquals("1234568-Matias-23|\n1234567-Nicolas-23|\n", r.valorString);    
    }
    
     @Test
    public void testListarVuelos() {
        
        testCrearSistemaDeGestion();
        
        Retorno r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("A737", 9, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 25, 06, 2024, 6 , 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V800" ,"Iberia","A737" , "Francia" , 25, 07, 2024, 6 , 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.listarVuelos();
        assertEquals("V731-Iberia-A737-0-0-9|\n V800-Iberia-A737-0-0-9|\n ", r.valorString);    
    }
    
    
    @Test
    public void vuelosDeCliente() {
        
        testCrearSistemaDeGestion();
        
        Retorno r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("A737", 9, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 25, 06, 2024, 6 , 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234567" ,"V731" , 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.vuelosDeCliente("999999");
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.vuelosDeCliente("1234567");
        assertEquals("V731-CPR\n", r.valorString);    
                       
        
        
        r = miSistema.crearVuelo("V800" ,"Iberia","A737" , "Portugal" , 27, 06, 2024, 6 , 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234567" ,"V800" , 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.devolverPasaje("1234567", "V800");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.vuelosDeCliente("1234567");
        assertEquals("V731-CPR\nV800-DEV\n", r.valorString);
        
        
    }
    
    @Test
    public void pasajesDevueltos() {
        
        testCrearSistemaDeGestion();
        
        Retorno r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);        
         
        r = miSistema.pasajesDevueltos("Pluna");
        assertEquals(Retorno.error1().resultado, r.resultado);
        
         r = miSistema.registrarAvion("A737", 9, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 25, 06, 2024, 6 , 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234567" ,"V731" , 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.devolverPasaje("1234567", "V731");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        
        
        r = miSistema.registrarCliente("1234568", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234568" ,"V731" , 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.devolverPasaje("1234568", "V731");
        assertEquals(Retorno.ok().resultado, r.resultado);
                

        r = miSistema.pasajesDevueltos("Iberia");
        assertEquals("1234568-V731|\n1234567-V731", r.valorString); 
    }

    
     @Test
    public void vistaDeVuelo() {
        
        testCrearSistemaDeGestion();
        
        Retorno r = miSistema.registrarCliente("1234567", "Nicolas", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
                
        
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("A737", 9, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.crearVuelo("V731" ,"Iberia","A737" , "Portugal" , 25, 06, 2024, 3 , 6);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234567" ,"V731" , 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("1234567" ,"V731" , 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.registrarCliente("5109822", "Mateo", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("5109822" ,"V731" , 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
               
                
        r = miSistema.vistaDeVuelo("V731");
        assertEquals("**********************************\n" +
                             "* PRIMERA *\n" +
                     "**********************************\n" +
                     " * 5109822 *  * 1234567 *  * XXXXXXXX * \n" +
                     "**********************************\n" +
                     " * XXXXXXXX *  * XXXXXXXX *  * XXXXXXXX * \n" +
                     "**********************************\n" +
                     "**********************************\n" +
                             "* ECONÓMICA *\n" +
                     "**********************************\n" +
                     " * 1234567 *  * XXXXXXXX *  * XXXXXXXX * \n" +
                     "**********************************\n" +
                     "**********************************\n",
                    r.valorString);
         
    }
    
}
