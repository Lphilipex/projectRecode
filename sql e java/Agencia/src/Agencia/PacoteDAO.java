package Agencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO {
    private Connection connection;

    
    public PacoteDAO(Connection connection) {
        this.connection = connection;
    }

   
    public void inserirPacote(Pacote pacote) throws SQLException {
        String sql = "INSERT INTO Pacote (dataDePartida, dataDeRetorno, precoTotal) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, pacote.getDataDePartida());
            statement.setDate(2, pacote.getDataDeRetorno());
            statement.setBigDecimal(3, pacote.getPrecototal());

            statement.executeUpdate();
        }
    }

    
    public void atualizarPacote(Pacote pacote) throws SQLException {
        String sql = "UPDATE Pacote SET dataDePartida = ?, dataDeRetorno = ?, precoTotal = ? WHERE idPacote = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, pacote.getDataDePartida());
            statement.setDate(2, pacote.getDataDeRetorno());
            statement.setBigDecimal(3, pacote.getPrecototal());
            statement.setInt(4, pacote.getIdPacote());

            statement.executeUpdate();
        }
    }

    
    public void excluirPacote(int idPacote) throws SQLException {
        String sql = "DELETE FROM Pacote WHERE idPacote = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPacote);

            statement.executeUpdate();
        }
    }

   
    public Pacote buscarPacotePorId(int idPacote) throws SQLException {
        String sql = "SELECT * FROM Pacote WHERE idPacote = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPacote);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Pacote pacote = new Pacote();
                    pacote.setIdPacote(resultSet.getInt("idPacote"));
                    pacote.setDataDePartida(resultSet.getDate("dataDePartida"));
                    pacote.setDataDeRetorno(resultSet.getDate("dataDeRetorno"));
                    pacote.setPrecototal(resultSet.getBigDecimal("precoTotal"));
                    return pacote;
                }
            }
        }

        return null; 
    }

    
    public List<Pacote> listarPacotes() throws SQLException {
        List<Pacote> pacotes = new ArrayList<>();
        String sql = "SELECT * FROM Pacote";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Pacote pacote = new Pacote();
                    pacote.setIdPacote(resultSet.getInt("idPacote"));
                    pacote.setDataDePartida(resultSet.getDate("dataDePartida"));
                    pacote.setDataDeRetorno(resultSet.getDate("dataDeRetorno"));
                    pacote.setPrecototal(resultSet.getBigDecimal("precoTotal"));
                    pacotes.add(pacote);
                }
            }
        }

        return pacotes;
    }
}
