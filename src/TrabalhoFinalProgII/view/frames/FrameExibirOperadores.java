/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.Cargo;
import TrabalhoFinalProgII.model.Operador;
import TrabalhoFinalProgII.service.OperadorService;
import TrabalhoFinalProgII.view.panels.CRUDActionPanel;
import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author guilh
 */
public class FrameExibirOperadores extends FrameCRUD implements ActionListener {

    private static final String titulo = "Exibição de Operadores";
    private static final Dimension dimension = new Dimension(800, 300);
    private Operador novoOperador;
    private OperadorService operadorService;

    private Label lbNome;
    private Label lbDataNasc;
    private Label lbCargo;
    private Label lbTelefone;
    private Label tfNome;
    private Label lbExibeDataNasc;
    private Label lbExibeTelefone;
    private Label lbExibeCargo;
    private JComboBox cbOperadores;
    private List<Operador> operadores;
    private String nomesEIds[];
    private JButton jbMostrar;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameExibirOperadores() {
        super(titulo, dimension);

        novoOperador = new Operador();
        operadorService = new OperadorService();
        operadores = operadorService.buscarOperadores();
        carregarNomesEids();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public FrameExibirOperadores(String titulo, Dimension dimension) {
        super(titulo, dimension, true);

        novoOperador = new Operador();
        operadorService = new OperadorService();
        operadores = operadorService.buscarOperadores();
        carregarNomesEids();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void carregarNomesEids() {
        int cont = 0;
        nomesEIds = new String[12];
        for (Operador ops : operadores) {
            nomesEIds[cont] = "Id: " + ops.getMatricula() + " " + ops.getNome() + "";
            cont++;
        }
    }

    public void carregarCamposOps() {

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
        tfNome = new Label("Nome");
        editaFont(tfNome);
        lbExibeCargo = new Label("Cargo");
        editaFont(lbExibeCargo);
        lbExibeDataNasc = new Label("Data de Nascimento");
        editaFont(lbExibeDataNasc);
        lbExibeTelefone = new Label("Telefone");
        editaFont(lbExibeTelefone);
        lbExibeTelefone.setPreferredSize(new Dimension(150, 25));

        jbMostrar = new JButton("Exibir");
        jbMostrar.setSize(new Dimension(100, 20));
        addBotao(jbMostrar);
        jbMostrar.addActionListener(this);

        cbOperadores = new JComboBox(nomesEIds);
        editaFont(cbOperadores);

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
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(new Label(" "), cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(new Label(" "), cons);

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
        panelFormulario.add(lbExibeDataNasc, cons);

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
        panelFormulario.add(lbExibeTelefone, cons);

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
        panelFormulario.add(lbExibeCargo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbOperadores, cons);

        super.addFormulario(panelFormulario);
    }

    @Override
    public void limparCampos() {

        tfNome.setText(" ");
        lbExibeDataNasc.setText("");
        lbExibeTelefone.setText("");
    }

    @Override
    public void gravarCampos() {

    }

    @Override
    public void excluirRegistro() {
        try {
            long idOperador = Long.parseLong(cbOperadores.getSelectedItem().toString().split(" ")[1]);
            operadorService.excluirOperadorPorId(idOperador);
            JOptionPane.showMessageDialog(null, "Operador excluído com sucesso!");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um operador para excluir.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "O operador informado não pôde ser excluído.");
        }

        tfNome.setText(" ");
        lbExibeDataNasc.setText("");
        lbExibeTelefone.setText("");
        lbExibeCargo.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent evt
    ) {
        Object obj = evt.getSource();
        if (obj == jbMostrar) {
            String od = cbOperadores.getSelectedItem().toString();
            System.out.println(cbOperadores.getSelectedItem());

            int id = Integer.parseInt(od.split(" ")[1]);
            for (Operador op : operadores) {
                if (op.getMatricula() == id) {
                    tfNome.setText(op.getNome());
                    lbExibeCargo.setText(op.getCargo());
                    lbExibeDataNasc.setText(op.getDataNascimento());
                    lbExibeTelefone.setText(op.getTelefone());
                    System.out.println(id);
                    id = 0;
                };
            }

        }

    }

}
