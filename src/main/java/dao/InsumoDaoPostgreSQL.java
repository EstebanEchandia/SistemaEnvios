/**
 * 
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.utils.DB;
import dominio.Camion;
import dominio.Insumo;
import dominio.InsumoGeneral;
import dominio.InsumoLiquido;
import enums.Unidad;

/**
 * @author esteb
 *
 */
public class InsumoDaoPostgreSQL implements InsumoDao{
	
	private static final String INSERT_INSUMO =
			"INSERT INTO trabajopractico.INSUMO(DESCRIPCION,UNIDADDEMEDIDA,COSTO)"
					+ " VALUES (?,?::unidad,?) RETURNING ID";
	
	private static final String INSERT_INSUMO_GENERAL =
			"INSERT INTO trabajopractico.INSUMOGENERAL(ID,PESO)"
					+ " VALUES (?,?)";
	
	private static final String INSERT_INSUMO_LIQUIDO =
			"INSERT INTO trabajopractico.INSUMOliquido(ID,DENSIDAD)"
					+ " VALUES (?,?)";
	
	
	private static final String UPDATE_INSUMO =
			" UPDATE trabajopractico.insumo SET DESCRIPCION = ?,UNIDADDEMEDIDA = ?::unidad, COSTO = ?"
			+ " WHERE ID = ?";
	
	
	private static final String UPDATE_INSUMO_GENERAL =
			" UPDATE trabajopractico.INSUMOGENERAL SET PESO = ?"
			+ " WHERE ID = ?";
	
	private static final String UPDATE_INSUMO_LIQUIDO =
			" UPDATE trabajopractico.INSUMOLIQUIDO SET DENSIDAD = ?"
			+ " WHERE ID = ?";
	
	private static final String DELETE_INSUMO =
			" DELETE FROM trabajopractico.insumo" + " WHERE ID = ?";
	
	private static final String DELETE_INSUMO_GENERAL =
			" DELETE FROM trabajopractico.insumogeneral" + " WHERE ID = ?";
	
	private static final String DELETE_INSUMO_LIQUIDO =
			" DELETE FROM trabajopractico.insumoliquido" + " WHERE ID = ?";
	
	private static final String SELECT_INSUMOS_LIQUIDOS =
			"SELECT insumo.id,  insumo.descripcion, insumo.unidaddemedida, insumo.costo, insumoliquido.densidad " + 
			"FROM TRABAJOPRACTICO.insumo, trabajopractico.insumoliquido WHERE insumo.id = insumoliquido.id ORDER BY insumo.id";
	
