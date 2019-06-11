/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.service;

import TrabalhoFinalProgII.core.AjustesDAO;
import TrabalhoFinalProgII.core.JPADAO;
import TrabalhoFinalProgII.model.ValoresAlarmesTrip;
import java.util.List;

/**
 *
 * @author guilh
 */
public class AjustesService {
    
    JPADAO<ValoresAlarmesTrip> dao = new JPADAO();
    AjustesDAO ajustesDao = new AjustesDAO();
    
    public ValoresAlarmesTrip criarAjuste(String nomeAjuste, String valorAjusteUg1, String valorAjusteUg2) throws Exception{
        if(nomeAjuste == null | valorAjusteUg1 == null | valorAjusteUg2 == null)
            throw new Exception("Preencha todos os campos do formulário e tente novamente.");
        
        ValoresAlarmesTrip ajuste = new ValoresAlarmesTrip();
        ajuste.setNomeAjuste(nomeAjuste);
        ajuste.setValorAjusteUg1(valorAjusteUg1);
        ajuste.setValorAjusteUg2(valorAjusteUg2);
        
        dao.inserir(ajuste);
        
        return ajuste;
    }
    
    public List<ValoresAlarmesTrip> buscarAjustes(){
        return ajustesDao.buscarAjustes();
    }
    
}
