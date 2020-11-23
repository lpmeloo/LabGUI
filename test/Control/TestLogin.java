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
public class TestLogin {
    
    private static ValidarLogin validarLogin = new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud de nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud de contrasena incorrecta";
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    
    
    public TestLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
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
    
    @Test
    public void TestLongitudNombre(){
        Usuario u = new Usuario();
        //prueba 1
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        
        //prueba 2
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void TestLongitudContrasenia(){
        Usuario u = new Usuario();
        //prueba 1
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
        
        //prueba 2
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void TestNombre(){
        Usuario u = new Usuario();
        //prueba 1
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void TestContrasenia(){
        Usuario u = new Usuario();
        //prueba 1
        u.setNombre("Maria");
        u.setPassword("A234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void TestDatos(){
        Usuario u = new Usuario();
        //prueba 1
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void TestTodoCorrecto(){
        Usuario u = new Usuario();
        
        //prueba 1
        u.setNombre("Pepito");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
        //prueba 2
        u.setNombre("Lolita");
        u.setPassword("123");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
        //prueba 3
        u.setNombre("Maria");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
