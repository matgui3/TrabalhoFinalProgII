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
public enum PeriodoTurno {
    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");
    
    private String periodo;
    
    PeriodoTurno(String periodo){
        this.periodo = periodo;
    }
    
    public String getPeriodoTurno(){
        return this.periodo;
    }
}
