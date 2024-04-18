package mpooStore.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import mpooStore.util.SpringUtilities;

public class CamposPanel extends JPanel{
	private JLabel nomeLabel, cpfLabel, emailLabel;
	private JTextField nomeField, emailField;
	private JFormattedTextField cpfField;
	
	
	public CamposPanel() {

		setLayout(new SpringLayout());
		
		
		nomeLabel = new JLabel("Nome:" );
		nomeField = new JTextField(10);
		cpfLabel = new JLabel("CPF:");
		
		cpfField = new JFormattedTextField();
		
		try {
			cpfField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			cpfField.setColumns(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		emailLabel = new JLabel("Email:");
		emailField = new JTextField(10);
		
		
		add(nomeLabel);
		add(nomeField);
		add(cpfLabel);
		add(cpfField);
		add(emailLabel);
		add(emailField);
	
		
		SpringUtilities.makeCompactGrid(this, 3, 2, 5, 5, 5, 5);
		
		
		
		
		
		
	}

	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public JLabel getCpfLabel() {
		return cpfLabel;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}


	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public JFormattedTextField getCpfField() {
		return cpfField;
	}


	
	

}
