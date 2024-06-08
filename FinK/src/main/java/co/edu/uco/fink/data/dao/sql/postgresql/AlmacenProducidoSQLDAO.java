package co.edu.uco.fink.data.dao.sql.postgresql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.data.dao.AlmacenProducidoDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.AlmacenProducidoEntity;
import co.edu.uco.fink.entity.FincaEntity;
import co.edu.uco.fink.entity.LugarFincaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlmacenProducidoSQLDAO extends SQLconnection implements AlmacenProducidoDAO {

    public AlmacenProducidoSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<AlmacenProducidoEntity> consultar(AlmacenProducidoEntity entidad) {
        final var listaAlmacenes = new ArrayList<AlmacenProducidoEntity>();
        final var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT AP.identificador AS almacenidentificador, AP.nombre AS almacennombre, AP.descripcion as almacendescripcion, LF.identificador AS lugaridentificador, LF.ubicacion AS lugarubicacion, LF.nomenclatura AS nomenclatura, F.id as fincaid, F.nombre as fincanombre" +
                            "FROM almacenproducido AP JOIN lugarfinca LF " +
                            "ON AP.lugar = concat_ws('-', LF.ubicacion, LF.nomenclatura, LF.finca) " +
                            "JOIN finca F " +
                            "ON LF.finca = F.nombre " +
                            "ORDER BY AP.identificador ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())){
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()){
                while (resultado.next()){
                    AlmacenProducidoEntity almacenTMP = AlmacenProducidoEntity.Build(resultado.getInt("almacenidentificador"), resultado.getString("almacennombre"), LugarFincaEntity.build(resultado.getInt("lugaridentificador")), resultado.getString("almacendescripcion"));
                    almacenTMP.setLugar(LugarFincaEntity.build(resultado.getInt("lugaridentificador"), resultado.getString("lugarubicacion"), resultado.getString("nomenclatura"), FincaEntity.Build(resultado.getInt("fincaid"), resultado.getString("fincanombre"))));

                    listaAlmacenes.add(almacenTMP);
                }
            }
        } catch (final SQLException exception){
            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002));
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000028), "SELECT", "almacenes producido", "almacenproducido");
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataFinKException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002));
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000030), "SELECT", "almacenes producido", "almacenproducido");;
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaAlmacenes;
    }

    @Override
    public List<AlmacenProducidoEntity> consultarEmpleado(AlmacenProducidoEntity entidad) {
        return List.of();
    }

    @Override
    public void crear(AlmacenProducidoEntity entidad) {
        final var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO almacenproducido(nombre, lugar, descripcion) " +
                            "VALUES (?, (SELECT string_agg(concat_ws('-', ubicacion, nomenclatura, finca), '')" +
                                            "FROM lugarfinca " +
                                            "WHERE lugarfinca.identificador = ?), ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getLugar().getIdentificador());
            sentenciaPreparada.setString(3, entidad.getDescripcion());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000029), entidad.getNombre());
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000028), "CREATE", "almacen", "almacenProducido");
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000029), entidad.getNombre());
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000030), "SELECT", "almacen", "almacenProducido");
            throw new DataFinKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
