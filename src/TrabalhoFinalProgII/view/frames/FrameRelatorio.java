package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.exceptions.TurnoSelecionadoInvalidoException;
import TrabalhoFinalProgII.model.Dia;
import TrabalhoFinalProgII.model.EnumTurnos;
import TrabalhoFinalProgII.model.EstadoServicosAuxiliares;
import TrabalhoFinalProgII.model.EstadoSubestacao;
import TrabalhoFinalProgII.model.EstadoUnidadeGeradora;
import TrabalhoFinalProgII.model.Ocorrencia;
import TrabalhoFinalProgII.model.Operador;
import TrabalhoFinalProgII.model.PeriodoTurno;
import TrabalhoFinalProgII.model.Turno;
import TrabalhoFinalProgII.model.UnidadeGeradora;
import TrabalhoFinalProgII.service.DiaService;
import TrabalhoFinalProgII.service.OcorrenciaService;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
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

    private Dia dia;
    private DiaService diaService;
    private OcorrenciaService ocorrenciaService;
    private OperadorService operadorService;
    private List<Operador> operadores;

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
    private Turno turno;
    LocalTime horaRecebida;

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

        initializeComponents();
        addComponents();
        setBorder(null);
        setClosable(true);
        getNomeOperadores();
        setMaximizable(true);

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
                nome = "Quinta-feira";
                break;
            case Calendar.FRIDAY:
                nome = "Sexta-feria";
                break;
            case Calendar.SATURDAY:
                nome = "Sábado";
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

    public String[] getNomeOperadores() {
        String[] operadores = operadorService.buscarNomesOperadores();
        return operadores;
    }

    private void initializeComponents() {
        turno = null;
        horaRecebida = null;
        diaService = new DiaService();
        criarDia();
        operadorService = new OperadorService();
        operadores = operadorService.buscarOperadores();
        ocorrenciaService = new OcorrenciaService();

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
        cbOp1Turno1 = new JComboBox(getNomeOperadores());
        tabtOps1 = new JTable(1, 2);
        tabtOps2 = new JTable(1, 2);
        tabtOps3 = new JTable(1, 2);

        cbOp1Turno1.setMaximumSize(new Dimension(100, 100));
        cbOp1Turno2 = new JComboBox(getNomeOperadores());
        cbOp1Turno3 = new JComboBox(getNomeOperadores());
        cbOp2Turno1 = new JComboBox(getNomeOperadores());
        cbOp2Turno2 = new JComboBox(getNomeOperadores());
        cbOp2Turno3 = new JComboBox(getNomeOperadores());
        tabelaOpsAdiciona(tabtOps1, cbOp1Turno1);
        tabelaOpsAdiciona(tabtOps1, cbOp2Turno1);
        tabelaOpsAdiciona(tabtOps2, cbOp1Turno2);
        tabelaOpsAdiciona(tabtOps2, cbOp2Turno2);
        tabelaOpsAdiciona(tabtOps3, cbOp1Turno3);
        tabelaOpsAdiciona(tabtOps3, cbOp2Turno3);

        lbHora = new Label("Hora");
        tfHora = new JFormattedTextField(Mascara("##:##"));
        tfHora.setPreferredSize(new Dimension(60, 24));
        tfHora.setHorizontalAlignment(JFormattedTextField.CENTER);
        lbOcorrencia = new Label("Ocorrência");
        taOcorrencia = new TextArea("", 1, 60);
        jbGravar = new JButton("Gravar");
        jbGravar.addActionListener(this);
        jbFimTurno = new JButton("Finalizar Dia");
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

        cabecalhoLayout1 = new FlowLayout(FlowLayout.CENTER, 20, 10);

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

        defineValoresRelatorio(dia);

    }

    public void tabelaOpsAdiciona(JTable tab, JComboBox cbT) {
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
    public void LimpaTabela(JTable tabela) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                System.out.println(tabela.getRowCount());
        for (int i = 0; i < tabela.getRowCount(); i++) {
            model.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj == jbGravar) {
            Ocorrencia ocorrencia = new Ocorrencia();
            int combo = cbTurnos.getSelectedIndex();

            //Verificação feita no horário para ver se confere com o Turno recebido, e se é um horário possível.
            try {
                horaRecebida = LocalTime.parse(tfHora.getText());
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Horário de ocorrência inválido!");
            }

            try {
                if (horaRecebida.isAfter(LocalTime.of(23, 30)) || horaRecebida.isBefore(LocalTime.of(07, 30))) {
                    if (combo != 2) {
                        throw new TurnoSelecionadoInvalidoException("O turno selecionado é inválido para o horário informado.");
                    }
                    turno = dia.getTurnos().get(2);
                } else if (horaRecebida.isAfter(LocalTime.of(15, 30))) {
                    if (combo != 1) {
                        throw new TurnoSelecionadoInvalidoException("O turno selecionado é inválido para o horário informado.");
                    }
                    turno = dia.getTurnos().get(1);
                } else {
                    if (combo != 0) {
                        throw new TurnoSelecionadoInvalidoException("O turno selecionado é inválido para o horário informado.");
                    }
                    turno = dia.getTurnos().get(0);
                }
            } catch (TurnoSelecionadoInvalidoException ex) {
                JOptionPane.showMessageDialog(null, "O turno selecionado é inválido para o horário informado.");
            }

            String descricao = "<html>" + taOcorrencia.getText() + "</html>";
            if (descricao.length() > 60) {
                tabela1.setRowHeight(40);
                StringBuilder stringBuilder = new StringBuilder(descricao);
                stringBuilder.insert(60, "<br>");
                descricao = stringBuilder.toString();
            }

            ocorrencia.setTurno(turno);
            ocorrencia.setDescricao(descricao);
            ocorrencia.setHora(horaRecebida);
            turno.addOcorrencia(descricao, horaRecebida);

            try {
                ocorrenciaService.cadastrarOcorrencia(ocorrencia);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            String frase[] = {tfHora.getText(), descricao};
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

            if (cbOp1Turno1.getSelectedIndex() == -1 | cbOp2Turno1.getSelectedIndex() == -1 | cbOp1Turno2.getSelectedIndex() == -1
                    | cbOp2Turno2.getSelectedIndex() == -1 | cbOp1Turno3.getSelectedIndex() == -1 | cbOp2Turno3.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Todos os turnos devem possuir pelo menos dois operadores.");
            } else {
                for (Operador op : operadores) {
                    String nome1 = cbOp1Turno1.getSelectedItem().toString();
                    String nome2 = cbOp2Turno1.getSelectedItem().toString();
                    if (op.getNome() == nome1) {
                        turno.addOperadores(op);
                    } else if (op.getNome() == nome2) {
                        turno.addOperadores(op);
                    }
                }
                JOptionPane.showConfirmDialog(null, "Deseja confirmar todos os dados do relatório?");

                dia.setGerador1(cbUgs.getSelectedItem().toString());
                dia.setGerador2(cbUgs2.getSelectedItem().toString());
                dia.setServicosAuxiliares(cbSA.getSelectedItem().toString());
                dia.setSubestacao(cbSE.getSelectedItem().toString());
                try {
                    diaService.salvarDia(dia);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                Dia novoDia = new Dia();
                try {
                    diaService.novoDia(novoDia);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            LimpaTabela(tabela1);
            LimpaTabela(tabela2);
            LimpaTabela(tabela3);
            initializeComponents();
            this.dispose();
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
            exclusaoEAlteracao();
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
            exclusaoEAlteracao();
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

    public void fechar() {
        this.dispose();
    }

    public void exclusaoEAlteracao() {
        try {
            ocorrenciaService.deletarOcorrencias();

        } catch (Exception ex) {
        }
        if (tabela1.getValueAt(0, 0) != null) {
            for (int i = 0; i < tabela1.getRowCount(); i++) {
                Ocorrencia ocorrencia = new Ocorrencia();
                String s[] = {tabela1.getValueAt(i, 0).toString(), tabela1.getValueAt(i, 1).toString()};
                horaRecebida = LocalTime.parse(tabela1.getValueAt(i, 0).toString());
                String descricao = tabela1.getValueAt(i, 1).toString();
                turno = dia.getTurnos().get(0);
                ocorrencia.setTurno(turno);
                ocorrencia.setDescricao(descricao);
                ocorrencia.setHora(horaRecebida);
                turno.addOcorrencia(descricao, horaRecebida);
                try {
                    ocorrenciaService.cadastrarOcorrencia(ocorrencia);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
        if (tabela2.getValueAt(0, 0) != null) {
            for (int i = 0; i < tabela2.getRowCount(); i++) {
                Ocorrencia ocorrencia = new Ocorrencia();
                String s[] = {tabela2.getValueAt(i, 0).toString(), tabela2.getValueAt(i, 1).toString()};
                horaRecebida = LocalTime.parse(tabela2.getValueAt(i, 0).toString());
                String descricao = tabela2.getValueAt(i, 1).toString();
                turno = dia.getTurnos().get(1);
                ocorrencia.setTurno(turno);
                ocorrencia.setDescricao(descricao);
                ocorrencia.setHora(horaRecebida);
                turno.addOcorrencia(descricao, horaRecebida);
                try {
                    ocorrenciaService.cadastrarOcorrencia(ocorrencia);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (tabela3.getValueAt(0, 0) != null) {
            for (int i = 0; i < tabela3.getRowCount(); i++) {
                Ocorrencia ocorrencia = new Ocorrencia();
                String s[] = {tabela3.getValueAt(i, 0).toString(), tabela3.getValueAt(i, 1).toString()};
                horaRecebida = LocalTime.parse(tabela3.getValueAt(i, 0).toString());
                String descricao = tabela3.getValueAt(i, 1).toString();
                turno = dia.getTurnos().get(2);
                ocorrencia.setTurno(turno);
                ocorrencia.setDescricao(descricao);
                ocorrencia.setHora(horaRecebida);
                turno.addOcorrencia(descricao, horaRecebida);
                try {
                    ocorrenciaService.cadastrarOcorrencia(ocorrencia);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void excluirRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void criarDia() {
        dia = diaService.pesquisarDiaPorData(LocalDate.now());
        if (dia == null) {
            dia = new Dia();
            LocalDate data = LocalDate.now();
            String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dia.setData(dataFormatada);

            dia.getTurnos().add(new Turno(PeriodoTurno.MANHA.getPeriodoTurno()));
            dia.getTurnos().get(0).setDia(dia);
            dia.getTurnos().add(new Turno(PeriodoTurno.TARDE.getPeriodoTurno()));
            dia.getTurnos().get(1).setDia(dia);
            dia.getTurnos().add(new Turno(PeriodoTurno.NOITE.getPeriodoTurno()));
            dia.getTurnos().get(2).setDia(dia);
            try {
                diaService.novoDia(dia);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void povoarjTables(List<Ocorrencia> list, JTable tabela) {
        int cont = 0;

        String frases[] = {};

        for (Ocorrencia ocor : list) {
            String hora = ocor.getHora().toString();
            String fraseT1[] = {hora, ocor.getDescricao()};

            DefaultTableModel modelo = new DefaultTableModel(fraseT1, 0);
            modelo = (DefaultTableModel) tabela.getModel();
            if (modelo.getValueAt(0, 0) == null) {
                modelo.removeRow(0);
            }
            modelo.addRow(fraseT1);

            tabela.setModel(modelo);

            alinhaTableCentro(tabela);
            cont++;
        }
    }

    private void defineValoresRelatorio(Dia dia) {
        List<Turno> turnos = dia.getTurnos();

        List<Ocorrencia> ocorrenciasT1 = turnos.get(0).getOcorrencias();
        List<Ocorrencia> ocorrenciasT2 = turnos.get(1).getOcorrencias();
        List<Ocorrencia> ocorrenciasT3 = turnos.get(2).getOcorrencias();

        Operador[] operadoresT1 = new Operador[2];
        if (turnos.get(0).getOperadores().size() > 0) {
            operadoresT1[0] = turnos.get(0).getOperadores().get(0);
            if (turnos.get(0).getOperadores().size() > 1) {
                operadoresT1[1] = turnos.get(0).getOperadores().get(1);
            }
        }

        Operador[] operadoresT2 = new Operador[2];
        if (turnos.get(1).getOperadores().size() > 0) {
            operadoresT2[0] = turnos.get(1).getOperadores().get(0);
            if (turnos.get(1).getOperadores().size() > 1) {
                operadoresT2[1] = turnos.get(1).getOperadores().get(1);
            }
        }

        Operador[] operadoresT3 = new Operador[2];
        if (turnos.get(2).getOperadores().size() > 0) {
            operadoresT3[0] = turnos.get(2).getOperadores().get(0);
            if (turnos.get(2).getOperadores().size() > 1) {
                operadoresT3[1] = turnos.get(2).getOperadores().get(1);
            }
        }

        povoarjTables(ocorrenciasT1, tabela1);
        povoarjTables(ocorrenciasT2, tabela2);
        povoarjTables(ocorrenciasT3, tabela3);

    }

}
