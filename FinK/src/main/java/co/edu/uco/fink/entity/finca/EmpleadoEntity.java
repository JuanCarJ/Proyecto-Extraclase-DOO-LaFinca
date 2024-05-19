package co.edu.uco.fink.entity.finca;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;
import co.edu.uco.fink.dto.fincas.EstadoEmpleadoDTO;
import co.edu.uco.fink.dto.fincas.FincaDTO;

public class EmpleadoEntity {
    private int identificador;
    private int documento;
    private String clave;
    private String nombre;
    private String telefono;
    private FincaEntity finca;
    private EstadoEmpleadoEntity estado;

    private EmpleadoEntity(final int identificador){
        setIdentificador(identificador);
        setDocumento(NumericHelper.ZERO);
        setClave(TextHelper.EMPTY);
        setNombre(TextHelper.EMPTY);
        setTelefono(TextHelper.EMPTY);
        setFinca(FincaEntity.build());
        setEstado(EstadoEmpleadoEntity.Build());
    }

    public EmpleadoEntity(final int identificador, final int documento, final String clave, final String nombre, final String telefono, final FincaEntity finca, final EstadoEmpleadoEntity estado) {
        setIdentificador(identificador);
        setDocumento(documento);
        setClave(clave);
        setNombre(nombre);
        setTelefono(telefono);
        setFinca(finca);
        setEstado(estado);
    }

    public static final EmpleadoEntity Build(final int identificador){
        return new EmpleadoEntity(identificador);
    }

    public static final EmpleadoEntity Build(final int identificador, final int documento, final String clave, final String nombre, final String telefono, final FincaEntity finca, final EstadoEmpleadoEntity estado){
        return new EmpleadoEntity(identificador, documento, clave, nombre, telefono, finca, estado);
    }

    protected static final EmpleadoEntity Build(){
        return new EmpleadoEntity(NumericHelper.ZERO);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final int getDocumento() {
        return documento;
    }

    public final void setDocumento(final int documento) {
        this.documento = documento;
    }

    public final String getClave() {
        return clave;
    }

    public final void setClave(final String clave) {
        this.clave = TextHelper.applyTrim(clave);
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public final String getTelefono() {
        return telefono;
    }

    public final void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    public final FincaEntity getFinca() {
        return finca;
    }

    public final void setFinca(final FincaEntity finca) {
        this.finca = ObjectHelper.getObjectHelper().getDefault(finca, FincaEntity.build());
    }

    public EstadoEmpleadoEntity getEstado() {
        return estado;
    }

    public final void setEstado(final EstadoEmpleadoEntity estado) {
        this.estado = ObjectHelper.getObjectHelper().getDefault(estado, EstadoEmpleadoEntity.Build());
    }
}
