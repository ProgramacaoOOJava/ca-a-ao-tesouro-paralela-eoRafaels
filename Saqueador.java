
public class Saqueador extends Explorador {

    public Saqueador(String nome, int prioridade, Missao missao) {
        super(nome, "Saqueador", prioridade, missao);
    }

    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        // Implementação específica para Saqueador
        System.out.println(getNome() + " está saqueando a área...");
        // Simulação de execução da tarefa
        try {
            Thread.sleep(1000); // Simula o tempo gasto para saquear
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(getNome() + " concluiu o saque.");
    }

    @Override
    public Double executarMissao() {
        // Implementação específica para Saqueador
        Missao missaoAtual = getMissao();
        System.out.println(getNome() + " está executando a missão de " + missaoAtual.getDescricao() + " na "
                + missaoAtual.getLocal() + "...");
        // Simulação de execução da missão
        try {
            Thread.sleep(2000); // Simula o tempo gasto para executar a missão
            System.out.println(getNome() + " concluiu a missão de " + missaoAtual.getDescricao() + " na "
                    + missaoAtual.getLocal() + "...");
            return missaoAtual.getDificuldade() * 1.5; // Retorna um valor fictício baseado na dificuldade da missão
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Retorna um valor fictício caso a missão não seja concluída
        return 0.0;
    }

}
