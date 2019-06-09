/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Classe contendo os comportamentos e atributos das Unidades Geradoras.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
//Comentado para teste de nova classe como ENUM
@Entity
@Table(name = "unidade_geradora")
public class UnidadeGeradora {
    @Id
    @Column(name = "id_unidade")
    private int numero;
    @Column(name = "potencia")
    private String potencia;
    @Column(name = "estado_ug")
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

public UnidadeGeradora(){}
    
}
