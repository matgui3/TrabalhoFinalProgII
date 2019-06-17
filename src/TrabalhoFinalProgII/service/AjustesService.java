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
import java.util.NoSuchElementException;

/**
 *
 * @author guilh
 */
public class AjustesService {
    
    JPADAO<ValoresAlarmesTrip> dao = new JPADAO();
    AjustesDAO ajustesDao = new AjustesDAO();
    
    
    public void excluirAjuste() throws Exception{
        ajustesDao.excluirAjuste();
    }
    
    public ValoresAlarmesTrip criarAjuste(String nomeAjuste, String valorAjusteUg1, String valorAjusteUg2) throws Exception{
        if(nomeAjuste == null | valorAjusteUg1 == null | valorAjusteUg2 == null)
            throw new NoSuchElementException("Preencha todos os campos do formulário e tente novamente.");
        
        ValoresAlarmesTrip ajuste = new ValoresAlarmesTrip();
        ajuste.setNomeAjuste(nomeAjuste);
        ajuste.setValorAjusteUg1(valorAjusteUg1);
        ajuste.setValorAjusteUg2(valorAjusteUg2);
        
        dao.inserir(ajuste);
        
        return ajuste;
    }
    
    public String[][] buscarAjustes(){
        List<ValoresAlarmesTrip> ajustes = ajustesDao.buscarAjustes();
        
        String[][] ajustesTexto = new String[ajustes.size()][3];
        
        for(int i=0; i<ajustes.size(); i++){
            ajustesTexto[i][0] = ajustes.get(i).getNomeAjuste();
            ajustesTexto[i][1] = ajustes.get(i).getValorAjusteUg1();
            ajustesTexto[i][2] = ajustes.get(i).getValorAjusteUg2();
        }
        
        return ajustesTexto;
    }
    
}
