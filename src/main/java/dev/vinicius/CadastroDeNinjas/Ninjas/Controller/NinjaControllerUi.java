package dev.vinicius.CadastroDeNinjas.Ninjas.Controller;

import dev.vinicius.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.vinicius.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Lista todos os ninjas
    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> lista = ninjaService.listarNinjas();
        model.addAttribute("ninjas", lista);
        return "listar-ninjas";
    }

    // Formulário para novo ninja
    @GetMapping("/novo")
    public String novoNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "criar-ninja";
    }

    @PostMapping("/novo")
    public String salvarNinja(@ModelAttribute("ninja") NinjaDTO ninjaDTO) {
        ninjaService.criarNinja(ninjaDTO);
        return "redirect:/ninjas/ui/listar";
    }

    // Editar ninja
    @GetMapping("/editar/{id}")
    public String editarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        model.addAttribute("ninja", ninja);
        return "editar-ninja";
    }

    @PostMapping("/editar/{id}")
    public String atualizarNinja(@PathVariable Long id, @ModelAttribute("ninja") NinjaDTO ninjaDTO) {
        ninjaService.atualizarNinja(id, ninjaDTO);
        return "redirect:/ninjas/ui/listar";
    }

    // Ver detalhes
    @GetMapping("/{id}")
    public String detalhesNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        model.addAttribute("ninja", ninja);
        return "detalhes-ninja";
    }

    // Deletar
    @PostMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }
}
