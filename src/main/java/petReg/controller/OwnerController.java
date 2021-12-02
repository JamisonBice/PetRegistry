package petReg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import petReg.beans.Owner;
import petReg.repository.OwnerRepository;
import petReg.service.OwnerService;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Sep 4, 2021
 */
@Controller
//@RequestMapping("owner")
public class OwnerController {

	@Autowired
	OwnerRepository repo;

	@Autowired
	private OwnerService service;

	@GetMapping({ "-", "viewAllOwners" })
	public String viewAllOwners(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewOwner(model);
		}
		model.addAttribute("owners", repo.findAll());
		return "ownerResults";
	}

	@GetMapping("/inputOwner")
	public String addNewOwner(Model model) {
		Owner c = new Owner();
		model.addAttribute("newOwner", c);
		return "ownerInput";
	}

	@PostMapping("/inputOwner")
	public String addNewOwner(@ModelAttribute Owner c, Model model) {
		repo.save(c);
		return viewAllOwners(model);
	}

	@GetMapping("/ownerEdit/{id}")
	public String showUpdateOwner(@PathVariable("id") long id, Model model) {
		Owner c = repo.findById(id).orElse(null);
		model.addAttribute("newOwner", c);
		return "ownerInput";
	}

	@PostMapping("/ownerUpdate/{id}")
	public String reviseOwner(Owner c, Model model) {
		repo.save(c);
		return viewAllOwners(model);
	}

	@GetMapping("/ownerDelete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Owner c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllOwners(model);
	}

	@RequestMapping(path = { "/", "/search" })
	public String home(Owner shop, Model model, String keyword) {
		if (keyword != null) {
			List<Owner> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Owner> list = service.getAllOwners();
			model.addAttribute("list", list);
		}
		return "ownerInput";
	}
}
