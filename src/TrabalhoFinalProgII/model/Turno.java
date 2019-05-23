/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Turno.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_turno")
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_dia", referencedColumnName = "id_dia")
    private Dia dia;
    @OneToMany()
    private ArrayList<Ocorrencia> ocorrencias;
    @OneToOne
    private PeriodoTurno periodo;
    private Operador[] operadores;

    /**
     * Método construtor da classe Turno.
     * @param periodo Período do turno (Manhã, Tarde, Noite).
     */
    public Turno(PeriodoTurno periodo) {
        ocorrencias = new ArrayList<>();
        this.periodo = periodo;
        operadores = new Operador[3];
    }

    public PeriodoTurno getPeriodo() {
        return this.periodo;
    }

    /**
     * Método responsável por adicionar uma ocorrência à lista de ocorrências.
     * @param descricao Descrição da ocorrência.
     * @param hora Hora em que a ocorrência foi adicionada.
     */
    public void addOcorrencia(String descricao, Date hora) {
        Ocorrencia ocorrencia = new Ocorrencia(hora, descricao);
        ocorrencias.add(ocorrencia);
    }

}
