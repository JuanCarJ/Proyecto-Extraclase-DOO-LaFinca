package co.edu.uco.fink.api.controller;


import co.edu.uco.fink.api.response.AlmacenProducidoResponse;
import co.edu.uco.fink.business.fachade.concrete.CrearAlmacenProducidoFachadeImpl;
import co.edu.uco.fink.business.fachade.concrete.ObtenerAlmacenesFachadeImpl;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.almacenamiento.AlmacenProducidoDTO;
import co.edu.uco.fink.dto.fincas.FincaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/almacenProducido")
public class AlmacenProducidoController {

    @GetMapping("/dummy")
    public AlmacenProducidoDTO getDummy(){ return AlmacenProducidoDTO.build(); }

    @GetMapping("/obtener")
    public ResponseEntity<AlmacenProducidoResponse> obtener(@RequestBody  FincaDTO finca){
        var httpStatusCode = HttpStatus.ACCEPTED;
        var almacenResponse = new AlmacenProducidoResponse();

        try {
            var fachade = new ObtenerAlmacenesFachadeImpl();
            almacenResponse.setDatos(fachade.ejecutar(finca));
        } catch (final FinKException exception){
            exception.printStackTrace();
            almacenResponse.getMensajes().add(exception.getMensajeUsuario());
            httpStatusCode = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception){
            exception.printStackTrace();
            almacenResponse.getMensajes().add(TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000030), "la pagina"));
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(almacenResponse, httpStatusCode);
    }

    @PostMapping("/crear")
    public ResponseEntity<AlmacenProducidoResponse> crear(@RequestBody AlmacenProducidoDTO almacen)
    {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var almacenResponse = new AlmacenProducidoResponse();

        try{
            var fachade = new CrearAlmacenProducidoFachadeImpl();
            fachade.ejecutar(almacen);
            almacenResponse.getMensajes().add(TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000026)));
        }
        catch (FinKException exception){

            httpStatusCode = HttpStatus.BAD_REQUEST;
            almacenResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        }
        catch (Exception exception){
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000032));
            almacenResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(almacenResponse, httpStatusCode);
    }
}
