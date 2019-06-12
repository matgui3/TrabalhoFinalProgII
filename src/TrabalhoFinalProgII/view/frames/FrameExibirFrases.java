/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.service.FrasesService;
import static TrabalhoFinalProgII.view.frames.FrameExibirAjustes.alinhaTableCentro;
import static TrabalhoFinalProgII.view.frames.FrameRelatorio.alinhaTableCentro;
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
public class FrameExibirFrases extends FrameCRUD implements ActionListener {

    private static final String titulo = "Frases";
    private static Dimension dimension = new Dimension(1000, 600);
    private JTable tabela1;
    private FrasesService frasesService;

    private JButton jbSair;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panelzaco;
    private JScrollPane barra;

    private GridBagLayout layout;
    private GridBagConstraints cons;

    private FlowLayout cabecalhoLayout1;

    public FrameExibirFrases() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
        setMaximizable(true);

    }

    public void editaFont(Label umJl) {
        umJl.setFont(new Font("Serif", Font.PLAIN, 18));
    }

    private void initializeComponents() {
        frasesService = new FrasesService();

        tabela1 = new JTable(1, 1) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        cabecalhoLayout1 = new FlowLayout(FlowLayout.CENTER, 50, 10);

        panel1 = new JPanel(new BorderLayout());

        layout = new GridBagLayout();
        panel2 = new JPanel(cabecalhoLayout1);
        panelzaco = new JPanel();
        panelzaco.setLayout(new BoxLayout(panelzaco, BoxLayout.Y_AXIS));

        removeJbts();
    }

    private void addComponents() {

        iniciarTabela(tabela1);
        panel2.add(tabela1);

        panelzaco.add(panel2);
        panel1.add(panelzaco);
        barra = new JScrollPane(panel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        super.addFormulario(barra);

    }

    public void iniciarTabela(JTable tabela) {
        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(3, 3, 3, 3, color);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(900);
        tabela.setRowHeight(25);
        tabela.setBorder(border);
        tabela.setAutoscrolls(true);
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        //método adicionado aqui apenas para teste
        mostrarFrases();

    }

    public void mostrarFrases() {
        //String frases[] = frasesService.buscarFrases();
        //System.out.println(frases[0]);
        //DefaultTableModel modelo = new DefaultTableModel(frases, 0);
        //modelo = (DefaultTableModel) tabela1.getModel();
        //if (modelo.getValueAt(0, 0) == null) {
        //    modelo.removeRow(0);
        //}
        //modelo.addRow(frases);

        //tabela1.setModel(modelo);

        //alinhaTableCentro(tabela1);
        
        String frases[] = frasesService.buscarFrases();
        DefaultTableModel modelo = new DefaultTableModel(frases, 0);
        modelo = (DefaultTableModel) tabela1.getModel();
        if (modelo.getValueAt(0, 0) == null) {
            modelo.removeRow(0);
        }
        
        for (int i = 0; i< frases.length; i++) {
            String a[] = {frases[i]};
            modelo.addRow(a);
            
            
        }
        tabela1.setModel(modelo);
        alinhaTableCentro(tabela1);
        
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

    public static void alinhaTableCentro(JTable table) {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(
                cellRender);
    }

    public void removeLinha(JTable tabela) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        int[] rows = tabela.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj == jbSair) {
            dispose();
        }

    }

    @Override
    public void excluirRegistro() {
        removeLinha(tabela1);
    }

}
