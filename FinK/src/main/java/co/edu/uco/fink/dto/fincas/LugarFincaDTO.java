package co.edu.uco.fink.dto.fincas;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class LugarFincaDTO {
    private int identificador;
    private String ubicacion;
    private String nomenclatura;
    private FincaDTO finca;

    public LugarFincaDTO() {
        setUbicacion(TextHelper.EMPTY);
        setNomenclatura(TextHelper.EMPTY);
        setFinca(FincaDTO.build());
    }

    public LugarFincaDTO(final int identificador, final String ubicacion, final String nomenclatura, final FincaDTO finca) {
        setIdentificador(identificador);
        setUbicacion(ubicacion);
        setNomenclatura(nomenclatura);
        setFinca(finca);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final LugarFincaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public static final LugarFincaDTO build(){
        return new LugarFincaDTO();
    }

    public final String  getUbicacion() {
        return ubicacion;
    }

    public final LugarFincaDTO setUbicacion(final String ubicacion) {
        this.ubicacion = TextHelper.applyTrim(ubicacion);
        return this;
    }

    public final String getNomenclatura() {
        return nomenclatura;
    }

    public final LugarFincaDTO setNomenclatura(final String nomenclatura) {
        this.nomenclatura = nomenclatura;
        return this;
    }

    public final FincaDTO getFinca() {
        return finca;
    }

    public final LugarFincaDTO setFinca(final FincaDTO finca) {
        this.finca = ObjectHelper.getObjectHelper().getDefault(finca, FincaDTO.build());
        return this;
    }
}
