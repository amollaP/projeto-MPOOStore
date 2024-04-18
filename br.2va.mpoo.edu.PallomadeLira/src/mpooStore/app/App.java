package mpooStore.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mpooStore.controller.AberturaController;
import mpooStore.controller.GanharCupomController;
import mpooStore.model.BaseDados;
import mpooStore.model.CPFException;
import mpooStore.model.GeradorCupom;
import mpooStore.model.GerenciadorCupom;
import mpooStore.model.TempoOferta;
import mpooStore.view.AberturaView;
import mpooStore.view.GanharCupomView;

public class App {
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
				
		try {
			BaseDados.createBase();
		} catch (CPFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AberturaView aberturaView = new AberturaView();
		GanharCupomView ganharCupomView =  new GanharCupomView();
		AberturaController aberturaController =  new AberturaController(aberturaView, ganharCupomView);
		GerenciadorCupom gerenciadorCupom = new GerenciadorCupom();
		GanharCupomController ganharCupomController = new GanharCupomController(ganharCupomView,aberturaView, gerenciadorCupom);
		
		TempoOferta tempoOferta = new TempoOferta(gerenciadorCupom);
		tempoOferta.start();

		GeradorCupom geradorCupom = new GeradorCupom(gerenciadorCupom);
		geradorCupom.start();
		
	}


}