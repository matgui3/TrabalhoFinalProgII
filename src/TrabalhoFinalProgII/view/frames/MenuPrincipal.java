/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.view.listener.ListenerMenuAplicação;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
    private JMenuItem menuItemSair;

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
        menuItemSair = new JMenuItem("Sair");
        menuItemSair.addActionListener(this);
    }

    private void addComponents() {
        menuAbrirRelatorio.add(menuItemAbrirRelatorio);

        menuBibliotecas.add(menuItemAddFrase);
        menuBibliotecas.add(menuItemAddAjuste);

        menuOperadores.add(menuItemVerOperadores);
        menuOperadores.add(menuItemAddOperadores);

        menuAjuda.add(menuItemSair);

        super.add(menuAbrirRelatorio);
        super.add(menuBibliotecas);
        super.add(menuOperadores);
        super.add(menuAjuda);
    }

    private void addListener() {
        ActionListener listener = new ListenerMenuAplicação(FrameBuscarRelatorio.class, frameSistema);
        menuItemAbrirRelatorio.addActionListener(listener);

        listener = new ListenerMenuAplicação(FrameFrasesProntas.class, frameSistema);
        menuItemAddFrase.addActionListener(listener);
        
        listener = new ListenerMenuAplicação(FrameCadastrarOperadores.class, frameSistema);
        menuItemAddOperadores.addActionListener(listener);

        listener = new ListenerMenuAplicação(FrameFrasesAjustes.class, frameSistema);
        menuItemAddAjuste.addActionListener(listener);

        listener = new ListenerMenuAplicação(FrameExibirOperadores.class, frameSistema);
        menuItemVerOperadores.addActionListener(listener);
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
