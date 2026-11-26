package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("tarefas/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    // EXERCICIO 1
    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        Contato cont = contatoService.save(contato);
        return ResponseEntity.ok(cont);
    }

    // EXERCICIO 2
    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        Contato cont = contatoService.getById(id);
        return ResponseEntity.ok(cont);
    }

    // EXERCICIO 3
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Contato> getContatoByNome(@PathVariable("nome") String nome) {
        Contato cont = contatoService.getContatoByNome(nome);
        return ResponseEntity.ok(cont);
    }

    // EXERCICIO 4
    @GetMapping
    public ResponseEntity<Integer> getQuantidadeDeContatos() {
        Integer contatos = contatoService.getAll();
        return ResponseEntity.ok(contatos);
    }

    // EXERCICIO 5
    @GetMapping("data/{data}")
    public ResponseEntity<List<Contato>> getContatosByDataNascimento(@PathVariable LocalDate data) {
        List<Contato> contatos = contatoService.getByDataNascimento(data);
        return ResponseEntity.ok(contatos);
    }

    // EXERCICIO 6
    @PatchMapping("/{id}")
    public ResponseEntity<Contato> updateContatoById(@PathVariable Long id, @RequestBody Contato contato) {
        Contato cont = contatoService.update(id, contato);
        return ResponseEntity.ok(cont);
    }

    // EXERCICIO 7
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        String msg = contatoService.delete(id);
        return ResponseEntity.ok(msg);
    }
}
