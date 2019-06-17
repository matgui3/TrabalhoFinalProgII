/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private String hora;
    @Column(name = "descricao")
    private String descricao;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")
    private Turno turno;

    /**
     * Método construtor da classe ocorrencia.
     * @param hora Hora de acontecimento da ocorrência.
     * @param descricao Descrição do que está sendo registrado.
     */
    public Ocorrencia(LocalTime hora, String descricao) {
        super();
        this.hora = hora.toString();
        this.descricao = descricao;
    }  
    
    public Ocorrencia(){}

    public void setHora(LocalTime hora) {
        this.hora = hora.toString();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public LocalTime getHora() {
        return LocalTime.parse(hora);
    }

    public String getDescricao() {
        return descricao;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    
    
}
