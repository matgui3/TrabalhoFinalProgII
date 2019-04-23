package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EnumFrases;
import TrabalhoFinalProgII.model.EstadoServicosAuxiliares;
import TrabalhoFinalProgII.model.EstadoSubestacao;
import TrabalhoFinalProgII.model.EstadoUnidadeGeradora;
import TrabalhoFinalProgII.model.FrasesProntas;
import TrabalhoFinalProgII.model.ValoresAlarmesTrip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 00783962045
 */
public final class FrameRelatorio extends FrameCRUD {

    private static final String titulo = "Relatório de Ocorrências";
    private static Dimension dimension = new Dimension(800, 600);

    private Label lb1;
    private Label lb2;
    private Label lb3;
    private Label lb4;
    private Label lb5;
    private Label lb6;
    private Label lb7;
    private Label lb8;
    private Label lb9;
    private Label lb10;
    private Label lbAjusteUg1;
    private Label lbAjusteUg2;
    private JComboBox cbUgs;
    private JComboBox cbSA;
    private JComboBox cbSE;

    private JPanel panel1;
    private JPanel panel2;

    private LayoutManager layout;
    private GridBagConstraints cons;
    private FlowLayout cabecalhoLayout1;

    public FrameRelatorio() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
        setBorder(null);
    }

    public void editaFont(Label umJl) {
        umJl.setFont(new Font("Serif", Font.PLAIN, 18));
    }

    private void initializeComponents() {
        lb1 = new Label("Dia da Semana ");
        editaFont(lb1);
        lb2 = new Label("Terça - Feira");
        editaFont(lb2);
        lb3 = new Label("Data: DD/MM/AAAA");
        editaFont(lb3);

        lb4 = new Label("Horário");
        editaFont(lb4);
        lb5 = new Label("00:00h");
        editaFont(lb5);

        lb6 = new Label("Condições da Usina");
        editaFont(lb6);

        lb7 = new Label("Unidade 1");
        editaFont(lb7);
        cbUgs = new JComboBox(EstadoUnidadeGeradora.values());

        lb8 = new Label("Unidade 2");
        editaFont(lb8);

        lb9 = new Label("Subestação");
        editaFont(lb9);
        cbSE = new JComboBox(EstadoSubestacao.values());

        lb10 = new Label("serviços Auxiliares");
        editaFont(lb10);
        cbSA = new JComboBox(EstadoServicosAuxiliares.values());

        cabecalhoLayout1 = new FlowLayout(FlowLayout.CENTER, 100, 10);

        layout = new GridBagLayout();
        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(layout);

    }

    private void addComponents() {
        /*panel1.add(lb1);
        panel1.add(lb2);
        panel1.add(lb3);
        
        panel1.add(lb4);*/
        panel1.add(panel2, BorderLayout.NORTH);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;

        panel2.add(lb2, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb3, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb4, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb5, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb6, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb7, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cbUgs, cons);
        cons = new GridBagConstraints();
        
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb8, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cbUgs, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb9, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cbSE, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb10, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 6;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cbSA, cons);

       
        super.addFormulario(panel1);

    }

    @Override
    public void carregarCampos() {

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

}
