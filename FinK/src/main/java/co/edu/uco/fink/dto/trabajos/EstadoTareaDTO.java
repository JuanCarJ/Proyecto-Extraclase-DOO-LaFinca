package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public final class EstadoTareaDTO {

    private int identificador;

    private String tipo;

    public EstadoTareaDTO(){
        setTipo(TextHelper.EMPTY);
    }

    public EstadoTareaDTO(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final EstadoTareaDTO Build(){
        return new EstadoTareaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final EstadoTareaDTO setIdentificador(int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return tipo;
    }

    public final EstadoTareaDTO setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
        return this;
    }
}
