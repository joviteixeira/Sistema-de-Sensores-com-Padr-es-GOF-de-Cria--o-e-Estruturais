package main;

import controlador.SensorControlador;
import decoracao.AlertaDecorador;
import decoracao.LogDecorador;
import factory.SensorFactory;
import central.ISensor;
import decoracao.FormatadorDecorador;

public class Main {
    public static void main(String[] args) {
        System.out.println("### Sistema de Sensores Refatorado ###");

        SensorControlador controlador = SensorControlador.getInstance();
        controlador.adicionarSensor("temperatura");
        controlador.adicionarSensor("umidade");
        controlador.adicionarSensor("luminosidade");

        controlador.exibirDadosDeTodosOsSensores();

        System.out.println("\n-----------------------------------------------------\n");

        System.out.println("### Demonstração de Composição Manual ###\n");

        SensorFactory factory = new SensorFactory();

        System.out.println("--- Criando Sensor de Temperatura com Log e Alerta ---");
        ISensor sensorTemp = factory.criarSensor("temperatura");
        ISensor sensorTempComLog = new LogDecorador(sensorTemp);
        ISensor sensorTempComAlerta = new AlertaDecorador(sensorTempComLog, 25.0);

        FormatadorDecorador sensorFinal = new FormatadorDecorador(sensorTempComAlerta);


        System.out.println("Resultado: " + sensorFinal.getValorFormatado());
    }
}