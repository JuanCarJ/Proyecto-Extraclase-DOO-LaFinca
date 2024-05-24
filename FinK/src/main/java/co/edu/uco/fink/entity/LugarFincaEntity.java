package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class LugarFincaEntity {
    private int identificador;
    private String ubicacion;
    private String nomenclatura;
    private String finca;

    private LugarFincaEntity(final int identificador) {
        setIdentificador(identificador);
        setUbicacion(TextHelper.EMPTY);
        setNomenclatura(TextHelper.EMPTY);
        setFinca(TextHelper.EMPTY);
    }

    private LugarFincaEntity(final int identificador, final String ubicacion, final String nomenclatura, final String finca) {
        setIdentificador(identificador);
        setUbicacion(ubicacion);
        setNomenclatura(nomenclatura);
        setFinca(finca);
    }

    public static final LugarFincaEntity build(final int identificador){
        return new LugarFincaEntity(identificador);
    }

    public static final LugarFincaEntity build(final int identificador, final String ubicacion, final String nomenclatura, final String finca) {
        return new LugarFincaEntity(identificador, ubicacion, nomenclatura, finca);
    }

    protected static final LugarFincaEntity build() { return new LugarFincaEntity(NumericHelper.ZERO); }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getUbicacion() {
        return ubicacion;
    }

    public final void setUbicacion(final String ubicacion) {
        this.ubicacion = TextHelper.applyTrim(ubicacion);
    }

    public final String getNomenclatura() {
        return nomenclatura;
    }

    public final void setNomenclatura(final String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public final String getFinca() {
        return finca;
    }

    public final void setFinca(final String finca) {
        this.finca = TextHelper.applyTrim(finca);
    }
}
