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
    protected TareaFincaPostgreSQLDAO(final Connection connection) {
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
        sentenciaSql.append("SELECT TF.Identificador, TF.Codigo, TF.Descripcion, E.Identificador, E.NumeroDocumento, TT.Identificador, TT.Tipo, LF.ID, LF.Ubicacion, LF.Nomenclatura, LF.Finca ");
        sentenciaSql.append("FROM TareaFinca TF JOIN Empleado E ");
        sentenciaSql.append("ON TF.EmpleadoAsignado = E.Documento");
        sentenciaSql.append("JOIN TipoTrabajo TT");
        sentenciaSql.append("ON TF.TipoTrabajo = TT.Tipo");
        sentenciaSql.append("JOIN LugarFinca LF");
        sentenciaSql.append("ON TF.Lugar = LF.Identificador");
        sentenciaSql.append("WHERE TF.tipotrabajo = ?");
        sentenciaSql.append("ORDER BY TipoTrabajo ASC");



        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            sentenciaPreparada.setString(1, entidad.getTipoTrabajo().getTipo());
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<TareaFincaEntity> Tareas = new ArrayList<>();
                while (resultado.next()){
                    TareaFincaEntity tareaTMP = TareaFincaEntity.build(resultado.getInt("TF.Identificador"), EmpleadoEntity.Build(resultado.getInt("E.Identificador"), resultado.getInt("E.NumeroDocumento")), TipoTareaFincaEntity.build(resultado.getInt("TT.Identificador"), resultado.getString("TT.Tipo")), resultado.getInt("Codigo"), LugarFincaEntity.build(resultado.getInt("LF.ID"), resultado.getString("LF.Ubicacion"), resultado.getString("LF.Nomenclatura"), resultado.getString("LF.Finca")), resultado.getString("TF.Descripcion"));
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
    public void crear(TareaFincaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO TareaFinca(EmpleadoAsignado, TipoTrabajo, Codigo, Lugar, Descripcion");
        sentenciaSql.append("VALUES(?, ?, ?, ?, ?)");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, entidad.getEmpleadoAsignado().getDocumento());
            sentenciaPreparada.setString(2, entidad.getTipoTrabajo().getTipo());
            sentenciaPreparada.setInt(3, entidad.getCodigo());
            sentenciaPreparada.setInt(4, entidad.getLugar().getIdentificador());
            sentenciaPreparada.setString(5, entidad.getDescripcion());
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
