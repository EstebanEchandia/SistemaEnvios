package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.utils.DB;
import dominio.Pedido;

public class PedidoDaoPostgreSQL implements PedidoDao {

	

	private static final String INSERT_PEDIDO =
			"INSERT INTO trabajopractico.pedido(FECHASOLICITUD,FECHAENTREGA,ESTADO,IDENVIO,PLANTAORIGEN,PLANTADESTINO)"+""
					+ " VALUES (?,?,?::EstadoPedido,null,?,?)";
	
	private static final String UPDATE_ESTADO_PEDIDO = "UPDATE trabajopractico.pedido set ESTADO = ? WHERE NUMERODEORDEN = ?";
	
	@Override
	public void altaPedido(Pedido p) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		System.out.println("Creando pedido");
		try {
			
			pstmt = conn.prepareStatement(INSERT_PEDIDO);
			pstmt.setDate(1, Date.valueOf(p.getFechaSolicitud()));
			pstmt.setDate(2, Date.valueOf(p.getFechaSolicitud()));
			pstmt.setObject(3, p.getEstado().toString());
			pstmt.setInt(4,p.getPlantaOrigen());
			pstmt.setInt(5,p.getPlantaDestino());
			
			pstmt.executeUpdate();
			System.out.println("Termine de crear");
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();				
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}

	

	@Override
	public void modificarEstadoPedido(Pedido p) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		System.out.println("Updateando estado pedido");
		
		try {
			
			pstmt = conn.prepareStatement(UPDATE_ESTADO_PEDIDO);
			pstmt.setObject(1, p.getEstado().toString());
			pstmt.setInt(2, p.getNumeroDeOrden());
			
			pstmt.executeUpdate();
			System.out.println("Termine de updatear pedido");
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();				
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}

}
