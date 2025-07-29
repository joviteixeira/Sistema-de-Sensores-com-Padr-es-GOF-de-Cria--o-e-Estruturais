package decoracao;

import central.ISensor;

public class AlertaDecorador extends SensorDecorador {
    private final double limite;

    public AlertaDecorador(ISensor sensor, double limite) {
        super(sensor);
        this.limite = limite;
    }

    @Override
    public double lerValor() {
        double valor = super.lerValor();

        if (valor > this.limite) {
            System.out.println("[ALERTA!] Sensor '" + getTipo() + "' ultrapassou o limite de " + limite + "! Valor: " + valor);
        }

        return valor;
    }
}