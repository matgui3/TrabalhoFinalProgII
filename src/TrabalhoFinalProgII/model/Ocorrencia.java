/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Ocorrência.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "ocorrencia")
public class Ocorrencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ocorrencia")
    private long id;
    @Column(name = "hora")
    private Date hora;
    @Column(name = "descricao")
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
