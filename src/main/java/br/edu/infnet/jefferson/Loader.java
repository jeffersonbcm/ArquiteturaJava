package br.edu.infnet.jefferson;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.jefferson.model.domain.Carro;
import br.edu.infnet.jefferson.model.domain.Endereco;
import br.edu.infnet.jefferson.model.domain.Locadora;
import br.edu.infnet.jefferson.model.domain.Moto;
import br.edu.infnet.jefferson.model.service.LocadoraService;
import br.edu.infnet.jefferson.model.service.VeiculoService;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private LocadoraService locadoraservice;
//	@Autowired
//	private LocalizacaoService localizacaoService;
	@Autowired
	private VeiculoService veiculoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		for(Estado estado : localizacaoService.obterEstados()) {
			System.out.println("ESTADO: "+ estado.getNome());
			
		}		
		
		
		for(Municipio municipio : localizacaoService.obterMunicipios(13)) {
			System.out.println("MUNICIPIOS: "+ municipio.getNome());
			
		}
		*/
		
		FileReader file = new FileReader("files/locadoras.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		Locadora locadora = null;
				
		while (linha != null) {

			String[] campos = linha.split(";");
			switch (campos[0].toUpperCase()) {
			case "L":

				locadora = new Locadora();
				locadora.setCnpj(campos[1]);
				locadora.setRazaosocial(campos[2]);			
				locadora.setEndereco(new Endereco(campos[3]));
				
				locadora = locadoraservice.incluir(locadora);
				
				System.out.println("LOCADORA ["+locadora+"]");
				
				break;
			case "M":
				Moto moto = new Moto();
				moto.setMarca(campos[1]);
				moto.setModelo(campos[2]);
				moto.setCilindrada(campos[3]);
				moto.setAutonomia(Float.parseFloat(campos[4]));
				moto.setLocadora(locadora);
				
				veiculoService.incluir(moto);
				
				locadora.getVeiculos().add(moto);
								
				break;
			case "C":
				
				Carro carro = new Carro();
				carro.setMarca(campos[1]);
				carro.setModelo(campos[2]);
				carro.setCategoria(campos[3]);
				carro.setGps(Boolean.parseBoolean(campos[4]));
				carro.setLocadora(locadora);
				
				veiculoService.incluir(carro);
				
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
		
		System.out.println("#### findByRazaosocialContaining ####"+ locadoraservice.obterPorRazaosocial("Locadora") );
		
		leitura.close();
	}

}
