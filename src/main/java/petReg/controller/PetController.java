package petReg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import petReg.beans.Pet;
import petReg.repository.PetRepository;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Nov 18, 2021
 */
@Controller
public class PetController {
	
	@Autowired
	PetRepository repo;

	@GetMapping({ "/", "viewAllPets" })
	public String viewAllPets(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewPet(model);
		}
		model.addAttribute("pets", repo.findAll());
		return "petResults";
	}
	
	@GetMapping("/inputPet")
	public String addNewPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("newPet", p);
		return "petInput";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatePet(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		model.addAttribute("newPet", p);
		return "petInput";
	}

	@PostMapping("/update/{id}")
	public String reviseOwner(Pet p, Model model) {
		repo.save(p);
		return viewAllPets(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deletePet(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		repo.delete(p);
		return viewAllPets(model);
	}	
}

