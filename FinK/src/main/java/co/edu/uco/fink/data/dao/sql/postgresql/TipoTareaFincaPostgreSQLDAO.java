package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.TipoTareaFincaDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.TareaFincaEntity;
import co.edu.uco.fink.entity.TipoSuministroEntity;
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
        sentenciaSql.append("SELECT Identificador, Tipo ");
        sentenciaSql.append("FROM TipoTareaFinca ");
        sentenciaSql.append("ORDER BY Tipo ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<TipoTareaFincaEntity> Suministros = new ArrayList<>();
                while (resultado.next()){
                    TipoTareaFincaEntity tipoTareaTMP = TipoTareaFincaEntity.build(resultado.getInt("Identificador"), resultado.getString("Tipo"));
                    listaTiposTarea.add(tipoTareaTMP);
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
        return listaTiposTarea;
    }
}
