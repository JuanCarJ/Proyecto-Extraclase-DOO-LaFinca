package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTrabajoDTO {
    private int identificador;

    private String tipo;

    public TipoTrabajoDTO(){
        setTipo(TextHelper.EMPTY);
    }

    public TipoTrabajoDTO(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTrabajoDTO build(){
        return new TipoTrabajoDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoTrabajoDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return tipo;
    }

    public final TipoTrabajoDTO setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
        return this;
    }
}
