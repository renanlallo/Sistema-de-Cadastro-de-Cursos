package br.com.escola.curso.controller;

import br.com.escola.curso.model.Curso;
import br.com.escola.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PublicController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cursos", cursoService.listarTodos());
        return "public/index";
    }

    @GetMapping("/cursos/{id}")
    public String detalhesPublico(@PathVariable Long id, Model model) {
        Curso curso = cursoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso inválido: " + id));
        model.addAttribute("curso", curso);
        return "public/detalhes";
    }

}
