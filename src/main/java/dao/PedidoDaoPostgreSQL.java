package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import java.util.ArrayList;

import dao.utils.DB;
import dominio.Pedido;

public class PedidoDaoPostgreSQL implements PedidoDao {

	

	private static final String INSERT_PEDIDO =
			"INSERT INTO trabajopractico.pedido(FECHASOLICITUD,FECHAENTREGA,ESTADO,IDENVIO,PLANTAORIGEN,PLANTADESTINO)"+""
					+ " VALUES (NOW(),?,'CREADA'::estados,null,null,?) RETURNING NUMERODEORDEN";
	
	private static final String UPDATE_ESTADO_PEDIDO = "UPDATE trabajopractico.pedido set ESTADO = ?::estados WHERE NUMERODEORDEN = ?";
	
	private static final String SELECT_PEDIDOS_CREADOS = "SELECT * from trabajopractico.pedido where pedido.estado = 'CREADA'";
	
	private static final String SELECT_PEDIDOS_PROCESADOS = "SELECT * from trabajopractico.pedido where pedido.estado = 'PROCESADA'";
	
	private static final String BUSCAR_DETALLE_ORDEN = 
			"SELECT itempedido.id, itempedido.cantidad, itempedido.idinsumo "+
			"from trabajopractico.pedido, trabajopractico.itempedido "+
			"where pedido.numerodeorden = ? "+
			"and itempedido.numeroDeOrden = pedido.numeroDeOrden ";
	
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
	
	@Override
	public ArrayList<ArrayList<String>> buscarPedidosCreados(){
			Connection conn = DB.getConnection();
			PreparedStatement pstmt = null;
			ArrayList<ArrayList <String>> res = new ArrayList<ArrayList <String>>();
			
			try {
				System.out.println("Buscando pedidos creados");
				pstmt = conn.prepareStatement(SELECT_PEDIDOS_CREADOS);
				
				ResultSet rs = pstmt.executeQuery();	
				
				while(rs.next()) {
					ArrayList<String> fila = new ArrayList<String>();
					fila.add(rs.getString("numerodeorden"));
					fila.add(rs.getString("fechasolicitud"));
					fila.add(rs.getString("fechaentrega"));
					fila.add(rs.getString("estado"));
					fila.add(rs.getString("plantadestino"));
					fila.add(rs.getString("plantaorigen"));
					fila.add(rs.getString("idenvio"));
					res.add(fila);
					
				}
								
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
			
			return res;
		
	}
	
	@Override
	public ArrayList<ArrayList<String>> buscarPedidosProcesados(){
			Connection conn = DB.getConnection();
			PreparedStatement pstmt = null;
			ArrayList<ArrayList <String>> res = new ArrayList<ArrayList <String>>();
			
			try {
				System.out.println("Buscando pedidos creados");
				pstmt = conn.prepareStatement(SELECT_PEDIDOS_PROCESADOS);
				
				ResultSet rs = pstmt.executeQuery();	
				
				while(rs.next()) {
					ArrayList<String> fila = new ArrayList<String>();
					fila.add(rs.getString("numerodeorden"));
					fila.add(rs.getString("fechasolicitud"));
					fila.add(rs.getString("fechaentrega"));
					fila.add(rs.getString("estado"));
					fila.add(rs.getString("plantadestino"));
					fila.add(rs.getString("plantaorigen"));
					fila.add(rs.getString("idenvio"));
					res.add(fila);
					
				}
								
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
			
			return res;
		
	}
	
	@Override
	public ArrayList<ArrayList <String>> verDetalleOrden(Integer nroOrden) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		ArrayList<ArrayList <String>> res = new ArrayList<ArrayList <String>>();
		
		System.out.println("Buscando detalles del orden");
		
		try {

			pstmt = conn.prepareStatement(BUSCAR_DETALLE_ORDEN);
			pstmt.setDouble(1, nroOrden);
		
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ArrayList<String> fila = new ArrayList<String>();
				fila.add(rs.getString("id"));
				fila.add(rs.getString("cantidad"));
				fila.add(rs.getString("idinsumo"));
				res.add(fila);
			}
			
			System.out.println("Termine de crear item pedido");
		
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
		return res;
	}
}
