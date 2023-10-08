package Agencia; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO {
    private Connection connection;

    
    public ReservasDAO(Connection connection) {
        this.connection = connection;
    }

  
    public void inserirReserva(Reservas reserva) throws SQLException {
        String sql = "INSERT INTO Reservas (idCliente, idPacote) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reserva.getIdCliente());
            statement.setInt(2, reserva.getIdPacote());

            statement.executeUpdate();
        }
    }

   
    public void excluirReserva(int idCliente, int idPacote) throws SQLException {
        String sql = "DELETE FROM Reservas WHERE idCliente = ? AND idPacote = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCliente);
            statement.setInt(2, idPacote);

            statement.executeUpdate();
        }
    }

   
    public List<Reservas> listarReservasPorCliente(int idCliente) throws SQLException {
        List<Reservas> reservas = new ArrayList<>();
        String sql = "SELECT * FROM Reservas WHERE idCliente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCliente);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Reservas reserva = new Reservas();
                    reserva.setIdCliente(resultSet.getInt("idCliente"));
                    Pacote pacote = new Pacote();
					pacote.setIdPacote(resultSet.getInt("idPacote"));
                    reservas.add(reserva);
                }
            }
        }

        return reservas;
    }

    
    public List<Reservas> listarReservasPorPacote(int idPacote) throws SQLException {
        List<Reservas> reservas = new ArrayList<>();
        String sql = "SELECT * FROM Reservas WHERE idPacote = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPacote);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Reservas reserva = new Reservas();
                    reserva.setIdCliente(resultSet.getInt("idCliente"));
                    Pacote pacote = new Pacote();
					pacote.setIdPacote(resultSet.getInt("idPacote"));
                    reservas.add(reserva);
                }
            }
        }
        return reservas;
    }
}
