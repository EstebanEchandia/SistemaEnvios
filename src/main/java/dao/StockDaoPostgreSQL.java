/**
 * 
 */
package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	private static final String SELECT_STOCK_PLANTA =
			"SELECT * " + 
			"FROM trabajopractico.STOCK " + 
			"WHERE stock.idplanta = ? ";
	
	
	private static final String SELECT_STOCK_PLANTA_INSUMO =
	"SELECT * " + 
	"FROM trabajopractico.STOCK " + 
	"WHERE stock.idplanta = ? and stock.idinsumo = ?";
	
	private static final String SUMAR_STOCK_DE_UN_INSUMO =
						"SELECT SUM(stock.cantidad) "+
							"from trabajopractico.stock, trabajopractico.insumo "+
								"where stock.idInsumo = insumo.id and insumo.id = ?";
					
	private static final String BUSCAR_STOCK_INSUFICIENTE =
			"SELECT * "+
			"FROM trabajopractico.insumo "+
			"RIGHT JOIN(SELECT * FROM trabajopractico.stock where cantidad<ptominimodepedido) as tmp "+
			"ON insumo.id = tmp.idInsumo ";
		
	
	
	
	
	
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
	

		
	@Override
	public ArrayList<Stock> recuperarTodosStockDePlanta(Integer idPlanta){

		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ArrayList<Stock> res = new ArrayList<Stock>();
		
		try {		
			pstmt = conn.prepareStatement(SELECT_STOCK_PLANTA);	
			pstmt.setInt(1, idPlanta);
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				res.add(new Stock(rs.getDouble("cantidad"), rs.getDouble("ptominimodepedido"), rs.getInt("idinsumo"), rs.getInt("idplanta")));
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
	public Stock recuperarStockDeUnInsumoEnUnaPlanta(Integer idPlanta, Integer idInsumo){

		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		Stock s = null;
		
		try {		
			pstmt = conn.prepareStatement(SELECT_STOCK_PLANTA_INSUMO);	
			pstmt.setInt(1, idPlanta);
			pstmt.setInt(2, idInsumo);
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				s.setId(rs.getInt("id"));
				s = new Stock(rs.getDouble("cantidad"),rs.getDouble("ptominimodepedido"), rs.getInt("idInsumo"), rs.getInt("idPlanta"));
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
		return s;
	}
	
	
	
	
	
	
		

}
