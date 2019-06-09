/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 *
 * @author 00783962045
 */
public enum EnumTurnos {

    TURNO1("1° TURNO"),
    TURNO2("2° TURNO"),
    TURNO3("3° TURNO");
    
    private final String enumTurnos;

    EnumTurnos(String enumTurnos) {
        this.enumTurnos = enumTurnos;
    }

    public String getValue() {
        return enumTurnos;
    }

    @Override
    public String toString() {
        return this.enumTurnos;
    }

}
