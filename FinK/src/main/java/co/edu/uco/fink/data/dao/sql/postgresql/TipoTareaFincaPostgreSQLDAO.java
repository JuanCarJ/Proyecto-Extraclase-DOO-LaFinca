package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.data.dao.TipoTareaFincaDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.TipoTareaFincaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class TipoTareaFincaPostgreSQLDAO extends SQLconnection implements TipoTareaFincaDAO {
    public TipoTareaFincaPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<TipoTareaFincaEntity> consultar(TipoTareaFincaEntity entidad) {
        final var listaTiposTarea = new ArrayList<TipoTareaFincaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT id, tipo ");
        sentenciaSql.append("FROM tipotareafinca ");
        sentenciaSql.append("ORDER BY tipo ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                while (resultado.next()){
                    TipoTareaFincaEntity tipoTareaTMP = TipoTareaFincaEntity.build(resultado.getInt("id"), resultado.getString("tipo"));
                    listaTiposTarea.add(tipoTareaTMP);
                }
            }
        } catch (final SQLException exception){
            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002));
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000028), "SELECT", "tipos de tareas", "tipotareafinca");
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataFinKException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002));
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000028), "SELECT", "tipos de tareas", "tipotareafinca");
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaTiposTarea;
    }

    @Override
    public List<TipoTareaFincaEntity> consultarEmpleado(TipoTareaFincaEntity entidad) {
        return List.of();
    }
}
