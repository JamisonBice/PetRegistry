package petReg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petReg.beans.Pet;
import petReg.repository.PetRepository;
import petReg.service.PetService;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Nov 18, 2021
 */
@Controller
//@RequestMapping("pet")
public class PetController {
	
	@Autowired
	PetRepository repo;
	
	@Autowired
	PetService service;

	
	@GetMapping("/")
	public String home(Model model) {
		//List<Pet> listPets = service.listAll();
		//model.addAttribute("listPets", listPets);
		return "/index";
	}
	
	@GetMapping({"viewAll" })
	public String viewAllPets(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewPet(model);
		}
		model.addAttribute("pets", repo.findAll());
		return "results";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePet(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		repo.delete(p);
		return "results";

	}

	@GetMapping("/inputPet")
	public String addNewPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("newPet", p);
		return "input";

	}

	@PostMapping("/inputPet")
	public String addNewPet(@ModelAttribute Pet p, Model model) {
		repo.save(p);
		return viewAllPets(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdatePet(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		model.addAttribute("newPet", p);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String revisePet(Pet p, Model model) {
		repo.save(p);
		return viewAllPets(model);
	}
	
	@RequestMapping("/searchPets")
	public String searchPet(Model model, @RequestParam("keyword") String keyword) {
		List<Pet>listPets = service.listAll(keyword);
		model.addAttribute("listPets", listPets);
		model.addAttribute("keyword", keyword);
		
		return "search";
	}
}


