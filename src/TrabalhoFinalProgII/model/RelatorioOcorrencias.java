/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos Relatórios de Ocorrências.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "relatorio_ocorrencias")
public class RelatorioOcorrencias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Dia[] dias;
    @OneToOne
    @JoinColumn(name = "id_painel_avisos", referencedColumnName = "id_painel")
    private PainelDeAvisos painelAvisos;
    @OneToOne
    @JoinColumn(name = "id_dia", referencedColumnName = "id_dia")
    private Dia diaAtual;
    private int i = 0;
    
    /**
     * Método construtor da classe RelatorioOcorrencias, responsável por criar o Array de dias, o Painel de Avisos, e settar os dados do dia atual.
     */
    public RelatorioOcorrencias(){
        dias = new Dia[31];
        painelAvisos= new PainelDeAvisos();
        diaAtual = new Dia(EstadoUnidadeGeradora.OPERANDO, EstadoUnidadeGeradora.PARADA_SGI, EstadoSubestacao.LTS2, EstadoServicosAuxiliares.TSA1E2);
    }
    
    /**
     * Guarda os dados do dia atual no array de dias, adiciona 1 ao valor do contator do dia e cria o novo dia com os novos dados.
     * @param estadoGerador1 Estado do gerador 1 no momento de criação do dia.
     * @param estadoGerador2 Estado do gerador 2 no momento de criação do dia.
     * @param subestacao Estado da subestação no momento de criação do dia.
     * @param servicosAuxiliares  Estado dos serviços auxiliares no momento de criação do dia.
     */
    public void NovoDia(EstadoUnidadeGeradora estadoGerador1, EstadoUnidadeGeradora estadoGerador2, EstadoSubestacao subestacao, EstadoServicosAuxiliares servicosAuxiliares){
        dias[i] = (diaAtual);
        i++;
        diaAtual = new Dia(estadoGerador1, estadoGerador2, subestacao, servicosAuxiliares);
    }
    
}
