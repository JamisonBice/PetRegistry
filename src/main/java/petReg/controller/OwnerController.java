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

import petReg.beans.Owner;
import petReg.repository.OwnerRepository;
import petReg.service.OwnerService;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Sep 4, 2021
 */
@Controller
public class OwnerController {

	@Autowired
	OwnerRepository repo;

	// Used to display all of the owner objects
	@GetMapping({ "-", "viewAllOwners" })
	public String viewAllOwners(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewOwner(model);
		}
		model.addAttribute("owners", repo.findAll());
		return "ownerResults";
	}

	// Used to get input from the input Owner page
	@GetMapping("/inputOwner")
	public String addNewOwner(Model model) {
		Owner c = new Owner();
		model.addAttribute("newOwner", c);
		return "ownerInput";
	}

	// Used to get input from the input Owner page
	@PostMapping("/inputOwner")
	public String addNewOwner(@ModelAttribute Owner c, Model model) {
		repo.save(c);
		return viewAllOwners(model);
	}

	// Edits the Owner Object with that ID
	@GetMapping("/ownerEdit/{id}")
	public String showUpdateOwner(@PathVariable("id") int id, Model model) {
		Owner c = repo.findById(id).orElse(null);
		model.addAttribute("newOwner", c);
		return "ownerInput";
	}

	// Updates the edits to the Owner Object with that ID
	@PostMapping("/ownerUpdate/{id}")
	public String reviseOwner(Owner c, Model model) {
		repo.save(c);
		return viewAllOwners(model);
	}

	// Deletes the Owner object with the ID
	@GetMapping("/ownerDelete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		Owner c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllOwners(model);
	}

	@Autowired
	private OwnerService service;

	// Uses the Query and Service to search the Owner database for the Keyword
	@RequestMapping(path = { "-", "/ownerSearch" })
	public String home(Owner shop, Model model, String keyword) {
		if (keyword != null) {
			List<Owner> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Owner> list = service.getAllOwners();
			model.addAttribute("list", list);
		}
		return "searchOwner";
	}
}
