import { useState } from 'react';
import FormularioEvento from './componentes/FormularioEvento';
import ListaEventos from './componentes/ListaEventos';
import styles from './App.module.css';

function App() {
  const [atualizarLista, setAtualizarLista] = useState(0);

  function eventoCadastrado() {
    setAtualizarLista(atualizarLista + 1);
  }

  return (
    <main className={styles.container}>
      <header className={styles.header}>
        <h1>Sistema de Eventos</h1>
        <p>Cadastre e visualize os eventos.</p>
      </header>

      <FormularioEvento aoCadastrar={eventoCadastrado} />
      <ListaEventos atualizarLista={atualizarLista} />
    </main>
  );
}

export default App;
