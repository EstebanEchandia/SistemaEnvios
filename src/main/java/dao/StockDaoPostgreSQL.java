/**
 * 
 */
package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.utils.DB;
import dominio.Stock;

/**
 * @author esteb
 *
 */

public class StockDaoPostgreSQL implements StockDao{

	private static final String INSERT_STOCK =
			"INSERT INTO trabajopractico.stock (CANTIDAD,PTOMINIMODEPEDIDO,IDINSUMO,IDPLANTA)"
					+ " VALUES (?,?,?,?)";
	
	private static final String SUMAR_STOCK_DE_UN_INSUMO =
						"SELECT SUM(stock.cantidad) "+
							"from trabajopractico.stock, trabajopractico.insumo "+
								"where stock.idInsumo = insumo.id and insumo.id = ?";
					
	
	
	@Override
	public void altaStock(Stock s) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		

		try {
			System.out.println("Creando Stock");
			pstmt = conn.prepareStatement(INSERT_STOCK);
			pstmt.setDouble(1, s.getCantidad());
			pstmt.setDouble(2, s.getPtoMinimoDePedido());
			pstmt.setInt(3, s.getInsumoAsociado());
			pstmt.setInt(4, s.getIdPlanta());
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
	public Integer getStockDeUnInsumo(Integer idInsumo) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		Integer res = 0;
		
		try {
					
			pstmt = conn.prepareStatement(SUMAR_STOCK_DE_UN_INSUMO);	
			pstmt.setInt(1, idInsumo);	
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				res = rs.getInt(1);
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
	public Stock modificarStock(Stock s) {
		
		return null;
	}



}
