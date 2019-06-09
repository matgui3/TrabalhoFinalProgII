/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos objetos de tipo SenhasLogins.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "senhas_logins")
public class SenhasLogins {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipamento")
    private long idEquipamento;
    @Column(name = "desc_equipamento")
    private String equipamento;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    
    /**
     * Método construtor dos objetos de tipo SenhasLogins.
     * @param equipamento Equipamento do qual a senha e o login estão sendo registrados.
     * @param login Login do equipamento.
     * @param senha  Senha do equipamento.
     */
    public SenhasLogins(String equipamento, String login, String senha){
        super();
        this.equipamento=equipamento;
        this.login=login;
        this.senha=senha;
    }
    
    public SenhasLogins(){}

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
