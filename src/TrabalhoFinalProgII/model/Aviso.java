/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.Date;

/**
 * Classe contendo os comportamentos e atributos dos Avisos.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public class Aviso {
    
    private Date data;
    private String aviso;
    private Operador publisher;
    
   /**
    * Método construtor da classe Aviso.
    * @param data Data de postagem do aviso.
    * @param aviso Conteúdo em escrito do aviso em si.
    * @param publisher Operador que publicou o aviso no painel.
    */ 
    public Aviso(Date data, String aviso, Operador publisher){
        super();
        this.data=data;
        this.aviso=aviso;
        this.publisher=publisher;
    }

    public Date getData() {
        return data;
    }
    
    public String getAviso() {
        return aviso;
    }

    public Operador getPublisher() {
        return publisher;
    }
    
}
