package sistemaAutogestion;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre:      post:
    public Retorno crearSistemaDeGestion();;
    
    //pre:
        //1- nombre, pais y cantMaxAviones no pueden estar vacío
        //2- cantMaxAviones se ingresa números enteros
        //3- nombre y pais se ingresa datos de tipo String
    //post:
        //1- Si cantMaxAviones es 0 o menor retorna un error1
        //2- Si nombre ya existe en la lista de aereolineas retorna un error2
        //3- Si cantMaxAvion es mayor a 0 y el nombre ingresado no existe previamente
            //la Aereolinea se agrega a la lista de aereolineas y retorna ok.
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones);
    
    //pre:
        //1-nombre no puede estar vacio
        //2-nombre tiene que ser de tipo string
    //post:
        //1-Si la Aereolinea no existe retorna un error1
        //2-Si la Aereolinea contiene aviones retorna un error2
        //3-Si la Aereolinea existe y no contiene aviones se borra y retorna ok.
    
    public  Retorno eliminarAerolinea(String nombre);; 
    
    //pre:
        //1-codigo, capacidadMax y nomAerolinea no pueden ser nulos
        //2-capacidadMax tiene que ser un valor de tipo int
        //3-codigo y nomAerolinea tiene que ser valores de tipo string
    
    //post:
        //1-si capacidadMax es menor a 9 o no es multiplo de 3 retorna un error1.
        //2-Si el nombre de la aereolinea no existe retorna error2
        //3-Si el codigo existe previamente en la lista de aviones en la aerolinea
            //retorna error3
        //4-Si cumple las condiciones se agrega a la lista de aviones de la aerolinea
            //y retorna ok.

    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea); 
    
    //pre:
        //1-nomAerolinea y codAvion no puede ser vacio
        //2-nomAerolinea y codAvion tiene que ser tipo string.
    //post:
        //1-Si la aerolinea no exist retorna error1.
        //2-Si el codigo del avion no existe en la lista de aerolinea retorna un
            //error2
        //3- Si cumple las condiciones se elimina el avion de la lista y retorna
            //ok 
    public Retorno eliminarAvion(String nomAerolinea, String codAvion);
    
    //pre:
        
    
    //post:
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);
    //pre:      post:
    
      /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
    */
    
     //pre:      post:
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);
    //pre:      post:
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);
    //pre:      post:
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    //pre:
    
    //post:
        //1-Listas todas la aereolineas
    public Retorno listarAerolineas();
    //pre: 
        //1-nombre no puede ser nulo
        //2-el nombre de la aerolinea tiene que existir
    
    //post:
        //1-Lista los aviones de la aerolinea
    public Retorno listarAvionesDeAerolinea(String nombre);
    //pre:      post: 
    public Retorno listarClientes();
    //pre:      post: 
    public Retorno listarVuelos();
    //pre:      post: 
    public Retorno vuelosDeCliente(String pasaporte);
    //pre:      post: 
    public Retorno pasajesDevueltos(String nombreAerolinea);
    //pre:      post: 
    public Retorno vistaDeVuelo(String codigoVuelo);
    
    
    
}
