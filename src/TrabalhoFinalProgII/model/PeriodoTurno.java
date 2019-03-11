/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

/**
 * Classe enum contendo os possíveis períodos de Turno.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public enum PeriodoTurno {
    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");
    
    private String periodo;
    
    PeriodoTurno(String periodo){
        this.periodo = periodo;
    }
    
    /**
     * Método para receber a representação textual do período do turno atual.
     * @return Período do turno atual.
     */
    public String getPeriodoTurno(){
        return this.periodo;
    }
}
