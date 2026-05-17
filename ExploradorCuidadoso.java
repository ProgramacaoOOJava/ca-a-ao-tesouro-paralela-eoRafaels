import java.util.concurrent.Semaphore;

/**
 * Explorador cuidadoso que executa tarefas com precisão e atenção aos detalhes.
 * Implementa Runnable para execução em thread separada.
 */
public class ExploradorCuidadoso extends Explorador implements Runnable {

    // * Construtor do explorador cuidadoso.
    public ExploradorCuidadoso(String nome, int prioridade, Tarefa tarefa, Semaphore semaforo) {
        super(nome, "Cuidadoso", prioridade, tarefa, semaforo);
    }

    /**
     * Implementação específica da execução de tarefa para exploradores cuidadosos.
     * Exploradores cuidadosos executam tarefas com mais cautela e precisão.
     * 
     * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
     */
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        if (getTarefa() == null || getTarefa().getDescricao().isEmpty()) {
            throw new TarefaInvalidaException("A tarefa não pode ser nula ou vazia.");
        }
        try {
            semaforo.acquire();

            System.out.println(getNome() + " começou a tarefa.");

            System.out
                    .println(getNome() + " está executando a tarefa: " + getTarefa().getDescricao() + " com cuidado!");

            Thread.sleep(2000);

            System.out.println(getNome() + " terminou a tarefa.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }

    /**
     * Método run() executado quando a thread é iniciada.
     * Trata exceções e chama executarTarefa().
     */
    @Override
    public void run() {
        try {
            executarTarefa();
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro ao executar a tarefa: " + e.getMessage());
        }
    }
}
