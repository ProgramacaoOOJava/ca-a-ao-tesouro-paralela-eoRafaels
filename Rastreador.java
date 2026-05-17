
public class Rastreador extends Explorador {

    public Rastreador(String nome, int prioridade, Missao missao) {
        super(nome, "Rastreador", prioridade, missao);
    }

    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        // Implementação específica para Rastreador
        System.out.println(getNome() + " está rastreando a área...");
        // Simulação de execução da tarefa
        try {
            Thread.sleep(1000); // Simula o tempo gasto para rastrear
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(getNome() + " concluiu o rastreamento.");
    }

    @Override
    public Double executarMissao() {
        // Implementação específica para Rastreador
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
