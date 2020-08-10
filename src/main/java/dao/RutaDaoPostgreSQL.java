package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.utils.DB;
import dominio.Planta;
import dominio.Ruta;

public class RutaDaoPostgreSQL implements RutaDao{

	private static final String INSERT_RUTA =
			"INSERT INTO trabajopractico.ruta(SIGLA,DISTANCIAENKM,DURACIONENHORAS,CANTMAXATRANSPORTARENKG,PLANTAORIGEN,PLANTADESTINO)"+""
					+ " VALUES (?,?,?,?,?,?)";
	

	
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


}
