package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class EmpleadoEntity {
    private int identificador;
    private int documento;

    private EmpleadoEntity(final int identificador){
        setIdentificador(identificador);
        setDocumento(NumericHelper.ZERO);
    }

    private EmpleadoEntity(final int identificador, final int documento) {
        setIdentificador(identificador);
        setDocumento(documento);
    }

    public static final EmpleadoEntity Build(final int identificador){
        return new EmpleadoEntity(identificador);
    }

    public static final EmpleadoEntity Build(final int identificador, final int documento){
        return new EmpleadoEntity(identificador, documento);
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
}
