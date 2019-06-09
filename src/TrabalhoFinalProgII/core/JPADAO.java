/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.core;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author guilh
 */
public class JPADAO<X> implements DAO{
    EntityManagerFactory emf;
    EntityManager em;
    
    public JPADAO (){
        super();
        emf = Persistence.createEntityManagerFactory("TrabalhoFinalProgIIPU");
        em = emf.createEntityManager();
    }

    @Override
    public boolean inserir(Object obj) throws Exception {
        em.getTransaction().begin();
        
        try{
            em.persist(obj);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
        return false;
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        em.getTransaction().begin();
        
        try{
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
        return false;
    }

    @Override
    public boolean alterar(Object obj) throws Exception {
        em.getTransaction().begin();
        
        try{
            em.merge(obj);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
        return false;
    }

    @Override
    public boolean deletar(Object obj) throws Exception {
        em.getTransaction().begin();
        
        try{
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
        return false;
    }
    
    @Override
    public Object pesquisarPorId(Long id, Class tipo){
        em.getTransaction().begin();
        Object objeto = null;
        
        try{
            objeto = (Object) em.find(tipo, id);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
        return objeto;
    }

}
