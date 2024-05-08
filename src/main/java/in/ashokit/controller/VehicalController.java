package in.ashokit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.binding.VehicalBinding;
import in.ashokit.entity.VehicalEntity;
import in.ashokit.repo.VehicalRepository;
import in.ashokit.service.VehicalService;
import jakarta.persistence.metamodel.StaticMetamodel;

@Controller
public class VehicalController {

	@Autowired
	private VehicalService ss;
	
	@Autowired
	private VehicalRepository repo;
	
	@GetMapping("/")
	public String loadForm(Model model)
	{
		initBindVehical(model);
		return "index";
	}
	
//	@InitBinder
	private void initBindVehical(Model model) {
		model.addAttribute("vehicalbind", new VehicalBinding());
		model.addAttribute("mode1",ss.getMode());
		model.addAttribute("sitter1",ss.getSitter());
	}
	
	@PostMapping("/save")
	public String handleSave(@Validated @ModelAttribute("vehicalbind") VehicalBinding vb,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "FillInfo";
		}
		
		boolean b=ss.saveVehical(vb);
		if(b)
		model.addAttribute("msg", "Saveed Vehical Information");
		initBindVehical(model);
		return "index";
	}
	@GetMapping("/vehicals")
	public String viewVehicals(Model model)
	{
		model.addAttribute("vehicals", ss.findAll());
		
		return "ViewAllVehical";
	}
	@GetMapping("/edit")
	public String viewAllVehicals(@RequestParam("id") Integer id, Model model)
	{
		model.addAttribute("vehical", ss.findbyId(id));
		model.addAttribute("mode1",ss.getMode());
		model.addAttribute("sitter1",ss.getSitter());
		return "VehicalInfo";
		
	}
	
	@GetMapping("/delete")
	public String deleteByid(@RequestParam("id") Integer id,Model model)
	{
		ss.deleteById(id);
		model.addAttribute("msg","Vehical Record Deleted.");		
		model.addAttribute("vehicals", ss.findAll());
		return "ViewAllVehical";
	}
	@PostMapping("/update")
	public String handleSave1(@ModelAttribute("VehicalEntity ") VehicalBinding vb, Model model)
	{
		ss.saveVehical(vb);
		model.addAttribute("msg1", "Update Vehical Information");
		model.addAttribute("vehicals",ss.findAll());
		return "ViewAllVehical";
	}
	
	
}
