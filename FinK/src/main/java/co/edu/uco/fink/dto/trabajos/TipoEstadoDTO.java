package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public final class TipoEstadoDTO {

    private int identificador;

    private String tipo;

    public TipoEstadoDTO(){
        setTipo(TextHelper.EMPTY);
    }

    public TipoEstadoDTO(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoEstadoDTO Build(){
        return new TipoEstadoDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoEstadoDTO setIdentificador(int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return tipo;
    }

    public final TipoEstadoDTO setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
        return this;
    }
}
