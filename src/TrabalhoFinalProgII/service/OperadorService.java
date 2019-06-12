/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.service;

import TrabalhoFinalProgII.core.JPADAO;
import TrabalhoFinalProgII.core.OperadorDAO;
import TrabalhoFinalProgII.model.Cargo;
import TrabalhoFinalProgII.model.Operador;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author guilh
 */
public class OperadorService {

    JPADAO<Operador> dao = new JPADAO();
    OperadorDAO operadorDAO = new OperadorDAO();

    public List<Operador> buscarOperadores() {
        List<Operador> operadores;
        operadores = operadorDAO.buscarTodosOperadores();
        return operadores;
    }

    public Operador cadastrarOperador(String nome, LocalDate dataNascimento, String telefone, Cargo cargo) throws Exception {
        if (nome == null || nome.equals("")) {
            throw new IOException("O nome do operador não pode ser nulo.");
        }
        if (telefone == null || telefone.length() != 15) {
            throw new IOException("Telefone inválido. Tente novamente.");
        }
        if (cargo == null) {
            throw new IOException("O cargo do operador não pode ser nulo.");
        }
        String[] dataSplit;
        dataSplit = dataNascimento.toString().split("-");
        String dataFormatada = dataSplit[2] + "-" + dataSplit[1] + "-" + dataSplit[0];

        Operador operador = new Operador();

        operador.setNome(nome);
        operador.setDataNascimento(dataFormatada);
        operador.setTelefone(telefone);
        operador.setCargo(cargo);

        dao.inserir(operador);
        return operador;
    }

//    public Operador editarOperador(long matricula, String nome, LocalDate dataNascimento, String telefone, Cargo cargo) throws Exception {
//        Operador operador = operadorDAO.buscarOperadorPorMatricula(Long matricula
//        );
//        
//        if (nome != null) 
//            operador.setNome(nome);
//        if (dataNascimento != null) 
//            operador.setDataNascimento(dataNascimento);
//        if (telefone != null || !telefone.equals("")) 
//            operador.setTelefone(telefone);
//        if (cargo != null) 
//            System.out.println("Cargo de operador inválido na edilção.");
//
//        dao.inserir(operador);
//        return operador;
//    }
}
