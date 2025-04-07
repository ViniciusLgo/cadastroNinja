package dev.vinicius.CadastroDeNinjas.Missoes.Controller;

import dev.vinicius.CadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.vinicius.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Listar todas as missões
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("missoes", missoesService.listarMissoes());
        return "listar-missoes";
    }

    // Página para criar nova missão
    @GetMapping("/criar")
    public String criarNovaMissao(Model model) {
        model.addAttribute("missao", new MissoesModel());
        return "criar-missao";
    }

    // Salvar nova missão
    @PostMapping("/criar")
    public String salvarMissao(@ModelAttribute("missao") MissoesModel missao) {
        missoesService.criarMissao(missao);
        return "redirect:/missoes/ui/listar";
    }

    // Página de edição
    @GetMapping("/editar/{id}")
    public String formularioEdicao(@PathVariable Long id, Model model) {
        model.addAttribute("missao", missoesService.buscarPorId(id));
        return "editar-missao";
    }

    // Salvar edição
    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute("missao") MissoesModel missao) {
        missoesService.atualizarMissao(id, missao);
        return "redirect:/missoes/ui/listar";
    }

    // Detalhes da missão
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        model.addAttribute("missao", missoesService.buscarPorId(id));
        return "detalhes-missao";
    }

    // Deletar
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        missoesService.deletarMissoesPorId(id);
        return "redirect:/missoes/ui/listar";
    }
}
