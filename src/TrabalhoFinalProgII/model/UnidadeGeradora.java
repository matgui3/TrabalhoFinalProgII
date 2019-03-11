/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 *
 * @author Guilherme Rafael Deschamps
 */
public class UnidadeGeradora {
    
    private int numero;
    private String potencia;
    private EstadoUnidadeGeradora estadoUg;

    public int getNumero() {
        return numero;
    }

    public String getPotencia() {
        return potencia;
    }

    /**
     * Método construtor dos objetos de tipo Unidade Geradora.
     * @param numero Número da unidade geradora.
     * @param potencia Potência da unidade geradora.
     * @param estadoUg Estado da unidade geradora.
     */
    public UnidadeGeradora(int numero, String potencia, EstadoUnidadeGeradora estadoUg) {
        super();
        this.numero = numero;
        this.potencia = potencia;
        this.estadoUg = estadoUg;
    }    
    
}
