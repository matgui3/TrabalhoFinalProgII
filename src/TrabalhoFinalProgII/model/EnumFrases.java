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
public enum EnumFrases {
    UG1("UG1"),
    UG2("UG2"),
    SERVIÇOSAUXILIARES("Serviçes Auxiliares"),
    TOMADADAGUA("Tomada D'Água"),
    SE("Subestação");
    
    private final String enumFrases;

    EnumFrases(String enumFrases) {
        this.enumFrases = enumFrases;
    }
    
    public String getValue(){
        return enumFrases;
    }

    @Override
    public String toString() {
        return this.enumFrases;
    }
    
}
