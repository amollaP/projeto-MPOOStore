package mpooStore.model;

public interface ValidadorCPFInterface {
	public final String CPF_INVALIDO = "CPF informado é inválido";


	public abstract boolean validarCPF(String cpf)throws CPFException;

}
