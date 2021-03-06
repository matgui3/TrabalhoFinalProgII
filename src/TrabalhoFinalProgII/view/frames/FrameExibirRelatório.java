/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.Dia;
import TrabalhoFinalProgII.model.EstadoServicosAuxiliares;
import TrabalhoFinalProgII.model.EstadoSubestacao;
import TrabalhoFinalProgII.model.EstadoUnidadeGeradora;
import TrabalhoFinalProgII.model.Ocorrencia;
import TrabalhoFinalProgII.model.Operador;
import TrabalhoFinalProgII.model.Turno;
import TrabalhoFinalProgII.service.DiaService;
import static TrabalhoFinalProgII.view.frames.FrameRelatorio.alinhaTableCentro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
 * @author tasso
 */
public class FrameExibirRelatório extends FrameCRUD implements ActionListener {

    private static final String titulo = "Relatório de Ocorrências";
    private static Dimension dimension = new Dimension(800, 600);

    private DiaService diaService;

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

    private Label lbCabecalhoTurno1;
    private Label lbCabecalhoTurno2;
    private Label lbCabecalhoTurno3;
    private Label lbCabecalhoTurno4;
    private Label lbCabecalhoTurno5;
    private Label lbCabecalhoTurno21;
    private Label lbCabecalhoTurno22;
    private Label lbCabecalhoTurno23;
    private Label lbCabecalhoTurno24;
    private Label lbCabecalhoTurno25;
    private Label lbCabecalhoTurno31;
    private Label lbCabecalhoTurno32;
    private Label lbCabecalhoTurno33;
    private Label lbCabecalhoTurno34;
    private Label lbCabecalhoTurno35;

    private Label lbUgs;
    private Label lbUgs2;
    private Label lbSA;
    private Label lbSE;
    private JTable tabela1;
    private JTable tabela2;
    private JTable tabela3;

    private JButton jbSair;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panelzaco;
    private JScrollPane barra;
    private LocalDate date;
    private  String dateFormatado;

    private LayoutManager layout;
    private GridBagConstraints cons;
    private FlowLayout cabecalhoLayout1;

    public FrameExibirRelatório(LocalDate date) {
        super(titulo, dimension);

        this.date = date;
        initializeComponents();
        addComponents();
        setMaximizable(true);

    }

    public void editaFont(Label umJl) {
        umJl.setFont(new Font("Serif", Font.PLAIN, 18));
    }

    public String setDiaDaSemana(LocalDate ld) {
        Date d = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String nome = "";
        int dia = c.get(c.DAY_OF_WEEK);
        switch (dia) {
            case Calendar.SUNDAY:
                nome = "Domingo";
                break;
            case Calendar.MONDAY:
                nome = "Segunda-feira";
                break;
            case Calendar.TUESDAY:
                nome = "Terça-feira";
                break;
            case Calendar.WEDNESDAY:
                nome = "Quarta-feira";
                break;
            case Calendar.THURSDAY:
                nome = "Quinta-feira";
                break;
            case Calendar.FRIDAY:
                nome = "Sexta-feira";
                break;
            case Calendar.SATURDAY:
                nome = "Sábado";
                break;
        }
        return nome;
    }

    private void initializeComponents() {
        diaService = new DiaService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        dateFormatado = date.format(formatter);

        lb1 = new Label("Dia da Semana ");
        editaFont(lb1);
        lb2 = new Label(setDiaDaSemana(date));
        editaFont(lb2);
        lb3 = new Label("Data: " + dateFormatado);
        editaFont(lb3);
        lb4 = new Label("Horário");
        editaFont(lb4);
        lb5 = new Label();
        editaFont(lb5);

        lb6 = new Label("Condições da Usina");
        editaFont(lb6);

        lb7 = new Label("Unidade 1");
        editaFont(lb7);
        lbUgs = new Label("Preencher");
        editaFont(lbUgs);

        lb8 = new Label("Unidade 2");
        editaFont(lb8);
        lbUgs2 = new Label("Preencher");
        editaFont(lbUgs2);

        lb9 = new Label("Subestação");
        editaFont(lb9);
        lbSE = new Label("Preencher");
        editaFont(lbSE);

        lb10 = new Label("Serviços Auxiliares");
        editaFont(lb10);
        lbSA = new Label("Preencher");
        editaFont(lbSA);

        tabela1 = new JTable(1, 2) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
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

        jbSair = new JButton("Sair");
        jbSair.addActionListener(this);

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
        defineValoresRelatorio(date);
    }

    private void addComponents() {
        panelzaco.add(panel2, BorderLayout.NORTH);
        panelzaco.add(panel3);
        panelzaco.add(panel4);
        panelzaco.add(panel5);
        panelzaco.add(panel6);
        panelzaco.add(panel7);
        panelzaco.add(panel8);
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
        cons.ipadx = 360;
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
        panel2.add(lbUgs, cons);

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
        panel2.add(lbUgs2, cons);

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
        panel2.add(lbSE, cons);

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
        panel2.add(lbSA, cons);

        adicionarBlocoTurno();

        panel8.add(jbSair);

        super.addFormulario(barra);
        super.addFormularioRodape(panel8);

    }

    public void adicionarBlocoTurno() {

        lbCabecalhoTurno1 = new Label("1º Turno");
        editaFont(lbCabecalhoTurno1);
        lbCabecalhoTurno2 = new Label("07:30");
        editaFont(lbCabecalhoTurno2);
        lbCabecalhoTurno3 = new Label("Data: " + dateFormatado);
        editaFont(lbCabecalhoTurno3);

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

        iniciarTabela(tabela1);
        panel3.add(tabela1);
        lbCabecalhoTurno21 = new Label("2º Turno");
        editaFont(lbCabecalhoTurno21);
        lbCabecalhoTurno22 = new Label("15:30");
        editaFont(lbCabecalhoTurno22);
        lbCabecalhoTurno23 = new Label("Data: " + dateFormatado);
        editaFont(lbCabecalhoTurno23);

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

        iniciarTabela(tabela2);
        panel5.add(tabela2);

        lbCabecalhoTurno31 = new Label("3º Turno");
        editaFont(lbCabecalhoTurno31);
        lbCabecalhoTurno32 = new Label("23:30");
        editaFont(lbCabecalhoTurno32);
        lbCabecalhoTurno33 = new Label("Data: " + dateFormatado);
        editaFont(lbCabecalhoTurno33);

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

        iniciarTabela(tabela3);
        panel7.add(tabela3);
    }

    public void iniciarTabela(JTable tabela) {
        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(3, 3, 3, 3, color);
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

    public static void alinhaTableCentro(JTable table) {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(
                cellRender);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void defineValoresRelatorio(LocalDate date) {
        Dia dia = diaService.pesquisarDiaPorData(date);
        lbUgs.setText(dia.getGerador1());
        lbUgs2.setText(dia.getGerador2());
        lbSE.setText(dia.getSubestacao());
        lbSA.setText(dia.getServicosAuxiliares());

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
