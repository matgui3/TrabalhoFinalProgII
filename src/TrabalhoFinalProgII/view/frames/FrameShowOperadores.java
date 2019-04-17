/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.Cargo;
import TrabalhoFinalProgII.model.Operador;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 *
 * @author guilh
 */
public class FrameShowOperadores extends FrameCRUD{
    

    private static final String titulo = "Operadores Cadastrados";
    private static final Dimension dimension = new Dimension(800, 600);
//    private List<Operador> operadores;

    private Label lbTituloFrame;
    private Label lbNomeOperador;
    private Label lbCargoOperador;
    private Cargo enumCargo;
    
//    private JTable tbExibicao;
//    private OperadorTableModel tableModel;
//    private JScrollPane scrollTable;

    private JButton btVoltar;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameShowOperadores() {
        super(titulo, dimension);
        
//        this.operadores = operadores;

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
        lbTituloFrame.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        lbNomeOperador = new Label("Nome do operador");
        lbCargoOperador = new Label(enumCargo.OPERADOR1.toString());

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Exibir Operadores Cadastrados"));
        
//        tableModel = new OperadorTableModel(operadores);
//        tbExibicao = new JTable(tableModel);
//        scrollTable = new JScrollPane(tbExibicao);

        btVoltar = new JButton("Voltar");
    }

    public void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTituloFrame, cons);
        
//        cons = new GridBagConstraints();
//        cons.gridx = 0;
//        cons.gridy = 2;
//        cons.gridwidth = 2;
//        cons.fill = GridBagConstraints.HORIZONTAL;
//        panelFormulario.add(tbExibicao,cons);
                
        super.addFormulario(panelFormulario);
        super.addBotaoInferior(btVoltar);
//        this.getContentPane().add(scrollTable);
    }

    @Override
    public void limparCampos() {
    }

    @Override
    public void carregarCampos() {
    }
    
}
