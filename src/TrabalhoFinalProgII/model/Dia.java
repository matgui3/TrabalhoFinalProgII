package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Dia.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "dias")
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dia")
    private long id;
    @OneToOne
    @JoinColumn(name = "id_unidade")
    private UnidadeGeradora gerador1;
    @OneToOne
    @JoinColumn(name = "id_unidade")
    private UnidadeGeradora gerador2;
    @OneToMany(mappedBy = "dia")
    private Turno[] turnos;
    private Turno turnoAtual;
    @Column(name = "subestacao")
    private EstadoSubestacao subestacao;
    @Column(name = "servicos_auxiliares")
    private EstadoServicosAuxiliares servicosAuxiliares;

    /**
     * Método construtor da classe Dia, responsável por criar e definir os atributos dos objetos de tipo Dia.
     * @param estadoGerador1 Estado do gerador 1.
     * @param estadoGerador2 Estado do gerador 2.
     * @param estadoSubestacao Estado da subestação.
     * @param estadoServicosAuxiliares Estado dos serviços auxiliares.
     */
    Dia(EstadoUnidadeGeradora estadoGerador1, EstadoUnidadeGeradora estadoGerador2,
            EstadoSubestacao estadoSubestacao, EstadoServicosAuxiliares estadoServicosAuxiliares) {
        gerador1 = new UnidadeGeradora(1, "500kv", estadoGerador1);
        gerador2 = new UnidadeGeradora(2, "450kv", estadoGerador2);
        turnos = new Turno[3];
        turnoAtual = new Turno(PeriodoTurno.MANHA);
        this.subestacao = estadoSubestacao;
        this.servicosAuxiliares = estadoServicosAuxiliares;
    }
    
    Dia(){
        
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
