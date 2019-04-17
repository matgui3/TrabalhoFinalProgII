/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.model.Operador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author guilh
 */
class OperadorTableModel extends AbstractTableModel{

    private List<Operador> linhas = new ArrayList<Operador>();
    private String[] colunas;
    
    public OperadorTableModel(List<Operador> linhas){
        this.linhas = linhas;
        colunas = new String[]{"Nome", "Cargo"};
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return linhas.get(rowIndex);
    }
    
}
