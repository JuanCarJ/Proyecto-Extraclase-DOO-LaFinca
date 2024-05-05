package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class EmpleadoEntity {

    private int identificador;
    private int documento;
    private String clave;
    private String nombre;
    private String telefono;
    private FincaEntity finca;
    private EstadoEmpleadoEntity estado;

    private EmpleadoEntity() {
        setDocumento(NumericHelper.ZERO);
        setClave(TextHelper.EMPTY);
        setNombre(TextHelper.EMPTY);
        setTelefono(TextHelper.EMPTY);
        setFinca(FincaEntity.build());
        setEstado(EstadoEmpleadoEntity.build());
    }

    private EmpleadoEntity(final int identificador, final int documento, final String clave, final String nombre, final String telefono, final FincaEntity finca, final EstadoEmpleadoEntity estado) {
        setIdentificador(identificador);
        setDocumento(documento);
        setClave(clave);
        setNombre(nombre);
        setTelefono(telefono);
        setFinca(finca);
        setEstado(estado);
    }

    public static final EmpleadoEntity build(){
        return new EmpleadoEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final EmpleadoEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final int getDocumento() {
        return documento;
    }

    public final EmpleadoEntity setDocumento(final int documento) {
        this.documento = documento;
        return this;
    }

    public final String getClave() {
        return clave;
    }

    public final EmpleadoEntity setClave(final String clave) {
        this.clave = TextHelper.applyTrim(clave);
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final EmpleadoEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final String getTelefono() {
        return telefono;
    }

    public final EmpleadoEntity setTelefono(final String telefono) {
        this.telefono = telefono;
        return this;
    }

    public final FincaEntity getFinca() {
        return finca;
    }

    public final EmpleadoEntity setFinca(final FincaEntity finca) {
        this.finca = ObjectHelper.getObjectHelper().getDefault(finca, FincaEntity.build());
        return this;
    }

    public EstadoEmpleadoEntity getEstado() {
        return estado;
    }

    public final EmpleadoEntity setEstado(final EstadoEmpleadoEntity estado) {
        this.estado = ObjectHelper.getObjectHelper().getDefault(estado, EstadoEmpleadoEntity.build());
        return this;
    }
}
