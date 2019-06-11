/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.Cargo;
import TrabalhoFinalProgII.model.Operador;
import TrabalhoFinalProgII.service.OperadorService;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author guilh
 */
public class FrameShowOperadores extends FrameCRUD implements ActionListener{

    private static final String titulo = "Cadastro de Operadores";
    private static final Dimension dimension = new Dimension(800, 300);
    private Operador novoOperador;

    private Label lbNome;
    private Label lbDataNasc;
    private Label lbCargo;
    private Label lbTelefone;
    private TextField tfNome;
    private JFormattedTextField fTfDataNasc;
    private JFormattedTextField fTfTelefone;
    private JComboBox cbCargo;
    private JComboBox cbOpenadores;
    private MaskFormatter maskTf;
    private MaskFormatter maskTf1;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameShowOperadores() {
        super(titulo, dimension);

        novoOperador = new Operador();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public FrameShowOperadores(String titulo, Dimension dimension) {
        super(titulo, dimension, true);

        novoOperador = new Operador();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void initializeComponents() {
        lbNome = new Label("Nome: ");
        editaFont(lbNome);
        lbDataNasc = new Label("Data de Nascimento: ");
        editaFont(lbDataNasc);
        lbTelefone = new Label("Telefone :");
        editaFont(lbTelefone);
        lbCargo = new Label("Cargo:");
        editaFont(lbCargo);

        //String para obter nomes dos operadores
        String nomes[] = {"EU", "TU", "ELES"};

        cbOpenadores = new JComboBox(nomes);
        editaFont(cbOpenadores);
        cbOpenadores.addActionListener(this);

        tfNome = new TextField();
        cbCargo = new JComboBox(Cargo.values());

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
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastrar Operadores"));
        removeJbts();

    }

    public void editaFont(Label umJl) {
        umJl.setFont(new Font("Serif", Font.PLAIN, 18));
    }
    public void editaFont(JComboBox umJl) {
        umJl.setFont(new Font("Serif", Font.PLAIN, 18));
    }

    public void addComponents() {

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbOpenadores, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.ipadx = 400;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDataNasc, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(fTfDataNasc, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTelefone, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(fTfTelefone, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCargo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbCargo, cons);

        super.addFormulario(panelFormulario);
    }

    @Override
    public void limparCampos() {

        tfNome.setText(" ");
        fTfDataNasc.setText("");
        fTfTelefone.setText("");
    }

    @Override
    public void gravarCampos() {

    }

    @Override
    public void excluirRegistro() {
        String nomeOp = (String) cbOpenadores.getSelectedItem();
        
        tfNome.setText(" ");
        fTfDataNasc.setText("");
        fTfTelefone.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
