package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.utils.DB;
import dominio.Pedido;

public class PedidoDaoPostgreSQL implements PedidoDao {

	

	private static final String INSERT_PEDIDO =
			"INSERT INTO trabajopractico.pedido(FECHASOLICITUD,FECHAENTREGA,ESTADO,IDENVIO,PLANTAORIGEN,PLANTADESTINO)"+""
					+ " VALUES (NOW(),?,'CREADA'::estados,null,null,?) RETURNING NUMERODEORDEN";
	
	private static final String UPDATE_ESTADO_PEDIDO = "UPDATE trabajopractico.pedido set ESTADO = ? WHERE NUMERODEORDEN = ?";
	
	@Override
	public Integer altaPedido(Pedido p) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		System.out.println("Creando pedido");
		Integer id= 0;
		try {
			
			pstmt = conn.prepareStatement(INSERT_PEDIDO, Statement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, Date.valueOf(p.getFechaEntrega().toString()));
			pstmt.setInt(2,p.getPlantaDestino());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			while(rs.next()){
				id = rs.getInt(1);
			}
			System.out.println(id);
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
		return id;
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
