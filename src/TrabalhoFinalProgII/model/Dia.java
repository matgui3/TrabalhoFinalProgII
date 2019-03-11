/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Dia.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public class Dia {

    private UnidadeGeradora gerador1;
    private UnidadeGeradora gerador2;
    private Turno[] turnos;
    private Turno turnoAtual;
    private EstadoSubestacao subestacao;
//    private List<ArrayList<Ocorrencia>> ocorrenciasDia;

    Dia(String potGerador1, String potGerador2, EstadoUnidadeGeradora estadoGerador1, EstadoUnidadeGeradora estadoGerador2, EstadoSubestacao subestacao) {
        gerador1 = new UnidadeGeradora(1, potGerador1, estadoGerador1);
        gerador2 = new UnidadeGeradora(2, potGerador2, estadoGerador2);
        turnos = new Turno[3];
        turnoAtual = new Turno(PeriodoTurno.MANHA);
        this.subestacao = subestacao;
//        ocorrenciasDia = new ArrayList<>();
    }

    public void EncerrarTurno() {
        
        

        switch (turnoAtual.getPeriodo().getPeriodoTurno()) {

            case "Manhã":
                turnos[0] = turnoAtual;
                turnoAtual = new Turno(PeriodoTurno.TARDE);
                break;
            case "Tarde":
                turnos[1] = turnoAtual;
                turnoAtual = new Turno(PeriodoTurno.NOITE);
                break;
            case "Noite":
                turnos[2] = turnoAtual;

        }
        
    }

}
