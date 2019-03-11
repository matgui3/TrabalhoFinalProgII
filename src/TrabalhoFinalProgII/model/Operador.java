/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.Date;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Operador.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
public class Operador {
    
    private int matricula;
    private String nome;
    private Date dataNascimento;
    private int telefone;
    private Cargo cargo;
    
    /**
     * Método construtor que cria o objeto de tipo Operador.
     * Note que não há matrícula no método construtor, pois esta será definida automaticamente pelo sistema para que não existam duas matrículas iguais.
     * @param nome Nome do operador a ser registrado.
     * @param dataNascimento Data de nascimento do operador a ser registrado.
     * @param telefone Telefone do operador a ser registrado
     * @param cargo Cargo a ser definido para o operador que está sendo registrado.
     */
    public Operador(String nome, Date dataNascimento, int telefone, Cargo cargo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cargo = cargo;
    }   
    
    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    
    
}
