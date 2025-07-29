package decoracao;

import central.ISensor;

public class LogDecorador extends SensorDecorador {

    public LogDecorador(ISensor sensor) {
        super(sensor);
    }

    @Override
    public double lerValor() {

        double valor = super.lerValor();

        System.out.println("[LOG] Sensor '" + getTipo() + "' leu o valor: " + valor);

        return valor;
    }
}
