/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.service;

import TrabalhoFinalProgII.core.DiaDAO;
import TrabalhoFinalProgII.model.Dia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author guilh
 */
public class DiaService {
    
    DiaDAO dao = new DiaDAO();
    
    public Dia pesquisarDiaPorData(LocalDate data){
        String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dao.pesquisarDiaPorData(dataFormatada);
    }
    
    public Dia salvarDia(Dia dia) throws Exception {
        dao.inserir(dia);
        return dia;
    }
    
    public Dia novoDia(Dia dia) throws Exception{
        dao.inserir(dia);
        return dia;
    }

    public void salvarDia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
