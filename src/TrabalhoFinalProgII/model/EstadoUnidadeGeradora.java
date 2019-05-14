/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 * Classe enum contendo os possíveis estados das unidades geradoras..
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public enum EstadoUnidadeGeradora {
       
    OPERANDO("OPERANDO COMO GERADOR"),
    PARADA("PARADA DEVIDO À BAIXA AFLUÊNCIA"),
    PARADA_SGI("PARADA SGI");
    
    private final String estadoUg;

    EstadoUnidadeGeradora(String estadoUg) {
        this.estadoUg=estadoUg;
    }

    private String getEstadoUnidadeGeradora(){
        return this.estadoUg;
    }
    
    @Override
    public String toString() {
        return this.estadoUg;
    }
    
}
