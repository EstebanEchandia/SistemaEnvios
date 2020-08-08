package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.utils.DB;
import dominio.Camion;

public class CamionDaoPostgreSQL implements CamionDao{



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
					"INSERT INTO trabajopractico.CAMION (PATENTE,MODELO,KMRECORRIDOS,COSTOPORKM,COSTOPORHORA,FECHADECOMPRA)"+""
							+ " VALUES (?,?,?,?,?,?)";
			
			
			private static final String UPDATE_CAMION =
					" UPDATE trabajopractico.CAMION SET PATENTE = ?,MODELO = ?, KMRECORRIDOS = ?, COSTOPORKM = ?,COSTOPORHORA = ?,FECHADECOMPRA = ?"
					+ " WHERE ID = ?";
			
			
			private static final String DELETE_CAMION =
					" DELETE FROM trabajopractico.CAMION " + " WHERE ID = ?";
			
			private static final String SELECT_CAMION_ALL =
					"SELECT * FROM trabajopractico.CAMION ";
			
			private static final String SELECT_CAMION_ID =
					"SELECT * FROM trabajopractico.CAMION " + " WHERE ID = ?";
			
			
			
			private static final String SELECT_CAMION_PATENTE =
					"SELECT * FROM trabajopractico.CAMION " + " WHERE PATENTE = ?";
			
			
//			private void verificarTablas() {
//				TABLA_CREATE
//			}
			
			@Override
			public Integer getUltimoId() {
				
				String GET_LAST_ID = "select max(id) from trabajopractico.camion;";
						
				Connection conn = DB.getConnection();
				Statement pstmt = null;
				
				try{
					
					System.out.println("Buscando ultimo ID");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(GET_LAST_ID);
					return rs.getInt(1);
					
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
				return null;
				
			}
			
			@Override
			public Camion altaCamion(Camion c) {
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = null;
				
				System.out.println("Cree camion");
				try {
					pstmt = conn.prepareStatement(INSERT_CAMION);
					pstmt.setString(1, c.getPatente());
					pstmt.setString(2, c.getModelo());
					pstmt.setDouble(3, c.getKmRecorridos());
					pstmt.setDouble(4, c.getCostoPorKm());
					pstmt.setDouble(5, c.getCostoPorHora());
					pstmt.setDate(6, Date.valueOf(c.getFechaDeCompra()));
				
					
					pstmt.executeUpdate();
					System.out.println("Termine de crear");

					
					System.out.println(c.getFechaDeCompra().format(DateTimeFormatter.ofPattern("dd-MM-uuuu")));
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
			
			
			@Override
			public Camion updateCamion(Camion c) {
				
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = null;
				
				try {
						System.out.println("updatie");
						
						pstmt = conn.prepareStatement(UPDATE_CAMION);
						
						pstmt.setString(1, c.getPatente());
						pstmt.setString(2, c.getModelo());
						pstmt.setDouble(3, c.getKmRecorridos());
						pstmt.setDouble(4, c.getCostoPorKm());
						pstmt.setDouble(5, c.getCostoPorHora());
						pstmt.setObject(6, c.getFechaDeCompra());
						//pstmt.setInt(7, c.getPlanta());
						
						pstmt.setInt(7, c.getId());

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
			
			
			@Override
			public Camion bajaCamion(Camion c) {
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = null;
				try {
					
					System.out.println("Borrando Camion");			
					pstmt = conn.prepareStatement(DELETE_CAMION);
					pstmt.setInt(1, c.getId());
					pstmt.executeUpdate();
					System.out.println("Camion borrado con exito");
				
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
			

			@Override
			public ArrayList<Camion> recuperarCamionTodos() { //Buscar todos los camiones
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = null;
				ArrayList <Camion> res = new ArrayList<Camion>();
				try {
					System.out.println("Buscando Camiones");
					pstmt = conn.prepareStatement(SELECT_CAMION_ALL);
					
					ResultSet rs = pstmt.executeQuery();	
					
					while(rs.next()) {
						Camion c = new Camion();
						c.setId(rs.getInt("id"));
						c.setModelo(rs.getString("modelo"));
						c.setPatente(rs.getString("patente"));
						c.setCostoPorHora(rs.getDouble("costoporhora"));
						c.setCostoPorKm(rs.getDouble("costoporkm"));
						c.setFechaDeCompra(rs.getDate("fechadecompra").toLocalDate());
						c.setKmRecorridos(rs.getDouble("kmrecorridos"));
						c.setPlanta(rs.getInt("idPlanta"));
						res.add(c);
						
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
			public Camion recuperarCamionId(Camion c) { //Buscar un camion sabiendo solo su id
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = null;
				try {
					System.out.println("Buscando Camion");
					pstmt = conn.prepareStatement(SELECT_CAMION_ID);
					pstmt.setInt(1, c.getId());
					
					ResultSet rs = pstmt.executeQuery();		
					while(rs.next()) {
						c.setId(rs.getInt("id"));
						c.setModelo(rs.getString("modelo"));
						c.setPatente(rs.getString("patente"));
						c.setCostoPorHora(rs.getDouble("costoporhora"));
						c.setCostoPorKm(rs.getDouble("costoporkm"));
						c.setFechaDeCompra(rs.getDate("fechadecompra").toLocalDate());
						c.setKmRecorridos(rs.getDouble("kmrecorridos"));
						c.setPlanta(rs.getInt("idPlanta"));
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
			return c;
			}		
			
			@Override
			public Camion recuperarCamionPatente(Camion c) { //Buscar un camion sabiendo solo su id
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = null;
				try {
					System.out.println("Buscando Camion por patente");
					pstmt = conn.prepareStatement(SELECT_CAMION_PATENTE);
					pstmt.setString(1, c.getPatente());
					
					ResultSet rs = pstmt.executeQuery();		
					while(rs.next()) {
						c.setId(rs.getInt("id"));
						c.setModelo(rs.getString("modelo"));
						c.setPatente(rs.getString("patente"));
						c.setCostoPorHora(rs.getDouble("costoporhora"));
						c.setCostoPorKm(rs.getDouble("costoporkm"));
						c.setFechaDeCompra(rs.getDate("fechadecompra").toLocalDate());
						c.setKmRecorridos(rs.getDouble("kmrecorridos"));
						c.setPlanta(rs.getInt("idPlanta"));
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
			return c;
			}		

}
