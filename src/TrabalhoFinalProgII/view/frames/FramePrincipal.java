/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
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
    private FrameRelatorio relatorio;

    public FramePrincipal()  {
        super("Relatório de Ocorrências");

        initializeComponents();
        addComponents();

        setSize(dimTela);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void initializeComponents()  {
        dimTela = Toolkit.getDefaultToolkit().getScreenSize();
        desktop = new JDesktopPane();
        contentPane = super.getContentPane();
        relatorio = new FrameRelatorio();
        menuAplicacao = new MenuPrincipal(this);

    }

    public void addComponents() {
        contentPane.add(desktop, BorderLayout.CENTER);
        super.setJMenuBar(menuAplicacao);
        adicionarFormulario(relatorio);
        try {
            relatorio.setMaximum(true);
        } catch (PropertyVetoException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    


    public void adicionarFormulario(JInternalFrame frame) {
        desktop.add(frame);
        frame.setVisible(true);
    }

    public void fechar() {
        this.dispose();
    }

}
