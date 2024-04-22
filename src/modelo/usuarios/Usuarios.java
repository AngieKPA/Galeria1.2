package modelo.usuarios;

import java.util.ArrayList;
import java.util.List;

import modelo.inventario.Piezas;



public class Usuarios {
    private String id;
    private String nombre;
    private String rol;
    private String email;
    private String usuario;
    private String password;
    private String estado;
    private List<String> obras;
    private int montoAutorizado;

    // Constructor, getters y setters

    // Método para convertir un usuario a una cadena de texto en formato para guardar en el archivo
    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id).append("\n");
        sb.append("nombre=").append(nombre).append("\n");
        sb.append("rol=").append(rol).append("\n");
        sb.append("email=").append(email).append("\n");
        sb.append("usuario=").append(usuario).append("\n");
        sb.append("password=").append(password).append("\n");
        sb.append("estado=").append(estado).append("\n");
        sb.append("Obras=").append(String.join(",", obras)).append("\n");
        sb.append("montoAutorizado=").append(montoAutorizado).append("\n");
        return sb.toString();
    }

    // Método para crear un usuario a partir de una línea del archivo
    public static Usuarios fromFileString(String fileString) {
        Usuarios usuario = new Usuarios();
        String[] lines = fileString.split("\n");
        for (String line : lines) {
            String[] parts = line.split("=", 2);
            String key = parts[0];
            String value = parts[1];
            switch (key) {
                case "id":
                    usuario.setId(value);
                    break;
                case "nombre":
                    usuario.setNombre(value);
                    break;
                case "rol":
                    usuario.setRol(value);
                    break;
                case "email":
                    usuario.setEmail(value);
                    break;
                case "usuario":
                    usuario.setUsuario(value);
                    break;
                case "password":
                    usuario.setPassword(value);
                    break;
                case "estado":
                    usuario.setEstado(value);
                    break;
                case "Obras":
                    usuario.setObras(List.of(value.split(",")));
                    break;
                case "montoAutorizado":
                    usuario.setMontoAutorizado(Integer.parseInt(value));
                    break;
                default:
                    // Manejar otros atributos aquí si es necesario
            }
        }
        return usuario;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<String> getObras() {
        return obras;
    }

    public void setObras(List<String> obras) {
        this.obras = obras;
    }

    public int getMontoAutorizado() {
        return montoAutorizado;
    }

    public void setMontoAutorizado(int montoAutorizado) {
        this.montoAutorizado = montoAutorizado;
    }
}