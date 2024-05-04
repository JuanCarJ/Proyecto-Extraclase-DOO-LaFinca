package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoAlmacenDTO {
    private int identificador;

    private String tipo;

    public TipoAlmacenDTO(){
        setTipo(TextHelper.EMPTY);
    }

    public TipoAlmacenDTO(final int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoAlmacenDTO build(){
        return new TipoAlmacenDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoAlmacenDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return tipo;
    }

    public final TipoAlmacenDTO setTipo(final String tipo) {
        this.tipo = TextHelper.applyTrim(tipo);
        return this;
    }
}
