/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EnumPeriodo;
import TrabalhoFinalProgII.model.RelatorioOcorrencias;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author guilh
 */
public final class FrameBuscarRelatorio extends FrameCRUD implements ActionListener {

    private static final String titulo = "Abrir Relatorio de Ocorrências";
    private static final Dimension dimension = new Dimension(800, 300);
    private RelatorioOcorrencias novoRelatorio;

    private FramePrincipal frameSistema;

    private Label lbDtRelatorio;
    private Label lbTurno;
    private JFormattedTextField tfDtRelatorio;
    private MaskFormatter maskTf;

    private JButton jbAbrirRelatorio;
    private LocalDate data;

    private JPanel panelFormulario;
    private JPanel panelBotoes;
    private FlowLayout cabecalhoLayout1;

    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameBuscarRelatorio() {
        super(titulo, dimension);

        novoRelatorio = new RelatorioOcorrencias();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public FrameBuscarRelatorio(String titulo, Dimension dimension) {
        super(titulo, dimension, true);

        novoRelatorio = new RelatorioOcorrencias();

        initializeComponents();
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void initializeComponents() {
        lbDtRelatorio = new Label("Data do Relatório: ");
        lbTurno = new Label("Turno desejado: ");

        tfDtRelatorio = new JFormattedTextField();
        tfDtRelatorio.setPreferredSize(new Dimension(150, 25));
        try {
            maskTf = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(FrameBuscarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        maskTf.install(tfDtRelatorio);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Abrir Relatório de Ocorrências"));

        jbAbrirRelatorio = new JButton("Abrir Relatório");
        jbAbrirRelatorio.addActionListener(this);

        panelBotoes = new JPanel(cabecalhoLayout1);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj == jbAbrirRelatorio) {
            //Adicionar aqui também o método para buscar os dados dos campos para 
            //o relatório a ser buscado
            
            data = LocalDate.parse(tfDtRelatorio.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            FrameExibirRelatório tela = new FrameExibirRelatório(data);
            this.getParent().add(tela);
            tela.setVisible(true);

            this.dispose();

        }

    }

    public void addComponents() {

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDtRelatorio, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfDtRelatorio, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(new Label("            "), cons);

        super.addFormulario(panelFormulario);
        panelBotoes.add(jbAbrirRelatorio);

        super.addBotaoInferior(jbAbrirRelatorio);
    }

    @Override
    public void limparCampos() {
        this.novoRelatorio = new RelatorioOcorrencias();
        lbDtRelatorio.setText("");
        lbTurno.setText("");

        super.repaint();
    }

    @Override
    public void gravarCampos() {
        tfDtRelatorio.setText("");
    }

    @Override
    public void excluirRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
