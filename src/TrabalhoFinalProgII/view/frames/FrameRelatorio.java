package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EnumTurnos;
import TrabalhoFinalProgII.model.EstadoServicosAuxiliares;
import TrabalhoFinalProgII.model.EstadoSubestacao;
import TrabalhoFinalProgII.model.EstadoUnidadeGeradora;
import TrabalhoFinalProgII.model.Operador;
import TrabalhoFinalProgII.service.OperadorService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author 00783962045
 */
public final class FrameRelatorio extends FrameCRUD implements ActionListener {

    private static final String titulo = "Relatório de Ocorrências";
    private static Dimension dimension = new Dimension(800, 600);

    OperadorService operadorService = new OperadorService();
    private final List<Operador> operadores = operadorService.buscarOperadores();
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
    private Label lbHora;
    private Label lbOcorrencia;
    private JFormattedTextField tfHora;
    private TextArea taOcorrencia;
    private JButton jbGravar;
    private JButton jbFrases;
    private JButton jbAjustes;
    private JButton jbEditar;
    private JButton jbExcluir;
    private JComboBox cbUgs;
    private JComboBox cbUgs2;
    private JComboBox cbSA;
    private JComboBox cbSE;
    private JComboBox cbTurnos;
    private JComboBox cbOp1Turno1;
    private JComboBox cbOp1Turno2;
    private JComboBox cbOp1Turno3;
    private JComboBox cbOp2Turno1;
    private JComboBox cbOp2Turno2;
    private JComboBox cbOp2Turno3;
    private Label lbCabecalhoTurno1;
    private Label lbCabecalhoTurno2;
    private Label lbCabecalhoTurno3;
    private Label lbCabecalhoTurno4;
    private Label lbCabecalhoTurno21;
    private Label lbCabecalhoTurno22;
    private Label lbCabecalhoTurno23;
    private Label lbCabecalhoTurno24;
    private Label lbCabecalhoTurno31;
    private Label lbCabecalhoTurno32;
    private Label lbCabecalhoTurno33;
    private Label lbCabecalhoTurno34;
    private JTable tabela1;
    private JTable tabela2;
    private JTable tabela3;
    private JTable tabtOps1;
    private JTable tabtOps2;
    private JTable tabtOps3;
    private JButton jbFimTurno;
    private JScrollPane barra;

    private JPanel panelzaco;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;

    private LayoutManager layout;
    private GridBagConstraints cons;
    private FlowLayout cabecalhoLayout1;

    public FrameRelatorio() {
        super(titulo, dimension);

//        Operador op1 = new Operador("Rodrigo", LocalDate.of(1983, 03, 14), "47992402517", Cargo.OPERADOR3);
//        Operador op2 = new Operador("Giovani", LocalDate.of(1987, 03, 14), "47999999999", Cargo.OPERADOR2);
//        addOperador(op1);
//        addOperador(op2);
        initializeComponents();
        addComponents();
        setBorder(null);
        setClosable(true);
        getNomeAndIdOperadores();

    }

    public void addOperador(Operador op) {
        operadores.add(op);
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
        switch (dia) {
            case Calendar.SUNDAY:
                nome = "Domingo";
                break;
            case Calendar.MONDAY:
                nome = "Segunda-feria";
                break;
            case Calendar.TUESDAY:
                nome = "Terça-feria";
                break;
            case Calendar.WEDNESDAY:
                nome = "Quarta-feira";
                break;
            case Calendar.THURSDAY:
                nome = "Quinta-feria";
                break;
            case Calendar.FRIDAY:
                nome = "Sexta-feria";
                break;
            case Calendar.SATURDAY:
                nome = "sábado-feria";
                break;
        }
        return nome;
    }

    public MaskFormatter Mascara(String Mascara) {
        MaskFormatter F_Mascara = new MaskFormatter();
        try {
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        } catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }

    public String[][] getNomeAndIdOperadores() {
        String[][] operadores = operadorService.buscarNomesAndIdOperadores();
        return operadores;
    }

