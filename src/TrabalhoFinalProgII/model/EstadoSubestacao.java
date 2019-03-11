/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 *
 * @author guilh
 */
public enum Subestacao {
    
    LTS1("LTS DE 138 KV RIO DO SUL TIMBO E INDAIAL LIGADAS NA BARRA P 138 KV"),
    LTS2("LTS DE 138 KV RIO DO SUL E TIMBO LIGADAS NA BARRA P 138 KV"),
    LTS3("LTS DE 138 KV RIO DO SUL E INDAIAL LIGADAS NA BARRA P 138 KV"),
    LTS4("LTS DE 138 KV TIMBO E INDAIAL LIGADAS NA BARRA P 138 KV");
    
    private String subestacao;
    
    Subestacao(String subestacao){
        this.subestacao=subestacao;
    }
    
    public String getSubestacao(){
        return this.subestacao;
    }
    
}
