package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lisse
 */
public class Inicializacion {
    
    public Inicializacion() {
    }
    
    /*@Test
    public void initData(){
        UsuarioDAO dao = new UsuarioDAO();        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("Pepito");
        a.setPassword("1234");
        b.setNombre("Lolita");
        b.setPassword("123");
        c.setNombre("Maria");
        c.setPassword("12345");
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);   
        
        //sistema.setUsuarios(usuarios);        
        //for(Usuario i: sistema.getUsuarios()){
        for(Usuario i: usuarios){
            System.out.println(i.getNombre());
            System.out.println(i.getPassword());
            System.out.println("----------");
            dao.crear(i);
        }
    }*/
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
