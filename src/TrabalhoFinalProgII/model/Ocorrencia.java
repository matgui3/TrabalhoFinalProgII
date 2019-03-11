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
    private String descricao;

    public Ocorrencia(Date hora, String descricao) {
        super();
        this.hora = hora;
        this.descricao = descricao;
    }  
    
    public Date getHora() {
        return hora;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
