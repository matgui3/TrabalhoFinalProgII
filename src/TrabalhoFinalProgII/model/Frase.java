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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author guilh
 */
@Entity
@Table(name = "frases")
public class Frase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_frase")
    private int idFrase;
    @Column(name = "frase")
    private String frase;
    @ManyToOne
    @JoinColumn(name = "id_lista_frases", referencedColumnName = "id_lista_frases")
    private FrasesProntas frasesProntas;
}
