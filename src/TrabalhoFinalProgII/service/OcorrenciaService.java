/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.service;

import TrabalhoFinalProgII.core.OcorrenciaDAO;
import TrabalhoFinalProgII.model.Ocorrencia;

/**
 *
 * @author guilh
 */
public class OcorrenciaService {

    OcorrenciaDAO dao = new OcorrenciaDAO();

    public Ocorrencia cadastrarOcorrencia(Ocorrencia ocorrencia) throws Exception {
        dao.inserir(ocorrencia);
        return ocorrencia;
    }

}
