/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.view.panels.FrasesAjustesActionPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author 00783962045
 */
public class FramePrincipal extends JFrame {

    private Dimension dimTela;
    private JDesktopPane desktop;
    private Container contentPane;
    private JMenuBar menuAplicacao;
    private FrasesAjustesActionPanel panelBotoes;
    
    public FramePrincipal() {
        super("Relatório de Ocorrências");

        initializeComponents();
        addComponents();

        setSize(dimTela);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initializeComponents() {
        dimTela = Toolkit.getDefaultToolkit().getScreenSize();
        desktop = new JDesktopPane();
        contentPane = super.getContentPane();
        menuAplicacao = new MenuPrincipal(this);
        panelBotoes = new FrasesAjustesActionPanel(this);
       
    }

    private void addComponents() {
        contentPane.add(desktop, BorderLayout.CENTER);
        super.setJMenuBar(menuAplicacao);
        contentPane.add(panelBotoes,BorderLayout.NORTH);
        
    }


    public void adicionarFormulario(JInternalFrame frame) {
        desktop.add(frame);
        frame.setVisible(true);
    }
    public void fechar() {
        this.dispose();
    }

}
