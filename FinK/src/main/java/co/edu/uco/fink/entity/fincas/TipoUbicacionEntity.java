package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public class TipoUbicacionEntity {
    private int identificador;
    private String lugar;

    private TipoUbicacionEntity(){
        setLugar(TextHelper.EMPTY);
    }

    private TipoUbicacionEntity(final int identificador, final String lugar) {
        setIdentificador(identificador);
        setLugar(lugar);
    }

    public static final TipoUbicacionEntity build(){
        return new TipoUbicacionEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoUbicacionEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getLugar() {
        return lugar;
    }

    public final TipoUbicacionEntity setLugar(final String lugar) {
        this.lugar = TextHelper.applyTrim(lugar);
        return this;
    }
}
