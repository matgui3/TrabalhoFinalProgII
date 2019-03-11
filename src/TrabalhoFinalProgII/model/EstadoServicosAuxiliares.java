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
