import { useState } from 'react'
import axios from 'axios'
import styles from './FormularioEvento.module.css'

function FormularioEvento({ aoCadastrar }) {
  const [nome, setNome] = useState('')
  const [data, setData] = useState('')
  const [local, setLocal] = useState('')
  const [responsavel, setResponsavel] = useState('')
  const [tipo, setTipo] = useState('')
  const [situacao, setSituacao] = useState('ATIVO')
  const [carregando, setCarregando] = useState(false)
  const [sucesso, setSucesso] = useState('')
  const [erro, setErro] = useState('')

  function cadastrarEvento() {
    setSucesso('')
    setErro('')

    if (nome === '' || data === '' || local === '' || responsavel === '' || tipo === '') {
      setErro('Preencha todos os campos obrigatórios.')
      return
    }

    setCarregando(true)

    axios.post('http://localhost:8080/eventos', {
      nome: nome,
      data: data,
      local: local,
      responsavel: responsavel,
      tipo: tipo,
      situacao: situacao
    })
    .then(() => {
      setSucesso('Evento cadastrado com sucesso!')
      setNome('')
      setData('')
      setLocal('')
      setResponsavel('')
      setTipo('')
      setSituacao('ATIVO')
      aoCadastrar()
    })
    .catch((error) => {
      if (error.response && error.response.data) {
        setErro(error.response.data)
      } else {
        setErro('Não foi possível conectar com a API.')
      }
    })
    .finally(() => {
      setCarregando(false)
    })
  }

  return (
    <section className={styles.card}>
      <h2>Cadastro de Evento</h2>
      <div className={styles.formulario}>
        <div className={styles.campo}>
          <label>Nome do evento</label>
          <input
            type="text"
            value={nome}
            onChange={(event) => setNome(event.target.value)}
            placeholder="Ex: Workshop de Java"
          />
        </div>
        <div className={styles.campo}>
          <label>Data</label>
          <input type="date" value={data} onChange={(event) => setData(event.target.value)} />
        </div>
        <div className={styles.campo}>
          <label>Local</label>
          <input
            type="text"
            value={local}
            onChange={(event) => setLocal(event.target.value)}
            placeholder="Ex: São Paulo"
          />
        </div>
        <div className={styles.campo}>
          <label>Responsável</label>
          <input
            type="text"
            value={responsavel}
            onChange={(event) => setResponsavel(event.target.value)}
            placeholder="Nome do responsável"
          />
        </div>
        <div className={styles.campo}>
          <label>Tipo</label>
          <select value={tipo} onChange={(event) => setTipo(event.target.value)}>
            <option value="">Selecione</option>
            <option value="Workshop">Workshop</option>
            <option value="Palestra">Palestra</option>
            <option value="Curso">Curso</option>
            <option value="Festa">Festa</option>
            <option value="Outro">Outro</option>
          </select>
        </div>
        <div className={styles.campo}>
          <label>Situação</label>
          <select value={situacao} onChange={(event) => setSituacao(event.target.value)}>
            <option value="ATIVO">Ativo</option>
            <option value="INATIVO">Inativo</option>
          </select>
        </div>
      </div>
      <button className={styles.botao} onClick={cadastrarEvento} disabled={carregando}>
        {carregando ? 'Cadastrando...' : 'Cadastrar Evento'}
      </button>
      {sucesso !== '' && <p className={styles.sucesso}>{sucesso}</p>}
      {erro !== '' && <p className={styles.erro}>{erro}</p>}
    </section>
  )
}
export default FormularioEvento
