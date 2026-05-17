/**
 * Explorador rápido que executa tarefas com alta velocidade e eficiência.
 * Implementa Runnable para execução em thread separada.
 */
public class ExploradorRapido extends Explorador implements Runnable {

    // * Construtor do explorador rápido.
    public ExploradorRapido(String nome, int prioridade, String tarefa) {
        super(nome, "Rápido", prioridade, tarefa);
    }

    /**
     * Implementação específica da execução de tarefa para exploradores rápidos.
     * Exploradores rápidos executam tarefas com maior agilidade.
     * 
     * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
     */
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        if (getTarefa() == null || getTarefa().isEmpty()) {
            throw new TarefaInvalidaException("A tarefa não pode ser nula ou vazia.");
        }
        System.out.println(getNome() + " está executando a tarefa: " + getTarefa() + " com rapidez!");
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
