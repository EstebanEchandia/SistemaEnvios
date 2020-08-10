package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.utils.DB;
import dominio.Planta;

public class PlantaDaoPostgreSQL implements PlantaDao{
	
	

	private static final String INSERT_PLANTA =
			"INSERT INTO trabajopractico.PLANTA (NOMBRE)"+""
					+ " VALUES (?)";
	
	
	private static final String UPDATE_PLANTA =
			" UPDATE trabajopractico.PLANTA SET NOMBRE = ?"
			+ " WHERE ID = ?";
	
	
	private static final String DELETE_PLANTA =
			" DELETE FROM trabajopractico.CAMION " + " WHERE ID = ?";
	
	private static final String SELECT_PLANTA_ALL =
			"SELECT * FROM trabajopractico.planta ";
	
	private static final String SELECT_PLANTA_INSUMO_MENOR_PTO_PEDIDO = 
	"SELECT p.nombre, i.descripcion, s.cantidad, s.ptominimodepedido, "+
	"( "+
	"	SELECT SUM(stock.cantidad) "+
	"	from trabajopractico.stock, trabajopractico.insumo "+
	"	where stock.idInsumo = insumo.id  "+
	"	and insumo.id = i.id "+
	"	) as stockTotal "+

	"FROM trabajopractico.planta as p, trabajopractico.insumo as i, trabajopractico.stock as s "+
	"WHERE s.idPlanta = p.id "+
	"AND s.Idinsumo = i.id "+
	"AND s.cantidad < s.PtoMinimoDePedido";
	
	
	@Override
	public Planta altaPlanta(Planta p) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		System.out.println("Cree planta");
		try {
			pstmt = conn.prepareStatement(INSERT_PLANTA);
			pstmt.setString(1, p.getNombre());
			
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
		
		return p;
		
	}
	
	
	@Override
	public Planta updatePlanta(Planta p) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		try {
				System.out.println("updatie");
				
				pstmt = conn.prepareStatement(UPDATE_PLANTA);
				
			

				pstmt.executeUpdate();

			
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
		return p;
	}
	
	
	@Override
	public Planta bajaPlanta(Planta p) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			
			System.out.println("Borrando Planta");			
			
			pstmt = conn.prepareStatement(DELETE_PLANTA);
	
			
			pstmt.executeUpdate();
			System.out.println("Planta borrada con exito");
		
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
	return p;
	}


	
	@Override
	public ArrayList<Planta> recuperarPlantasTodas() {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ArrayList <Planta> res = new ArrayList<Planta>();
		try {
			System.out.println("Buscando Plantas");
			pstmt = conn.prepareStatement(SELECT_PLANTA_ALL);
			
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				res.add(new Planta(rs.getInt("id"), rs.getString("nombre")));
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
	public ArrayList<ArrayList <String>> recuperarPlantasConInsumoMenorAlPtoPedido() {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ArrayList<ArrayList <String>> res = new ArrayList<ArrayList <String>>();
		try {
			System.out.println("Buscando Plantas con insumo menor al pto de pedido");
			pstmt = conn.prepareStatement(SELECT_PLANTA_INSUMO_MENOR_PTO_PEDIDO);
			
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				ArrayList<String> fila = new ArrayList<String>();
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("descripcion"));
				fila.add(rs.getString("cantidad"));
				fila.add(rs.getString("ptominimodepedido"));
				fila.add(rs.getString("stocktotal"));
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
	
	

}
