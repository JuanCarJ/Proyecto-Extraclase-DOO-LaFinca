package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;

public class TareaFincaDTO {

    private int identificador;
    private EmpleadoDTO empleadoAsignado;
    private TipoTareaFincaDTO tipoTrabajo;
    private int codigo;
    private LugarFincaDTO lugar;
    private String descripcion;

    public TareaFincaDTO(){
        setEmpleadoAsignado(EmpleadoDTO.build());
        setTipoTrabajo(TipoTareaFincaDTO.build());
        setCodigo(NumericHelper.ZERO);
        setLugar(LugarFincaDTO.build());
        setDescripcion(TextHelper.EMPTY);
    }

    public TareaFincaDTO(final int identificador, final EmpleadoDTO empleadoAsignado, final TipoTareaFincaDTO tipoTrabajo, final int codigo, final LugarFincaDTO lugar, final String descripcion) {
        setIdentificador(identificador);
        setEmpleadoAsignado(empleadoAsignado);
        setTipoTrabajo(tipoTrabajo);
        setCodigo(codigo);
        setLugar(lugar);
        setDescripcion(descripcion);
    }

    public static final TareaFincaDTO Build(){
        return new TareaFincaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TareaFincaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final EmpleadoDTO getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public final TareaFincaDTO setEmpleadoAsignado(final EmpleadoDTO empleadoAsignado) {
        this.empleadoAsignado = ObjectHelper.getObjectHelper().getDefault(empleadoAsignado, EmpleadoDTO.build());
        return this;
    }

    public final TipoTareaFincaDTO getTipoTrabajo() {
        return tipoTrabajo;
    }

    public final TareaFincaDTO setTipoTrabajo(final TipoTareaFincaDTO tipoTrabajo) {
        this.tipoTrabajo = ObjectHelper.getObjectHelper().getDefault(tipoTrabajo, TipoTareaFincaDTO.build());
        return this;
    }

    public final int getCodigo() {
        return codigo;
    }

    public final TareaFincaDTO setCodigo(final int codigo) {
        this.codigo = codigo;
        return this;
    }

    public final LugarFincaDTO getLugar() {
        return lugar;
    }

    public final TareaFincaDTO setLugar(final LugarFincaDTO lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaDTO.build());
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final TareaFincaDTO setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
