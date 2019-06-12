/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo Operador.
 *
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "operador")
@NamedQueries({
    @NamedQuery(name = "Operador.buscarTodos",
            query = "SELECT o FROM Operador o")
//    @NamedQuery(name = "Operador.buscarPorMatricula",
//            query = "SELECT o FROM Operador o WHERE o.matricula := matricula")
})
public class Operador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula")
    private int matricula;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "cargo")
    private String cargo;

    /**
     * Método construtor que cria o objeto de tipo Operador. Note que não há
     * matrícula no método construtor, pois esta será definida automaticamente
     * pelo sistema para que não existam duas matrículas iguais.
     *
     * @param nome Nome do operador a ser registrado.
     * @param dataNascimento Data de nascimento do operador a ser registrado.
     * @param telefone Telefone do operador a ser registrado
     * @param cargo Cargo a ser definido para o operador que está sendo
     * registrado.
     */
    public Operador(String nome, String dataNascimento, String telefone, Cargo cargo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cargo = cargo.getCargo();
    }

    public Operador() {
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo.getCargo();
    }

}
