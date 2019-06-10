/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.service;

import TrabalhoFinalProgII.core.JPADAO;
import TrabalhoFinalProgII.model.Frase;

/**
 *
 * @author guilh
 */
public class FrasesProntasService {

    JPADAO<Frase> dao = new JPADAO();

    public Frase criarFrase(String texto, String area) throws NoSuchFieldException {
        Frase frase = new Frase();

        frase.setTexto(texto);
        if (!area.equalsIgnoreCase("UG1") & !area.equalsIgnoreCase("UG2") & !area.equalsIgnoreCase("Serviços Auxiliares") & !area.equalsIgnoreCase("Tomada D'Água") & !area.equalsIgnoreCase("Subestação")) 
            throw new NoSuchFieldException("Área inválida, tente novamente!");
        else
            frase.setArea(area);
        
        return frase;
    }
}
