package controlador;

import central.ISensor;
import display.Display;
import factory.SensorFactory;
import decoracao.FormatadorDecorador;

import java.util.ArrayList;
import java.util.List;


public class SensorControlador {

    private static SensorControlador instancia;

    private final SensorFactory factory;
    private final List<ISensor> sensores;
    private final Display display;

    private SensorControlador() {

        this.factory = new SensorFactory();
        this.sensores = new ArrayList<>();
        this.display = new Display();
    }

    public static synchronized SensorControlador getInstance() {
        if (instancia == null) {
            instancia = new SensorControlador();
        }
        return instancia;
    }


    public void adicionarSensor(String tipo) {
        try {
            ISensor sensor = factory.criarSensor(tipo);
            this.sensores.add(sensor);
            System.out.println("INFO: Sensor do tipo '" + tipo + "' adicionado ao controlador.");
        } catch (IllegalArgumentException e) {

            System.err.println("ERRO: Falha ao adicionar sensor. " + e.getMessage());
        }
    }

    public void exibirDadosDeTodosOsSensores() {
        System.out.println("\n--- Lendo dados de todos os sensores gerenciados ---");
        if (sensores.isEmpty()) {
            System.out.println("Nenhum sensor está sendo gerenciado no momento.");
            return;
        }

        for (ISensor sensor : sensores) {

            FormatadorDecorador formatador = new FormatadorDecorador(sensor);
            display.mostrarDados(formatador.getTipo(), formatador.getValorFormatado());
        }
    }
}
