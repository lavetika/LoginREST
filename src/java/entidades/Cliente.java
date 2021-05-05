/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author laura
 */
public class Cliente {
    private int id;
    private String contrasenia;
    private String usuario;
    private String nombre;

    public Cliente() {
    }

    public Cliente(int id, String contrasenia, String usuario, String nombre) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public Cliente(String contrasenia, String usuario, String nombre) {
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
