/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.service;

import TrabalhoFinalProgII.core.JPADAO;
import TrabalhoFinalProgII.core.OperadorDAO;
import TrabalhoFinalProgII.model.Operador;
import java.util.List;


/**
 *
 * @author guilh
 */
public class OperadorService {
    
    JPADAO<Operador> dao = new JPADAO();
    OperadorDAO operadorDAO = new OperadorDAO();
    
    public List<Operador> buscarOperadores(){
        List<Operador> operadores;
        operadores = operadorDAO.buscarTodosOperadores();
        return operadores;
    }
    
}