    private void initializeComponents() {
        lb1 = new Label("Dia da Semana ");
        editaFont(lb1);
        lb2 = new Label(setDiaDaSemana());
        editaFont(lb2);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lb3 = new Label("Data: " + sdf.format(new Date()));
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

        cbTurnos = new JComboBox(EnumTurnos.values());
        String[][] dados = getNomeAndIdOperadores();
        cbOp1Turno1 = new JComboBox(dados);
        tabtOps1 = new JTable(1, 2);
        tabtOps2 = new JTable(1, 2);
        tabtOps3 = new JTable(1, 2);

        cbOp1Turno1.setMaximumSize(new Dimension(100, 100));
        cbOp1Turno2 = new JComboBox(dados);
        cbOp1Turno3 = new JComboBox(dados);
        cbOp2Turno1 = new JComboBox(dados);
        cbOp2Turno2 = new JComboBox(getNomeAndIdOperadores());
        cbOp2Turno3 = new JComboBox(getNomeAndIdOperadores());
        tabelaOps(tabtOps1, cbOp1Turno1);
        tabelaOps(tabtOps1, cbOp2Turno1);
        tabelaOps(tabtOps2, cbOp1Turno2);
        tabelaOps(tabtOps2, cbOp2Turno2);
        tabelaOps(tabtOps3, cbOp1Turno3);
        tabelaOps(tabtOps3, cbOp2Turno3);

        lbHora = new Label("Hora");
        tfHora = new JFormattedTextField(Mascara("##:##"));
        tfHora.setPreferredSize(new Dimension(60, 24));
        tfHora.setHorizontalAlignment(JFormattedTextField.CENTER);
        lbOcorrencia = new Label("Ocorrência");
        taOcorrencia = new TextArea("", 1, 60);
        jbGravar = new JButton("Gravar");
        jbGravar.addActionListener(this);
        jbFimTurno = new JButton("Finaliza Dia");
        jbFimTurno.addActionListener(this);
        jbFrases = new JButton("Frases");
        jbFrases.addActionListener(this);
        jbAjustes = new JButton("Ajustes");
        jbAjustes.addActionListener(this);
        jbEditar = new JButton("Editar");
        jbEditar.addActionListener(this);
        jbExcluir = new JButton("Excluir");
        jbExcluir.addActionListener(this);

        tabela1 = new JTable(1, 2) {
            
        };
        tabela2 = new JTable(1, 2) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        tabela3 = new JTable(1, 2) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        cabecalhoLayout1 = new FlowLayout(FlowLayout.CENTER, 50, 10);

        layout = new GridBagLayout();
        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(layout);
        panel3 = new JPanel(cabecalhoLayout1);
        panel4 = new JPanel(layout);
        panel5 = new JPanel(cabecalhoLayout1);
        panel6 = new JPanel(layout);
        panel7 = new JPanel(cabecalhoLayout1);
        panel8 = new JPanel(cabecalhoLayout1);
        panelzaco = new JPanel();
        panelzaco.setLayout(new BoxLayout(panelzaco, BoxLayout.Y_AXIS));

        panelBotoesCRUD.setVisible(
                false);

    }

    public void tabelaOps(JTable tab, JComboBox cbT) {
        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(1, 1, 1, 1, color);
        tab.setRowHeight(25);
        tab.setBorder(border);
        TableColumn op1Column = tab.getColumnModel().getColumn(0);
        TableColumn op2Column = tab.getColumnModel().getColumn(1);
        op1Column.setCellEditor(new DefaultCellEditor(cbT));
        op2Column.setCellEditor(new DefaultCellEditor(cbT));
    }
  

