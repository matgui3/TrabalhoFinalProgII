/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.Cargo;
import TrabalhoFinalProgII.model.EnumPeriodo;
import TrabalhoFinalProgII.model.RelatorioOcorrencias;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


/**
 *
 * @author guilh
 */
public class FrameShowOperadores extends FrameCRUD{
    

    private static final String titulo = "Operadores Cadastrados";
    private static final Dimension dimension = new Dimension(1000, 800);

    private Label lbTituloFrame;
    private Label lbNomeOperador;
    private Label lbCargoOperador;
    private Cargo enumCargo;
    private JTable tbExibicao;

    private JButton btVoltar;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameShowOperadores() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    public FrameShowOperadores(String titulo, Dimension dimension) {
        super(titulo, dimension, true);

        initializeComponents();
        addComponents();
    }

    public void initializeComponents() {
        lbTituloFrame = new Label("Operadores Cadastrados");
        lbNomeOperador = new Label("Nome do operador");
        lbCargoOperador = new Label(enumCargo.OPERADOR1.toString());

        cbPeriodo = new JComboBox(enumPeriodo.values());
        cbPeriodo.setSelectedIndex(-1);

        tfDtRelatorio = new JFormattedTextField();
        tfDtRelatorio.setPreferredSize(new Dimension(70,25));
        try {
            maskTf = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(FrameRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        maskTf.install(tfDtRelatorio);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Abrir Relatório de Ocorrências"));

        cbPeriodo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    enumPeriodo = (EnumPeriodo) e.getItem();
                }
            }

        }
        );

        btVoltar = new JButton("Voltar");
    }

    public void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDtRelatorio, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfDtRelatorio, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(new Label("            "), cons);

        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbPeriodo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 4;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbPeriodo, cons);

        super.addFormulario(panelFormulario);
        super.addBotaoInferior(btVoltar);
    }

    @Override
    public void limparCampos() {
        this.novoRelatorio = new RelatorioOcorrencias();
        lbDtRelatorio.setText("");
        lbPeriodo.setText("");
        lbTurno.setText("");
        cbPeriodo.setSelectedIndex(-1);

        super.repaint();
    }

    @Override
    public void carregarCampos() {
        tfDtRelatorio.setText("");
    }
    
}
