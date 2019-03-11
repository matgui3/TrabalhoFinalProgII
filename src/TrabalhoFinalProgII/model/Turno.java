/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Turno.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public class Turno {

    private ArrayList<Ocorrencia> ocorrencias;
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
