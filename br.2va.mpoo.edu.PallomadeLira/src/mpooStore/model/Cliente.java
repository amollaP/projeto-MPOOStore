package mpooStore.model;

public class Cliente extends Pessoa{
	private String email;
	private CupomDesconto cupomDesconto;
	
	public Cliente(String nome, String cpf, String email) throws CPFException {
		super(nome, cpf);
		this.email = email;
		cupomDesconto = new CupomDesconto(this);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CupomDesconto getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDesconto cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	@Override
	public String toString() {
		return "Cliente [email=" + email + ", cupomDesconto=" + cupomDesconto + ", toString()=" + super.toString()
				+ "]";
	}

	
	
	
}