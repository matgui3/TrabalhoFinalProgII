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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe contendo objetos Frases Prontas onde os Operários podem encontrar frases pré-definidas para avisos.
 * @author Guilherme Rafael Deschamps e Rodrigo Souza Tassoni
 * @since 11/03/2019
 */
@Entity
@Table(name = "frases_prontas")
@NamedQueries({
        @NamedQuery(name = "Frase.buscarFrases",
            query = "SELECT f FROM Frase f")
})
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_frase")
    private long id;
    @Column(name = "area")
    private EnumFrases area;
    @Column(name = "frase")
    private String texto;

    public EnumFrases getArea() {
        return area;
    }

    public void setArea(EnumFrases area) {
        this.area = area;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void CadastrarFrase(String text) {
        //Classe criada para fugir de erro de compilação. 
    }
    
}
