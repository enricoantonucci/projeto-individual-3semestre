import { useEffect, useState } from 'react';
import axios from 'axios';
import styles from './ListaEventos.module.css';

function ListaEventos({ atualizarLista }) {
  const [eventos, setEventos] = useState([]);
  const [carregando, setCarregando] = useState(false);
  const [erro, setErro] = useState('');

  function buscarEventos() {
    setCarregando(true);
    setErro('');

    axios
      .get('http://localhost:8080/eventos')
      .then((resposta) => {
        setEventos(resposta.data);
        setCarregando(false);
      })
      .catch(() => {
        setErro('Erro ao buscar os eventos. Verifique se a API está ligada.');
        setCarregando(false);
      });
  }

  useEffect(() => {
    buscarEventos();
  }, [atualizarLista]);

  return (
    <section className={styles.card}>
      <div className={styles.titulo}>
        <h2>Eventos Cadastrados</h2>
        <button onClick={buscarEventos}>Atualizar</button>
      </div>

      {carregando && <p>Carregando eventos...</p>}
      {erro !== '' && <p className={styles.erro}>{erro}</p>}
      {!carregando && erro === '' && eventos.length === 0 && <p>Nenhum evento cadastrado.</p>}

      <div className={styles.lista}>
        {eventos.map((evento) => (
          <article className={styles.evento} key={evento.id}>
            <h3>{evento.nome}</h3>
            <p>
              <strong>Local:</strong> {evento.local}
            </p>
            <p>
              <strong>Responsável:</strong> {evento.responsavel}
            </p>
            <p>
              <strong>Tipo:</strong> {evento.tipo}
            </p>
            <p>
              <strong>Situação:</strong> {evento.situacao}
            </p>
          </article>
        ))}
      </div>
    </section>
  );
}

export default ListaEventos;
