package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class TipoAlmacenEntity {

    private int identificador;
    private String tipo;

    private TipoAlmacenEntity(final int identificador) {
        setIdentificador(identificador);
        setTipo(TextHelper.EMPTY);
    }

    private TipoAlmacenEntity(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoAlmacenEntity build(final int identificador){
        return new TipoAlmacenEntity(identificador);
    }

    public static final TipoAlmacenEntity build(final int identificador, final String tipo){
        return new TipoAlmacenEntity(identificador, tipo);
    }

    protected static final TipoAlmacenEntity build(){
        return new TipoAlmacenEntity(ZERO);
    }

    public int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getTipo() {
        return tipo;
    }

    private final void setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
    }
}
