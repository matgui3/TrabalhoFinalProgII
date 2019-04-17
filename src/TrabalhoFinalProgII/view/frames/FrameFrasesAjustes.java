package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.EnumFrases;
import TrabalhoFinalProgII.model.FrasesProntas;
import TrabalhoFinalProgII.model.ValoresAlarmesTrip;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 00783962045
 */
public final class FrameFrasesAjustes extends FrameCRUD {

    private static final String titulo = "Painel de Ajustes";
    private static final Dimension dimension = new Dimension(800, 600);

    private ValoresAlarmesTrip novoAjuste;
    private String nomeAjuste;
    private String valorAjusteUg1;
    private String valorAjusteUg2;

    private Label lbArea;
    private Label lbAjusteUg1;
    private Label lbAjusteUg2;
    private JComboBox cbArea;

    private JFormattedTextField tfUg1;
    private JFormattedTextField tfUg2;

    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;
    private EnumFrases enumFrases;

    public FrameFrasesAjustes() {
        super(titulo, dimension);

        novoAjuste = new ValoresAlarmesTrip(nomeAjuste, valorAjusteUg1, valorAjusteUg2);

        initializeComponents();
        addComponents();

    }

    public FrameFrasesAjustes(ValoresAlarmesTrip novoAjuste) {
        super(titulo, dimension);

        this.novoAjuste = novoAjuste;

        initializeComponents();
        addComponents();

    }

    private void initializeComponents() {
        lbArea = new Label("Área: ");
        lbAjusteUg1 = new Label("Ajuste na U.G.1: ");
        lbAjusteUg2 = new Label("Ajuste na U.G.2: ");

        tfUg1 = new JFormattedTextField();
        tfUg2 = new JFormattedTextField();
        
        tfUg1.setPreferredSize(new Dimension(120, 30));
        tfUg2.setPreferredSize(new Dimension(120, 30));
        
        cbArea = new JComboBox(EnumFrases.values());

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

        panelFormulario.setBorder(BorderFactory.createTitledBorder("Ajustes"));
        //cria um itemListener para saber qual item foi selecionado
        cbArea.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    enumFrases = (EnumFrases) e.getItem();
                }
            }
        });
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbArea, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 0;
        cons.insets = new Insets(0, 0, 0, 15);
        panelFormulario.add(cbArea, cons);

        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbAjusteUg1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 4;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfUg1, cons);

        cons = new GridBagConstraints();
        cons.gridx = 5;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbAjusteUg2, cons);

        cons = new GridBagConstraints();
        cons.gridx = 6;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfUg2, cons);

        super.addFormulario(panelFormulario);

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
//        cbArea.setSelectedIndex(-1);
//
//        super.repaint();
    }

}
