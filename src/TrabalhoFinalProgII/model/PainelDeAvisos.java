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
 * Classe contendo os comportamentos e atributos dos objetos de tipo PainelDeAvisos.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public class PainelDeAvisos {
    
    private List<Aviso> avisos;
    private List<SenhasLogins> senhasLogins;
    private List<ValoresAlarmesTrip> valoresAlarmesTrip;
    
    /**
     * Método construtor dos objetos de tipo PainelDeAvisos.
     */
    PainelDeAvisos(){
        avisos = new ArrayList<>();
        senhasLogins = new ArrayList<>();
        valoresAlarmesTrip = new ArrayList<>();
    }
    
    /**
     * Adiciona um aviso à lista de avisos.
     * @param data Data do registro de aviso.
     * @param aviso Conteúdo do aviso em si.
     * @param publisher Operário publicador do aviso.
     */
    public void addAviso(Date data, String aviso, Operador publisher){
        Aviso advice = new Aviso(data, aviso, publisher);
        avisos.add(advice);
    }
    
    /**
     * Adiciona um novo registro do tipo SenhasLogins à lista.
     * @param equipamento Equipamento do qual está sendo colocado login e senha.
     * @param login Login para acesso aos dados do equipamento.
     * @param senha  Senha para acesso aos dados do equipamento.
     */
    public void addSenhasLogins(String equipamento, String login, String senha){
        SenhasLogins acesso = new SenhasLogins(equipamento, login, senha);
        senhasLogins.add(acesso);
    }
    
    /**
     * Adiciona um novo registro do tipo ValoresAlarmesTrip para a lista.
     * @param nomeAjuste Nome do ajuste a ser efetuado.
     * @param valorAjusteUg1 valor do ajuste na Unidade Geradora 1.
     * @param valorAjusteUg2  valor do ajuste na Unidade Geradora 2.
     */
    public void addValoresAlarmesTrip(String nomeAjuste, String valorAjusteUg1, String valorAjusteUg2){
        ValoresAlarmesTrip ajuste = new ValoresAlarmesTrip(nomeAjuste, valorAjusteUg1, valorAjusteUg2);
        valoresAlarmesTrip.add(ajuste);
    }
    
}