    private void addComponents() {
        /* panel1.add(panel3, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.NORTH);
        panel1.add(panel3, BorderLayout.CENTER);
        panel1.add(panel8, BorderLayout.SOUTH);*/
        panelzaco.add(panel2, BorderLayout.NORTH);
        panelzaco.add(panel3);
        panelzaco.add(panel4);
        panelzaco.add(panel5);
        panelzaco.add(panel6);
        panelzaco.add(panel7);
        //panelzaco.add(panel8);
        panel1.add(panelzaco);
        barra = new JScrollPane(panel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

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

        adicionarBlocoTurno();

        panel8.add(lbHora);
        panel8.add(tfHora);
        panel8.add(lbOcorrencia);
        panel8.add(taOcorrencia);
        panel8.add(cbTurnos);
        panel8.add(jbGravar);
        panel8.add(jbEditar);
        panel8.add(jbExcluir);
        panel8.add(jbFimTurno);

        super.addFormulario(barra);
        super.addFormularioRodape(panel8);

    }

    public void adicionarBlocoTurno() {

        lbCabecalhoTurno1 = new Label("1º Turno");
        editaFont(lbCabecalhoTurno1);
        lbCabecalhoTurno2 = new Label("07:30");
        editaFont(lbCabecalhoTurno2);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lbCabecalhoTurno3 = new Label("Data: " + sdf.format(new Date()));
        editaFont(lbCabecalhoTurno3);
        lbCabecalhoTurno4 = new Label("Operadores");
        editaFont(lbCabecalhoTurno4);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lbCabecalhoTurno1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lbCabecalhoTurno2, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lbCabecalhoTurno3, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 10;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(lbCabecalhoTurno4, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 10;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(tabtOps1, cons);

        iniciarTabela(tabela1);
        panel3.add(tabela1);
//Falta adicionar panel abaixo de panel
        lbCabecalhoTurno21 = new Label("2º Turno");
        editaFont(lbCabecalhoTurno21);
        lbCabecalhoTurno22 = new Label("15:30");
        editaFont(lbCabecalhoTurno22);
        lbCabecalhoTurno23 = new Label("Data: " + sdf.format(new Date()));
        editaFont(lbCabecalhoTurno23);
        lbCabecalhoTurno24 = new Label("Operadores");
        editaFont(lbCabecalhoTurno24);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.ipadx = 80;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(lbCabecalhoTurno21, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.ipadx = 393;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(lbCabecalhoTurno22, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(lbCabecalhoTurno23, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 10;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(lbCabecalhoTurno24, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 10;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(tabtOps2, cons);

        iniciarTabela(tabela2);
        panel5.add(tabela2);

        lbCabecalhoTurno31 = new Label("3º Turno");
        editaFont(lbCabecalhoTurno31);
        lbCabecalhoTurno32 = new Label("23:30");
        editaFont(lbCabecalhoTurno32);
        lbCabecalhoTurno33 = new Label("Data: " + sdf.format(new Date()));
        editaFont(lbCabecalhoTurno33);
        lbCabecalhoTurno34 = new Label("Operadores");
        editaFont(lbCabecalhoTurno34);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.ipadx = 80;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(lbCabecalhoTurno31, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.ipadx = 393;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(lbCabecalhoTurno32, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(lbCabecalhoTurno33, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 10;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(lbCabecalhoTurno34, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 10;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(tabtOps3, cons);

        iniciarTabela(tabela3);
        panel7.add(tabela3);
    }

    public void iniciarTabela(JTable tabela) {
        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(3, 3, 3, 3, color);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(650);
        tabela.setRowHeight(25);
        tabela.setBorder(border);
        tabela.setAutoscrolls(true);
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);

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

    public static void alinhaTableCentro(JTable tabela) {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);

        tabela.getColumnModel().getColumn(0).setCellRenderer(
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

        if (obj == jbGravar) {
            int combo = cbTurnos.getSelectedIndex();

            String ocorrencia = "<html>"+ taOcorrencia.getText()+"</html>";
            int cont = 0;
                int height = 20;
            if (ocorrencia.length() > 60) {
                cont++;
                height = height+20;
            tabela1.setRowHeight(40);
                StringBuilder stringBuilder = new StringBuilder(ocorrencia);
                stringBuilder.insert(60, "<br>");
                ocorrencia = stringBuilder.toString();
            }
            System.out.println(ocorrencia);

            String frase[] = {tfHora.getText(), ocorrencia};
            DefaultTableModel modelo = new DefaultTableModel(frase, 0);
            switch (combo) {
                case 0:

                    modelo = (DefaultTableModel) tabela1.getModel();
                    if (modelo.getValueAt(0, 0) == null) {
                        modelo.removeRow(0);

                    }
                    modelo.addRow(frase);

                    tabela1.setModel(modelo);

                    alinhaTableCentro(tabela1);
                    break;
                case 1:
                    modelo = (DefaultTableModel) tabela2.getModel();
                    if (modelo.getValueAt(0, 0) == null) {
                        modelo.removeRow(0);

                    }
                    modelo.addRow(frase);

                    tabela2.setModel(modelo);

                    alinhaTableCentro(tabela2);
                    break;
                case 2:
                    modelo = (DefaultTableModel) tabela3.getModel();
                    if (modelo.getValueAt(0, 0) == null) {
                        modelo.removeRow(0);

                    }
                    modelo.addRow(frase);

                    tabela3.setModel(modelo);

                    alinhaTableCentro(tabela3);
                    break;
            }

            tfHora.setText("");
            taOcorrencia.setText(" ");

        }
        if (obj == jbFimTurno) {
        }
        if (obj == jbEditar) {

            String hora = tfHora.getText();
            String frase = taOcorrencia.getText();
            int linha = tabela1.getSelectedRow();

            int combo = cbTurnos.getSelectedIndex();
            switch (combo) {
                case 0:

                    hora = tfHora.getText();
                    frase = taOcorrencia.getText();

                    tabela1.setValueAt(hora, linha, 0);
                    tabela1.setValueAt(frase, linha, 1);
                    break;
                case 1:
                    hora = tfHora.getText();
                    frase = taOcorrencia.getText();

                    tabela2.setValueAt(hora, linha, 0);
                    tabela2.setValueAt(frase, linha, 1);
                    break;
                case 2:
                    hora = tfHora.getText();
                    frase = taOcorrencia.getText();

                    tabela3.setValueAt(hora, linha, 0);
                    tabela3.setValueAt(frase, linha, 1);
                    break;
            }

            tfHora.setText("");
            taOcorrencia.setText(" ");
        }
        if (obj == jbExcluir) {

            int combo = cbTurnos.getSelectedIndex();
            switch (combo) {
                case 0:

                    removeLinha(tabela1);

                    break;
                case 1:
                    removeLinha(tabela2);

                    break;
                case 2:
                    removeLinha(tabela3);

                    break;
            }
        }
        if (obj == jbFrases) {
            FrameExibirFrases tela = new FrameExibirFrases();
            this.getParent().add(tela);
            tela.setVisible(true);
        }
        if (obj == jbAjustes) {
            FrameExibirAjustes tela = new FrameExibirAjustes();
            this.getParent().add(tela);
            tela.setVisible(true);
        }
    }

    @Override
    public void excluirRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
