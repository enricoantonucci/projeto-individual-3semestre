package br.com.sptech.eventos.controller;

import br.com.sptech.eventos.model.Evento;
import br.com.sptech.eventos.repository.EventoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoRepository repository;

    public EventoController(EventoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Evento>> buscarTodos() {
        return ResponseEntity.ok(repository.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Evento evento) {
        String erro = validar(evento);

        if (erro != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
        }

        repository.cadastrar(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }

    private String validar(Evento evento) {
        if (evento == null) {
            return "Evento inválido.";
        }

        if (vazio(evento.getNome())) {
            return "O nome é obrigatório.";
        }

        if (evento.getData() == null) {
            return "A data é obrigatória.";
        }

        if (vazio(evento.getLocal())) {
            return "O local é obrigatório.";
        }

        if (vazio(evento.getResponsavel())) {
            return "O responsável é obrigatório.";
        }

        if (vazio(evento.getTipo())) {
            return "O tipo é obrigatório.";
        }

        if (!"ATIVO".equals(evento.getSituacao()) && !"INATIVO".equals(evento.getSituacao())) {
            return "A situação deve ser ATIVO ou INATIVO.";
        }

        return null;
    }

    private boolean vazio(String valor) {
        return valor == null || valor.isBlank();
    }
}