package co.edu.uco.fink.business.domain;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TareaFincaDomain {

    private int identificador;
    private EmpleadoDomain empleadoAsignado;
    private TipoTareaFincaDomain tipoTrabajo;
    private int codigo;
    private LugarFincaDomain lugar;
    private String descripcion;

    private TareaFincaDomain(){
        setEmpleadoAsignado(EmpleadoDomain.crear());
        setTipoTrabajo(TipoTareaFincaDomain.crear());
        setCodigo(NumericHelper.ZERO);
        setLugar(LugarFincaDomain.crear());
        setDescripcion(TextHelper.EMPTY);
    }

    private TareaFincaDomain(final int identificador, final EmpleadoDomain empleadoAsignado, final TipoTareaFincaDomain tipoTrabajo, final int codigo, final LugarFincaDomain lugar, final String descripcion) {
        setIdentificador(identificador);
        setEmpleadoAsignado(empleadoAsignado);
        setTipoTrabajo(tipoTrabajo);
        setCodigo(codigo);
        setLugar(lugar);
        setDescripcion(descripcion);
    }

    public final int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final EmpleadoDomain getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    private final void setEmpleadoAsignado(final EmpleadoDomain empleadoAsignado) {
        this.empleadoAsignado = ObjectHelper.getObjectHelper().getDefault(empleadoAsignado, EmpleadoDomain.crear());
    }

    public final TipoTareaFincaDomain getTipoTrabajo() {
        return tipoTrabajo;
    }

    private final void setTipoTrabajo(final TipoTareaFincaDomain tipoTrabajo) {
        this.tipoTrabajo = ObjectHelper.getObjectHelper().getDefault(tipoTrabajo, TipoTareaFincaDomain.crear());
    }

    public final int getCodigo() {
        return codigo;
    }

    private final void setCodigo(final int codigo) {
        this.codigo = codigo;
    }

    public final LugarFincaDomain getLugar() {
        return lugar;
    }

    private final void setLugar(final LugarFincaDomain lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaDomain.crear());
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public static final TareaFincaDomain crear(final int identificador, final EmpleadoDomain empleadoAsignado, final TipoTareaFincaDomain tipoTrabajo, final int codigo, final LugarFincaDomain lugar, final String descripcion){
        return new TareaFincaDomain(identificador,empleadoAsignado,tipoTrabajo,codigo,lugar,descripcion);
    }

    public static final TareaFincaDomain crear(){
        return new TareaFincaDomain();
    }


}

