package decoracao;

import central.ISensor;


public abstract class SensorDecorador implements ISensor {

    protected ISensor sensorDecorado;

    public SensorDecorador(ISensor sensor) {
        this.sensorDecorado = sensor;
    }


    @Override
    public double lerValor() {
        return sensorDecorado.lerValor();
    }

    @Override
    public String getTipo() {
        return sensorDecorado.getTipo();
    }
}