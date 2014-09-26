import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class Boleto implements Serializable {

	@SerializedName("id")
	Long idBoleto;

	@SerializedName("amount")
	BigDecimal valor;

	@SerializedName("paid_amount")
	BigDecimal valorPago;

	@SerializedName("expire_at")
	String dataVencimento;

	@SerializedName("paid_at")
	String dataPagamento;

	@SerializedName("description")
	String descricao;

	@SerializedName("status")
	String situacao;

	@SerializedName("shorten_url")
	String urlBoleto;

	@SerializedName("our_number")
	String nossoNumero;

	@SerializedName("customer_person_type")
	String tipoCliente;

	@SerializedName("customer_person_name")
	String nomeCliente;

	@SerializedName("customer_cnpj_cpf")
	String cpfCnpjCliente;

	@SerializedName("customer_email")
	String emailCliente;

	@SerializedName("customer_address")
	String enderecoCliente;

	@SerializedName("customer_city_name")
	String cidadeCliente;

	@SerializedName("customer_state")
	String ufCliente;

	@SerializedName("customer_neighborhood")
	String bairroCliente;

	@SerializedName("customer_zipcode")
	String cepCliente;

	@SerializedName("customer_address_number")
	String numeroCliente;

	@SerializedName("customer_address_complement")
	String complementoCliente;

	@SerializedName("customer_phone_number")
	String telefoneCliente;

	@SerializedName("customer_id")
	String idCliente;

	@SerializedName("notification_url")
	String urlNotificacao;

	@SerializedName("send_email_on_creation")
	Boolean enviaEmail;

	@SerializedName("created_via_api")
	Boolean incluidoIntegracao;

	public Boleto(BigDecimal valor, String dataVencimento, String descricao,
			String idCliente, String urlNotificacao) {
		super();
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.descricao = descricao;
		this.idCliente = idCliente;
		this.urlNotificacao = urlNotificacao;
	}

	public Boleto(BigDecimal valor, String dataVencimento, String descricao,
			String nomeCliente, String cpfCnpjCliente, String emailCliente,
			String urlNotificacao) {
		super();
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.descricao = descricao;
		this.nomeCliente = nomeCliente;
		this.cpfCnpjCliente = cpfCnpjCliente;
		this.emailCliente = emailCliente;
		this.urlNotificacao = urlNotificacao;
	}

	public Boleto(BigDecimal valor, String dataVencimento, String descricao,
			String nomeCliente, String cpfCnpjCliente, String emailCliente,
			String enderecoCliente, String cidadeCliente, String ufCliente,
			String bairroCliente, String cepCliente, String numeroCliente,
			String complementoCliente, String telefoneCliente,
			String idCliente, String urlNotificacao, Boolean enviaEmail) {
		super();
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.descricao = descricao;
		this.nomeCliente = nomeCliente;
		this.cpfCnpjCliente = cpfCnpjCliente;
		this.emailCliente = emailCliente;
		this.enderecoCliente = enderecoCliente;
		this.cidadeCliente = cidadeCliente;
		this.ufCliente = ufCliente;
		this.bairroCliente = bairroCliente;
		this.cepCliente = cepCliente;
		this.numeroCliente = numeroCliente;
		this.complementoCliente = complementoCliente;
		this.telefoneCliente = telefoneCliente;
		this.idCliente = idCliente;
		this.urlNotificacao = urlNotificacao;
		this.enviaEmail = enviaEmail;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getUfCliente() {
		return ufCliente;
	}

	public void setUfCliente(String ufCliente) {
		this.ufCliente = ufCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public String getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getComplementoCliente() {
		return complementoCliente;
	}

	public void setComplementoCliente(String complementoCliente) {
		this.complementoCliente = complementoCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getUrlNotificacao() {
		return urlNotificacao;
	}

	public void setUrlNotificacao(String urlNotificacao) {
		this.urlNotificacao = urlNotificacao;
	}

	public Boolean getEnviaEmail() {
		return enviaEmail;
	}

	public void setEnviaEmail(Boolean enviaEmail) {
		this.enviaEmail = enviaEmail;
	}

	public Long getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(Long idBoleto) {
		this.idBoleto = idBoleto;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getUrlBoleto() {
		return urlBoleto;
	}

	public void setUrlBoleto(String urlBoleto) {
		this.urlBoleto = urlBoleto;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Boolean getIncluidoIntegracao() {
		return incluidoIntegracao;
	}

	public void setIncluidoIntegracao(Boolean incluidoIntegracao) {
		this.incluidoIntegracao = incluidoIntegracao;
	}
}