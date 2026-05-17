import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class CacaAoTesouroParalela {
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();

        Tarefa tarefa1 = new Tarefa("Encontrar o mapa do tesouro", "Ilha Misteriosa", 5);
        Tarefa tarefa2 = new Tarefa("Decifrar o código do baú", "Caverna Secreta", 3);
        Tarefa tarefa3 = new Tarefa("Desarmar armadilhas", "Floresta Perigosa", 4);
        Tarefa tarefa4 = new Tarefa("Analisar pistas antigas", "Biblioteca Antiga", 2);

        Semaphore semaforo = new Semaphore(2, true); // Semáforo para controlar o acesso às tarefas

        ExploradorRapido exploradorRapido1 = new ExploradorRapido("Rápido", 10, tarefa1, semaforo);
        ExploradorCuidadoso exploradorCuidadoso1 = new ExploradorCuidadoso("Cuidadoso", 1,
                tarefa2, semaforo);
        ExploradorRapido exploradorRapido2 = new ExploradorRapido("Rápido 2", 10, tarefa3, semaforo);
        ExploradorCuidadoso exploradorCuidadoso2 = new ExploradorCuidadoso("Cuidadoso 2", 1, tarefa4, semaforo);

        Thread threadExploradorRapido1 = new Thread(exploradorRapido1);
        Thread threadExploradorCuidadoso1 = new Thread(exploradorCuidadoso1);
        Thread threadExploradorRapido2 = new Thread(exploradorRapido2);
        Thread threadExploradorCuidadoso2 = new Thread(exploradorCuidadoso2);

        threadExploradorRapido1.setPriority(exploradorRapido1.getPrioridade());
        threadExploradorCuidadoso1.setPriority(exploradorCuidadoso1.getPrioridade());
        threadExploradorRapido2.setPriority(exploradorRapido2.getPrioridade());
        threadExploradorCuidadoso2.setPriority(exploradorCuidadoso2.getPrioridade());

        threadExploradorCuidadoso2.setDaemon(true);

        threads.add(threadExploradorRapido1);
        threads.add(threadExploradorCuidadoso1);
        threads.add(threadExploradorRapido2);
        threads.add(threadExploradorCuidadoso2);

        for (Thread thread : threads) {
            thread.start();
        }
    }
}