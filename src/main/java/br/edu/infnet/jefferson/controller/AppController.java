package br.edu.infnet.jefferson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.jefferson.model.service.CarroService;
import br.edu.infnet.jefferson.model.service.LocadoraService;
import br.edu.infnet.jefferson.model.service.MotoService;
import br.edu.infnet.jefferson.model.service.VeiculoService;

@Controller
public class AppController {

	@Autowired
	private LocadoraService locadoraService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private MotoService motoService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model) {
		
		model.addAttribute("qtdeLocadora", locadoraService.obterQtde());
		model.addAttribute("qtdeVeiculo", veiculoService.obterQtde());
		model.addAttribute("qtdeCarro", carroService.obterQtde());
		model.addAttribute("qtdeMoto", motoService.obterQtde());
		
		return "home";
	}
	
	@GetMapping(value = "/locadora/listagem")
	public String locadoraLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de Locadoras");
		model.addAttribute("listagem", locadoraService.obterLista());
		
		return telaHome(model);
	}
	
	
	
	@GetMapping(value = "/veiculo/listagem")
	public String veiculoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de Veiculos");
		model.addAttribute("listagem", veiculoService.obterLista());
		
		return telaHome(model);
	}
	
	
	@GetMapping(value = "/carro/listagem")
	public String carroLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de Carros");
		model.addAttribute("listagem", carroService.obterLista());
		
		return telaHome(model);
	}
	
	
	
	@GetMapping(value = "/moto/listagem")
	public String motoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de Motos");
		model.addAttribute("listagem", motoService.obterLista());
		
		return telaHome(model);
	}
	
	
}
