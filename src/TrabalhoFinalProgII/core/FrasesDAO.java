/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.core;

import TrabalhoFinalProgII.model.Frase;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author guilh
 */
public class FrasesDAO extends JPADAO<Frase>{
    
    public List<Frase> buscarFrases(){
        List<Frase> frases;
        
        Query query = em.createNamedQuery("Frase.buscarFrases");
        frases = query.getResultList();
        
        return frases;
    }
    
}
