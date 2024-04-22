package modelo.inventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Esta clase tiene la información de todas las piezas
 */
public class Piezas {
    private String id;
    private String tipo;
    private String nombre;
    private String autor;
    private String añoDeProduccion;
    private String descripcion;
    private String caracteristicas;
    private String estado;
    private int valorMinimo;
    private int valorInicial;

    // Constructor, getters y setters

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAñoDeProduccion() {
		return añoDeProduccion;
	}

	public void setAñoDeProduccion(String añoDeProduccion) {
		this.añoDeProduccion = añoDeProduccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	// para efectos de la subasta
	public int getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(int valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public int getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	// Constructor basico de piezas
	public Piezas(String id, String tipo, String nombre, String autor, String añoDeProduccion, String descripcion,
		String caracteristicas, String estado) {
		super();
		
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.autor = autor;
		this.añoDeProduccion = añoDeProduccion;
		this.descripcion = descripcion;
		this.caracteristicas = caracteristicas;
		this.estado = estado;

	}
	
	
	// Constructor usado para subastar
	public Piezas(String id, String tipo, String nombre, String autor, String añoDeProduccion, String descripcion,
			String caracteristicas, String estado, int valorMinimo, int valorInicial) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.autor = autor;
		this.añoDeProduccion = añoDeProduccion;
		this.descripcion = descripcion;
		this.caracteristicas = caracteristicas;
		this.estado = estado;
		this.valorMinimo = valorMinimo;
		this.valorInicial = valorInicial;
	}

	// Método para convertir una pieza a una cadena de texto en formato CSV
    public String toCSVString() {
        return id + "," + tipo + "," + nombre + "," + autor + "," + añoDeProduccion + "," +
               descripcion + "," + caracteristicas + "," + estado;
    }

	// Método para crear una instancia de Pieza a partir de una cadena de texto en formato CSV
    public static Piezas fromCSVString(String csvString) {
        String[] campos = csvString.split(",");
        Piezas pieza = new Piezas();
        pieza.setId(campos[0]);
        pieza.setTipo(campos[1]);
        pieza.setNombre(campos[2]);
        pieza.setAutor(campos[3]);
        pieza.setAñoDeProduccion(campos[4]);
        pieza.setDescripcion(campos[5]);
        pieza.setCaracteristicas(campos[6]);
        pieza.setEstado(campos[7]);
        return pieza;
    }

    public Piezas() {
		super();
	}

	@Override
    public String toString() {
        return "Pieza{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", añoDeProduccion='" + añoDeProduccion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
	
/*
	public ArrayList<String> listarObrasDisponibles( List<Piezas> listaPiezas){
		ArrayList<String> piezasDisponibles= new ArrayList<>();
		for(Piezas pieza:listaPiezas) {
			if (pieza.getEstado().equals("Disponible")) {
				piezasDisponibles.add(pieza.getNombre());
			} 
		}
		return piezasDisponibles;
	}*/
	
    public Map<String, Integer> listarObrasDisponiblesConPrecios(List<Piezas> listaPiezas) {
        Map<String, Integer> piezasDisponibles = new HashMap<>();
        for (Piezas pieza : listaPiezas) {
            if (pieza.getEstado().equals("Disponible")) {
                piezasDisponibles.put(pieza.getNombre(), pieza.getValorMinimo());
            }
        }
        return piezasDisponibles;
    }
	
	public ArrayList<String> historialOobrasVendidas( List<Piezas> listaPiezas){
		ArrayList<String> piezasVendidas= new ArrayList<>();
		for(Piezas pieza:listaPiezas) {
			if (pieza.getEstado().equals("Disponible")) {
				piezasVendidas.add(pieza.getNombre());
			} 
		}
		return piezasVendidas;
	}
	
}
