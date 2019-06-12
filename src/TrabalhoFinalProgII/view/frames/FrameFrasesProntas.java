/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EnumFrases;
import TrabalhoFinalProgII.model.Frase;
import TrabalhoFinalProgII.service.FrasesService;
import TrabalhoFinalProgII.view.panels.CRUDActionPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author 00783962045
 */
public final class FrameFrasesProntas extends FrameCRUD {

    private static final String titulo = "Cadastro de Frases Prontas";
    private static final Dimension dimension = new Dimension(800, 600);
    private FrasesService frasesService;

    private Frase novaFrase;

    private Label lbArea;
    private Label lbFrase;

    private JTextArea taFrase;
    private JComboBox cbArea;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;
    private EnumFrases enumFrases;

    public FrameFrasesProntas() {
        super(titulo, dimension);

        novaFrase = new Frase();

        initializeComponents();
        addComponents();

    }

    public FrameFrasesProntas(Frase novaFrase) {
        super(titulo, dimension);

        this.novaFrase = novaFrase;

        initializeComponents();
        addComponents();

    }

    private void initializeComponents() {
        frasesService = new FrasesService();
        lbArea = new Label("Área:");
        lbFrase = new Label("Frase:");

        taFrase = new JTextArea(5, 45);
        taFrase.setLineWrap(true);
        cbArea = new JComboBox(EnumFrases.values());

        cbArea.setSelectedIndex(-1);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

        panelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastrar Frases Prontas"));
        //cria um itemListener para saber qual item foi selecionado
        cbArea.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    enumFrases = (EnumFrases) e.getItem();
                }
            }
        });
        removeExcluir();
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
    public void gravarCampos() {
        
        String frase = taFrase.getText();
        EnumFrases area = (EnumFrases) cbArea.getSelectedItem();
        try {
            if (cbArea.getSelectedIndex() == -1) {
                throw new Exception("Selecione a área de aplicação da nova frase.");
            }
            frasesService.criarFrase(frase, area);
                JOptionPane.showMessageDialog(null, "Frase criada com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Algo deu errado!\nFrase não cadastrado!");
        }
    }

    @Override
    public void limparCampos() {
        this.novaFrase = new Frase();
        taFrase.setText("");
        cbArea.setSelectedIndex(-1);

        super.repaint();
    }

    @Override
    public void excluirRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
