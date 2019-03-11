/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class FrasesProntas {

    private ArrayList<String> frases = new ArrayList<String>();

    public void CadastrarFrase(String frase) {
        frases.add(frase);
    }

    public String toString() {
        String texto = "";
            for (String frase : frases) {
                texto+= frase + "; ";
            }

            return texto;
    }
}
