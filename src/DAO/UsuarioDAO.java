package DAO;

import Entidad.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author lisse
 */
public class UsuarioDAO {
    private static EntityManagerFactory
                emf = Persistence.createEntityManagerFactory("LoginApp_JPAPU");
    
    public void crear(Usuario obj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(obj);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }             
    }
    
    public boolean eliminar(Usuario obj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        
        try{
            em.remove(obj);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }             
    }
    
    public Usuario leer(Usuario par){
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        Query q = em.createQuery("Select u FROM Usuario u " + "WHERE u.nombre LIKE :nombre" + " AND u.password LIKE :password")
                .setParameter("nombre", par.getNombre())
                .setParameter("password", par.getPassword());
    
        try{
            usuario = (Usuario) q.getSingleResult();
        }catch(NonUniqueResultException e){
            usuario = (Usuario) q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
            return usuario;
        }             
    }
    
    public boolean actualizar(Usuario obj, Usuario nObj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        
        try{
            obj = leer(obj);
            obj.setNombre(nObj.getNombre());
            obj.setPassword(nObj.getPassword());
            em.merge(obj);
            em.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }             
    }    
}
