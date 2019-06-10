/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.view.panels.CRUDActionPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author 00783962045
 */
public abstract class FrameCRUD extends JInternalFrame {

    private JPanel panelPrincipal;
    protected CRUDActionPanel panelBotoesCRUD;
    private Dimension dimension;
    protected JScrollPane scroll;

    private LayoutManager layout;

    public FrameCRUD(String titulo, Dimension dimension) throws HeadlessException {
        this.dimension = dimension;

        initializeComponets();
        addComponets();

        super.setSize(dimension);
        super.setTitle(titulo);
        super.setLayout(layout);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
        public FrameCRUD(String titulo, Dimension dimension, boolean relatorio) throws HeadlessException {
        this.dimension = dimension;

        initializeComponets();
        
        this.setContentPane(panelPrincipal);

        super.setSize(dimension);
        super.setTitle(titulo);
        super.setLayout(layout);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initializeComponets() {
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(dimension);

        panelBotoesCRUD = new CRUDActionPanel(this);

        layout = new BorderLayout();
        panelPrincipal.setLayout(layout);
        setPosicao();

    }
    
    public void addBotaoInferior(JButton botao){
        panelPrincipal.add(botao, BorderLayout.SOUTH);
    }

    public void setPosicao() {
        Dimension d = panelPrincipal.getSize();
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - d.width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - d.height) / 4);
    }

    private void addComponets() {
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelBotoesCRUD, BorderLayout.SOUTH);
        //scroll = new JScrollPane(panelPrincipal);
    }
    

    public void addFormulario(Container container) {
        panelPrincipal.add(container, BorderLayout.CENTER);
    }
    
    public void addFormularioRodape(Container container) {
        panelPrincipal.add(container, BorderLayout.SOUTH);
    }

    public CRUDActionPanel getPanelBotoesCRUD() {
        return panelBotoesCRUD;
    }

    public abstract void limparCampos();

    public abstract void gravarCampos();
    
    public abstract void excluirRegistro();
    
    public void fechar() {
        this.dispose();
    }
}
