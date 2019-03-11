/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 * Classe enum contendo os possíveis estados dos serviços auxiliares.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public enum EstadoServicosAuxiliares {
    
    TSA1("ALIMENTADO PELO TRANSFORMADOR AUXILIAR TSA1"),
    TSA2("ALIMENTADO PELO TRANSFORMADOR AUXILIAR TSA2"),
    TSA1E2("ALIMENTADO PELO TRANSFORMADOR AUXILIAR TSA1 E TSA2");
    
    private String servico;

    private EstadoServicosAuxiliares(String servico) {
        this.servico=servico;
    }
    
    public String getServicosAuxiliares(){
        return this.servico;
    }
       
}
