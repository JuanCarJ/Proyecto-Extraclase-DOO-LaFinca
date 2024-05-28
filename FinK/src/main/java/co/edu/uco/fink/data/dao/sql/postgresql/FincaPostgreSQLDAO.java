package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.FincaDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.FincaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FincaPostgreSQLDAO extends SQLconnection implements FincaDAO {

    public FincaPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<FincaEntity> consultar(FincaEntity entidad) {
        final var listaFincas = new ArrayList<FincaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT identificador, nombre ");
        sentenciaSql.append("FROM finca ");
        sentenciaSql.append("ORDER BY nombre ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                while (resultado.next()){
                    FincaEntity fincaTMP = FincaEntity.Build(resultado.getInt("identificador"), resultado.getString("nombre"));
                    listaFincas.add(fincaTMP);
                }
            }
        } catch (final SQLException exception){
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de las Fincas. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataFinKException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de las Fincas. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaFincas;
    }

    @Override
    public List<FincaEntity> consultarEmpleado(FincaEntity entidad) {
        return List.of();
    }
}
