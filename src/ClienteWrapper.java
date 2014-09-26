import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class ClienteWrapper implements Serializable {

	@SerializedName("customer")
	Cliente cliente;

	public ClienteWrapper(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}