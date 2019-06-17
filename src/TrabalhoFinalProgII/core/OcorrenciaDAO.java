/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.core;

import TrabalhoFinalProgII.model.Ocorrencia;

/**
 *
 * @author guilh
 */
public class OcorrenciaDAO extends JPADAO<Ocorrencia>{
    
    public void excluirOcorrencia() throws Exception {
        
        try {
            em.getTransaction().begin();
            em.createNativeQuery("DELETE FROM ocorrencia").executeUpdate();
        } catch (Exception e) {
            System.out.println("Deu erro!" + e);
            em.getTransaction().rollback(); // desfaz transacao se ocorrer erro ao persitir
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
        }
    }
    
    
}
