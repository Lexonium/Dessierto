package entidades.Zona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class ZonaController {
    private ZonaRepository zonaRepository;
    @Autowired
    public ZonaController(ZonaRepository zonaRepository) {
        this.zonaRepository=zonaRepository;
    }
    @GetMapping("/Zonas")
    public String mostrarListaZonas (Model model){
        model.addAttribute("Zona", zonaRepository.findAll());
        return "Zonas";
    }
    @PostMapping("/addzona")
    public String addZona (@Valid Zona zona, BindingResult result, Model model){
        if(result.hasErrors()){
            return "/Zonas";
        }
        zonaRepository.save(zona);
        return "redirect:/index";
    }
}
