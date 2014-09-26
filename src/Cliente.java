import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Cliente implements Serializable {

	@SerializedName("id")
	Long idCliente;

	@SerializedName("person_type")
	String tipoCliente;

	@SerializedName("person_name")
	String nome;

	@SerializedName("cnpj_cpf")
	String cpfCnpj;

	@SerializedName("address")
	String endereco;

	@SerializedName("state")
	String uf;

	@SerializedName("neighborhood")
	String bairro;

	@SerializedName("zipcode")
	String cep;

	@SerializedName("address_number")
	String numero;

	@SerializedName("address_complement")
	String complemento;

	@SerializedName("phone_number")
	String telefone;

	@SerializedName("email")
	String email;

	@SerializedName("mobile_local_code")
	String codigoCelular;

	@SerializedName("mobile_number")
	String celular;

	@SerializedName("city_name")
	String cidade;

	public Cliente(String nome, String cpfCnpj, String email, String endereco,
			String cidade, String uf, String bairro, String cep, String numero,
			String complemento, String telefone) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.cidade = cidade;
		this.uf = uf;
		this.bairro = bairro;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
	}

	public Cliente(String nome, String cpfCnpj, String email, String endereco,
			String cidade, String uf, String bairro, String cep, String numero,
			String complemento, String telefone, String codigoCelular,
			String celular) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.cidade = cidade;
		this.uf = uf;
		this.bairro = bairro;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.codigoCelular = codigoCelular;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCodigoCelular() {
		return codigoCelular;
	}

	public void setCodigoCelular(String codigoCelular) {
		this.codigoCelular = codigoCelular;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}