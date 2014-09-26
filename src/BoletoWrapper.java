import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class BoletoWrapper implements Serializable {

	@SerializedName("bank_billet")
	Boleto boleto;

	public BoletoWrapper(Boleto boleto) {
		super();
		this.boleto = boleto;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}
}