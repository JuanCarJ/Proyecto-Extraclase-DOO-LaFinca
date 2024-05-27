package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.RegistroEstadoTareaDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroEstadoTareaPostgreSQLDAO extends SQLconnection implements RegistroEstadoTareaDAO {
    protected RegistroEstadoTareaPostgreSQLDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<RegistroEstadoTareaEntity> consultar(RegistroEstadoTareaEntity entidad) {
        final var listaSuministros = new ArrayList<RegistroEstadoTareaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT RE.Identificador, T.Identificador, E.Identificador, E.Tipo, RE.FechaActualizacion");
        sentenciaSql.append("FROM RegistroEstadoTarea SR JOIN Tarea T ");
        sentenciaSql.append("ON RE.Tarea = T.Identificador");
        sentenciaSql.append("JOIN TipoEstado E");
        sentenciaSql.append("ON RE.Estado = E.Tipo");
        sentenciaSql.append("ORDER BY RE.Identificador ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<RegistroEstadoTareaEntity> Tareas = new ArrayList<>();
                while (resultado.next()){
                    RegistroEstadoTareaEntity suministroTMP = RegistroEstadoTareaEntity.build(resultado.getInt("RE.Identificador"), TareaFincaEntity.Build(resultado.getInt("T.Identificador")), TipoEstadoEntity.build(resultado.getInt("E.Identificador"), resultado.getString("E.Tipo")),(resultado.getDate("RE.FechaActualización").toLocalDate()).atStartOfDay());
                    listaSuministros.add(suministroTMP);
                }
            }
        } catch (final SQLException exception){
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los países. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la finca";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataFinKException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los países. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la finca";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaSuministros;
    }

    @Override
    public void crear(RegistroEstadoTareaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO RegistroEstadoTarea(Identificador, Tarea, Estado, FechaActualizacion) ");
        sentenciaSql.append("VALUES(?, ?, ?, ?)");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, entidad.getIdentificador());
            sentenciaPreparada.setInt(2, entidad.getTarea().getIdentificador());
            sentenciaPreparada.setString(3, entidad.getEstado().getTipo());
            sentenciaPreparada.setDate(4, Date.valueOf((entidad.getFechaActualizacion()).toLocalDate()));
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getEstado().getTipo());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getEstado().getTipo());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
