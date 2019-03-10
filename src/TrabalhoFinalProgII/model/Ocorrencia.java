/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.Date;

/**
 *
 * @author guilh
 */
public class Ocorrencia {
    
    private Date hora;
    private String ocorrencia;

    public Ocorrencia(Date hora, String ocorrencia) {
        super();
        this.hora = hora;
        this.ocorrencia = ocorrencia;
    }  
    
    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
    
    
}
