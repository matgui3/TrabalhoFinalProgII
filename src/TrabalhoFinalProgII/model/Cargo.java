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
public enum Cargo {
    OPERADOR1("OPERADOR I"),
    OPERADOR2("OPERADOR II"),
    OPERADOR3("OPERADOR III");
    
    private String operador;
    
    Cargo(String operador){
        this.operador=operador;
    }
    
    public String getCargo(){
        return this.operador;
    }
}
