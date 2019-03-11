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
    private Turno turno;
    private List<ArrayList<Ocorrencia>> ocorrenciasDia;

    Dia() {
        gerador1 = new UnidadeGeradora();
        gerador2 = new UnidadeGeradora();
        turno = new Turno(PeriodoTurno.MANHA);
        ocorrenciasDia = new ArrayList<>();
    }

    public void EncerrarTurno() {

        switch (turno.getPeriodo().getPeriodoTurno()) {

            case "Manhã":
                ocorrenciasDia.add(0, turno.PassarOcorrencias());
                turno = new Turno(PeriodoTurno.TARDE);
                break;
            case "Tarde":
                ocorrenciasDia.add(1, turno.PassarOcorrencias());
                turno = new Turno(PeriodoTurno.NOITE);
                break;
            case "Noite":
                ocorrenciasDia.add(2, turno.PassarOcorrencias());

        }
        
    }

}
