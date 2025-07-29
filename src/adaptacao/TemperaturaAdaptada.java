package adaptacao;

import central.ISensor;
import legado.SensorTemperatura;


public class TemperaturaAdaptada implements ISensor {

    private final SensorTemperatura sensorLegado;

    public TemperaturaAdaptada(SensorTemperatura sensorLegado) {
        this.sensorLegado = sensorLegado;
    }

    @Override
    public double lerValor() {
        return this.sensorLegado.lerTemperatura();
    }

    @Override
    public String getTipo() {
        return "Temperatura";
    }
}