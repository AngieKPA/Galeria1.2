package modelo.usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.inventario.Piezas;

public class Cliente extends Usuarios{
	
	
	//Para que el cliente pueda ver las obras disponibles con sus precios para que pueda comprar
    public void verPiezasDisponiblesConPrecios(List<Piezas> listaPiezas) {
        Piezas piezas = new Piezas();
        Map<String, Integer> piezasDisponibles = piezas.listarObrasDisponiblesConPrecios(listaPiezas);
        System.out.println("Piezas disponibles para comprar:");
        for (Map.Entry<String, Integer> entry : piezasDisponibles.entrySet()) {
            System.out.println("- " + entry.getKey() + " - Precio: $" + entry.getValue());
        }
    }

    // Método para separa la pieza en compra privada"
    public void compraPrivada(String nombrePieza, List<Piezas> listaPiezas) {
        for (Piezas pieza : listaPiezas) {
            if (pieza.getNombre().equals(nombrePieza) && pieza.getEstado().equals("Disponible")) {
                pieza.setEstado("Bloqueada");
                System.out.println("Espera que el administrador verifique tu compra de la pieza: " + nombrePieza);
                return;
            }
        }
        System.out.println("La pieza no está disponible para comprar o no existe.");
    } 
}
