CREATE SCHEMA trabajoPractico

	CREATE TABLE trabajoPractico.planta
	
			(
			id varchar(32),
			nombre varchar(100),

			CONSTRAINT pk_idPlanta PRIMARY KEY (id)
		);
		
	CREATE TABLE trabajoPractico.camion
		(	
			
			id varchar(32),
			nombre varchar(100),
			modelo varchar(100),
			kmRecorridos numeric(20,2),
			costoPorKm numeric(20,2),
			costoPorHora numeric(20,2),
			fechaDeCompra date,
			idPlanta varchar(32),

			CONSTRAINT pk_idCamion PRIMARY KEY (id),
			
			CONSTRAINT fk_idPlanta FOREIGN KEY (idPlanta)
			REFERENCES trabajoPractico.planta(id)

		);




	CREATE TABLE trabajoPractico.envio
			(
			id varchar(32),
			costo numeric(20,2),
			idCamion varchar(32),

			CONSTRAINT pk_idEnvio PRIMARY KEY (id),
			CONSTRAINT fk_idCamion FOREIGN KEY (idCamion)
			REFERENCES trabajoPractico.camion(id)
		);
	
	CREATE TYPE estados AS
	ENUM('CREADA','PROCESADA','ENTREGADA','CANCELADO');

	CREATE TABLE trabajoPractico.pedido
			(
			numeroDeOrden varchar(32),
			fechaSolicitud date,
			fechaEntrega date,
			estado estados,
			idEnvio varchar(32),
			plantaOrigen varchar(32),
			plantaDestino varchar(32),
			

			CONSTRAINT pk_nroOrden PRIMARY KEY (numeroDeOrden),

			CONSTRAINT fk_idEnvio FOREIGN KEY (idEnvio)
			REFERENCES trabajoPractico.envio(id),

			CONSTRAINT fk_plantaOrigen FOREIGN KEY (plantaOrigen)
			REFERENCES trabajoPractico.planta(id),

			CONSTRAINT fk_plantaDestino FOREIGN KEY (plantaDestino)
			REFERENCES trabajoPractico.planta(id)


		);
		
			CREATE TYPE unidad AS
	ENUM('KILO','PIEZA','GRAMO','METRO','LITRO','M3','M2');

	CREATE TABLE trabajoPractico.insumo
	(

			id varchar(32),
			descripcion varchar(100),
			unidadDeMedida unidad,
			costo numeric(20,2),

			CONSTRAINT pk_idInsumo PRIMARY KEY (id)
		);
		
		
	CREATE TABLE trabajoPractico.itempedido
			(
			id varchar(32),
			cantidad numeric(20,2),
			numeroDeOrden varchar(32),
			idInsumo varchar(32),

			CONSTRAINT pk_idItemPedido PRIMARY KEY (id),

			CONSTRAINT fk_numeroDeOrden FOREIGN KEY (numeroDeOrden)
			REFERENCES trabajoPractico.pedido(numeroDeOrden),

			CONSTRAINT fk_idInsumo FOREIGN KEY (idInsumo)
			REFERENCES trabajoPractico.insumo(id)

		);



	CREATE TABLE trabajoPractico.insumoLiquido
		(
			id varchar(32),
			densidad numeric(20,2),

			CONSTRAINT pk_idInsumoLiquido PRIMARY KEY (id),

			CONSTRAINT fk_id FOREIGN KEY (id)
			REFERENCES trabajoPractico.insumo(id)
		);

	CREATE TABLE trabajoPractico.insumoGeneral
		(
			id varchar(32),
			peso numeric(20,2),

			CONSTRAINT pk_idInsumoGeneral PRIMARY KEY (id),

			CONSTRAINT fk_id FOREIGN KEY (id)
			REFERENCES trabajoPractico.insumo(id)
		);

	
	

	CREATE TABLE trabajoPractico.stock
		(
			id varchar(32),
			cantidad numeric(20,2),
			ptoMinimoDePedido numeric(20,2),
			idInsumo varchar(32),
			idPlanta varchar(32),

			CONSTRAINT pk_idStock PRIMARY KEY (id),

			CONSTRAINT fk_idInsumo FOREIGN KEY (idInsumo)
			REFERENCES trabajoPractico.insumo(id),

			CONSTRAINT fk_idPlanta FOREIGN KEY (idPlanta)
			REFERENCES trabajoPractico.planta(id)
		);
	