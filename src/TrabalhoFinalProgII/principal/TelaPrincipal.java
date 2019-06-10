/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.principal;

import TrabalhoFinalProgII.core.JPADAO;
import TrabalhoFinalProgII.model.Frase;
import TrabalhoFinalProgII.view.frames.FramePrincipal;
import javax.swing.JFrame;

/**
 *
 * @author 00783962045
 */
public class TelaPrincipal implements Runnable {

    public static void main(String[] args) {
        TelaPrincipal tela = new TelaPrincipal();
        
        Thread thread = new Thread(tela);

        thread.run();
    }

    @Override
    public void run() {
        JFrame frame = new FramePrincipal();

        frame.setVisible(true);
    }
}

