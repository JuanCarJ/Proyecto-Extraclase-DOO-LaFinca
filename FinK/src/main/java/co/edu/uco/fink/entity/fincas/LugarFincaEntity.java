package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;

public class LugarFincaEntity {
    private int identificador;
    private TipoUbicacionEntity ubicacion;
    private String nomenclatura;
    private FincaEntity finca;

    public final int getIdentificador() {
        return identificador;
    }

    public final LugarFincaEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public static final LugarFincaEntity build(){
        return new LugarFincaEntity();
    }

    public final TipoUbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public final LugarFincaEntity setUbicacion(final TipoUbicacionEntity ubicacion) {
        this.ubicacion = ObjectHelper.getObjectHelper().getDefault(ubicacion, TipoUbicacionEntity.build());
        return this;
    }

    public final String getNomenclatura() {
        return nomenclatura;
    }

    public final LugarFincaEntity setNomenclatura(final String nomenclatura) {
        this.nomenclatura = nomenclatura;
        return this;
    }

    public final FincaEntity getFinca() {
        return finca;
    }

    public final LugarFincaEntity setFinca(FincaEntity finca) {
        this.finca = ObjectHelper.getObjectHelper().getDefault(finca, FincaEntity.build());
        return this;
    }
}
