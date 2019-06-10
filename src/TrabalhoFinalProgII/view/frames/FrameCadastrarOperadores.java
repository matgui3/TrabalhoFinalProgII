/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.Operador;
import TrabalhoFinalProgII.model.RelatorioOcorrencias;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author 00783962045
 */
public class FrameCadastrarOperadores extends FrameCRUD implements ActionListener {

    private static final String titulo = "Abrir Relatorio de Ocorrências";
    private static final Dimension dimension = new Dimension(800, 300);
    private Operador novoOperador;

    private FramePrincipal frameSistema;

    private Label lbNome;
    private Label lbDataNasc;
    private Label lbCargo;
    private Label lbTelefone;
    private TextField tfNome;
    private JFormattedTextField fTfDataNasc;
    private JFormattedTextField fTfTelefone;
    private JComboBox cbCargo;
    private MaskFormatter maskTf;
    private MaskFormatter maskTf1;

    private JButton jbCadastrar;

    private JPanel panelFormulario;
    private JPanel panelBotoes;
    private FlowLayout cabecalhoLayout1;

    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameCadastrarOperadores() {
        super(titulo, dimension);

        novoOperador = new Operador();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public FrameCadastrarOperadores(String titulo, Dimension dimension) {
        super(titulo, dimension, true);

        novoOperador = new Operador();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void initializeComponents() {
        lbNome = new Label("Nome: ");
        lbDataNasc = new Label("Data de Nascimento: ");

        fTfDataNasc = new JFormattedTextField();
        fTfDataNasc.setPreferredSize(new Dimension(150, 25));
        try {
            maskTf = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(FrameBuscarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        maskTf.install(fTfDataNasc);
        
        fTfTelefone = new JFormattedTextField();
        fTfTelefone.setPreferredSize(new Dimension(150, 25));
        try {
            maskTf1 = new MaskFormatter("(##) #####-####");
        } catch (ParseException ex) {
            Logger.getLogger(FrameBuscarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        maskTf1.install(fTfTelefone);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Abrir Relatório de Ocorrências"));

        jbCadastrar = new JButton("Abrir Relatório");
        jbCadastrar.addActionListener(this);

        panelBotoes = new JPanel(cabecalhoLayout1);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj == jbCadastrar) {
            
        }

    }

    public void addComponents() {

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(new Label("            "), cons);

        super.addFormulario(panelFormulario);
        panelBotoes.add(jbCadastrar);

        super.addBotaoInferior(jbCadastrar);
    }

    @Override
    public void limparCampos() {
        
        super.repaint();
    }

    @Override
    public void carregarCampos() {
        
    }

}
