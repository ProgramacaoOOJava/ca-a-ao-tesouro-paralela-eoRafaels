import java.util.concurrent.Callable;

/**
 * Classe abstrata que representa um explorador na Caça ao Tesouro Paralela.
 * Define a estrutura básica para diferentes tipos de exploradores.
 */
public abstract class Explorador implements Callable<Double> {

    private String nome;
    private String tipo;
    private int nivel;
    private int energia;
    private int prioridade;
    private Missao missao;
    // private Tarefa tarefa;
    // protected Semaphore semaforo;

    // * Construtor que inicializa todos os atributos do explorador.
    public Explorador(String nome, String tipo, int prioridade, Missao missao
    // , Tarefa tarefa
    // , Semaphore semaforo
    ) {
        this.nome = nome;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.missao = missao;
        // this.tarefa = tarefa;
        // this.semaforo = semaforo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getEnergia() {
        return energia;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public Missao getMissao() {
        return missao;
    }

    // public Tarefa getTarefa() {
    // return tarefa;
    // }

    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     * Define como cada tipo de explorador executa sua tarefa.
     * 
     * @throws TarefaInvalidaException Se a tarefa for inválida
     */
    public abstract void executarTarefa() throws TarefaInvalidaException;

    public abstract Double executarMissao();

    @Override
    public Double call() throws Exception {
        return executarMissao();
    }

    /**
     * Exibe o status completo do explorador com formatação clara.
     */
    public void exibirStatus() {
        System.out.println("Explorador: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Missão: " + missao);
        // System.out.println("Tarefa: " + tarefa);
        System.out.println("-----------------------------");
    }

    // Getters para acesso aos atributos encapsulados

}
