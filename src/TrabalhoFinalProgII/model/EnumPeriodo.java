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
public enum EnumPeriodo {
    PERIODO("Um turno"),
    DIA("Um dia"),
    SEMANA("Uma semana");
    
    private final String enumPeriodo;

    EnumPeriodo(String enumPeriodo) {
        this.enumPeriodo = enumPeriodo;
    }
    
    public String getValue(){
        return enumPeriodo;
    }

    @Override
    public String toString() {
        return this.enumPeriodo;
    }
}