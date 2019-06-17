/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.panels;

import TrabalhoFinalProgII.view.frames.FrameCRUD;
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

    private JButton btLimpar;
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

        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(this);
        btLimpar.setSize(dimensaoBotao);

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
    public void removeJbExcluir(){
        this.remove(btExcluir);
    }
    
    public void removeJbts(){
        this.remove(btLimpar);
        this.remove(btGravar);
    }

    private void addComponents() {
        this.setLayout(layout);
        this.add(btLimpar);
        this.add(btExcluir);
        this.add(btGravar);
        this.add(btSair);
    }
    
    public void addBotao(JButton jbt){
        this.add(jbt);
    }

    public JButton getBtSair() {
        return btSair;
    }

    public JButton getbtLimpar() {
        return btLimpar;
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
        if (obj == btGravar) {
            this.parent.gravarCampos();
        }
        if (obj == btLimpar) {
            this.parent.limparCampos();
        }
        if (obj == btExcluir) {
            this.parent.excluirRegistro();
        }
        
    }

}
