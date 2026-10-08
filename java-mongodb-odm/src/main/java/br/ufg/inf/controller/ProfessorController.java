package br.ufg.inf.controller;

import br.ufg.inf.model.Professor;
import br.ufg.inf.repository.ProfessorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorRepository repo;

    public ProfessorController(ProfessorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Professor> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Professor salvar(@RequestBody Professor e) {
        return repo.save(e);
    }
}
