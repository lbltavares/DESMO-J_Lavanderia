import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.TimeInstant;

public class App {

    // Definição do tempo de simulação.
    private static double tempoSimulacao = 5000;

    public static void main(String[] args) {

        Lavanderia modeloLavanderia;
        Experiment experimento;

        // Criação do modelo da lavanderia.
        modeloLavanderia = new Lavanderia(null, "Modelo de uma lavanderia self-service", true, true);

        // Criação do experimento da lavanderia self-service.
        experimento = new Experiment("Experimento da lavanderia");

        // Conecta o modelo da lavanderia ao experimento.
        modeloLavanderia.connectToExperiment(experimento);

        // Determinação dos parâmetros do experimento:

        // Indica que, durante a simulação, uma barra de progresso deve ser mostrada.
        experimento.setShowProgressBar(true);

        // Indica quando a simulação deve ser interrompida.
        // Em nossa simulação, a unidade de tempo será um minuto.
        experimento.stop(new TimeInstant(tempoSimulacao));

        // Indica o período durante o qual as informações da simulação devem ser
        // armazenadas no trace da simulação.
        experimento.tracePeriod(new TimeInstant(0.0), new TimeInstant(tempoSimulacao));

        // Inicia o experimento no instante zero da simulação.
        experimento.start();

        // Gera um relatório, e outros arquivos de saída, relacionados ao modelo
        // conectado ao experimento.
        experimento.report();

        // Interrompe todos os eventos que ainda estão escalonados e fecha todos os
        // arquivos de saída.
        experimento.finish();
        
        System.exit(0);
    }
}
