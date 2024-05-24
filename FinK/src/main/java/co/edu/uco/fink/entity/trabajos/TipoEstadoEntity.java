package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.trabajos.TipoEstadoDTO;

public class TipoEstadoEntity {
    private int identificador;
    private String tipo;

    public TipoEstadoEntity(final int identificador){
        setIdentificador(identificador);
        setTipo(TextHelper.EMPTY);
    }

    public TipoEstadoEntity(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoEstadoEntity Build(final int identificador){
        return new TipoEstadoEntity(identificador);
    }

    public static final TipoEstadoEntity build(final int identificador, final String tipo) {
        return new TipoEstadoEntity(identificador, tipo);
    }

    protected static final TipoEstadoEntity build() {
        return new TipoEstadoEntity(NumericHelper.ZERO);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public final String getTipo() {
        return tipo;
    }

    public final void setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
    }
}
