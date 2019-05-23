/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.core;

/**
 *
 * @author guilh
 */
public interface DAO<X> {
    
    boolean inserir(X obj) throws Exception;
    boolean atualizar(X obj) throws Exception;
    boolean alterar(X obj) throws Exception;
    boolean deletar(X obj) throws Exception;
    Object pesquisarPorId(Long id, Class tipoj) throws Exception;
    
}
