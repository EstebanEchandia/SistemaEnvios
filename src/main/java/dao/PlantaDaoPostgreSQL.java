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
	
	

}
