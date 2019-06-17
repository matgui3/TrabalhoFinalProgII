/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.core;

import TrabalhoFinalProgII.model.Dia;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author guilh
 */
public class DiaDAO extends JPADAO<Dia> {

    public Dia pesquisarDiaPorData(String data) {
        Query query = em.createNamedQuery("Dia.pesquisarDiaPorData");
        query.setParameter("data", data);

        List<Dia> dias = query.getResultList();

        if (dias.size() != 0) {
            return dias.get(0);
        } else {
            return null;
        }
    }

}
