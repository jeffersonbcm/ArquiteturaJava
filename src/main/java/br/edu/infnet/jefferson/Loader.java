package br.edu.infnet.jefferson;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.jefferson.model.domain.Endereco;
import br.edu.infnet.jefferson.model.domain.Smart;
import br.edu.infnet.jefferson.model.domain.Tradicional;
import br.edu.infnet.jefferson.model.domain.Vendedor;
import br.edu.infnet.jefferson.model.service.VendedorService;

@Component
public class Loader implements ApplicationRunner {
	
//	private Map<String, Vendedor> mapaVendedores = new HashMap<String, Vendedor>();
	@Autowired
	private VendedorService vendedorservice;
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// System.out.println("Opa!");
		FileReader file = new FileReader("files/vendedores.txt");
		BufferedReader leitura = new BufferedReader(file);

		// System.out.println(leitura.readLine()); //Lê 1 linha
		String linha = leitura.readLine();
		Vendedor vendedor = null;
				
		while (linha != null) {

			String[] campos = linha.split(";");
			switch (campos[0].toUpperCase()) {
			case "V":
				
				Endereco endereco = new Endereco();
				endereco.setCep(campos[4]);
				
				//Vendedor vendedor = new Vendedor();
				vendedor = new Vendedor();
				vendedor.setNome(campos[1]);
				vendedor.setCpf(campos[2]);
				vendedor.setEmail(campos[3]);				
				vendedor.setEndereco(endereco);
				
				//System.out.println("Vendedor Cadastrado com Sucesso: "+vendedor);
//				mapaVendedores.put(vendedor.getCpf(), vendedor);
				vendedorservice.incluir(vendedor);
				
				break;
			case "T":
				Tradicional tradicional = new Tradicional();
				//tradicional.setCodigo(campos[1]);
				tradicional.setDescricao(campos[2]);
				tradicional.setMarca(campos[3]);
				//tradicional.setPreco(campos[4]);
				//tradicional.setEstoque(campos[5]);
				//tradicional.setGarantiaMeses(campos[6]);
				tradicional.setTipoRelogio(campos[7]);
				tradicional.setTipoPulseira(campos[8]);
				vendedor.getProdutos().add(tradicional);
				
				
				break;
			case "S":
				
				Smart smart = new Smart();
				//smart.setCodigo(campos[1]);
				smart.setDescricao(campos[2]);
				smart.setMarca(campos[3]);
				//smart.setPreco(campos[4]);
				//smart.setEstoque(campos[5]);
				//smart.setGarantiaMeses(campos[6]);
				//smart.setGps(campos[7]);
				//smart.setBatimentos(campos[8]);
				vendedor.getProdutos().add(smart);
				
				break;
			default:
				break;
			}

			// System.out.println(linha);
			 linha = leitura.readLine();

		}
		//for (Vendedor v: mapaVendedores.values()) {
		for (Vendedor v: vendedorservice.ObterLista()) {
			
			System.out.println("Vendedor Cadastrado com Sucesso: "+v);
		}
		
		
		leitura.close();
	}

}
