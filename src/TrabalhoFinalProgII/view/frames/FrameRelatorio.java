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
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author 00783962045
 */
public class FrameRelatorio extends FrameCRUD{
    private static final String titulo = "Frases Prontas";
    private static final Dimension dimension = new Dimension(800, 600);

    private FrasesProntas novaFrase;

    private Label lbArea;
    private Label lbFrase;

    private JTextArea taFrase;
    private JComboBox cbArea;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;
    private EnumFrases esseEnum;

    public FrameRelatorio() {
        super(titulo, dimension);

        novaFrase = new FrasesProntas();

        initializeComponents();
        addComponents();
        setMaximizable(true);
        setClosable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

  

    private void initializeComponents() {
        lbArea = new Label("Frame:");
        lbFrase = new Label("Frame:");

        taFrase = new JTextArea(5, 45);
        taFrase.setLineWrap(true);
        cbArea = new JComboBox(EnumFrases.values());

        cbArea.setSelectedIndex(-1);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

        panelFormulario.setBorder(BorderFactory.createTitledBorder("Frame Relatório"));
        
        //cria um itemListener para saber qual item foi selecionado
        cbArea.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    esseEnum = (EnumFrases) e.getItem();
                }
            }
        });
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
        cons.weightx = 0;
        cons.insets = new Insets(0, 0, 0, 15);
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
        panelFormulario.add(taFrase, cons);

        super.addFormulario(panelFormulario);
       
    }
    

    @Override
    public void carregarCampos() {
        
        novaFrase.setArea(esseEnum);
        novaFrase.CadastrarFrase(taFrase.getText());
        System.out.println(novaFrase.toString());

    }

    @Override
    public void limparCampos() {
        this.novaFrase = new FrasesProntas();
        taFrase.setText("");
        cbArea.setSelectedIndex(-1);

        super.repaint();
    }

    
}
