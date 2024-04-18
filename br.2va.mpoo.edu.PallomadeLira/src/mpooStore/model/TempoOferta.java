package mpooStore.model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TempoOferta extends Thread{
	private GerenciadorCupom gerenciadorCupom;
	private static final long TEMPO_OFERTA = 600000;

	
	
	public TempoOferta(GerenciadorCupom gerenciadorCupom) {
		this.gerenciadorCupom = gerenciadorCupom;
	}
	


	
	public GerenciadorCupom getGerenciadorCupom() {
		return gerenciadorCupom;
	}


	public void setGerenciadorCupom(GerenciadorCupom gerenciadorCupom) {
		this.gerenciadorCupom = gerenciadorCupom;
	}


	public static long getTempoOferta() {
		return TEMPO_OFERTA;
	}

	@Override
	public void run() {
		
	    try {
	        Thread.sleep(TEMPO_OFERTA);
	             
	        JOptionPane.showMessageDialog(
	            null,
	            "MPOO Store informa: campanha finalizada!",
	            "MPOO Store",
	            JOptionPane.PLAIN_MESSAGE,
	            new ImageIcon("mpooStore.img/icone.png"));
	        

	    } catch (InterruptedException e) {
	        e.printStackTrace();
	   
	        
	       
	    }
	
	}

	

}
