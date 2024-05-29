package co.edu.uco.fink.api.controller;

import co.edu.uco.fink.api.response.TareaFincaResponse;
import co.edu.uco.fink.business.fachade.concrete.CrearTareaFachadeImpl;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.trabajos.TareaFincaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/tareaFinca")
public final class TareaFincaController {

    @GetMapping("/dummy")
    public TareaFincaDTO getDummy(){ return TareaFincaDTO.Build(); }

    @PostMapping
    public ResponseEntity<TareaFincaResponse> crear(@RequestBody TareaFincaDTO tarea)
    {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var tareaResponse = new TareaFincaResponse();

        try{
            var fachade = new CrearTareaFachadeImpl();
            fachade.ejecutar(tarea);
            tareaResponse.getMensajes().add(TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000026)));
        }
        catch (FinKException exception){

            httpStatusCode = HttpStatus.BAD_REQUEST;
            tareaResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        }
        catch (Exception exception){
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema registrando la información de la nueva tarea.";
            tareaResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(tareaResponse, httpStatusCode);
    }
}
