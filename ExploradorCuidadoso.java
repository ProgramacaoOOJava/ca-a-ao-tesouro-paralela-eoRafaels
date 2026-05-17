/**
 * Explorador cuidadoso que executa tarefas com precisão e atenção aos detalhes.
 * Implementa Runnable para execução em thread separada.
 */
public class ExploradorCuidadoso extends Explorador implements Runnable {

    // * Construtor do explorador cuidadoso.
    public ExploradorCuidadoso(String nome, int prioridade, String tarefa) {
        super(nome, "Cuidadoso", prioridade, tarefa);
    }

    /**
     * Implementação específica da execução de tarefa para exploradores cuidadosos.
     * Exploradores cuidadosos executam tarefas com mais cautela e precisão.
     * 
     * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
     */
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        if (getTarefa() == null || getTarefa().isEmpty()) {
            throw new TarefaInvalidaException("A tarefa não pode ser nula ou vazia.");
        }
        System.out.println(getNome() + " está executando a tarefa: " + getTarefa() + " com cuidado!");
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
