/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.listener;

import TrabalhoFinalProgII.view.frames.FramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author 00783962045
 */
public class ListenerMenuAplicação implements ActionListener{
     private Class<? extends JInternalFrame> classe;
    private JInternalFrame frame;
    private FramePrincipal tela;

    public ListenerMenuAplicação(Class<? extends JInternalFrame> classe, FramePrincipal tela) {
        super();
        this.classe = classe;
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            frame = classe.newInstance();
            
            tela.adicionarFormulario(frame);
            
        } catch (InstantiationException ex) {
            
        } catch (IllegalAccessException ex) {
            
        }
    }
    
    
}
