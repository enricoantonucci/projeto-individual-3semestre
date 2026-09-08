package br.com.sptech.eventos.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.sptech.eventos.model.Evento;

@Repository
public class EventoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Evento> mapper = (rs, n) -> new Evento(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("local"),
            rs.getString("responsavel"),
            rs.getString("tipo"),
            rs.getString("situacao"));

    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Evento> buscarTodos() {
        return jdbcTemplate.query("SELECT * FROM evento ORDER BY id DESC", mapper);
    }

    public int cadastrar(Evento e) {
        return jdbcTemplate.update(
                "INSERT INTO evento (nome, local, responsavel, tipo, situacao) VALUES (?, ?, ?, ?, ?)",
                e.getNome(),
                e.getLocal(),
                e.getResponsavel(),
                e.getTipo(),
                e.getSituacao());
    }
}
