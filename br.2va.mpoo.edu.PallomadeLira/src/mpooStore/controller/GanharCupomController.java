package mpooStore.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mpooStore.model.BaseDados;
import mpooStore.model.CPFException;
import mpooStore.model.Cliente;
import mpooStore.model.ClienteException;
import mpooStore.model.CupomDesconto;
import mpooStore.model.CupomException;
import mpooStore.model.GerenciadorCupom;
import mpooStore.view.AberturaView;
import mpooStore.view.GanharCupomView;

public class GanharCupomController implements ActionListener{
	GanharCupomView ganharCupomView;
	AberturaView aberturaView;
	
	GerenciadorCupom gerenciadorCupom;
	WindowHandler windowHandler;
	 
	
	public GanharCupomController(GanharCupomView ganharCupomView, AberturaView aberturaView,
			GerenciadorCupom gerenciadorCupom) {
		this.ganharCupomView = ganharCupomView;
		this.aberturaView = aberturaView;
		this.gerenciadorCupom = gerenciadorCupom;
		
		windowHandler = new WindowHandler();
		
		
		control();
	}

	private void control() {
	
		ganharCupomView.getConfirmarButton().addActionListener(this);;
		ganharCupomView.addWindowListener(windowHandler);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon imagemIcon = new ImageIcon("mpooStore.img/icone.png");
		Cliente cliente;
		//pego os dados da view
	try {
		     cliente = new Cliente(ganharCupomView.getCamposPanel().getNomeField().getText(),
				                   ganharCupomView.getCamposPanel().getCpfField().getText(), 
			                       ganharCupomView.getCamposPanel().getEmailField().getText());
		     //verifico se os dados da view corresponde com os dados da base
		     BaseDados.isCliente(cliente);
		try {			
			CupomDesconto cupomDesconto = new CupomDesconto(GerenciadorCupom.CODIGO_CUPOM, cliente);		
			int valorCupom = gerenciadorCupom.getValorCupomAtual();			
			cupomDesconto.setValor(valorCupom);
			
			if(gerenciadorCupom.isOfertaCupom()== true)
			JOptionPane.showMessageDialog(null, "Parabéns, você ganhou R$ " + valorCupom,
					                            "MPOO Store", JOptionPane.PLAIN_MESSAGE, imagemIcon);
			else 
				
				 JOptionPane.showMessageDialog(
				            null,
				            "MPOO Store informa: campanha finalizada!",
				            "MPOO Store",
				            JOptionPane.PLAIN_MESSAGE,
				            new ImageIcon("mpooStore.img/icone.png"));
			
		} catch (CupomException cupomE) {
			cupomE.printStackTrace();
		}
		
	} catch (CPFException cpfE) {
		JOptionPane.showConfirmDialog(null, cpfE.getMessage(), "MPOOStore Error",
		                                    JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
		    cpfE.printStackTrace();
		
	}  catch (ClienteException clienteE) {
		JOptionPane.showConfirmDialog(null, "Cupom Desconto válido apenas para cliente de MPOOStore!", 
				                            "MPOO Store", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION, imagemIcon);
			clienteE.printStackTrace();
		}
	}


private class WindowHandler extends WindowAdapter{

	@Override
	public void windowClosing(WindowEvent e) {
		ganharCupomView.setVisible(false);
		aberturaView.setVisible(true);
		
	}
	
}
}


