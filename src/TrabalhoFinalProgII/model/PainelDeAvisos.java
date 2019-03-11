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
public class PainelDeAvisos {
    
    private List<Aviso> avisos;
    private List<SenhasLogins> senhasLogins;
    private List<ValoresAlarmesTrip> valoresAlarmesTrip;
    
    PainelDeAvisos(){
        avisos = new ArrayList<>();
        senhasLogins = new ArrayList<>();
        valoresAlarmesTrip = new ArrayList<>();
    }
    
    public void addAviso(Date data, String aviso, Operador publisher){
        Aviso advice = new Aviso(data, aviso, publisher);
        avisos.add(advice);
    }
    
    public void addSenhasLogins(String equipamento, String login, String senha){
        SenhasLogins acesso = new SenhasLogins(equipamento, login, senha);
        senhasLogins.add(acesso);
    }
    
    public void addValoresAlarmesTrip(String nomeAjuste, String valorAjusteUg1, String valorAjusteUg2){
        ValoresAlarmesTrip ajuste = new ValoresAlarmesTrip(nomeAjuste, valorAjusteUg1, valorAjusteUg2);
        valoresAlarmesTrip.add(ajuste);
    }
    
}
