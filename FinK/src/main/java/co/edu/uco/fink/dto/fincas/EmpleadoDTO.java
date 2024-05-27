package co.edu.uco.fink.dto.fincas;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class EmpleadoDTO {

    private int identificador;

    private int documento;

    private String estado;

    public EmpleadoDTO(){
        setDocumento(NumericHelper.ZERO);
        setEstado(TextHelper.EMPTY);
    }

    public EmpleadoDTO(final int identificador, final int documento, final String estado) {
        setIdentificador(identificador);
        setDocumento(documento);
        setEstado(TextHelper.EMPTY);
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

    public final String getEstado() {
        return estado;
    }

    public final EmpleadoDTO setEstado(final String estado) {
        this.estado = TextHelper.applyTrim(estado);
        return this;
    }
}
