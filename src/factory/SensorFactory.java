package factory;

import adaptacao.LuminosidadeAdaptada;
import adaptacao.TemperaturaAdaptada;
import adaptacao.UmidadeAdaptada;
import central.ISensor;
import legado.SensorLuminosidade;
import legado.SensorTemperatura;
import legado.SensorUmidade;


public class SensorFactory {

    public ISensor criarSensor(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("O tipo de sensor não pode ser nulo ou vazio.");
        }

        switch (tipo.toLowerCase()) {
            case "temperatura":

                return new TemperaturaAdaptada(new SensorTemperatura());

            case "umidade":
                return new UmidadeAdaptada(new SensorUmidade());

            case "luminosidade":
                return new LuminosidadeAdaptada(new SensorLuminosidade());

            default:

                throw new IllegalArgumentException("Tipo de sensor desconhecido: " + tipo);
        }
    }
}
