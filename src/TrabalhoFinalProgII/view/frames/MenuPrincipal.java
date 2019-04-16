/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.RelatorioOcorrencias;
import TrabalhoFinalProgII.view.listener.ListenerMenuAplicação;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author 00783962045
 */
public class MenuPrincipal extends JMenuBar implements ActionListener {

    private JMenu menuAbrirRelatorio;
    private JMenu menuBibliotecas;
    private JMenu menuOperadores;
    private JMenu menuAjuda;

    private JMenuItem menuItemAbrirRelatorio;
    private JMenuItem menuItemAddFrase;
    private JMenuItem menuItemAddAjuste;
    private JMenuItem menuItemAddOperadores;
    private JMenuItem menuItemVerOperadores;
    private JMenuItem menuItemSobre;
    private JMenuItem menuItemSair;
    private JMenuItem menuItemLogOut;

    private FramePrincipal frameSistema;

    public MenuPrincipal(FramePrincipal frameSistema) {
        this.frameSistema = frameSistema;

        initializeComponents();
        addComponents();
        addListener();
    }

    private void initializeComponents() {
        menuAbrirRelatorio = new JMenu("Relatório de Ocorrências");
        menuBibliotecas = new JMenu("Bibliotecas");
        menuOperadores = new JMenu("Operadores");
        menuAjuda = new JMenu("Ajuda");

        menuItemAbrirRelatorio = new JMenuItem("Abrir Relatório");
        menuItemAddFrase = new JMenuItem("Adicionar Frase à Biblioteca");
        menuItemAddAjuste = new JMenuItem("Adicionar Ajuste à Biblioteca");
        menuItemAddOperadores = new JMenuItem("Adicionar Operadores");
        menuItemVerOperadores = new JMenuItem("Operadores Cadastrados");
        menuItemSobre = new JMenuItem("Sobre a Aplicação");
        menuItemSair = new JMenuItem("Sair");
        menuItemLogOut = new JMenuItem("Efetuar logout");
        menuItemLogOut.addActionListener(this);
        menuItemSair.addActionListener(this);
    }

    private void addComponents() {
        menuAbrirRelatorio.add(menuItemAbrirRelatorio);
        
        menuBibliotecas.add(menuItemAddFrase);
        menuBibliotecas.add(menuItemAddAjuste);

        menuOperadores.add(menuItemVerOperadores);
        menuOperadores.add(menuItemAddOperadores);

        menuAjuda.add(menuItemSobre);
        menuAjuda.add(menuItemLogOut);
        menuAjuda.add(menuItemSair);

        super.add(menuAbrirRelatorio);
        super.add(menuBibliotecas);
        super.add(menuOperadores);
        super.add(menuAjuda);
    }

    private void addListener() {
        ActionListener listener = new ListenerMenuAplicação(FrameFrasesProntas.class, frameSistema);
        menuItemAddFrase.addActionListener(listener);
        
        listener = new ListenerMenuAplicação(FrameRelatorio.class, frameSistema);
        menuItemAbrirRelatorio.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == menuItemSair) {
            Object[] options = {"Sim", "Não"};
            int opcao = JOptionPane.showOptionDialog(null, "Deseja realmente sair do sistema?", 
                    "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0 ) { 
                frameSistema.dispose();
                  } 
        }
    }

}
