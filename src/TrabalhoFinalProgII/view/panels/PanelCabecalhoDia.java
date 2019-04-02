/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.panels;

import TrabalhoFinalProgII.model.EstadoServicosAuxiliares;
import TrabalhoFinalProgII.model.EstadoSubestacao;
import TrabalhoFinalProgII.model.EstadoUnidadeGeradora;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tasso
 */
public class PanelCabecalhoDia extends JPanel implements ActionListener {

    private JLabel jlDiaDaSemana;
    private JLabel jlCampoDiaSemana;
    private JLabel jlHorario;
    private JLabel jlCondicoesUsina;
    private JLabel jlData;
    private JLabel jlUnidade1;
    private JLabel jlUnidade2;
    private JLabel jlSubestacao;
    private JLabel jlServicosAuxiliares;

    private JComboBox jcEstadoUg1;
    private JComboBox jcEstadoUg2;
    private JComboBox jcServicosAuxiliares;
    private JComboBox jcSubestacao;

    private Dimension dimensaoLabel;
    private JPanel panel;

    private LayoutManager layout;
    private GridBagConstraints cons;

    private final Container parent;

    public PanelCabecalhoDia(Container parent) {
        this.parent = parent;

        initComponents();
        addComponents();

        super.setVisible(true);

    }

    private void initComponents() {
        dimensaoLabel = new Dimension(100, 30);
        layout = new GridBagLayout();
        panel = new JPanel(layout);
        jlDiaDaSemana = new JLabel("Dia da Semana");
        jlDiaDaSemana.setFont(new Font("Arial", Font.BOLD, 18));
        jlCampoDiaSemana = new JLabel("Segunda-Feira");
        jlCampoDiaSemana.setFont(new Font("Arial", Font.BOLD, 18));
        jlHorario = new JLabel("Horário");
        jlHorario.setFont(new Font("Arial", Font.BOLD, 18));
        jlCondicoesUsina = new JLabel("Condições da Usina");
        jlCondicoesUsina.setFont(new Font("Arial", Font.BOLD, 18));
        jlData = new JLabel("Data: ");
        jlData.setFont(new Font("Arial", Font.BOLD, 18));
        jlUnidade1 = new JLabel("Unidade 1");
        jlUnidade1.setFont(new Font("Arial", Font.BOLD, 18));
        jcEstadoUg1 = new JComboBox(EstadoUnidadeGeradora.values());
        jlUnidade2 = new JLabel("Unidade 2");
        jlUnidade2.setFont(new Font("Arial", Font.BOLD, 18));
        jcEstadoUg2 = new JComboBox(EstadoUnidadeGeradora.values());
        jlSubestacao = new JLabel("Subestação");
        jlSubestacao.setFont(new Font("Arial", Font.BOLD, 18));
        jcSubestacao = new JComboBox(EstadoSubestacao.values());
        jlServicosAuxiliares = new JLabel("Serviços Auxiliares");
        jlServicosAuxiliares.setFont(new Font("Arial", Font.BOLD, 18));
        jcServicosAuxiliares = new JComboBox(EstadoServicosAuxiliares.values());

    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlDiaDaSemana, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlCampoDiaSemana, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlData, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlHorario, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlCondicoesUsina, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlUnidade1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlUnidade2, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlSubestacao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(0, 0, 10, 0);
        panel.add(jlServicosAuxiliares, cons);

        this.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
