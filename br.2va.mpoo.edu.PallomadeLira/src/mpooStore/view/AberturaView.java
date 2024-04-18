package mpooStore.view;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class AberturaView extends JFrame {
	private JLabel imagemLabel, avisoLabel, perguntaLabel;
	private JRadioButton simButton, naoButton;
	private ButtonGroup buttonGroup;
	private JButton pegarCupomButton;
	
	public AberturaView() {

		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setUndecorated(true);
	
		
		imagemLabel = new JLabel(new ImageIcon("mpooStore.img/logo.png"));
		avisoLabel = new JLabel("Ganhe um Cupom de Desconto");
		perguntaLabel = new JLabel("Você é cliente de MPOOStore?");
		simButton = new JRadioButton("Sim", true);
		naoButton = new JRadioButton("Não");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(simButton);
		buttonGroup.add(naoButton);
		
		pegarCupomButton = new JButton("Pegar Cupom");
		
		add(imagemLabel);
		add(avisoLabel);
		add(perguntaLabel);
		add(simButton);
		add(naoButton);
		add(pegarCupomButton);
		
		
		
		setVisible(true);
		
	}

	public JLabel getImagemLabel() {
		return imagemLabel;
	}

	public JLabel getAvisoLabel() {
		return avisoLabel;
	}

	public JLabel getPerguntaLabel() {
		return perguntaLabel;
	}

	public JRadioButton getSimButton() {
		return simButton;
	}

	public JRadioButton getNaoButton() {
		return naoButton;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JButton getPegarCupomButton() {
		return pegarCupomButton;
	}

}
