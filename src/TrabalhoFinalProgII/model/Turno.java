/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.List;

/**
 *
 * @author guilh
 */
public class Turno {
    
    private List<Ocorrencia> ocorrencias;
    private PeriodoTurno periodo;

    public void setPeriodo(PeriodoTurno periodo) {
        this.periodo = periodo;
    }
    
    /*
    
    Exemplo de uso do Enum
    public static void main(String[] args) {
        System.out.println(PeriodoTurno.MANHA.getPeriodoTurno());
    }
    
    */
    
    public Turno getTurno(){
        Turno turno = new Turno();
        
        return turno;
    }
    
}
