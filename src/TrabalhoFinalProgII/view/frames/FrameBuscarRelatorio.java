/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EnumPeriodo;
import TrabalhoFinalProgII.model.RelatorioOcorrencias;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.text.MaskFormatter;

/**
 *
 * @author guilh
 */
public final class FrameBuscarRelatorio extends FrameCRUD implements ActionListener {

    private static final String titulo = "Abrir Relatorio de Ocorrências";
    private static final Dimension dimension = new Dimension(800, 600);
    private RelatorioOcorrencias novoRelatorio;

    private int Periodo;
    private Label lbDtRelatorio;
    private Label lbPeriodo;
    private Label lbTurno;
    private EnumPeriodo enumPeriodo;
    private JFormattedTextField tfDtRelatorio;
    private MaskFormatter maskTf;

    private JComboBox cbPeriodo;

    private JButton jbAbrirRelatorio;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameBuscarRelatorio() {
        super(titulo, dimension);

        novoRelatorio = new RelatorioOcorrencias();

        initializeComponents();
        addComponents();
        setClosable(true);
    }

    public FrameBuscarRelatorio(String titulo, Dimension dimension) {
        super(titulo, dimension, true);

        novoRelatorio = new RelatorioOcorrencias();

        initializeComponents();
        addComponents();
        setClosable(true);

    }

    public void initializeComponents() {
        lbDtRelatorio = new Label("Data do Relatório: ");
        lbPeriodo = new Label("Período do relatório: ");
        lbTurno = new Label("Turno desejado: ");

        cbPeriodo = new JComboBox(enumPeriodo.values());
        cbPeriodo.setSelectedIndex(-1);

        tfDtRelatorio = new JFormattedTextField();
        tfDtRelatorio.setPreferredSize(new Dimension(70, 25));
        try {
            maskTf = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(FrameBuscarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
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

        jbAbrirRelatorio = new JButton("Abrir Relatório");
        jbAbrirRelatorio.addActionListener(this);
    }
        @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj == jbAbrirRelatorio) {
            //Adicionar aqui também o método para buscar os dados dos campos para 
            //o relatório a ser buscado
            this.dispose();
        }
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
        super.addBotaoInferior(jbAbrirRelatorio);
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
