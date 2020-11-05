package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author lisse
 */
public class ValidarLogin {
    private Sistema sistema;
            
    public ValidarLogin() { 
        sistema = FramePrincipal.sistema;
    }
    
    public String verificarLogin(Usuario usuario){
        if(!verificarLongitudNombre(usuario.getNombre())){
            return("Longitud de nombre incorrecta");
        }
        if(!verificarLongitudPassword(usuario.getPassword())){
            return("Longitud de contrasena incorrecta");
        }
        for(Usuario i: sistema.getUsuarios()){
            if(i.getNombre().equals(usuario.getNombre().toString()) && i.getPassword().equals(usuario.getPassword().toString())){
                return("Bienvenido");
            }
        }
        return("Datos incorrectos");
    }
    
    public boolean verificarLongitudNombre(String nombre){
        return (nombre.length() > 1 && nombre.length() <= 6);
    }
    
    public boolean verificarLongitudPassword(String password){
        return (password.length() >= 3 && password.length() < 6);
    }
}
