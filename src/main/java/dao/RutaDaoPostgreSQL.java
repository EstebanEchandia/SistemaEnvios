package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.utils.DB;
import dominio.Ruta;

public class RutaDaoPostgreSQL implements RutaDao{

	private static final String INSERT_RUTA =
			"INSERT INTO trabajopractico.ruta(SIGLA,DISTANCIAENKM,DURACIONENHORAS,CANTMAXATRANSPORTARENKG,PLANTAORIGEN,PLANTADESTINO)"+""
					+ " VALUES (?,?,?,?,?,?)";
	
	private static final String SELECT_RUTA = "select * from trabajopractico.ruta";

	
	@Override
	public Ruta altaRuta(Ruta r) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		System.out.println("Cree ruta");
		try {
			pstmt = conn.prepareStatement(INSERT_RUTA);
			
			pstmt.setString(1, r.getSigla());
			pstmt.setDouble(2, r.getDistanciaEnKm());
			pstmt.setDouble(3, r.getDuracionEnHoras());
			pstmt.setDouble(4, r.getCantMaxMaterialesATransportarEnKG());
			pstmt.setInt(5, r.getPlantaOrigen());
			pstmt.setInt(6, r.getPlantaDestino());
			
			pstmt.executeUpdate();
			System.out.println("Termine de crear ruta");

			
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
		
		return r;
		
	}
	
	@Override
	public ArrayList<ArrayList <String>> recuperarRutas() {
		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ArrayList<ArrayList <String>> res = new ArrayList<ArrayList <String>>();
		try {
			System.out.println("Buscando Plantas con insumo menor al pto de pedido");
			pstmt = conn.prepareStatement(SELECT_RUTA);
			
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				ArrayList<String> fila = new ArrayList<String>();
				fila.add(rs.getString("sigla"));
				fila.add(rs.getString("distanciaenkm"));
				fila.add(rs.getString("duracionenhoras"));
				fila.add(rs.getString("cantmaxatransportarenkg"));
				fila.add(rs.getString("plantaorigen"));
				fila.add(rs.getString("plantadestino"));
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
