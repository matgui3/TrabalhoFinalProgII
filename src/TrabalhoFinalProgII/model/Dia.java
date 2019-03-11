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
    private EstadoServicosAuxiliares servicosAuxiliares;

    /**
     * Método construtor da classe Dia, responsável por criar e definir os atributos dos objetos de tipo Dia.
     * @param estadoGerador1 Estado do gerador 1.
     * @param estadoGerador2 Estado do gerador 2.
     * @param subestacao Estado da subestação.
     * @param servicosAuxiliares Estado dos serviços auxiliares.
     */
    Dia(EstadoUnidadeGeradora estadoGerador1, EstadoUnidadeGeradora estadoGerador2,
            EstadoSubestacao subestacao, EstadoServicosAuxiliares servicosAuxiliares) {
        gerador1 = new UnidadeGeradora(1, "500kv", estadoGerador1);
        gerador2 = new UnidadeGeradora(2, "450kv", estadoGerador2);
        turnos = new Turno[3];
        turnoAtual = new Turno(PeriodoTurno.MANHA);
        this.subestacao = subestacao;
        this.servicosAuxiliares = servicosAuxiliares;
    }

    /**
     * Método responsável por fazer o término de um turno, gravar os dados do último turno vigente e iniciar o novo turno.
     */
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
