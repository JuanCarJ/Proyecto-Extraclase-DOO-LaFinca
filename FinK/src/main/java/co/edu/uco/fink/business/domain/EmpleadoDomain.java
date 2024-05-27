package co.edu.uco.fink.business.domain;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class EmpleadoDomain {

    private int identificador;
    private int documento;
    private String estado;

    public EmpleadoDomain(final int identificador,final int documento, final String estado) {
        setIdentificador(identificador);
        setDocumento(documento);
        setEstado(estado);
    }

    private EmpleadoDomain (){
        setDocumento(NumericHelper.ZERO);
    }
    
    public final int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final int getDocumento() {
        return documento;
    }

    private final void setDocumento(final int documento) {
        this.documento = documento;
    }    

    public static final EmpleadoDomain crear(final int identificador,final int documento, final String estado){
        return new EmpleadoDomain(identificador,documento, estado);
    }

    public static final EmpleadoDomain crear(){
        return new EmpleadoDomain();
    }

    private void setEstado(final String estado) {
        this.estado = TextHelper.applyTrim(estado);
    }

    public final String getEstado() {
        return estado;
    }



}