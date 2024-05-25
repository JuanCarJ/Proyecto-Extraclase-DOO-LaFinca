package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.data.dao.SuministroRequeridoDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class SuministroRequeridoPostgreSQLDAO extends SQLconnection implements SuministroRequeridoDAO {

    public SuministroRequeridoPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void actualizar(SuministroRequeridoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE SuministroRequerido ");
        sentenciaSql.append("SET CantidadRequerida = ? ");
        sentenciaSql.append("WHERE Identificador = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, entidad.getCantidad());
            sentenciaPreparada.setInt(2, entidad.getIdentificador());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getSuministro().getNombre());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getSuministro().getNombre());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public List<SuministroRequeridoEntity> consultar(SuministroRequeridoEntity entidad) {
        final var listaSuministros = new ArrayList<SuministroRequeridoEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT SR.Identificador, T.Identificador, S.ID, SR.CantidadRequerida");
        sentenciaSql.append("FROM SuministroRequerido SR JOIN Tarea T ");
        sentenciaSql.append("ON SR.Tarea = T.Identificador");
        sentenciaSql.append("JOIN TipoSuministro S");
        sentenciaSql.append("ON SR.Suministro = S.ID");
        sentenciaSql.append("ORDER BY TipoTrabajo ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                List<SuministroRequeridoEntity> Tareas = new ArrayList<>();
                while (resultado.next()){
                    SuministroRequeridoEntity suministroTMP = SuministroRequeridoEntity.build(resultado.getInt("Identificador"), TareaFincaEntity.Build(resultado.getInt("Identificador")), TipoSuministroEntity.build(resultado.getInt("ID")), resultado.getInt("CantidadRequerida"));
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
    public void crear(SuministroRequeridoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO SuministroRequerido(Identificador, Tarea, Suministro, CantidadRequerida");
        sentenciaSql.append("VALUES(?, ?, ?, ?)");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, entidad.getIdentificador());
            sentenciaPreparada.setInt(2, entidad.getTarea().getIdentificador());
            sentenciaPreparada.setInt(3, entidad.getSuministro().getID());
            sentenciaPreparada.setInt(4, entidad.getCantidad());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getSuministro().getNombre());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getSuministro().getNombre());
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
