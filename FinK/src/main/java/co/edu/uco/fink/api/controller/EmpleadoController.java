package co.edu.uco.fink.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.fink.api.response.EmpleadoResponse;
import co.edu.uco.fink.business.fachade.concrete.ConsultarEmpleadoFachadaImpl;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    @GetMapping("/dummy")
    public EmpleadoDTO getDummy(){
        return EmpleadoDTO.build();
    }

    @GetMapping
    public ResponseEntity<EmpleadoResponse> consultar(
            @RequestParam(required = false,defaultValue = "") int Identificador,
            @RequestParam(required = false, defaultValue = "")int NumeroDocumento,
            @RequestParam(required = false,defaultValue = "") String Clave,
            @RequestParam(required = false, defaultValue = "")String Nombre,
            @RequestParam(required = false,defaultValue = "") String Telefono,
            @RequestParam(required = false, defaultValue = "")String Finca,
            @RequestParam(required = false, defaultValue = "")String Estado){
                EmpleadoResponse empleadoResponse = EmpleadoResponse.build();
        HttpStatus httpStatusResponse = HttpStatus.OK;

        try {
            final var EmpleadoDTOFilter = EmpleadoDTO.build().setDocumento(NumeroDocumento).setEstado(Estado);
            final ConsultarEmpleadoFachadaImpl fachada = new ConsultarEmpleadoFachadaImpl();
            empleadoResponse.setDatos(fachada.execute(EmpleadoDTOFilter));
            empleadoResponse.getMensajes().add("Empleado consultado exitosamente");
        } catch (final FinKException exception){
            exception.printStackTrace();
            empleadoResponse.getMensajes().add(exception.getMensajeUsuario());
            httpStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception){
            exception.printStackTrace();
            empleadoResponse.getMensajes().add("se ha presentado un problema inesperado");
            httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(empleadoResponse, httpStatusResponse);
    }    

}
