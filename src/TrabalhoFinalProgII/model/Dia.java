/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Dia {

    private UnidadeGeradora gerador1;
    private UnidadeGeradora gerador2;
    private Turno[] turnos;
    private Turno turnoAtual;
//    private List<ArrayList<Ocorrencia>> ocorrenciasDia;

    Dia() {
        gerador1 = new UnidadeGeradora();
        gerador2 = new UnidadeGeradora();
        turnos = new Turno[3];
        turnoAtual = new Turno(PeriodoTurno.MANHA);
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
