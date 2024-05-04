package co.edu.uco.fink.dto.fincas;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public final class FincaDTO {

    private int identificador;
    private String nombre;
    private String direccion;
    private ciudadDTO ciudad;
    private String correo;
    private String telefono;

    public FincaDTO(){
        setNombre(TextHelper.EMPTY);
        setDireccion(TextHelper.EMPTY);
        setCiudad(ciudadDTO.build());
        setCorreo(TextHelper.EMPTY);
        setTelefono(TextHelper.EMPTY);
    }

    public FincaDTO(final int identificador, final String nombre, final String direccion, final ciudadDTO ciudad, final String correo, final String telefono) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDireccion(direccion);
        setCiudad(ciudad);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public static final FincaDTO build(){
        return new FincaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final FincaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final FincaDTO setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public final String getDireccion() {
        return direccion;
    }

    public final FincaDTO setDireccion(final String direccion) {
        this.direccion = direccion;
        return this;
    }

    public final ciudadDTO getCiudad() {
        return ciudad;
    }

    public final FincaDTO setCiudad(final ciudadDTO ciudad) {
        this.ciudad = ObjectHelper.getObjectHelper().getDefault(ciudad, ciudadDTO.build());
        return this;
    }

    public final String getCorreo() {
        return correo;
    }

    public final FincaDTO setCorreo(final String correo) {
        this.correo = TextHelper.applyTrim(correo);
        return this;
    }

    public final String getTelefono() {
        return telefono;
    }

    public final FincaDTO setTelefono(final String telefono) {
        this.telefono = telefono;
        return this;
    }
}
