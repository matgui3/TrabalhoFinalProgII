/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe contendo objetos Frases Prontas onde os Operários podem encontrar frases pré-definidas para avisos.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "frases_prontas")
public class FrasesProntas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lista_frases")
    private long id;
    @Column(name = "area")
    private EnumFrases area;
    @OneToMany(mappedBy = "frasesProntas", cascade = CascadeType.ALL)
    private ArrayList<Frase> frases;

    /**
     * Método que adiciona uma frase à lista de frases prontas.
     * @param frase Frase a ser adicionada.
     */ 
    public void addFrase(Frase frase) {
        frases.add(frase);
    }

    public EnumFrases getArea() {
        return area;
    }

    public void setArea(EnumFrases area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "FrasesProntas{" + "area=" + area + ", frases=" + frases + '}';
    }

}
