import java.util.*;
import java.util.concurrent.*;

public class SomaPontos extends RecursiveTask<Double> {
    private ArrayList<Double> pontos;

    public SomaPontos(ArrayList<Double> pontos) {
        this.pontos = pontos;
    }

    @Override
    protected Double compute() {
        if (pontos.size() <= 2) {
            Double soma = 0.0;
            for (Double ponto : pontos) {
                soma += ponto;
            }
            return soma;
        } else {
            int meio = pontos.size() / 2;
            SomaPontos tarefaEsquerda = new SomaPontos(new ArrayList<>(pontos.subList(0, meio)));
            SomaPontos tarefaDireita = new SomaPontos(new ArrayList<>(pontos.subList(meio, pontos.size())));
            tarefaEsquerda.fork();
            Double resultadoDireita = tarefaDireita.compute();
            Double resultadoEsquerda = tarefaEsquerda.join();
            return resultadoEsquerda + resultadoDireita;
        }
    }
}
