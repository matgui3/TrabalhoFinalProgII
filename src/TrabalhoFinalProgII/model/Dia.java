package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Dia.
 *
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "dias")
@NamedQueries({
    @NamedQuery(name = "Dia.pesquisarDiaPorData",
            query = "SELECT d FROM Dia d WHERE d.data = :data")
})
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dia")
    private long id;
    @Column(name = "id_unidade1")
    private String gerador1;
    @Column(name = "id_unidade2")
    private String gerador2;
    @OneToMany(mappedBy = "dia", cascade = CascadeType.ALL)
    private List<Turno> turnos;
    @Column(name = "subestacao")
    private String subestacao;
    @Column(name = "servicos_auxiliares")
    private String servicosAuxiliares;
    @Column(name = "data")
    private String data;

    /**
     * Método construtor da classe Dia, responsável por criar e definir os
     * atributos dos objetos de tipo Dia.
     *
     * @param estadoGerador1 Estado do gerador 1.
     * @param estadoGerador2 Estado do gerador 2.
     * @param estadoSubestacao Estado da subestação.
     * @param estadoServicosAuxiliares Estado dos serviços auxiliares.
     */
    Dia(EstadoUnidadeGeradora estadoGerador1, EstadoUnidadeGeradora estadoGerador2,
            EstadoSubestacao estadoSubestacao, EstadoServicosAuxiliares estadoServicosAuxiliares) {
        gerador1 = new UnidadeGeradora(1, "500kv", estadoGerador1).toString();
        gerador2 = new UnidadeGeradora(2, "450kv", estadoGerador2).toString();
        turnos = new ArrayList<>();
        turnos.add(new Turno(PeriodoTurno.MANHA.getPeriodoTurno()));
        this.subestacao = estadoSubestacao.toString();
        this.servicosAuxiliares = estadoServicosAuxiliares.toString();
    }

    public Dia() {
        turnos = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGerador1() {
        return gerador1;
    }

    public void setGerador1(String gerador1) {
        this.gerador1 = gerador1.toString();
    }

    public String getGerador2() {
        return gerador2;
    }

    public void setGerador2(String gerador2) {
        this.gerador2 = gerador2;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setListaTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setTurno(Turno turno, int index) {
        this.turnos.set(index, turno);
    }

    public String getSubestacao() {
        return subestacao;
    }

    public void setSubestacao(String subestacao) {
        this.subestacao = subestacao;
    }

    public String getServicosAuxiliares() {
        return servicosAuxiliares;
    }

    public void setServicosAuxiliares(String servicosAuxiliares) {
        this.servicosAuxiliares = servicosAuxiliares;
    }

}
