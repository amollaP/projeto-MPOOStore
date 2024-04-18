package mpooStore.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import mpooStore.view.AberturaView;
import mpooStore.view.GanharCupomView;

public class AberturaController {
	AberturaView aberturaView;
	GanharCupomView ganharCupomView;
	ButtonHandler buttonHandler;
	RadioHandler radiohandler;
	KeyHandler keyHandler;
	


	boolean cliente = true;
	
	
	public AberturaController(AberturaView aberturaView, GanharCupomView ganharCupomView) {
		this.aberturaView = aberturaView;
		this.ganharCupomView = ganharCupomView;
		
		radiohandler = new RadioHandler();
		buttonHandler = new ButtonHandler();
		keyHandler = new KeyHandler();
		
		control();
		
	}

		private void control() {
			aberturaView.getPegarCupomButton().addActionListener(buttonHandler);
		
			aberturaView.getSimButton().addItemListener(radiohandler);
			aberturaView.getNaoButton().addItemListener(radiohandler);
			
		
			aberturaView.getPegarCupomButton().addKeyListener(keyHandler);
		}
			
		

	
	
private class RadioHandler implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent event) {

		if(event.getItem() == aberturaView.getSimButton()&& event.getStateChange() == ItemEvent.SELECTED)
			cliente = true;
		
		if(event.getItem() == aberturaView.getNaoButton() && event.getStateChange() == ItemEvent.SELECTED)
			cliente = false;
		
		
	}
	
}
private class ButtonHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		ImageIcon imageIcon = new ImageIcon("mpooStore.img/icone.png");
		
			if(cliente) {
				aberturaView.setVisible(false);
				ganharCupomView.setVisible(true);
			}
			else
			
				JOptionPane.showMessageDialog(null, "Cupom Desconto válido apenas para clientes de MPOOStore!", 
						                            "MPOO Store", JOptionPane.PLAIN_MESSAGE, imageIcon);
				
		}
		
	}
private class KeyHandler extends KeyAdapter{
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "MPOOStore", JOptionPane.YES_NO_OPTION)==0) {
				System.exit(0);
			}
		}
	}		 
}
}

