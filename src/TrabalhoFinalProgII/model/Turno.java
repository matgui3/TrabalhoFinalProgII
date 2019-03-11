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
 *
 * @author guilh
 */
public class Turno {
    
    private ArrayList<Ocorrencia> ocorrencias;
    private PeriodoTurno periodo;
    private Operador[] operadores;
    
    public Turno(PeriodoTurno periodo, Operador operador1){
        ocorrencias = new ArrayList<>();
        this.periodo=periodo;
        operadores = new Operador[3];
        operadores[0] = operador1;
    }
    
    public Turno(PeriodoTurno periodo, Operador operador1, Operador operador2){
        ocorrencias = new ArrayList<>();
        this.periodo=periodo;
        operadores = new Operador[3];
        operadores[0] = operador1;
        operadores[1] = operador2;
    }
    
    public Turno(PeriodoTurno periodo, Operador operador1, Operador operador2, Operador operador3){
        ocorrencias = new ArrayList<>();
        this.periodo=periodo;
        operadores = new Operador[3];
        operadores[0] = operador1;
        operadores[1] = operador2;
        operadores[2] = operador3;
    }
    
    public PeriodoTurno getPeriodo(){
        return this.periodo;
    }
    
    public void addOcorrencia(String descricao, Date hora){
        Ocorrencia ocorrencia = new Ocorrencia(hora, descricao);
        ocorrencias.add(ocorrencia);
    }
    
    public ArrayList PassarOcorrencias(){

        return ocorrencias;
        
    }
    
}
