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
    public void excluirAjuste() throws Exception {
        
        try {
            em.getTransaction().begin();
            em.createNativeQuery("DELETE FROM valores_alarmes_trip").executeUpdate();
        } catch (Exception e) {
            System.out.println("Deu erro!" + e);
            em.getTransaction().rollback(); // desfaz transacao se ocorrer erro ao persitir
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
        }
    }
}
