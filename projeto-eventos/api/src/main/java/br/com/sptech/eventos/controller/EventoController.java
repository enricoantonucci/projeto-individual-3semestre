package br.com.sptech.eventos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sptech.eventos.model.Evento;
import br.com.sptech.eventos.repository.EventoRepository;

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
    public ResponseEntity<?> cadastrar(@RequestBody Evento e) {
        String erro = validar(e);

        if (erro != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
        }

        repository.cadastrar(e);
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }

    private String validar(Evento e) {
        if (e == null) {
            return "Evento inválido.";
        }
        if (vazio(e.getNome())) {
            return "O nome é obrigatório.";
        }
        if (vazio(e.getLocal())) {
            return "O local é obrigatório.";
        }
        if (vazio(e.getResponsavel())) {
            return "O responsável é obrigatório.";
        }
        if (vazio(e.getTipo())) {
            return "O tipo é obrigatório.";
        }
        if (!"ATIVO".equals(e.getSituacao()) && !"INATIVO".equals(e.getSituacao())) {
            return "A situação deve ser ATIVO ou INATIVO.";
        }
        return null;
    }

    private boolean vazio(String s) {
        return s == null || s.isBlank();
    }
}
