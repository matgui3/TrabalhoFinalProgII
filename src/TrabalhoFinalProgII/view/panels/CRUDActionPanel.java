/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.panels;

import TrabalhoFinalProgII.view.frames.FrameCRUD;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author 00783962045
 */
public class CRUDActionPanel extends JPanel implements ActionListener {

    private JButton btCancelar;
    private JButton btNovo;
    private JButton btGravar;
    private JButton btExcluir;
    private JButton btSair;

    private LayoutManager layout;

    private Dimension dimensaoBotao;
    private Dimension dimensaoPainel;

    // private Container parent;
    private FrameCRUD parent;

    public CRUDActionPanel(FrameCRUD parent) {
        this.parent = parent;
        initComponents();
        addComponents();

        super.setVisible(true);
        super.setSize(dimensaoPainel);
    }

    /*
    public CRUDActionPanel(Container parent) {
        this.parent = parent;

        initComponents();
        addComponents();

        super.setVisible(true);
        super.setSize(dimensaoPainel);
    }
     */
    private void initComponents() {
        dimensaoBotao = new Dimension(100, 20);
        dimensaoPainel = new Dimension(parent.getWidth(), 30);

        layout = new FlowLayout(FlowLayout.CENTER);

        btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(this);
        btCancelar.setSize(dimensaoBotao);

        btNovo = new JButton("Novo");
        btNovo.addActionListener(this);
        btNovo.setSize(dimensaoBotao);

        btGravar = new JButton("Gravar");
        btGravar.addActionListener(this);
        btGravar.setSize(dimensaoBotao);

        btExcluir = new JButton("Excluir");
        btExcluir.addActionListener(this);
        btExcluir.setSize(dimensaoBotao);

        btSair = new JButton("Sair");
        btSair.addActionListener(this);
        btSair.setSize(dimensaoBotao);
    }

    private void addComponents() {
        this.setLayout(layout);
        this.add(btCancelar);
        this.add(btNovo);
        this.add(btExcluir);
        this.add(btGravar);
        this.add(btSair);
    }

    public JButton getBtSair() {
        return btSair;
    }

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public JButton getBtNovo() {
        return btNovo;
    }

    public JButton getBtGravar() {
        return btGravar;
    }

    public JButton getBtExcluir() {
        return btExcluir;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == btSair) {
            this.parent.fechar();
        }
    }

}
