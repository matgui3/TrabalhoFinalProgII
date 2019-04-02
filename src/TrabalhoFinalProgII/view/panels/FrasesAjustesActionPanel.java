/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.panels;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tasso
 */
public class FrasesAjustesActionPanel extends JPanel implements ActionListener {

    private JButton btFrases;
    private JButton btAjustes;

    private LayoutManager layout;
    private JPanel panel;

    private Dimension dimensaoBotao;
    private Dimension dimensaoPainel;
    private GridBagConstraints cons;

    private final Container parent;

    public FrasesAjustesActionPanel(Container parent) {
        this.parent = parent;
        initComponents();
        addComponents();

        super.setVisible(true);
        super.setSize(dimensaoPainel);
    }

    private void initComponents() {
        dimensaoBotao = new Dimension(100, 20);
        dimensaoPainel = new Dimension(parent.getWidth(), 30);

        layout = new GridBagLayout();
        panel = new JPanel(layout);

        btFrases = new JButton("Frases");
        btFrases.addActionListener(this);
        btFrases.setSize(dimensaoBotao);
        btFrases.setAlignmentX(10);

        btAjustes = new JButton("Ajustes");
        btAjustes.addActionListener(this);
        btAjustes.setSize(dimensaoBotao);
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 0, 550);
        panel.add(btFrases, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 0, 15);
        panel.add(btAjustes, cons);
        this.add(panel);
    }

    public JButton getBtFrases() {
        return btFrases;
    }

    public JButton getBtAjustes() {
        return btAjustes;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == btFrases) {

        }
    }
}