	private static final String SELECT_INSUMOS_GENERALES =
			"SELECT insumo.id,  insumo.descripcion, insumo.unidaddemedida, insumo.costo, insumogeneral.peso " + 
			"FROM TRABAJOPRACTICO.insumo, trabajopractico.insumogeneral WHERE insumo.id = insumogeneral.id ORDER BY insumo.id"; 
			
	
	@Override
	public InsumoGeneral altaInsumoGeneral(InsumoGeneral i) {
	
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		try {
			System.out.println("Creando insumo general");
			pstmt = conn.prepareStatement(INSERT_INSUMO, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, i.getDescripcion());
			pstmt.setObject(2, i.getUnidad().toString());
			pstmt.setDouble(3, i.getCosto());
			
			pstmt.executeUpdate();
				
			ResultSet rs = pstmt.getGeneratedKeys();
			
			Integer id= 0;
			while(rs.next()){
				id = rs.getInt(1);
			}
			
			pstmt2 = conn.prepareStatement(INSERT_INSUMO_GENERAL);
			pstmt2.setInt(1, id);
			pstmt2.setDouble(2,i.getPeso());
			pstmt2.executeUpdate();
		
			System.out.println("Termine de crear el insumo general");

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
		
		return i;
	}
	
	@Override
	public InsumoGeneral updateInsumoGeneral(InsumoGeneral i) {

		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		try {
			System.out.println("Updateando insumo general");
			
			pstmt = conn.prepareStatement(UPDATE_INSUMO);
			System.out.println(i.getDescripcion());
			pstmt.setString(1, i.getDescripcion());
			pstmt.setObject(2, i.getUnidad().toString());
			pstmt.setDouble(3, i.getCosto());
			pstmt.setInt(4, i.getId());
			pstmt.executeUpdate();
				
			
			pstmt2 = conn.prepareStatement(UPDATE_INSUMO_GENERAL);
			
			System.out.println(i.getPeso());
			
			pstmt2.setDouble(1, i.getPeso());
			pstmt2.setInt(2, i.getId());
			
			pstmt2.executeUpdate();
		
			System.out.println("Termine de modificar el insumo general");

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
		
		return i;
	}





	@Override
	public InsumoLiquido altaInsumoLiquido(InsumoLiquido i) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		try {
			System.out.println("Creando insumo liquidol");
			pstmt = conn.prepareStatement(INSERT_INSUMO, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, i.getDescripcion());
			pstmt.setObject(2, i.getUnidad().toString());
			pstmt.setDouble(3, i.getCosto());
			
			pstmt.executeUpdate();
				
			ResultSet rs = pstmt.getGeneratedKeys();
			
			Integer id= 0;
			while(rs.next()){
				id = rs.getInt(1);
			}
			
			pstmt2 = conn.prepareStatement(INSERT_INSUMO_LIQUIDO);
			pstmt2.setInt(1, id);
			pstmt2.setDouble(2,i.getDensidad());
			pstmt2.executeUpdate();
		
			System.out.println("Termine de crear el insumo liquido");

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
		
		return i;
	
	}




	



	@Override
	public InsumoLiquido updateInsumoLiquido(InsumoLiquido i) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		try {
			System.out.println("Updateando insumo liquido");
			
			pstmt = conn.prepareStatement(UPDATE_INSUMO);
			System.out.println(i.getDescripcion());
			pstmt.setString(1, i.getDescripcion());
			pstmt.setObject(2, i.getUnidad().toString());
			pstmt.setDouble(3, i.getCosto());
			pstmt.setInt(4, i.getId());
			pstmt.executeUpdate();
				
			
			pstmt2 = conn.prepareStatement(UPDATE_INSUMO_LIQUIDO);
			
			pstmt2.setDouble(1, i.getDensidad());
			pstmt2.setInt(2, i.getId());
			
			pstmt2.executeUpdate();
		
			System.out.println("Termine de modificar el insumo liquido");

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
		
		return i;
	}



	@Override
	public void bajaInsumo(Integer id) {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {	
			System.out.println("Borrando insumo");		
			
			pstmt2 = conn.prepareStatement(DELETE_INSUMO_LIQUIDO);
			pstmt2.setInt(1, id);
			pstmt2.executeUpdate();
			
			pstmt3 = conn.prepareStatement(DELETE_INSUMO_GENERAL);
			pstmt3.setInt(1, id);
			pstmt3.executeUpdate();

			pstmt = conn.prepareStatement(DELETE_INSUMO);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			
			
			
			System.out.println("insumo borrado con exito");
		
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
	public ArrayList<Insumo> recuperarInsumoTodos() {
		
			Connection conn = DB.getConnection();
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			ArrayList <Insumo> res = new ArrayList<Insumo>();
			
			try {
				System.out.println("Buscando insumos");
						
				pstmt = conn.prepareStatement(SELECT_INSUMOS_LIQUIDOS);
				
				ResultSet rs = pstmt.executeQuery();	
				
				while(rs.next()) {
					res.add(new InsumoLiquido(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("costo"), Unidad.valueOf(rs.getObject("unidaddemedida").toString()), rs.getDouble("densidad")));
				}
				
				pstmt2 = conn.prepareStatement(SELECT_INSUMOS_GENERALES);
				
				rs = pstmt2.executeQuery();	
				
				while(rs.next()) {
					res.add(new InsumoGeneral(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("costo"), Unidad.valueOf(rs.getObject("unidaddemedida").toString()), rs.getDouble("peso")));
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
