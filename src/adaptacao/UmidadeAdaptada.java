package adaptacao;

import central.ISensor;
import legado.SensorUmidade;


public class UmidadeAdaptada implements ISensor {
    private final SensorUmidade sensorLegado;

    public UmidadeAdaptada(SensorUmidade sensorLegado) {
        this.sensorLegado = sensorLegado;
    }

    @Override
    public double lerValor() {
        return this.sensorLegado.lerUmidade();
    }

    @Override
    public String getTipo() {
        return "Umidade";
    }
}