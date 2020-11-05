package Entidad;

import java.util.ArrayList;

/**
 *
 * @author lisse
 */
public class Sistema {
    private ArrayList<Usuario> usuarios;
    
    public Sistema(){
    }

    public ArrayList<Usuario>getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }  
}
