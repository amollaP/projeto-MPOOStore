package mpooStore.model;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GeradorCupom extends Thread {
	private static final long GERAR_CUPOM = 5000;
	private GerenciadorCupom gerenciadorCupom;
	TempoOferta tempoOferta;
	
	
	
	public GeradorCupom(GerenciadorCupom gerenciadorCupom) {
		this.gerenciadorCupom = gerenciadorCupom;
	}



	private void gerarCupom() {
		gerenciadorCupom.setValorCupomAtual(new Random().nextInt(100));
		
		
		
	}
	
		
	public GerenciadorCupom getGerenciadorCupom() {
		return gerenciadorCupom;
	}



	public void setGerenciadorCupom(GerenciadorCupom gerenciadorCupom) {
		this.gerenciadorCupom = gerenciadorCupom;
	}



	public static long getGerarCupom() {
		return GERAR_CUPOM;
	}



	@Override
	public void run() {
	    gerenciadorCupom.setOfertaCupom(true);
	    
	    long tempoInicio = System.currentTimeMillis();

	    while (gerenciadorCupom.isOfertaCupom()){
	    	
	        gerarCupom();
	        System.out.println("Cupom gerado " + gerenciadorCupom.getValorCupomAtual());             
	        try {
	        	
	            Thread.sleep(GERAR_CUPOM);
	                   
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	           
	        }
	        //Verifica se o tempo de oferta ultrapassou o tempo de oferta :)
	        long tempoAtual = System.currentTimeMillis();
	        if (tempoAtual - tempoInicio > 600000) {
	            //Se o tempo ultrapassou 10min interrompe o loop
	            gerenciadorCupom.setOfertaCupom(false);	           	
	            break;
	            
	        }
	         
	       

	    }
	}


}
