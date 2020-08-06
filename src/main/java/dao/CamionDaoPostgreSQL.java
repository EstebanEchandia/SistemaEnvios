package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.utils.DB;
import dominio.Camion;

public class CamionDaoPostgreSQL implements CamionDao{


	@Override
	public Camion recuperarCamion() {
		// TODO Auto-generated method stub
		return null;
	}

//	private static final String TABLA_CREATE = 
//			"CREATE TABLE  IF NOT EXISTS `died`.`camion` ( "+
//			"		  `ID` INT NOT NULL AUTO_INCREMENT, "+
//			"		  `PATENTE` VARCHAR(14) NULL, "+
//			"		  `MARCA` VARCHAR(45) NULL, "+
//			"		  `MODELO` VARCHAR(45) NULL, "+
//			"		  `KM` VARCHAR(45) NULL, "+
//			"		  `CAMIONcol` INT NULL, "+
//			"		  PRIMARY KEY (`ID`)) ";

			private static final String INSERT_CAMION =
					"INSERT INTO CAMION (PATENTE,MODELO,KMRECORRIDOS,COSTOPORKM,COSTOPORHORA,FECHADECOMPRA,IDPLANTA) VALUES (?,?,?,?,?,?)";
			
			private static final String UPDATE_CAMION =
					" UPDATE CAMION SET PATENTE = ?,MODELO = ?, KMRECORRIDOS = ?, COSTOPORKM = ?,COSTOPORHORA = ?,FECHADECOMPRA = ?, IDPLANTA = ?"
					+ " WHERE ID = ?";
			
//			private void verificarTablas() {
//				TABLA_CREATE
//			}
			
			@Override
			public Camion altaOModificacionCamion(Camion c) {
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = null;
				try {
					if(c.getId()!=null && c.getId()>0) {
						pstmt= conn.prepareStatement(UPDATE_CAMION);
						pstmt.setString(1, c.getPatente());
						pstmt.setString(2, c.getModelo());
						pstmt.setDouble(3, c.getKmRecorridos());
						pstmt.setDouble(4, c.getCostoPorKm());
						pstmt.setDouble(5, c.getCostoPorHora());
						pstmt.setObject(6, c.getFechaDeCompra());
						pstmt.setInt(7, c.getPlanta());
						pstmt.setInt(8, c.getId());
						
						pstmt.executeUpdate();
					}else {
						pstmt= conn.prepareStatement(INSERT_CAMION);
						pstmt.setString(1, c.getPatente());
						pstmt.setString(2, c.getModelo());
						pstmt.setDouble(3, c.getKmRecorridos());
						pstmt.setDouble(4, c.getCostoPorKm());
						pstmt.setDouble(5, c.getCostoPorHora());
						pstmt.setObject(6, c.getFechaDeCompra());
						pstmt.setInt(7, c.getPlanta());
					}
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
				return c;
			}

}
