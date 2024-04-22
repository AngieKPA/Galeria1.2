package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.inventario.Piezas;
import modelo.inventario.Subasta;
import modelo.usuarios.Usuarios;
import persistencia.PersistenciaInventario;
import persistencia.PersistenciaUsuarios;

public class Main {

	public static void main(String[] args) {
		
		
		//Lectura de las piezas 
		PersistenciaInventario piezas = new PersistenciaInventario("./Datos1/inventario.txt");
		
		List<Piezas> listaPiezas = piezas.leerPiezas();
		
		System.out.println("A continuación podra ver la lista de piezas");
		System.out.println(listaPiezas);
		
		
		// Lectura de los usuarios
        String archivoUsuarios = "./Datos1/usuarios.txt";

        // Instanciacion
        PersistenciaUsuarios persistenciaUsuarios = new PersistenciaUsuarios(archivoUsuarios);

        // leer los usuarios
        List<Usuarios> usuarios = persistenciaUsuarios.leerUsuarios();
        
		
		
		//prueba de funcion subastar parte 1
		List<Piezas> piezasParaSubastar = new ArrayList<>();
	    piezasParaSubastar.add(new Piezas("1", "Pintura", "La Mona Lisa", "Leonardo da Vinci", "1503",
	            "Esta icónica pintura representa a una mujer con una enigmática sonrisa.", "77 cm x 53 cm",
	            "Disponible", 250000,0));
	    piezasParaSubastar.add(new Piezas("2", "Pintura", "La Noche Estrellada", "Vincent Van Gogh", "1889",
	            "Esta obra maestra postimpresionista muestra un paisaje nocturno con un cielo estrellado.",
	            "73.7 cm x 92.1 cm", "Bloqueada",72000000,0));
	    
	    // Crear subasta  parte 2
	    Subasta subasta = new Subasta();
	    
	    // Agregar piezas a la subasta parte 3
	    for (Piezas pieza : piezasParaSubastar) {
	        subasta.agregarPieza(pieza);
	    }
	    
	    // Establecer precios base para las piezas en subasta  parte 4
	    subasta.establecerPrecioInicial("1", 1000);
	    subasta.establecerPrecioInicial("2", 1500);
	    
	    // Mostrar piezas en subasta  parte final de la prueba
	    System.out.println("A continuación puede ver que se pueden ver y consultar las obras en subasta");
	    subasta.mostrarPiezasEnSubasta();
	}

}
