package br.edu.infnet.jefferson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.jefferson.client.EnderecoClient;
import br.edu.infnet.jefferson.client.LocalidadeClient;
import br.edu.infnet.jefferson.model.domain.Endereco;
import br.edu.infnet.jefferson.model.domain.Estado;
import br.edu.infnet.jefferson.model.domain.Carro;
import br.edu.infnet.jefferson.model.domain.Moto;
import br.edu.infnet.jefferson.model.domain.Municipio;
import br.edu.infnet.jefferson.model.domain.Locadora;
import br.edu.infnet.jefferson.model.service.LocadoraService;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private LocadoraService locadoraservice;
	
	@Autowired
	private EnderecoClient enderecoClient;
	
	@Autowired
	private LocalidadeClient localidadeClient;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		for(Estado estado : localidadeClient.obterEstados()) {
			System.out.println("ESTADO: "+ estado.getNome());
			
		}		
		
		
		for(Municipio municipio : localidadeClient.obterMunicipios(13)) {
			System.out.println("MUNICIPIOS: "+ municipio.getNome());
			
		}
		
		
		FileReader file = new FileReader("files/locadoras.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		Locadora locadora = null;
				
		while (linha != null) {

			String[] campos = linha.split(";");
			switch (campos[0].toUpperCase()) {
			case "L":
				
				Endereco endereco = enderecoClient.findByCep(campos[3]);

				locadora = new Locadora();
				locadora.setCnpj(campos[1]);
				locadora.setRazaosocial(campos[2]);			
				locadora.setEndereco(endereco);
				
				locadoraservice.incluir(locadora);
				
				break;
			case "M":
				Moto moto = new Moto();
				moto.setMarca(campos[1]);
				moto.setModelo(campos[2]);
				moto.setCilindrada(campos[3]);
				moto.setAutonomia(Float.parseFloat(campos[4]));
					
				locadora.getVeiculos().add(moto);
								
				break;
			case "C":
				
				Carro carro = new Carro();
				carro.setMarca(campos[1]);
				carro.setModelo(campos[2]);
				carro.setCategoria(campos[3]);
				carro.setGps(Boolean.parseBoolean(campos[4]));
								
				locadora.getVeiculos().add(carro);
				
				break;
			default:
				break;
			}

			 linha = leitura.readLine();

		}

		for (Locadora v: locadoraservice.ObterLista()) {
			
			System.out.println("Locadora Cadastrada com Sucesso: "+v);
		}
		
		
		leitura.close();
	}

}
