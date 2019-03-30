/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinalProgII.view.frames;

import TrabalhoFinalProgII.view.listener.ListenerMenuAplicação;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author 00783962045
 */
public class MenuPrincipal extends JMenuBar {
    private JMenu menuBibliotecas;
    private JMenu menuOperadores;
    private JMenu menuAjuda;
    
    private JMenuItem menuItemAddFrase;
    private JMenuItem menuItemAddAjuste;
    private JMenuItem menuItemAddOperadores;
    private JMenuItem menuItemVerOperadores;
    private JMenuItem menuItemSobre;
    private JMenuItem menuItemSair;
    
    private FramePrincipal frameSistema;

    public MenuPrincipal(FramePrincipal frameSistema) {
        this.frameSistema = frameSistema;
    
        initializeComponents();
        addComponents();
        addListener();
    }

    private void initializeComponents() {
        menuBibliotecas = new JMenu("Bibliotecas");
        menuOperadores = new JMenu("Operadores");
        menuAjuda = new JMenu("Ajuda");
        
        menuItemAddFrase = new JMenuItem("Adicionar Frase à Biblioteca");
        menuItemAddAjuste = new JMenuItem("Adicionar Ajuste à Biblioteca");
        menuItemAddOperadores = new JMenuItem("Adicionar Operadores");
        menuItemVerOperadores = new JMenuItem("Operadores Cadastrados");
        menuItemSobre = new JMenuItem("Sobre a Aplicação");
        menuItemSair = new JMenuItem("Sair");
    }

    private void addComponents() {
        menuBibliotecas.add(menuItemAddFrase);
        menuBibliotecas.add(menuItemAddAjuste);
        
        menuOperadores.add(menuItemVerOperadores);
        menuOperadores.add(menuItemAddOperadores);
        
        menuAjuda.add(menuItemSobre);
        menuAjuda.add(menuItemSair);
        
        super.add(menuBibliotecas);
        super.add(menuOperadores);
        super.add(menuAjuda);
    }

    private void addListener() {
        ActionListener listener = new ListenerMenuAplicação(FrameFrasesProntas.class, frameSistema);
        menuItemAddFrase.addActionListener(listener);
    
    }
    
    
    
    
    
    
}
