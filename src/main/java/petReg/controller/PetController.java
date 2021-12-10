package petReg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petReg.beans.Pet;
import petReg.repository.PetRepository;
import petReg.service.PetService;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Nov 18, 2021
 */
@Controller
public class PetController {

	@Autowired
	PetRepository repo;

	@Autowired
	PetService service;

	// Index?
	@GetMapping("/")
	public String home(Model model) {
		return "/index";
	}

	// Used to display all of the owner objects
	@GetMapping({ "viewAll" })
	public String viewAllPets(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewPet(model);
		}
		model.addAttribute("pets", repo.findAll());
		return "results";
	}

	// Deletes the Pet object with the ID
	@GetMapping("/delete/{id}")
	public String deletePet(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		repo.delete(p);
		return "results";

	}

	// Used to get input from the input Pet page
	@GetMapping("/inputPet")
	public String addNewPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("newPet", p);
		return "input";

	}

	// Used to get input from the input Pet page
	@PostMapping("/inputPet")
	public String addNewPet(@ModelAttribute Pet p, Model model) {
		repo.save(p);
		return viewAllPets(model);
	}

	// Edits the Pet Object with that ID
	@GetMapping("/edit/{id}")
	public String showUpdatePet(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		model.addAttribute("newPet", p);
		return "input";
	}

	// Updates the edits to the Pet Object with that ID
	@PostMapping("/update/{id}")
	public String revisePet(Pet p, Model model) {
		repo.save(p);
		return viewAllPets(model);
	}

	// Uses the Query and Service to search the Pet database for the Keyword
	@RequestMapping(path = { "/", "/searchPets" })
	public String home(Pet shop, Model model, String keyword) {
		if (keyword != null) {
			List<Pet> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Pet> list = service.getAllPets();
			model.addAttribute("list", list);
		}
		return "search";
	}
}
