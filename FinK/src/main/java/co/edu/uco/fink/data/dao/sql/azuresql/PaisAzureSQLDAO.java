package co.edu.uco.fink.data.dao.sql.azuresql;

import co.edu.uco.fink.data.dao.PaisDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.finca.PaisEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class PaisAzureSQLDAO extends SQLconnection implements PaisDAO {
    
    public PaisAzureSQLDAO(final Connection connection){
        super(connection);
    }
    @Override
    public final void actualizar(final PaisEntity entidad) {
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE Pais");
        sentenciaSQL.append("SET nombre = ?");
        sentenciaSQL.append("WHERE id = ?");

        try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())){

            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getId());

            sentenciaPreparada.executeUpdate();

        } catch (final SQLException excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del País deseado. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema tratando de realizar un update de la información del país \"${1}\" en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo País. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de realizar un insert de la información del país \"${1}\" en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }

    @Override
    public final List<PaisEntity> consultar(final PaisEntity entidad) {

        final var listaPaises = new ArrayList<PaisEntity>();
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre");
        sentenciaSQL.append("FROM Pais");
        sentenciaSQL.append("ORDER BY nombre ASC");

        try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())) {

            try (final ResultSet resultados = sentenciaPreparada.executeQuery()) {

                while (resultados.next()){
                    PaisEntity paisTmp = PaisEntity.build(resultados.getInt("id"), resultados.getString("nombre"));
                    listaPaises.add(paisTmp);
                }

            } catch (final SQLException excepcion) {
                var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de información de uno o más paises";
                var mensajeTecnico = "Ha ocurrido un error ejecutando la sentencia SQL de consulta de los países en la base de datos AZURE SQL";

                throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
            }
        } catch (final DataFinKException excepcion) {
            throw excepcion;
        } catch (final SQLException excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo País. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema preparando la sentencia de Query en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo País. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de realizar un insert de la información del país \"${1}\" en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        }

        return listaPaises;
    }

    @Override
    public final void crear(final PaisEntity entidad) {
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO Pais(nombre)");
        sentenciaSQL.append("VALUES (?)");

        try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())){

            sentenciaPreparada.setString(1, entidad.getNombre());

            sentenciaPreparada.executeUpdate();

        } catch (final SQLException excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo País. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema tratando de realizar un insert de la información del país \"${1}\" en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo País. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de realizar un insert de la información del país \"${1}\" en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("DELETE FROM Pais");
        sentenciaSQL.append("WHERE id = ?");

        try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())){

            sentenciaPreparada.setInt(1, id);

            sentenciaPreparada.executeUpdate();

        } catch (final SQLException excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo País. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema tratando de realizar un insert de la información del país \"${1}\" en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion){
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo País. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la finca";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de realizar un insert de la información del país \"${1}\" en la tabla Pais en la base de datos AZURE_SQL";

            throw new DataFinKException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }
}
