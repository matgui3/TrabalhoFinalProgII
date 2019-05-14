/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 * Classe enum contendo os possíveis estados das subestações.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public enum EstadoSubestacao {
    
    LTS1("LTS DE 138 KV RIO DO SUL TIMBO E INDAIAL LIGADAS NA BARRA P 138 KV"),
    LTS2("LTS DE 138 KV RIO DO SUL E TIMBO LIGADAS NA BARRA P 138 KV"),
    LTS3("LTS DE 138 KV RIO DO SUL E INDAIAL LIGADAS NA BARRA P 138 KV"),
    LTS4("LTS DE 138 KV TIMBO E INDAIAL LIGADAS NA BARRA P 138 KV");
    
    private final String subestacao;
    
    EstadoSubestacao(String subestacao){
        this.subestacao=subestacao;
    }
    
    public String getSubestacao(){
        return this.subestacao;
    }
    @Override
    public String toString() {
        return this.subestacao;
    }
}
