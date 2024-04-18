package mpooStore.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GanharCupomView extends JFrame{
	private JLabel imagemLabel, cupomDescontoLabel, brindeLabel;
	private ImageIcon iconeIcon;
	private JButton confirmarButton;
	private CamposPanel camposPanel;//= new CamposPanel();
	private JPanel panel1;
	
	
	
	public GanharCupomView() {
		super("MPOOStore");
		
		setSize(300, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		imagemLabel = new JLabel(new ImageIcon("mpooStore.img/logo.png"));
		iconeIcon = new ImageIcon("mpooStore.img/icone.png");
		setIconImage(iconeIcon.getImage());
		camposPanel = new CamposPanel();
		confirmarButton = new JButton("Confirmar");
		
		cupomDescontoLabel = new JLabel("Cupom Desconto");
		brindeLabel = new JLabel(new ImageIcon("mpooStore.img/brinde.png"));
		
		panel1 = new JPanel();

		add(imagemLabel, BorderLayout.NORTH);
		add(camposPanel, BorderLayout.CENTER);

		add(confirmarButton, BorderLayout.EAST);
		panel1.add(cupomDescontoLabel);
		panel1.add(brindeLabel);
		add(panel1, BorderLayout.SOUTH);
		
		setVisible(false);
		

	
		
	
	}



	public JLabel getImagemLabel() {
		return imagemLabel;
	}



	public JLabel getCupomDescontoLabel() {
		return cupomDescontoLabel;
	}



	public JLabel getBrindeLabel() {
		return brindeLabel;
	}



	public ImageIcon getIconeIcon() {
		return iconeIcon;
	}



	public JButton getConfirmarButton() {
		return confirmarButton;
	}



	public CamposPanel getCamposPanel() {
		return camposPanel;
	}



	public JPanel getPanel1() {
		return panel1;
	}

}
