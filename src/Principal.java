import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {

	public static final String URL_PRODUCAO = "https://boletosimples.com.br";

	public static final String URL_TESTE = "https://sandbox.boletosimples.com.br";

	public static final String URL_BASE = URL_TESTE;

	public static final String URL_NOTIFICACAO = "http://seusite.com.br/notificacao-boleto";

	public static final String REQUEST_GET = "GET";

	public static final String REQUEST_POST = "POST";

	public static final String METODO_CLIENTE = "/api/v1/customers";

	public static final String METODO_BOLETO = "/api/v1/bank_billets";

	public static final String METODO_TRANSACAO = "/api/v1/transactions";

	public static final String METODO_USUARIO = "/api/v1/userinfo";

	public static void main(String[] args) throws Exception {

		System.out.println(" ... Iniciando os testes Gerais ...\n");

		testarClientes();
		testarBoletos();
		testarTransacoes();
		testarUsuarios();

		System.out.println("\n ... Testes Gerais Finalizados ...");
	}

	public static synchronized String boletar(String urlAcao, String request,
			Object... objeto)
			throws Exception {

		String usuario = "meu_usuario";
		String senha = "minha_senha";

		String autenticacao = new String(
				new Base64().encode((usuario + ":" + senha).getBytes()));

		// Validar Certificado Digital
		SSLContext sc = SSLContext.getInstance("TLS");
		sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() },
				new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String string, SSLSession ssls) {
				return true;
			}
		});

		HttpURLConnection conn = (HttpURLConnection) new URL(URL_BASE + urlAcao)
				.openConnection();

		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(true);
		conn.setAllowUserInteraction(false);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("User-Agent", "Seu Site (contato@seusite.com.br)");
		conn.setRequestProperty("Authorization", "Basic " + autenticacao);
		conn.setRequestMethod(request);

		if (objeto != null && objeto.length > 0) {

			OutputStream os = conn.getOutputStream();
			OutputStreamWriter bos = new OutputStreamWriter(os, "UTF-8");

			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(Date.class, new DateTimeSerializer());

			Gson gson = builder.create();
			String json = gson.toJson(objeto[0]);

			bos.write(json);
			bos.close();
			os.close();
		}

		conn.connect();
		
		if ((request.equals(REQUEST_GET) && conn.getResponseCode() != 200)
				|| (request.equals(REQUEST_POST) && conn.getResponseCode() != 201)) {

			System.out.println("\n---\n" + conn.getResponseMessage()
					+ "\n---\n");

			Map<String, List<String>> map = conn.getHeaderFields();

			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " ,Value : "
						+ entry.getValue());
			}

			if ((request.equals(REQUEST_POST) && (conn.getResponseCode() == 422))) {

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream()), "UTF-8"));

				System.out.println("Retorno: " + br);

				return "Erro 422";

			} else {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode() + "\n"
						+ conn.getResponseMessage());
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream()), "UTF-8"));

		StringBuffer resultado = new StringBuffer();
		String output;

		while ((output = br.readLine()) != null) {
			resultado.append(output);
		}

		conn.disconnect();

		// Existe uma validação de uma requisição por segundo.
		Thread.sleep(1000);

		return resultado.toString();
	}
	
	public static void testarClientes() throws Exception {
		
		String resultadoListar = boletar(METODO_CLIENTE, REQUEST_GET);

		System.out.println("Listar Clientes: \n" + resultadoListar);

		ClienteWrapper cliente = new ClienteWrapper(new Cliente("Nome Cliente",
				"666.222.284-30", "email@email.com", "Rua", "Florianópolis",
				"SC", "Trindade", "88036-500", "388", "Apto 824", "4832230334"));

		String resultadoIncluir = boletar(METODO_CLIENTE, REQUEST_POST, cliente);

		Cliente clienteIncluir = transformar(Cliente.class, resultadoIncluir);

		System.out.println("Incluir Clientes: \n" + resultadoIncluir);

		String resultadoInformar = boletar(METODO_CLIENTE + "/"
				+ clienteIncluir.getIdCliente(),
				REQUEST_GET);

		System.out.println("Informações Cliente: \n" + resultadoInformar);

		Cliente retorno = transformar(Cliente.class, resultadoInformar);

		System.out.println(retorno.getIdCliente() + " - " + retorno.getNome());
	}

	public static void testarBoletos() throws Exception {

		String resultadoListar = boletar(METODO_BOLETO, REQUEST_GET);

		System.out.println("Listar Boletos: \n" + resultadoListar);

		// Para garantir que não será gerado um Boleto Teste em Produção
		if (!URL_BASE.equals(URL_PRODUCAO)) {

			BoletoWrapper boleto = new BoletoWrapper(new Boleto(new BigDecimal(
					"9.10"), "2014-08-23", "Referente Setembro de 2014",
					"Nome do cliente", "032.313.119-00", "contato@seusite.com",
					URL_NOTIFICACAO));

			String resultadoIncluir = boletar(METODO_BOLETO, REQUEST_POST, boleto);

			System.out.println("Incluir Boleto: \n" + resultadoIncluir);

			Boleto retornoIncluir = transformar(Boleto.class, resultadoIncluir);

			String resultadoInformar = boletar(METODO_BOLETO + "/"
					+ retornoIncluir.getIdBoleto(), REQUEST_GET);

			System.out.println("Informações Boleto: \n" + resultadoInformar);

			Boleto retorno = transformar(Boleto.class, resultadoInformar);

			System.out.println(retorno.getIdBoleto() + " - "
					+ retorno.getDescricao());
		}
	}

	public static void testarTransacoes() throws Exception {

		String resultadoListar = boletar(METODO_TRANSACAO, REQUEST_GET);

		System.out.println("Listar Transações: \n" + resultadoListar);
	}

	public static void testarUsuarios() throws Exception {

		String resultadoInfo = boletar(METODO_USUARIO, REQUEST_GET);

		System.out.println("Informações Usuário: \n" + resultadoInfo);
	}

	private static <T extends Object> T transformar(final Class<T> objeto,
			String json) {

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new DateTimeSerializer());

		Gson gson = builder.create();

		return (T) gson.fromJson(json, objeto);
	}
}