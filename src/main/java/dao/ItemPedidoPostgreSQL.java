
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.utils.DB;
import dominio.ItemPedido;

public class ItemPedidoPostgreSQL implements ItemPedidoDao{

	
	private static final String INSERT_ITEM_PEDIDO = "INSERT INTO trabajopractico.itempedido (CANTIDAD,NUMERODEORDEN,IDINSUMO) values (?,?,?)";
	
	
	@Override
	public void altaItemPedido(ItemPedido ip) {
	
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		System.out.println("Creando item pedido");
		
		try {

			pstmt = conn.prepareStatement(INSERT_ITEM_PEDIDO);
			pstmt.setDouble(1, ip.getCantidad());
			pstmt.setInt(2, ip.getNumeroDeOrden());
			pstmt.setInt(3, ip.getIdInsumo());
		
			pstmt.executeUpdate();
			
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
		
	}
	
	
}
