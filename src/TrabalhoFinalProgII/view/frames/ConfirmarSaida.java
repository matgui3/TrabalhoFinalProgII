/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 00783962045
 */
public class ConfirmarSaida extends JFrame implements ActionListener {

    private JButton btSim;
    private JButton btNao;
    private Label jlPergunta;
    private LayoutManager layout;
    private FramePrincipal parent;
    private Dimension dimensaoBotao;
    private Dimension dimensaoPainel;

    public ConfirmarSaida(FramePrincipal parent) {
        this.parent = parent;

        initializeComponents();
        addComponents();

        super.setLayout(layout);
        super.setSize(dimensaoPainel);
        setLocationRelativeTo(null);

    }

    private void addComponents() {
       

        this.setLayout(layout);
        this.add(btSim);
        this.add(btNao);
        this.add(jlPergunta);

    }

    private void initializeComponents() {
        dimensaoBotao = new Dimension(100, 20);
        dimensaoPainel = new Dimension(300, 150);

        layout = new FlowLayout(FlowLayout.CENTER);

        jlPergunta = new Label("Deseja realmente Sair?");

        btNao = new JButton("Não");
        btNao.addActionListener(this);
        btNao.setSize(dimensaoBotao);
        

        btSim = new JButton("Sim");
        btSim.addActionListener(this);
        btSim.setSize(dimensaoBotao);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == btSim) {
            this.parent.fechar();
            this.dispose();
        }
    }

}
