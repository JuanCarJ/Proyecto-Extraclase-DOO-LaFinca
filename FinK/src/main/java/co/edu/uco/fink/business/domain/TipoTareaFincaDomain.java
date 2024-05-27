package co.edu.uco.fink.business.domain;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTareaFincaDomain {

    private int identificador;
    private String tipo;

    private TipoTareaFincaDomain(){
        setIdentificador(identificador);
        setTipo(TextHelper.EMPTY);
    }

    private TipoTareaFincaDomain(int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public final int getIdentificador() {
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

    public static final TipoTareaFincaDomain crear(final int identificador,final String tipo){
        return new TipoTareaFincaDomain(identificador,tipo);
    }

    public static final TipoTareaFincaDomain crear(){
        return new TipoTareaFincaDomain();
    }
}

