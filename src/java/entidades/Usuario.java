/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/**
 *
 * @author laura
 */
public class Usuario{
    
    private int id;
    @Expose
    private String usuario;
    
    private String nombre;
    
    @Expose
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public Usuario(int id, String usuario, String nombre) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public Usuario(String contrasenia, String usuario, String nombre) {
        this.contrasena=contrasenia;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", contrasena=" + contrasena + '}';
    }
}
