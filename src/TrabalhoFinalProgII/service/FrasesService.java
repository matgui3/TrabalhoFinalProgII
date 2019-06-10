/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.service;

import TrabalhoFinalProgII.core.FrasesDAO;
import TrabalhoFinalProgII.core.JPADAO;
import TrabalhoFinalProgII.model.EnumFrases;
import TrabalhoFinalProgII.model.Frase;
import java.util.List;

/**
 *
 * @author guilh
 */
public class FrasesService {

    JPADAO<Frase> dao = new JPADAO();
    FrasesDAO frasesDAO = new FrasesDAO();

    public Frase criarFrase(String texto, EnumFrases area) throws NoSuchFieldException, Exception {
        Frase frase = new Frase();

        frase.setTexto(texto);
        if (!area.equals(EnumFrases.UG1) | !area.equals(EnumFrases.UG2) | !area.equals(EnumFrases.SERVIÇOSAUXILIARES) | !area.equals(EnumFrases.TOMADADAGUA) | !area.equals(EnumFrases.SUBESTACAO)  ) 
            throw new NoSuchFieldException("Área inválida, tente novamente!");
        else
            frase.setArea(area);
        
        dao.inserir(frase);
        
        return frase;
    }
    
    public List<Frase> buscarFrases(){
        return frasesDAO.buscarFrases();
    }
}