/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe contendo objetos Frases Prontas onde os Operários podem encontrar frases pré-definidas para avisos.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public class FrasesProntas {

    private ArrayList<String> frases = new ArrayList<String>();

    /**
     * Método que adiciona uma frase à lista de frases prontas.
     * @param frase Frase a ser adicionada.
     */ 
    public void CadastrarFrase(String frase) {
        frases.add(frase);
    }

    /**
     * Método toString que retorna todas as frases prontas armazenadas.
     * @return Retorna todas as frases prontas armazenadas no momento.
     */
    public String toString() {
        String texto = "";
            for (String frase : frases) {
                texto+= frase + "; ";
            }

            return texto;
    }
}
