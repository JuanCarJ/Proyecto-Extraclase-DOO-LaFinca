package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.EmpleadoDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.FincaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class EmpleadoPostgreSQLDAO extends SQLconnection implements EmpleadoDAO {

    public EmpleadoPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public final List<EmpleadoEntity> consultar(final EmpleadoEntity entidad) {
        final var listaEmpleados = new ArrayList<EmpleadoEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT E.id, E.numerodocumento, E.estado, F.identificador, F.nombre ");
        sentenciaSql.append("FROM empleado E JOIN finca F ");
        sentenciaSql.append("ON E.finca = F.nombre ");
        sentenciaSql.append("ORDER BY numerodocumento ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<EmpleadoEntity> Empleados = new ArrayList<>();
                while (resultado.next()){
                    EmpleadoEntity EmpleadoTMP = EmpleadoEntity.Build(resultado.getInt("identificador"), resultado.getInt("numerodocumento"), resultado.getString("estado"), FincaEntity.Build(resultado.getInt("identificador"), resultado.getString("nombre")));
                    listaEmpleados.add(EmpleadoTMP);
                }
            }
        } catch (final SQLException exception){
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los empleados. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataFinKException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los empleados. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaEmpleados;
    }

    @Override
    public final List<EmpleadoEntity> consultarEmpleado(final EmpleadoEntity entidad) {
        return null;
    }


    
}
