package adaptacao;

import central.ISensor;
import legado.SensorLuminosidade;


public class LuminosidadeAdaptada implements ISensor {
    private final SensorLuminosidade sensorLegado;

    public LuminosidadeAdaptada(SensorLuminosidade sensorLegado) {
        this.sensorLegado = sensorLegado;
    }

    @Override
    public double lerValor() {
        return this.sensorLegado.lerLuminosidade();
    }

    @Override
    public String getTipo() {
        return "Luminosidade";
    }
}