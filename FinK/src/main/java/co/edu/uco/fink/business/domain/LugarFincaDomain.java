package co.edu.uco.fink.business.domain;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class LugarFincaDomain {

    private int identificador;
    private String ubicacion;
    private String nomenclatura;
    private FincaDomain finca;

    private LugarFincaDomain() {
        setIdentificador(identificador);
        setUbicacion(TextHelper.EMPTY);
        setNomenclatura(TextHelper.EMPTY);
        setFinca(FincaDomain.Crear());
    }

    private LugarFincaDomain(final int identificador, final String ubicacion, final String nomenclatura, final FincaDomain finca) {
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

    public final FincaDomain getFinca() {
        return finca;
    }

    private final void setFinca(final FincaDomain finca) {
        this.finca = ObjectHelper.getObjectHelper().getDefault(finca, FincaDomain.Crear());
    }

    public static final LugarFincaDomain crear(final int identificador, final String ubicacion, final String nomenclatura, final FincaDomain finca){
        return new LugarFincaDomain(identificador, ubicacion, nomenclatura, finca);
    }

    public static final LugarFincaDomain crear(){
        return new LugarFincaDomain();
    }


}

