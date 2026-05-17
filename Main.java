import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();

        ExploradorRapido exploradorRapido1 = new ExploradorRapido("Rápido", 10, "Encontrar o mapa do tesouro");
        ExploradorCuidadoso exploradorCuidadoso1 = new ExploradorCuidadoso("Cuidadoso", 1, "Decifrar o código do baú");
        ExploradorRapido exploradorRapido2 = new ExploradorRapido("Rápido 2", 10, "Desarmar armadilhas");
        ExploradorCuidadoso exploradorCuidadoso2 = new ExploradorCuidadoso("Cuidadoso 2", 1, "Analisar pistas antigas");

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
