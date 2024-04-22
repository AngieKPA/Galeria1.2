package modelo.usuarios;

import modelo.inventario.Piezas;
import modelo.inventario.Subasta;

public class Operador extends Usuarios{
	
	private Subasta subasta;

	public Operador(Subasta subasta) {
		this.subasta = subasta;
		
	}
	
	// metodo para que el operador registre la puja de la subasta
	public void  modificarValorInicial(String idPieza, int pujaEnSubasta) {
		Piezas pieza = subasta.obtenerPieza(idPieza);
		
		if (pieza !=null && pujaEnSubasta > pieza.getValorInicial()) {
			
			subasta.establecerPrecioInicial(idPieza, pujaEnSubasta);
		}
		else {
			System.out.println("El valor de la puja debe ser mayor al valor inicial propuesto");
		}
		
		if (pieza !=null && pujaEnSubasta > pieza.getValorMinimo()) {
			
			pieza.setEstado("Bloqueada");
		}
		else {
			System.out.println("La pieza no se venderá hasta que alcance"+ pieza.getValorMinimo());
		}
		
	}
}
