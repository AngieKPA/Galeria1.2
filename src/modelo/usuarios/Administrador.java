package modelo.usuarios;

import java.util.ArrayList;
import java.util.List;

import modelo.inventario.Piezas;
import modelo.inventario.Subasta;
import persistencia.PersistenciaInventario;
import persistencia.PersistenciaUsuarios;

public class Administrador extends Usuarios{
	
	private Subasta subasta;
	private PersistenciaInventario persistenciaInventario;
	private PersistenciaUsuarios persistenciaUsuarios;
	private Cliente cliente;
    private List<Usuarios> listaUsuarios;
    private List<Piezas> listaPiezas;
	
    public Administrador(Subasta subasta,PersistenciaInventario persistenciaInventario,
            List<Usuarios> listaUsuarios, List<Piezas> listaPiezas) {
        this.subasta = subasta;
        this.persistenciaInventario = persistenciaInventario;
        this.listaUsuarios = listaUsuarios;
        this.listaPiezas = listaPiezas;
    }
	
	public void aprobarSubasta(String idPieza, String nuevoEstado, Boolean cumple) {
		Piezas pieza = subasta.obtenerPieza(idPieza);
		if(pieza !=null && pieza.getEstado().equals("Bloqueada") && cumple== true) {
			pieza.setEstado("Vendida");
		}else {
			pieza.setEstado("Disponible");
		}
	}
	
	public void verificarComprador(String idCliente, Boolean autorizarCliente, List<Usuarios> listaUsuarios) {
        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getId().equals(idCliente) && usuario instanceof Cliente && autorizarCliente== true ) {
                Cliente cliente = (Cliente) usuario;
                cliente.setEstado("Activo");
                System.out.println("Se ha actualizado el estado del Cliente a activo");
                
                return;
            }
        }
        System.out.println("No se verificó al cliente");		
		
	}
	
	public void cambiarMontoAutorizado(String idCliente, int nuevoMontoAutorizado, List<Usuarios> listaUsuarios) {
		
        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getId().equals(idCliente) && usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                cliente.setMontoAutorizado(nuevoMontoAutorizado);
                System.out.println("El monto autorizado del cliente con ID " + idCliente + " se ha actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún el cliente");
    }
	
	public void guardarCambiosEnArchivos(List<Usuarios> listaUsuarios, List<Piezas> listaPiezas) {
	    persistenciaUsuarios.guardarUsuarios(listaUsuarios);
	    persistenciaInventario.escribirPiezas(listaPiezas);
	}

}
