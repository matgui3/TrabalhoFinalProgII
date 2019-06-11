/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.core;

import TrabalhoFinalProgII.model.ValoresAlarmesTrip;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author guilh
 */
public class AjustesDAO extends JPADAO<ValoresAlarmesTrip> {

    public List<ValoresAlarmesTrip> buscarAjustes() {
        List<ValoresAlarmesTrip> ajustes;

        Query query = em.createNamedQuery("ValoresAlarmesTrip.buscarAjustes");
        ajustes = query.getResultList();

        return ajustes;
    }
}
