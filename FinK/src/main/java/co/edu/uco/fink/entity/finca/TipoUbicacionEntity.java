package co.edu.uco.fink.entity.finca;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.TipoUbicacionDTO;

public class TipoUbicacionEntity {
    private int identificador;

    private String Lugar;

    public TipoUbicacionEntity(final int identificador){
        setIdentificador(identificador);
        setLugar(TextHelper.EMPTY);
    }

    public TipoUbicacionEntity(final int identificador, final String lugar) {
        setIdentificador(identificador);
        setLugar(lugar);
    }

    public static final TipoUbicacionEntity build(final int identificador){
        return new TipoUbicacionEntity(identificador);
    }

    public static final TipoUbicacionEntity build(final int identificador, final String lugar) {
        return new TipoUbicacionEntity(identificador, lugar);
    }

    protected static final TipoUbicacionEntity build() { return new TipoUbicacionEntity(NumericHelper.ZERO); }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getLugar() {
        return Lugar;
    }

    public final void setLugar(final String lugar) {
        Lugar = TextHelper.applyTrim(lugar);
    }
}
