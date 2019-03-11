/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.List;

/**
 *
 * @author guilh
 */
public class RelatorioOcorrencias {
    
    private Dia[] dias;
    private PainelDeAvisos painelAvisos;
    private Dia diaAtual;
    private int i = 0;
    
    public RelatorioOcorrencias(){
        dias = new Dia[31];
        painelAvisos= new PainelDeAvisos();
        diaAtual = new Dia(EstadoUnidadeGeradora.OPERANDO, EstadoUnidadeGeradora.PARADA_SGI, EstadoSubestacao.LTS2, EstadoServicosAuxiliares.TSA1E2);
    }
    
    public void NovoDia(EstadoUnidadeGeradora estadoGerador1, EstadoUnidadeGeradora estadoGerador2, EstadoSubestacao subestacao, EstadoServicosAuxiliares servicosAuxiliares){
        dias[i] = (diaAtual);
        i++;
        diaAtual = new Dia(estadoGerador1, estadoGerador2, subestacao, servicosAuxiliares);
    }
    
}
