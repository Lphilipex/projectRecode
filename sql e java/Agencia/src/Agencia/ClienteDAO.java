package Agencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

  
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

   
    public void inserirCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, telefone, preferenciaDeViagem, observacoes) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getPreferenciaDeViagem());
            statement.setString(4, cliente.getObservacoes());

            statement.executeUpdate();
        }
    }

    
    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET nome = ?, telefone = ?, preferenciaDeViagem = ?, observacoes = ? WHERE idCliente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getPreferenciaDeViagem());
            statement.setString(4, cliente.getObservacoes());
            statement.setInt(5, cliente.getIdCliente());

            statement.executeUpdate();
        }
    }

    
    public void excluirCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCliente);

            statement.executeUpdate();
        }
    }

    
    public Cliente buscarClientePorId(int idCliente) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCliente);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(resultSet.getInt("idCliente"));
                    cliente.setNome(resultSet.getString("nome"));
                    cliente.setTelefone(resultSet.getString("telefone"));
                    cliente.setPreferenciaDeViagem(resultSet.getString("preferenciaDeViagem"));
                    cliente.setObservacoes(resultSet.getString("observacoes"));
                    return cliente;
                }
            }
        }

        return null; 
    }

    
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(resultSet.getInt("idCliente"));
                    cliente.setNome(resultSet.getString("nome"));
                    cliente.setTelefone(resultSet.getString("telefone"));
                    cliente.setPreferenciaDeViagem(resultSet.getString("preferenciaDeViagem"));
                    cliente.setObservacoes(resultSet.getString("observacoes"));
                    clientes.add(cliente);
                }
            }
        }

        return clientes;
    }
}
