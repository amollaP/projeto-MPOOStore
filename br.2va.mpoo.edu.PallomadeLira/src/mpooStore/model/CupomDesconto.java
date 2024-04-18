package mpooStore.model;

public class CupomDesconto implements ValidadorCupomInterface{
	private double valor;
	private String codigo;

	
	public CupomDesconto(Cliente cliente) {}
	
	
	private CupomDesconto( String codigo) {
		this.valor = 0.0;
		this.codigo = codigo;
	}


	public CupomDesconto(String codigo, Cliente cliente) throws ClienteException, CupomException {
		if(!ValidadorCupomInterface.validarCupom(codigo))
			throw new CupomException();
		try {
			BaseDados.isCliente(cliente);
		} catch (ClienteException e) {
			throw new ClienteException();
		}
		cliente.setCupomDesconto(new CupomDesconto(codigo));
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "CupomDesconto [valor=" + valor + ", codigo=" + codigo + "]";
	}
	
	
}
