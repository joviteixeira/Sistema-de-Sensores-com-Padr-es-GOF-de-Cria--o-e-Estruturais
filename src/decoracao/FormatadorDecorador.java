package decoracao;

import central.ISensor;

public class FormatadorDecorador extends SensorDecorador {

    public FormatadorDecorador(ISensor sensor) {
        super(sensor);
    }

    public String getValorFormatado() {
        double valor = this.lerValor();
        String tipo = this.getTipo();

        switch (tipo) {
            case "Temperatura":
                return String.format("%.1f °C", valor);
            case "Umidade":
                return String.format("%.1f %%", valor);
            case "Luminosidade":
                return String.format("%d lux", (int) valor);
            default:
                return String.valueOf(valor);
        }
    }
}