/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.core;

import TrabalhoFinalProgII.model.Operador;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author guilh
 */
public class OperadorDAO extends JPADAO<Operador>{
    
    public List<Operador> buscarTodosOperadores(){
        List<Operador> operadores = null;
        
        Query query = em.createNamedQuery("Operador.buscarTodos", Operador.class);
        operadores = query.getResultList();
        
        return operadores;
    }
    
}
