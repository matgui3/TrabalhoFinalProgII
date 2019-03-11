/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.Date;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Ocorrência.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public class Ocorrencia {
    
    private Date hora;
    private String descricao;

    /**
     * Método construtor da classe ocorrencia.
     * @param hora Hora de acontecimento da ocorrência.
     * @param descricao Descrição do que está sendo registrado.
     */
    public Ocorrencia(Date hora, String descricao) {
        super();
        this.hora = hora;
        this.descricao = descricao;
    }  
    
    public Date getHora() {
        return hora;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
