/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 00783962045
 */
public class FrameExibirAjustes extends FrameCRUD implements ActionListener {

    private static final String titulo = "Ajustes";
    private static Dimension dimension = new Dimension(1000, 600);
    private JTable tabela1;
    private DefaultTableModel modelo;

    private JButton jbSair;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panelzaco;
    private JScrollPane barra;
    private JScrollPane scr;

    private GridBagLayout layout;
    private GridBagConstraints cons;

    private FlowLayout cabecalhoLayout1;

    public FrameExibirAjustes() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
        setMaximizable(true);

    }

    public void editaFont(Label umJl) {
        umJl.setFont(new Font("Serif", Font.PLAIN, 18));
    }

    private void initializeComponents() {
        modelo = new DefaultTableModel();

        tabela1 = new JTable(modelo);

        /*{
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };*/
        //tabela1.getColumnModel().getColumn(0).setPreferredWidth(55);
        //scr = new JScrollPane(tabela1);
        //scr.setSize(new Dimension(900, 600));
        jbSair = new JButton("Sair");
        jbSair.addActionListener(this);

        cabecalhoLayout1 = new FlowLayout(FlowLayout.CENTER, 50, 10);

        panel1 = new JPanel(new BorderLayout());

        layout = new GridBagLayout();
        panel2 = new JPanel(cabecalhoLayout1);
        // panel3 = new JPanel(cabecalhoLayout1);
        panelzaco = new JPanel();
        panelzaco.setLayout(new BoxLayout(panelzaco, BoxLayout.Y_AXIS));

        //panelBotoesCRUD.setVisible(false);
    }

    private void addComponents() {
        iniciarTabela(tabela1);
        panel2.add(tabela1);

        panelzaco.add(panel2);
        //panelzaco.add(panel3);
        panel1.add(panelzaco);
        barra = new JScrollPane(panel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //panel3.add(jbSair);
        super.addFormulario(barra);
        //super.addFormularioRodape(panel3);

    }

    public void iniciarTabela(JTable tabela) {
        modelo.addColumn("AJUSTES");
        modelo.addColumn("UG1");
        modelo.addColumn("UG2");
        String a[] = {"AJUSTES", "UG1", "UG2"};
        modelo.addRow(a);
        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(3, 3, 3, 3, color);
        tabela.setRowHeight(25);
        tabela.setBorder(border);
        tabela.setAutoscrolls(true);
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        //método adicionado aqui apenas para teste
        mostrarFrases();

    }

    public void mostrarFrases() {
        String frasesBanco[][] = {
            {"SETPOINT", "96 MW", "96 MW"},
            {"SETPOINT", "Potencia liquida 190,45 MW\n"
                + "Limite de transmissão 193 MW", "Potencia liquida 190,45 MW"},
            {"SETPOINT", "96 MW", "96 MW"}
        };

        int cont = 0;
        for (String a[] : frasesBanco) {
            a = frasesBanco[cont];
            modelo.addRow(a);
            if (cont > 0) {
                tabela1.getColumnModel().getColumn(1).setPreferredWidth(350);
                tabela1.getColumnModel().getColumn(2).setPreferredWidth(350);
            }
            cont++;
        }
        alinhaTableCentro(tabela1);
    }

    public void removeLinha(JTable tabela) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        int[] rows = tabela.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);
        }
    }

    @Override
    public void gravarCampos() {

//        novoAjuste.setArea(enumFrases);
//        novoAjuste.CadastrarFrase(taFrase.getText());
//        System.out.println(novoAjuste.toString());
    }

    @Override
    public void limparCampos() {
//        this.novoAjuste = new FrasesProntas();
//        taFrase.setText("");
//        cbUgs.setSelectedIndex(-1);
//
//        super.repaint();
    }

    @Override
    public void excluirRegistro() {
        removeLinha(tabela1);
    }

    public static void alinhaTableCentro(JTable table) {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(cellRender);
    }
   

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj == jbSair) {
            dispose();
        }

    }

}
