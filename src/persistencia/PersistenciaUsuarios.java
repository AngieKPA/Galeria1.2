package persistencia;

import modelo.usuarios.Usuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class PersistenciaUsuarios {
	
	private String archivoUsuarios;

    public PersistenciaUsuarios(String archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

    public List<Usuarios> leerUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    // Fin de usuario, crear usuario a partir de las líneas leídas
                    Usuarios usuario = Usuarios.fromFileString(sb.toString());
                    usuarios.add(usuario);
                    sb = new StringBuilder();
                } else {
                	
                	 sb.append(line).append("\n");
                }
            }
            // Añadir el último usuario
            if (sb.length() > 0) {
                Usuarios usuario = Usuarios.fromFileString(sb.toString());
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void guardarUsuarios(List<Usuarios> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUsuarios))) {
            for (Usuarios usuario : usuarios) {
                String usuarioString = usuario.toFileString();
                bw.write(usuarioString);
                bw.write("\n"); // Separador entre usuarios
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
              
                	}
                }
