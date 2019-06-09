/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos Relatórios de Ocorrências.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "valores_alarmes_trip")
public class ValoresAlarmesTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_valores_alarmes_trip")
    private long id;
    @Column(name = "nome_ajuste")
    private String nomeAjuste;
    @Column(name = "valor_ajuste_ug1")
    private String valorAjusteUg1;
    @Column(name = "valor_ajuste_ug2")
    private String valorAjusteUg2;

    /**
     * Método construtor da classe ValoresAlarmesTrip.
     * @param nomeAjuste Nome do ajuste a ser efetuado.
     * @param valorAjusteUg1 Valor do ajuste na Unidade Geradora 1.
     * @param valorAjusteUg2 Valor do ajuste na Unidade Geradora 2.
     */
    public ValoresAlarmesTrip(String nomeAjuste, String valorAjusteUg1, String valorAjusteUg2) {
        this.nomeAjuste = nomeAjuste;
        this.valorAjusteUg1 = valorAjusteUg1;
        this.valorAjusteUg2 = valorAjusteUg2;
    }
    
    public ValoresAlarmesTrip(){}

    public String getNomeAjuste() {
        return nomeAjuste;
    }

    public void setNomeAjuste(String nomeAjuste) {
        this.nomeAjuste = nomeAjuste;
    }

    public String getValorAjusteUg1() {
        return valorAjusteUg1;
    }

    public void setValorAjusteUg1(String valorAjusteUg1) {
        this.valorAjusteUg1 = valorAjusteUg1;
    }

    public String getValorAjusteUg2() {
        return valorAjusteUg2;
    }

    public void setValorAjusteUg2(String valorAjusteUg2) {
        this.valorAjusteUg2 = valorAjusteUg2;
    }
    
    
    
}
