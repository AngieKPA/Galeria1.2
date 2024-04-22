package persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import modelo.inventario.Piezas;

public class PersistenciaInventario {

    private String rutaArchivo;
    
  
    public PersistenciaInventario(String rutaArchivo) {
		
		this.rutaArchivo = rutaArchivo;
	}

	public List<Piezas> leerPiezas() {
        List<Piezas> listaPiezas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                listaPiezas.add(Piezas.fromCSVString(linea));
            }
            System.out.println("Datos leídos exitosamente desde el archivo: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPiezas;
    }

    public void escribirPiezas(List<Piezas> listaPiezas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Piezas pieza : listaPiezas) {
                writer.write(pieza.toCSVString());
                writer.newLine();
            }
            System.out.println("Datos escritos exitosamente en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
