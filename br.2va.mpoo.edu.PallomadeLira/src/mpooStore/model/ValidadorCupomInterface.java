package mpooStore.model;

public interface ValidadorCupomInterface {

	public static boolean validarCupom(String codigoCupom) {
		if(codigoCupom.equals("MPOOSTOREOFF"))
			return true;
		return false;
	}
}
