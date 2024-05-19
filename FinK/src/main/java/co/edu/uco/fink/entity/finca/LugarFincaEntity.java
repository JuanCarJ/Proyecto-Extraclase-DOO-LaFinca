package co.edu.uco.fink.entity.finca;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.FincaDTO;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;
import co.edu.uco.fink.dto.fincas.TipoUbicacionDTO;

public class LugarFincaEntity {
    private int identificador;
    private TipoUbicacionEntity ubicacion;
    private String nomenclatura;
    private FincaEntity finca;

    public LugarFincaEntity(final int identificador) {
        setIdentificador(identificador);
        setUbicacion(TipoUbicacionEntity.build());
        setNomenclatura(TextHelper.EMPTY);
        setFinca(FincaEntity.build());
    }

    public LugarFincaEntity(final int identificador, final TipoUbicacionEntity ubicacion, final String nomenclatura, final FincaEntity finca) {
        setIdentificador(identificador);
        setUbicacion(ubicacion);
        setNomenclatura(nomenclatura);
        setFinca(finca);
    }

    public static final LugarFincaEntity build(final int identificador){
        return new LugarFincaEntity(identificador);
    }

    public static final LugarFincaEntity build(final int identificador, final TipoUbicacionEntity ubicacion, final String nomenclatura, final FincaEntity finca) {
        return new LugarFincaEntity(identificador, ubicacion, nomenclatura, finca);
    }

    protected static final LugarFincaEntity build() { return new LugarFincaEntity(NumericHelper.ZERO); }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final TipoUbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public final void setUbicacion(final TipoUbicacionEntity ubicacion) {
        this.ubicacion = ObjectHelper.getObjectHelper().getDefault(ubicacion, TipoUbicacionEntity.build());
    }

    public final String getNomenclatura() {
        return nomenclatura;
    }

    public final void setNomenclatura(final String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public final FincaEntity getFinca() {
        return finca;
    }

    public final void setFinca(FincaEntity finca) {
        this.finca = ObjectHelper.getObjectHelper().getDefault(finca, FincaEntity.build());
    }
}
