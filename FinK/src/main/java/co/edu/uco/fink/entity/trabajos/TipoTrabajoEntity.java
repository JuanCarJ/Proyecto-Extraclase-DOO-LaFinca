package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTrabajoEntity {
    private int identificador;
    private String tipo;

    private TipoTrabajoEntity(){
        setTipo(TextHelper.EMPTY);
    }

    private TipoTrabajoEntity(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTrabajoEntity build(){
        return new TipoTrabajoEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoTrabajoEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return tipo;
    }

    public final TipoTrabajoEntity setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
        return this;
    }
}
