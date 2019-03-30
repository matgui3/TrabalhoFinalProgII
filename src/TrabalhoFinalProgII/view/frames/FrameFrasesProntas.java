/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EnumFrases;
import TrabalhoFinalProgII.model.FrasesProntas;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 00783962045
 */
public class FrameFrasesProntas extends FrameCRUD {

    private static final String titulo = "Frases Prontas";
    private static final Dimension dimension = new Dimension(800, 600);

    private FrasesProntas novaFrase;

    private Label lbArea;
    private Label lbFrase;

    private JTextField tfFrase;
    private JComboBox cbArea;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameFrasesProntas() {
        super(titulo, dimension);

        novaFrase = new FrasesProntas();

        initializeComponents();
        addComponents();

        carregarCampos();
    }

    public FrameFrasesProntas(FrasesProntas novaFrase) {
        super(titulo, dimension);

        this.novaFrase = novaFrase;

        initializeComponents();
        addComponents();

        carregarCampos();
    }

    private void initializeComponents() {
        lbArea = new Label("Área:");
        lbFrase = new Label("Frase:");

        tfFrase = new JTextField();
        cbArea = new JComboBox(EnumFrases.values());

        cbArea.setSelectedIndex(-1);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

        panelFormulario.setBorder(BorderFactory.createTitledBorder("Frases Prontas"));
    }

    @Override
    public void carregarCampos() {
        tfFrase.setText(novaFrase.toString());

        EnumFrases area = novaFrase.getArea();
        if (area != null) {
            cbArea.setSelectedIndex(area.ordinal());
        } else {
            cbArea.setSelectedIndex(-1);
        }
    }

    @Override
    public void limparCampos() {
        this.novaFrase = new FrasesProntas();

        carregarCampos();

        super.repaint();
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbArea, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 5;
        panelFormulario.add(cbArea, cons);

        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbFrase, cons);

        cons = new GridBagConstraints();
        cons.gridx = 4;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        panelFormulario.add(tfFrase, cons);

        super.addFormulario(panelFormulario);
    }



}
