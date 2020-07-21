package gui;

import javax.swing.JPanel;

public class PanelBuscarOrdenesCreadas extends JPanel{
	/* 
	 * Ver el detalle de la orden.
		• Ver todas las plantas donde hay disponible STOCK de los ítems solicitados. Si no existe una planta que tenga disponible stock de todos los productos se mostrará un mensaje de error y el pedido pasa a estado CANCELADO
		• De cada una de las posibles plantas se debe calcular y visualizar las posibles rutas siguiendo 2 alternativas:
				o La más corta en KM
				o La más rápida en Tiempo
		• Si hay más de una ruta con la misma duración o distancia se visualizarán todas y el usuario debe seleccionar 1 de estas rutas para asignársela al pedido.
		• Automáticamente el pedido queda asociado a este envío, que se realizará siguiente esta ruta.
		• Al pedido se le asigna automáticamente el primer camión disponible de la cola de prioridad de camiones disponibles. (los camiones se almacenan en memoria en una cola de prioridad, y se asigna aquel que tenga la menor cantidad de KM recorridos). Un camión a su vez está disponible si no está asignado a ninguna orden de pedido que esté en estado “PROCESADA”
		• Cada vez que se asigna un camión a un pedido, se actualizan la cantidad de km recorridos del camión.
		• El detalle del envío calcula el costo de envío sumando:
				o Costo por KM del camión asignado por cantidad de KM a recorrer
				o Costo por HORA del camión asignado por cantidad de horas que lleva el recorrido.
*/
}
