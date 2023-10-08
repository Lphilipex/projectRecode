package Agencia; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DestinoDAO {
    private Connection connection;

    
    public DestinoDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void inserirDestino(Destino destino) throws SQLException {
        String sql = "INSERT INTO Destino (nomeDoDestino, descricao) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, destino.getNomeDoDestino());
            statement.setString(2, destino.getDescricao());

            statement.executeUpdate();
        }
    }

    
    public void atualizarDestino(Destino destino) throws SQLException {
        String sql = "UPDATE Destino SET nomeDoDestino = ?, descricao = ? WHERE idDestino = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, destino.getNomeDoDestino());
            statement.setString(2, destino.getDescricao());
            statement.setInt(3, destino.getIdDestino());

            statement.executeUpdate();
        }
    }

    
    public void excluirDestino(int idDestino) throws SQLException {
        String sql = "DELETE FROM Destino WHERE idDestino = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDestino);

            statement.executeUpdate();
        }
    }

    
    public Destino buscarDestinoPorId(int idDestino) throws SQLException {
        String sql = "SELECT * FROM Destino WHERE idDestino = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDestino);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Destino destino = new Destino();
                    destino.setIdDestino(resultSet.getInt("idDestino"));
                    destino.setNomeDoDestino(resultSet.getString("nomeDoDestino"));
                    destino.setDescricao(resultSet.getString("descricao"));
                    return destino;
                }
            }
        }

        return null; 
    }

   
    public List<Destino> listarDestinos() throws SQLException {
        List<Destino> destinos = new ArrayList<>();
        String sql = "SELECT * FROM Destino";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
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
