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
public class Avisos {
    
    private Date data;
    private String aviso;
    private Operador publisher;
    
    private Avisos(Date data, Date hora, String aviso, Operador publisher){
        super();
        this.data=data;
        this.aviso=aviso;
        this.publisher=publisher;
    }

    public Date getData() {
        return data;
    }


    public String getAviso() {
        return aviso;
    }

    public Operador getPublisher() {
        return publisher;
    }
    
}
