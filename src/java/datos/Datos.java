/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
public class Datos {
    private List<Usuario> lstUsuarios;

    public Datos() {
        lstUsuarios=new ArrayList<Usuario>();
        lstUsuarios.add(new Usuario("123", "chimbox", "Alfonso Felix"));
        lstUsuarios.add(new Usuario("321","lavetika","Diana Castro"));
        lstUsuarios.add(new Usuario("111", "angel", "Angel Aviles"));
        
    }
    
    public boolean login(String username, String contra){
        for (Usuario usuario: lstUsuarios) {
            if(usuario.getUsuario().equalsIgnoreCase(username)&&usuario.getContrasena().equals(contra)){
                return true;
            }
        }
        
        return false;
    }

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    
}
