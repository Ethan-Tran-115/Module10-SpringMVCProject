package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Manufacturer;
import dmacc.beans.Phone;
import dmacc.beans.Specification;
import dmacc.repository.ManufacturerRepository;
import dmacc.repository.PhoneRepository;
import dmacc.repository.SpecificationRepository;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Mar 25, 2024
 */
@Controller
public class WebController {
	 	@Autowired
	    private PhoneRepository phoneRepo;

	    @Autowired
	    private ManufacturerRepository manufacturerRepo;

	    @Autowired
	    private SpecificationRepository specificationRepo;

	    @GetMapping({"/", "/viewAllPhones"})
	    public String viewAllPhones(Model model) {
	        model.addAttribute("phones", phoneRepo.findAll());
	        return "results";
	    }

	    @GetMapping("/inputPhone")
	    public String addNewPhone(Model model) {
	        Phone phone = new Phone();
	        model.addAttribute("newPhone", phone);
	        model.addAttribute("manufacturers", manufacturerRepo.findAll());
	        model.addAttribute("specifications", specificationRepo.findAll());
	        return "input";
	    }

	    @PostMapping("/inputPhone")
	    public String addNewPhone(@ModelAttribute Phone phone) {
	        Specification specification = phone.getSpecification();

	        Manufacturer savedManufacturer = manufacturerRepo.save(specification.getManufacturer());

	        specification.setManufacturer(savedManufacturer);

	        Specification savedSpecification = specificationRepo.save(specification);

	        phone.setSpecification(savedSpecification);

	        phoneRepo.save(phone);
	        return "redirect:/viewAllPhones";
	    }

	    @GetMapping("/editPhone/{id}")
	    public String showUpdatePhone(@PathVariable("id") Long id, Model model) {
	        Phone phone = phoneRepo.findById(id).orElse(null);
	        model.addAttribute("newPhone", phone);
	        model.addAttribute("manufacturers", manufacturerRepo.findAll());
	        model.addAttribute("specifications", specificationRepo.findAll());
	        return "input";
	    }

	    @PostMapping("/updatePhone/{id}")
	    public String revisePhone(@ModelAttribute Phone phone) {
	        Specification specification = phone.getSpecification();

	        Manufacturer savedManufacturer = manufacturerRepo.save(specification.getManufacturer());

	        specification.setManufacturer(savedManufacturer);

	        Specification savedSpecification = specificationRepo.save(specification);

	        phone.setSpecification(savedSpecification);

	        phoneRepo.save(phone);
	        return "redirect:/viewAllPhones";
	    }

	    @GetMapping("/deletePhone/{id}")
	    public String deletePhone(@PathVariable("id") Long id) {
	        phoneRepo.deleteById(id);
	        return "redirect:/viewAllPhones";
	    }

	   
}
