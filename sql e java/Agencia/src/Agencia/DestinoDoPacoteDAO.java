package Agencia; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinoDoPacoteDAO {
    private Connection connection;

  
    public DestinoDoPacoteDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void associarDestinoPacote(int idDestino, int idPacote) throws SQLException {
        String sql = "INSERT INTO DestinoDoPacote (idDestino, idPacote) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDestino);
            statement.setInt(2, idPacote);

            statement.executeUpdate();
        }
    }

    
    public void desassociarDestinoPacote(int idDestino, int idPacote) throws SQLException {
        String sql = "DELETE FROM DestinoDoPacote WHERE idDestino = ? AND idPacote = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDestino);
            statement.setInt(2, idPacote);

            statement.executeUpdate();
        }
    }

    
    public List<Destino> listarDestinosPorPacote(int idPacote) throws SQLException {
        List<Destino> destinos = new ArrayList<>();
        String sql = "SELECT D.* FROM Destino D " +
                     "INNER JOIN DestinoDoPacote DP ON D.idDestino = DP.idDestino " +
                     "WHERE DP.idPacote = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPacote);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Destino destino = new Destino();
                    destino.setIdDestino(resultSet.getInt("idDestino"));
                    destino.setNomeDoDestino(resultSet.getString("nomeDoDestino"));
                    destino.setDescricao(resultSet.getString("descricao"));
                    destinos.add(destino);
                }
            }
        }

        return destinos;
    }
}
