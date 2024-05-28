package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TareaFincaEntity {
    private int identificador;
    private EmpleadoEntity empleadoAsignado;
    private TipoTareaFincaEntity tipoTrabajo;
    private int codigo;
    private LugarFincaEntity lugar;
    private String descripcion;

    private TareaFincaEntity(final int identificador){
        setEmpleadoAsignado(EmpleadoEntity.Build());
        setTipoTrabajo(TipoTareaFincaEntity.build());
        setCodigo(NumericHelper.ZERO);
        setLugar(LugarFincaEntity.build());
        setDescripcion(TextHelper.EMPTY);
    }

    private TareaFincaEntity(final int identificador, final EmpleadoEntity empleadoAsignado, final TipoTareaFincaEntity tipoTrabajo, final int codigo, final LugarFincaEntity lugar, final String descripcion) {
        setIdentificador(identificador);
        setEmpleadoAsignado(empleadoAsignado);
        setTipoTrabajo(tipoTrabajo);
        setCodigo(codigo);
        setLugar(lugar);
        setDescripcion(descripcion);
    }

    public static final TareaFincaEntity Build(final int identificador){
        return new TareaFincaEntity(identificador);
    }

    public static final TareaFincaEntity build(final int identificador, final EmpleadoEntity empleadoAsignado, final TipoTareaFincaEntity tipoTrabajo, final int codigo, final LugarFincaEntity lugar, final String descripcion) {
        return new TareaFincaEntity(identificador, empleadoAsignado, tipoTrabajo, codigo, lugar, descripcion);
    }

    protected static final TareaFincaEntity build() {
        return new TareaFincaEntity(NumericHelper.ZERO);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final EmpleadoEntity getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public final void setEmpleadoAsignado(final EmpleadoEntity empleadoAsignado) {
        this.empleadoAsignado = ObjectHelper.getObjectHelper().getDefault(empleadoAsignado, EmpleadoEntity.Build());
    }

    public final TipoTareaFincaEntity getTipoTrabajo() {
        return tipoTrabajo;
    }

    public final void setTipoTrabajo(final TipoTareaFincaEntity tipoTrabajo) {
        this.tipoTrabajo = ObjectHelper.getObjectHelper().getDefault(tipoTrabajo, TipoTareaFincaEntity.build());
    }

    public final int getCodigo() {
        return codigo;
    }

    public final void setCodigo(final int codigo) {
        this.codigo = codigo;
    }

    public final LugarFincaEntity getLugar() {
        return lugar;
    }

    public final void setLugar(final LugarFincaEntity lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaEntity.build());
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
}
