package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.TipoSuministroDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.TipoSuministroEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class TipoSuministroPostgreSQLDAO extends SQLconnection implements TipoSuministroDAO {
    public TipoSuministroPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public final List<TipoSuministroEntity> consultar(final TipoSuministroEntity entidad) {
        final var listaSuministros = new ArrayList<TipoSuministroEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT ID, Nombre, UnidadMedida ");
        sentenciaSql.append("FROM TipoSuministro ");
        sentenciaSql.append("ORDER BY Nombre ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<TipoSuministroEntity> Suministros = new ArrayList<>();
                while (resultado.next()){
                    TipoSuministroEntity SuministroTMP = TipoSuministroEntity.build(resultado.getInt("ID"), resultado.getString("Nombre"), resultado.getString("UnidadMedida"));
                    listaSuministros.add(SuministroTMP);
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
}
