import java.util.ArrayList;
import java.util.concurrent.*;

public class CacaAoTesouroParalela {
    public static void main(String[] args) {

        ArrayList<Explorador> exploradores = new ArrayList<>();

        Missao missao1 = new Missao("Encontrar o mapa do tesouro", "Ilha Misteriosa", 5);
        Missao missao2 = new Missao("Decifrar o código do baú", "Caverna Secreta", 3);
        Missao missao3 = new Missao("Analisar pistas antigas", "Biblioteca Antiga", 2);
        Missao missao4 = new Missao("Desarmar armadilhas", "Floresta Perigosa", 4);

        Saqueador exploradorSaqueador1 = new Saqueador("Saqueador 1", 10, missao1);
        Rastreador exploradorRastreador1 = new Rastreador("Rastreador 1", 1, missao2);
        Rastreador exploradorRastreador2 = new Rastreador("Rastreador 2", 10, missao3);
        Saqueador exploradorSaqueador2 = new Saqueador("Saqueador 2", 1, missao4);

        exploradores.add(exploradorSaqueador1);
        exploradores.add(exploradorRastreador1);
        exploradores.add(exploradorRastreador2);
        exploradores.add(exploradorSaqueador2);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        ArrayList<Future<Double>> futures = new ArrayList<>();
        for (Explorador explorador : exploradores) {
            Future<Double> future = executor.submit(explorador);
            futures.add(future);
        }

        ArrayList<Double> pontosObtidos = new ArrayList<>();

        for (int i = 0; i < futures.size(); i++) {
            try {
                Double pontos = futures.get(i).get();
                pontosObtidos.add(pontos);
                System.out.println(
                        "Pontos Obtidos por "
                                + exploradores.get(i).getNome()
                                + ": "
                                + pontos);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrompida.");
            } catch (ExecutionException e) {
                System.out.println("Erro durante execução: " + e.getCause());
            }
        }

        SomaPontos somaPontos = new SomaPontos(pontosObtidos);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Double totalPontos = forkJoinPool.invoke(somaPontos);

        System.out.println("Total de Pontos Obtidos: " + totalPontos);

        executor.shutdown();

        // ArrayList<Thread> threads = new ArrayList<>();

        // Tarefa tarefa1 = new Tarefa("Encontrar o mapa do tesouro", "Ilha Misteriosa",
        // 5);
        // Tarefa tarefa2 = new Tarefa("Decifrar o código do baú", "Caverna Secreta",
        // 3);
        // Tarefa tarefa3 = new Tarefa("Desarmar armadilhas", "Floresta Perigosa", 4);
        // Tarefa tarefa4 = new Tarefa("Analisar pistas antigas", "Biblioteca Antiga",
        // 2);

        // Semaphore semaforo = new Semaphore(2, true); // Semáforo para controlar o
        // acesso às tarefas

        // ExploradorRapido exploradorRapido1 = new ExploradorRapido("Rápido", 10,
        // tarefa1, semaforo);
        // ExploradorCuidadoso exploradorCuidadoso1 = new
        // ExploradorCuidadoso("Cuidadoso", 1,
        // tarefa2, semaforo);
        // ExploradorRapido exploradorRapido2 = new ExploradorRapido("Rápido 2", 10,
        // tarefa3, semaforo);
        // ExploradorCuidadoso exploradorCuidadoso2 = new ExploradorCuidadoso("Cuidadoso
        // 2", 1, tarefa4, semaforo);

        // Thread threadExploradorRapido1 = new Thread(exploradorRapido1);
        // Thread threadExploradorCuidadoso1 = new Thread(exploradorCuidadoso1);
        // Thread threadExploradorRapido2 = new Thread(exploradorRapido2);
        // Thread threadExploradorCuidadoso2 = new Thread(exploradorCuidadoso2);

        // threadExploradorRapido1.setPriority(exploradorRapido1.getPrioridade());
        // threadExploradorCuidadoso1.setPriority(exploradorCuidadoso1.getPrioridade());
        // threadExploradorRapido2.setPriority(exploradorRapido2.getPrioridade());
        // threadExploradorCuidadoso2.setPriority(exploradorCuidadoso2.getPrioridade());

        // threadExploradorCuidadoso2.setDaemon(true);

        // threads.add(threadExploradorRapido1);
        // threads.add(threadExploradorCuidadoso1);
        // threads.add(threadExploradorRapido2);
        // threads.add(threadExploradorCuidadoso2);

        // for (Thread thread : threads) {
        // thread.start();
        // }
    }
}