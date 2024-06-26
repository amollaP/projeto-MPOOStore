package mpooStore.model;

import java.util.ArrayList;

public class BaseDados {
	private static ArrayList<Pessoa> pessoas;
	
	public static void createBase() throws CPFException{
		pessoas = new ArrayList<Pessoa>();
		inicializarBase();
	}
	
	private static void inicializarBase() throws CPFException{
			try {
			    pessoas.add(new Cliente("Maria Silva", "833.553.163-34", "maria@gmail.com"));
			} catch (CPFException e) {
				throw new CPFException();
			}
			
			try {
				pessoas.add(new Cliente("joao Santos", "111.111.111-11", "joao@gmail.com"));
			} catch (CPFException e) {
				throw new CPFException();

			} 
			try {
				pessoas.add(new Cliente("Godofredo Alves", "358.251.830-27", "godofredo@gmail.com"));
			} catch (CPFException e) {
				throw new CPFException();

			}
			
	}
	
	private static Pessoa buscarPessoa(String cpf){ 
		if (cpf == null)
			return null;
		
		for (Pessoa pessoaCurrent : pessoas){
			if (pessoaCurrent.getCpf().equalsIgnoreCase(cpf))
				return pessoaCurrent;
		}
		return null;
	}
	
	public static Cliente buscarCliente(String email){ 
		if (email== null)
			return null;
		
		for (Pessoa pessoaCurrent : pessoas){
			if (pessoaCurrent instanceof Cliente)
				if (((Cliente) pessoaCurrent).getEmail().equalsIgnoreCase(email))
					return (Cliente)pessoaCurrent;
		}
		return null;
	}

	public static boolean isCliente(Cliente cliente) throws ClienteException{
		
		boolean contains;
		contains=pessoas.contains(buscarCliente(cliente.getEmail()));
		if (contains) return true;
		contains=pessoas.contains(buscarPessoa(cliente.getCpf()));
		if (contains) return true;
		
		throw new ClienteException();
	}
}