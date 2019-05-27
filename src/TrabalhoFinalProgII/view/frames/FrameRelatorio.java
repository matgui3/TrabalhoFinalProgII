package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EstadoServicosAuxiliares;
import TrabalhoFinalProgII.model.EstadoSubestacao;
import TrabalhoFinalProgII.model.EstadoUnidadeGeradora;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 00783962045
 */
public final class FrameRelatorio extends FrameCRUD implements ActionListener {

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
    private Label lbHora;
    private Label lbOcorrencia;
    private TextField tfHora;
    private TextArea taOcorrencia;
    private JButton jbGravar;
    private JButton jbFrases;
    private JButton jbAjustes;
    private JComboBox cbUgs;
    private JComboBox cbUgs2;
    private JComboBox cbSA;
    private JComboBox cbSE;
    private JTable tabela;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

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
    public String setDiaDaSemana() {
    Date d = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		String nome = "";
		int dia = c.get(c.DAY_OF_WEEK);
		switch(dia){
		  case Calendar.SUNDAY: nome = "Domingo";break;
		  case Calendar.MONDAY: nome = "Segunda-feria";break;
		  case Calendar.TUESDAY: nome = "Terça-feria";break;
		  case Calendar.WEDNESDAY: nome = "Quarta-feira";break;
		  case Calendar.THURSDAY: nome = "Quinta-feria";break;
		  case Calendar.FRIDAY: nome = "Sexta-feria";break;
		  case Calendar.SATURDAY: nome = "sábado-feria";break;
		}
                return nome;
    }

    private void initializeComponents() {
        lb1 = new Label("Dia da Semana ");
        editaFont(lb1);
        lb2 = new Label(setDiaDaSemana());
        editaFont(lb2);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lb3 = new Label("Data: "+ sdf.format(new Date()));
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
        cbUgs2 = new JComboBox(EstadoUnidadeGeradora.values());
        editaFont(lb8);

        lb9 = new Label("Subestação");
        editaFont(lb9);
        cbSE = new JComboBox(EstadoSubestacao.values());

        lb10 = new Label("Serviços Auxiliares");
        editaFont(lb10);
        cbSA = new JComboBox(EstadoServicosAuxiliares.values());

        lbHora = new Label("Hora");
        tfHora = new TextField("", 20);
        lbOcorrencia = new Label("Ocorrência");
        taOcorrencia = new TextArea("", 1, 60);
        jbGravar = new JButton("Gravar");
        jbGravar.addActionListener(this);
        jbFrases = new JButton("Frases");
        jbAjustes = new JButton("Ajustes");
        tabela = new JTable(1, 2);

        cabecalhoLayout1 = new FlowLayout(FlowLayout.CENTER, 100, 10);

        layout = new GridBagLayout();
        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(layout);
        panel3 = new JPanel(cabecalhoLayout1);
        panel4 = new JPanel(cabecalhoLayout1);

        panelBotoesCRUD.setVisible(
                false);

    }

    private void addComponents() {
        /*panel1.add(lb1);
        panel1.add(lb2);
        panel1.add(lb3);
        
        panel1.add(lb4);*/
        panel1.add(panel2, BorderLayout.NORTH);
        panel1.add(panel3, BorderLayout.CENTER);
        panel1.add(panel4, BorderLayout.SOUTH);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;

        panel2.add(lb2, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb3, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb4, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb5, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb6, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb7, cons);

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
        panel2.add(lb8, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cbUgs2, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb9, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 6;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cbSE, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 7;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lb10, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 7;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cbSA, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 8;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(jbAjustes, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 8;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(jbFrases, cons);

        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(3, 3, 3, 3, color);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(650);
        tabela.setRowHeight(25);
        tabela.setBorder(border);
        tabela.setAutoscrolls(true);
        panel3.add(tabela);

        panel4.add(lbHora);
        panel4.add(tfHora);
        panel4.add(lbOcorrencia);
        panel4.add(taOcorrencia);
        panel4.add(jbGravar);

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

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj == jbGravar) {
            String frase [] = {tfHora.getText(), taOcorrencia.getText()};
            DefaultTableModel modelo = new DefaultTableModel(frase, 0);
            modelo = (DefaultTableModel) tabela.getModel();
            if(modelo.getValueAt(0,0)== null){
                modelo.removeRow(0);
            }

            modelo.addRow(frase);
            
            tabela.setModel(modelo);

        }
    }

}
