package co.edu.uco.fink.dto.fincas;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class EmpleadoDTO {

    private int identificador;

    private int documento;

    private String clave;

    private String nombre;

    private String telefono;

    private FincaDTO finca;

    private EstadoEmpleadoDTO estado;

    public EmpleadoDTO(){
        setDocumento(NumericHelper.ZERO);
        setClave(TextHelper.EMPTY);
        setNombre(TextHelper.EMPTY);
        setTelefono(TextHelper.EMPTY);
        setFinca(FincaDTO.build());
        setEstado(EstadoEmpleadoDTO.build());
    }

    public EmpleadoDTO(final int identificador, final int documento, final String clave, final String nombre, final String telefono, final FincaDTO finca, final EstadoEmpleadoDTO estado) {
        setIdentificador(identificador);
        setDocumento(documento);
        setClave(clave);
        setNombre(nombre);
        setTelefono(telefono);
        setFinca(finca);
        setEstado(estado);
    }

    public static final EmpleadoDTO build(){
        return new EmpleadoDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final EmpleadoDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final int getDocumento() {
        return documento;
    }

    public final EmpleadoDTO setDocumento(final int documento) {
        this.documento = documento;
        return this;
    }

    public final String getClave() {
        return clave;
    }

    public final EmpleadoDTO setClave(final String clave) {
        this.clave = TextHelper.applyTrim(clave);
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final EmpleadoDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final String getTelefono() {
        return telefono;
    }

    public final EmpleadoDTO setTelefono(final String telefono) {
        this.telefono = telefono;
        return this;
    }

    public final FincaDTO getFinca() {
        return finca;
    }

    public final EmpleadoDTO setFinca(final FincaDTO finca) {
        this.finca = ObjectHelper.getObjectHelper().getDefault(finca, FincaDTO.build());
        return this;
    }

    public EstadoEmpleadoDTO getEstado() {
        return estado;
    }

    public final EmpleadoDTO setEstado(final EstadoEmpleadoDTO estado) {
        this.estado = ObjectHelper.getObjectHelper().getDefault(estado, EstadoEmpleadoDTO.build());
        return this;
    }
}
