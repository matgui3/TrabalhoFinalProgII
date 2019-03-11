/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 *
 * @author guilh
 */
public enum EstadoUnidadeGeradora {
       
    OPERANDO("OPERANDO COMO GERADOR"),
    PARADA("PARADA DEVIDO À BAIXA AFLUÊNCIA"),
    PARADA_SGI("PARADA SGI");
    
    private String estadoUg;

    EstadoUnidadeGeradora(String estadoUg) {
        this.estadoUg=estadoUg;
    }

    private String getEstadoUnidadeGeradora(){
        return this.estadoUg;
    }
    
}
