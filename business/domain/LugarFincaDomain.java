package co.edu.uco.fink.business.domain;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class LugarFincaDomain {

    private int identificador;
    private String ubicacion;
    private String nomenclatura;
    private String finca;

    private LugarFincaDomain() {
        setIdentificador(identificador);
        setUbicacion(TextHelper.EMPTY);
        setNomenclatura(TextHelper.EMPTY);
        setFinca(TextHelper.EMPTY);
    }

    private LugarFincaDomain(final int identificador, final String ubicacion, final String nomenclatura, final String finca) {
        setIdentificador(identificador);
        setUbicacion(ubicacion);
        setNomenclatura(nomenclatura);
        setFinca(finca);
    }
      
    public final int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getUbicacion() {
        return ubicacion;
    }

    private final void setUbicacion(final String ubicacion) {
        this.ubicacion = TextHelper.applyTrim(ubicacion);
    }

    public final String getNomenclatura() {
        return nomenclatura;
    }

    private final void setNomenclatura(final String nomenclatura) {
        this.nomenclatura = TextHelper.applyTrim(nomenclatura);
    }

    public final String getFinca() {
        return finca;
    }

    private final void setFinca(final String finca) {
        this.finca = TextHelper.applyTrim(finca);
    }

    public static final LugarFincaDomain crear(final int identificador, final String ubicacion, final String nomenclatura, final String finca){
        return new LugarFincaDomain(identificador, ubicacion, nomenclatura, finca);
    }

    public static final LugarFincaDomain crear(){
        return new LugarFincaDomain();
    }


}

