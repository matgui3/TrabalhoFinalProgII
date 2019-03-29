/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.view.listener.ListenerMenuAplicação;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author 00783962045
 */
public class MenuPrincipal extends JMenuBar {
    private JMenu menuCliente;
    private JMenu menuConta;
    private JMenu menuAjuda;
    
    private JMenuItem menuItemCadCliCliente;
    private JMenuItem menuItemCadCliEndereco;
    private JMenuItem menuItemCadAgenca;
    private JMenuItem menuItemCadContaCorrente;
    private JMenuItem menuItemCadContaPoupanca;
    private JMenuItem menuItemCadContaSalario;
    private JMenuItem menuItemSobre;
    
    private FramePrincipal frameSistema;

    public MenuPrincipal(FramePrincipal frameSistema) {
        this.frameSistema = frameSistema;
    
        initializeComponents();
        addComponents();
        addListener();
    }

    private void initializeComponents() {
        menuCliente = new JMenu("Cliente");
        menuConta = new JMenu("Conta");
        menuAjuda = new JMenu("Ajuda");
        
        menuItemCadCliCliente = new JMenuItem("Cadastro de Cliente");
        menuItemCadCliEndereco = new JMenuItem("Cadastro de Endereco");
        menuItemCadAgenca = new JMenuItem("Cadastro de Agencia");
        menuItemCadContaCorrente = new JMenuItem("Cadastro de Conta Corrente");
        menuItemCadContaSalario = new JMenuItem("Cadastro de Conta Salario");
        menuItemCadContaPoupanca = new JMenuItem("Cadastro de Conta Poupanca");
        menuItemSobre = new JMenuItem("Sobre a Aplicação");
    }

    private void addComponents() {
        menuCliente.add(menuItemCadCliCliente);
        menuCliente.add(menuItemCadCliEndereco);
        
        menuConta.add(menuItemCadAgenca);
        menuConta.add(menuItemCadContaCorrente);
        menuConta.add(menuItemCadContaPoupanca);
        menuConta.add(menuItemCadContaSalario);
        
        menuAjuda.add(menuItemSobre);
        
        super.add(menuCliente);
        super.add(menuConta);
        super.add(menuAjuda);
    }

    private void addListener() {
        ActionListener listener = new ListenerMenuAplicação(FrameFrasesProntas.class, frameSistema);
        menuItemCadCliEndereco.addActionListener(listener);
    
    }
    
    
    
    
    
    
}
