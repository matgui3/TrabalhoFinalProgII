/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe contendo os comportamentos e atributos dos Avisos.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "avisos")
public class Aviso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_aviso")
    private long idAviso;
    @Column(name = "data")
    private Date data;
    @Column(name = "aviso")
    private String aviso;
    @ManyToOne
    @JoinColumn(name = "id_painel", referencedColumnName = "id_painel")
    private PainelDeAvisos painelDeAvisos;
    @OneToOne
    @JoinColumn(name = "matricula_operador", referencedColumnName = "matricula")
    private Operador publisher;
    
   /**
    * Método construtor da classe Aviso.
    * @param data Data de postagem do aviso.
    * @param aviso Conteúdo em escrito do aviso em si.
    * @param publisher Operador que publicou o aviso no painel.
    */ 
    public Aviso(Date data, String aviso, Operador publisher){
        super();
        this.data=data;
        this.aviso=aviso;
        this.publisher=publisher;
    }

    public Date getData() {
        return data;
    }
    
    public String getAviso() {
        return aviso;
    }

    public Operador getPublisher() {
        return publisher;
    }
    
}
