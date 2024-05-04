package co.edu.uco.fink.dto.fincas;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoUbicacionDTO {
    private int identificador;

    private String Lugar;

    public TipoUbicacionDTO(){
        setLugar(TextHelper.EMPTY);
    }

    public TipoUbicacionDTO(final int identificador, final String lugar) {
        setIdentificador(identificador);
        setLugar(lugar);
    }

    public static final TipoUbicacionDTO build(){
        return new TipoUbicacionDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoUbicacionDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getLugar() {
        return Lugar;
    }

    public final TipoUbicacionDTO setLugar(final String lugar) {
        Lugar = TextHelper.applyTrim(lugar);
        return this;
    }
}
