package Agencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
          
            Connection conexao = Conexao.createConnectionToMySQL();

            
            ClienteDAO clienteDAO = new ClienteDAO(conexao);

           
            Cliente novoCliente = new Cliente();
            novoCliente.setNome("Nome do Cliente");
            novoCliente.setTelefone("Telefone do Cliente");
            novoCliente.setPreferenciaDeViagem("Preferência de Viagem");
            novoCliente.setObservacoes("Observações do Cliente");
            clienteDAO.inserirCliente(novoCliente);

           
            List<Cliente> clientes = clienteDAO.listarClientes();
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getIdCliente());
                System.out.println("Nome: " + cliente.getNome());
               
            }

          
            PacoteDAO pacoteDAO = new PacoteDAO(conexao);

           
            Pacote novoPacote = new Pacote();
            novoPacote.setDataDePartida(java.sql.Date.valueOf("2023-12-01"));
            novoPacote.setDataDeRetorno(java.sql.Date.valueOf("2023-12-10"));
            novoPacote.setPrecototal(new BigDecimal("1000.00"));
            pacoteDAO.inserirPacote(novoPacote);

           
            List<Pacote> pacotes = pacoteDAO.listarPacotes();
            for (Pacote pacote : pacotes) {
                System.out.println("ID: " + pacote.getIdPacote());
                System.out.println("Data de Partida: " + pacote.getDataDePartida());
                
            }

            
            ReservasDAO reservasDAO = new ReservasDAO(conexao);

         
            Reservas novaReserva = new Reservas();
            novaReserva.setIdCliente(1); 
            novaReserva.setIdPacote(1); 
            reservasDAO.inserirReserva(novaReserva);

            
            List<Reservas> reservasPorCliente = reservasDAO.listarReservasPorCliente(1); // Substitua pelo ID do cliente
            for (Reservas reserva : reservasPorCliente) {
                System.out.println("ID Cliente: " + reserva.getIdCliente());
                System.out.println("ID Pacote: " + reserva.getIdPacote());
            }

            
            List<Reservas> reservasPorPacote = reservasDAO.listarReservasPorPacote(1); // Substitua pelo ID do pacote
            for (Reservas reserva : reservasPorPacote) {
                System.out.println("ID Cliente: " + reserva.getIdCliente());
                System.out.println("ID Pacote: " + reserva.getIdPacote());
            }

           
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
