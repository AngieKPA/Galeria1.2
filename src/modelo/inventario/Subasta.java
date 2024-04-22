package modelo.inventario;

import java.util.ArrayList;
import java.util.List;

import modelo.usuarios.Cliente;

public class Subasta {
	private Cliente cliente;
    private List<Piezas> piezasEnSubasta;

    
    public List<Piezas> getPiezasEnSubasta() {
		return piezasEnSubasta;
	}

	public void setPiezasEnSubasta(List<Piezas> piezasEnSubasta) {
		this.piezasEnSubasta = piezasEnSubasta;
	}

	// Constructor
    public Subasta() {
        this.piezasEnSubasta = new ArrayList<>();
    }
    
    public Piezas obtenerPieza(String idPieza) {
        for (Piezas pieza : piezasEnSubasta) {
            if (pieza.getId().equals(idPieza)) {
                return pieza;
            }
        }
        return null; // si no encuentra con el id especifico
    }

    // Método para agregar piezas a la subasta
    public void agregarPieza(Piezas pieza) {
        piezasEnSubasta.add(pieza);
    }

    // Método para establecer precio base de una pieza en la subasta
    public void establecerPrecioInicial(String idPieza, int precioBase) {
        for (Piezas pieza : piezasEnSubasta) {
            if (pieza.getId().equals(idPieza)) {
                pieza.setValorInicial(precioBase);
                return;
            }
        }
        System.out.println("Pieza no encontrada en la subasta.");
    }

    // Método para mostrar piezas en subasta
    public void mostrarPiezasEnSubasta() {
        for (Piezas pieza : piezasEnSubasta) {
            System.out.println("ID: " + pieza.getId());
            System.out.println("Nombre: " + pieza.getNombre());
            System.out.println("Tipo: " + pieza.getTipo());
            System.out.println("Precio minimo: $" + pieza.getValorMinimo());
            System.out.println("Precio inicial: $" + pieza.getValorInicial());
            System.out.println("----------------------");
        }
    }
}
