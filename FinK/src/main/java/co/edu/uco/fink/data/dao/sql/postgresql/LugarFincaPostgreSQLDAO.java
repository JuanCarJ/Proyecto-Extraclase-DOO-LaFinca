package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.LugarFincaDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.FincaEntity;
import co.edu.uco.fink.entity.LugarFincaEntity;
import co.edu.uco.fink.entity.TipoSuministroEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class LugarFincaPostgreSQLDAO extends SQLconnection implements LugarFincaDAO {
    public LugarFincaPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<LugarFincaEntity> consultar(LugarFincaEntity entidad) {
        final var listaLugares = new ArrayList<LugarFincaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT LF.id, LF.ubicacion, LF.nomenclatura, F.identificador, F.nombre ");
        sentenciaSql.append("FROM lugarfinca LF JOIN finca F ");
        sentenciaSql.append("ON LF.finca = F.nombre ");
        sentenciaSql.append("ORDER BY id ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<LugarFincaEntity> Lugares = new ArrayList<>();
                while (resultado.next()){
                    LugarFincaEntity lugarTMP = LugarFincaEntity.build(resultado.getInt("id"), resultado.getString("ubicacion"), resultado.getString("nomenclatura"), FincaEntity.Build(resultado.getInt("identificador"), resultado.getString("nombre")));
                    listaLugares.add(lugarTMP);
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
        return listaLugares;
    }

    @Override
    public List<LugarFincaEntity> consultarEmpleado(LugarFincaEntity entidad) {
        return List.of();
    }
}
