// import java.util.concurrent.Semaphore;

// /**
// * Explorador rápido que executa tarefas com alta velocidade e eficiência.
// * Implementa Runnable para execução em thread separada.
// */
// public class ExploradorRapido extends Explorador implements Runnable {

// // * Construtor do explorador rápido.
// public ExploradorRapido(String nome, int prioridade, Tarefa tarefa, Semaphore
// semaforo) {
// super(nome, "Rápido", prioridade, tarefa, semaforo);
// }

// /**
// * Implementação específica da execução de tarefa para exploradores rápidos.
// * Exploradores rápidos executam tarefas com maior agilidade.
// *
// * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
// */
// @Override
// public void executarTarefa() throws TarefaInvalidaException {
// if (getTarefa() == null || getTarefa().getDescricao().isEmpty()) {
// throw new TarefaInvalidaException("A tarefa não pode ser nula ou vazia.");
// }
// try {
// semaforo.acquire();

// System.out.println(getNome() + " começou a tarefa.");

// System.out
// .println(getNome() + " está executando a tarefa: " +
// getTarefa().getDescricao() + " com rapidez!");

// Thread.sleep(2000);

// System.out.println(getNome() + " terminou a tarefa.");

// } catch (InterruptedException e) {
// e.printStackTrace();
// } finally {
// semaforo.release();
// }
// }

// @Override
// public void executarMissao() {
// System.out.println(getNome() + " está executando a missão com rapidez...");
// try {
// Thread.sleep(2000); // Simula o tempo gasto para executar a missão
// } catch (InterruptedException e) {
// Thread.currentThread().interrupt();
// }
// System.out.println(getNome() + " concluiu a missão com rapidez.");
// }

// /**
// * Método run() executado quando a thread é iniciada.
// * Trata exceções e chama executarTarefa().
// */
// @Override
// public void run() {
// try {
// executarTarefa();
// } catch (TarefaInvalidaException e) {
// System.out.println("Erro ao executar a tarefa: " + e.getMessage());
// }
// }
// }
