package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class EstadoTareaEntity {

    private int identificador;
    private String tipo;

    public EstadoTareaEntity(){
        setTipo(TextHelper.EMPTY);
    }

    public EstadoTareaEntity(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final EstadoTareaEntity build(){
        return new EstadoTareaEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final EstadoTareaEntity setIdentificador(int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return tipo;
    }

    public final EstadoTareaEntity setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
        return this;
    }
}
