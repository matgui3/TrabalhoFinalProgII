package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.ValoresAlarmesTrip;
import TrabalhoFinalProgII.service.AjustesService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.util.NoSuchElementException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

/**
 *
 * @author 00783962045
 */
public final class FrameCadastrarAjustes extends FrameCRUD {

    private static final String titulo = "Adicionar Ajuste";
    private static final Dimension dimension = new Dimension(800, 600);
    private AjustesService ajustesService;

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

    public FrameCadastrarAjustes() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();

    }

    public FrameCadastrarAjustes(ValoresAlarmesTrip novoAjuste) {
        super(titulo, dimension);

        this.novoAjuste = novoAjuste;

        initializeComponents();
        addComponents();

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
        ajustesService = new AjustesService();
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
        String nomeAjuste = tfAjuste.getText();
        String textoUg1 = tfUg1.getText();
        String textoUg2 = tfUg2.getText();
        try {
            ajustesService.criarAjuste(nomeAjuste, textoUg1, textoUg2);
            JOptionPane.showMessageDialog(null, "Ajuste cadastrado com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Algo deu errado!\nAjuste não cadastrado!");
        }
        tfAjuste.setText("");
        tfUg1.setText("");
        tfUg2.setText("");
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
