package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.ValoresAlarmesTrip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

/**
 *
 * @author 00783962045
 */
public final class FrameFrasesAjustes extends FrameCRUD {

    private static final String titulo = "Adicionar Ajuste";
    private static final Dimension dimension = new Dimension(800, 600);

    private ValoresAlarmesTrip novoAjuste;

    private Label lbAjuste;
    private Label lbAjusteUg1;
    private Label lbAjusteUg2;

    private JTextArea tfAjuste;
    private JTextArea tfUg1;
    private JTextArea tfUg2;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameFrasesAjustes() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();

    }

    public FrameFrasesAjustes(ValoresAlarmesTrip novoAjuste) {
        super(titulo, dimension);

        this.novoAjuste = novoAjuste;

        initializeComponents();
        addComponents();

    }

    public void setAjuste(String nome, String Ug1, String Ug2) {
        novoAjuste = new ValoresAlarmesTrip(nome, Ug1, Ug2);

    }

    public void editaFont(Label umJl) {
        umJl.setFont(new Font("Serif", Font.PLAIN, 18));
    }

    private void editaTa(JTextArea ta) {
        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(3, 3, 3, 3, color);
        ta.setBorder(border);
    }

    private void initializeComponents() {
        lbAjuste = new Label("AJUSTE : ");
        editaFont(lbAjuste);
        lbAjusteUg1 = new Label("UG1: ");
        editaFont(lbAjusteUg1);
        lbAjusteUg2 = new Label("UG2: ");
        editaFont(lbAjusteUg2);

        tfUg1 = new JTextArea(10, 300);
        editaTa(tfUg1);
        tfUg2 = new JTextArea(10, 300);
        editaTa(tfUg2);
        tfAjuste = new JTextArea(10, 300);
        editaTa(tfAjuste);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

        panelFormulario.setBorder(BorderFactory.createTitledBorder("Ajustes"));
        removeExcluir();

    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbAjuste, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 200;
        panelFormulario.add(lbAjusteUg1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 200;
        panelFormulario.add(lbAjusteUg2, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfAjuste, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfUg1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfUg2, cons);

        super.addFormulario(panelFormulario);

    }

    @Override
    public void gravarCampos() {
        setAjuste(tfAjuste.getText(), tfUg1.getText(), tfUg2.getText());
    }

    @Override
    public void limparCampos() {
        tfAjuste.setText("");
        tfUg1.setText("");
        tfUg2.setText("");
    }

    @Override
    public void excluirRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
