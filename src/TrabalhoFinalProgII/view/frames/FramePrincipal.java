/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

/**
 *
 * @author 00783962045
 */
public class FramePrincipal extends JFrame {

    private Dimension dimTela;
    private JDesktopPane desktop;
    private Container contentPane;
    private JMenuBar menuAplicacao;

    public FramePrincipal() {
        super("Relatório de Ocorrências");

        initializeComponents();
        addComponents();

        setSize(dimTela);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    private void initializeComponents() {
        dimTela = new Dimension(800, 600);
        desktop = new JDesktopPane();
        contentPane = super.getContentPane();
        menuAplicacao = new MenuPrincipal(this);
    }

    private void addComponents() {
        contentPane.add(desktop, BorderLayout.CENTER);
        super.setJMenuBar(menuAplicacao);
    }

    public void adicionarFormulario(JInternalFrame frame) {
        desktop.add(frame);
        frame.setVisible(true);
    }

}
