package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.TareaFincaDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class TareaFincaPostgreSQLDAO extends SQLconnection implements TareaFincaDAO {

    public TareaFincaPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void actualizar(TareaFincaEntity entidad) {
        final var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE TareaFinca");
        sentenciaSQL.append("SET EmpleadoAsignado = ?");
        sentenciaSQL.append("WHERE identificador = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setInt(1, entidad.getEmpleadoAsignado().getDocumento());
            sentenciaPreparada.setInt(2, entidad.getIdentificador());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getDescripcion());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getDescripcion());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public List<TareaFincaEntity> consultar(TareaFincaEntity entidad) {
        final var listaTareas = new ArrayList<TareaFincaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT TF.id, TF.codigo, TF.descripcion, E.id, E.numerodocumento, E.estado, TT.id, TT.tipo, LF.id, LF.ubicacion, LF.nomenclatura, F.identificador, F.nombre ");
        sentenciaSql.append("FROM tareafinca TF JOIN empleado E ");
        sentenciaSql.append("ON TF.empleadoasignado = E.numerodocumento ");
        sentenciaSql.append("JOIN tipotareafinca TT ");
        sentenciaSql.append("ON TF.tipotrabajo = TT.tipo ");
        sentenciaSql.append("JOIN lugarfinca LF ");
        sentenciaSql.append("ON TF.lugar = concat_ws('-', LF.ubicacion, LF.nomenclatura, LF.finca) ");
        sentenciaSql.append("JOIN finca F ");
        sentenciaSql.append("ON LF.finca = F.nombre ");
        sentenciaSql.append("WHERE TF.tipotrabajo = ? ");
        sentenciaSql.append("ORDER BY TF.tipotrabajo ASC");



        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            sentenciaPreparada.setString(1, entidad.getTipoTrabajo().getTipo());
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<TareaFincaEntity> Tareas = new ArrayList<>();
                while (resultado.next()){
                    TareaFincaEntity tareaTMP = TareaFincaEntity.build(resultado.getInt("id"), EmpleadoEntity.Build(resultado.getInt("id"), resultado.getInt("numerodocumento"), resultado.getString("estado"), FincaEntity.Build(resultado.getInt("identificador"), resultado.getString("nombre"))), TipoTareaFincaEntity.build(resultado.getInt("id"), resultado.getString("tipo")), resultado.getInt("codigo"), LugarFincaEntity.build(resultado.getInt("id"), resultado.getString("ubicacion"), resultado.getString("nomenclatura"), FincaEntity.Build(resultado.getInt("identificador"), resultado.getString("nombre"))), resultado.getString("descripcion"));
                    listaTareas.add(tareaTMP);
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
        return listaTareas;
    }

    @Override
    public List<TareaFincaEntity> consultarEmpleado(TareaFincaEntity entidad) {
        return List.of();
    }

    @Override
    public void crear(TareaFincaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO TareaFinca(empleadoasignado, tipotrabajo, codigo, lugar, descripcion) ");
        sentenciaSql.append("VALUES(?, ?, ?, (SELECT string_agg(concat_ws('-', ubicacion, nomenclatura, finca), '') ");
        sentenciaSql.append("                 FROM lugarfinca ");
        sentenciaSql.append("                 WHERE lugarfinca.ubicacion = ? AND lugarfinca.nomenclatura = ? AND lugarfinca.finca = ?), ?)");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, entidad.getEmpleadoAsignado().getDocumento());
            sentenciaPreparada.setString(2, entidad.getTipoTrabajo().getTipo());
            sentenciaPreparada.setInt(3, entidad.getCodigo());
            sentenciaPreparada.setString(4, entidad.getLugar().getUbicacion());
            sentenciaPreparada.setString(5, entidad.getLugar().getNomenclatura());
            sentenciaPreparada.setString(6, entidad.getLugar().getFinca().getNombre());
            sentenciaPreparada.setString(7, entidad.getDescripcion());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getDescripcion());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getDescripcion());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
