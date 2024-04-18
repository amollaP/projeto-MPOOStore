package mpooStore.model;

public class CPFException extends Exception{
	
	public CPFException() {
		super(ValidadorCPFInterface.CPF_INVALIDO);

	}
	public CPFException(String mensagem) {
		super(mensagem);

	}

}
