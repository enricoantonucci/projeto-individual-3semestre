package br.com.sptech.eventos.repository;

import br.com.sptech.eventos.model.Evento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventoRepository {

    private final JdbcTemplate jdbcTemplate;

    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Evento> mapper = (rs, rowNum) -> new Evento(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getDate("data").toLocalDate(),
            rs.getString("local"),
            rs.getString("responsavel"),
            rs.getString("tipo"),
            rs.getString("situacao"));

    public List<Evento> buscarTodos() {
        return jdbcTemplate.query("SELECT * FROM evento ORDER BY id DESC", mapper);
    }

    public int cadastrar(Evento evento) {
        return jdbcTemplate.update(
                "INSERT INTO evento (nome,data,local,responsavel,tipo,situacao) VALUES (?,?,?,?,?,?)",
                evento.getNome(), evento.getData(), evento.getLocal(), evento.getResponsavel(),
                evento.getTipo(), evento.getSituacao());
    }
}
