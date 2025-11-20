package br.com.escola.curso.controller;

import br.com.escola.curso.model.Curso;
import br.com.escola.curso.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", cursoService.listarTodos());
        return "admin/listar";
    }

    @GetMapping("/novo")
    public String formulario(Curso curso) {
        return "admin/formulario";
    }

    @PostMapping
    public String salvar(@Valid Curso curso, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/formulario";
        }
        cursoService.salvar(curso);
        return "redirect:/admin/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Curso curso = cursoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso inválido: " + id));
        model.addAttribute("curso", curso);
        return "admin/formulario";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Curso curso = cursoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso inválido: " + id));
        model.addAttribute("curso", curso);
        return "admin/detalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        cursoService.excluir(id);
        return "redirect:/admin/cursos";
    }
}