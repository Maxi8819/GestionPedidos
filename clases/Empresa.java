package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
	Scanner leer = new Scanner(System.in);		
	
	private String nombre;
	private ArrayList <Pedido> pedidos;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		this.pedidos = new ArrayList <Pedido>();
	}
	
	
	// cargarPedido: verificará que el número de pedido no haya sido ingresado antes. Cuando se agrega un pedido, su
	//   estado inicial es "P" (pendiente) y su cantidad pendiente es igual a su cantidad pedida. 
	
	public void cargarPedido (int nPedido, int codigoArt, int cant, int importe) {
		Pedido p;
		p=buscarPedidoXnumero(nPedido);
		if (p==null) {
			if(!esNroArticuloOK(codigoArt)) {
				System.out.println(" nro articulo incorrecto, ingrese nuevamente");
				codigoArt=Integer.parseInt(leer.nextLine());
			}else {
				System.out.println("articulo verificado OK");
			}
			p=new Pedido(nPedido,codigoArt,cant,importe,cant, Estado.P);
			pedidos.add(p);
			System.out.println("Pedido agragado correctamente");
		}else {
			System.out.println("Este pedido ya existe");
		}
		
	}
		
	private boolean esNroArticuloOK(int codigoArt) {
		return codigoArt>0&&codigoArt<10;
		
	}


	private Pedido buscarPedidoXnumero(int nroPedido) {
		 int i=0;
		 Pedido p=null;
		 Pedido existe=null;
		 boolean bandera=false;
		 		 
		 while(i<pedidos.size()&& !bandera) {
			 p=pedidos.get(i);
			 bandera=(p.getnPedido()==nroPedido)?true:false;
			 if(bandera) {
				 existe=p;
			 };
			 i++;
		 }
		return existe;
		
	}

	//pedidoMasAlto: mostrará todos los datos del pedido que tenga el importe más alto de todos los ingresados. 
	
	 public void pedidoMasAlto() {		 
		 Pedido p;
		 int i=0;
		 int max=0;
		 Pedido pedidoMax = null;
		 
		 while (i<pedidos.size()) {
			 p=pedidos.get(i);
			 if (max<p.dameMonto()) {
				 max=p.dameMonto();
				 pedidoMax=p;
			 }
			 i++;
		 }
		System.out.println( pedidoMax.toString());
		 
	 }
	
	 /*
	  * • entregar: cambia el estado del pedido cuando el mismo sea entregado. Este cambio se podrá hacer solo si el
pedido aún tiene unidades pendientes de entrega, recibiendo el número del mismo y la cantidad entregada. Se
permiten entregas parciales. La cantidad entregada no podrá ser mayor que la cantidad original y si fuera igual a
la misma el pedido quedará en estado "E" (entregado). Por supuesto que el pedido debe existir. 

	  * */
	 
	 public void entregar (int pedido, int cant) {
		 Pedido p = null;
		 
		 p=buscarPedidoXnumero(pedido);
		 if(!(p==null)) {
			if(p.getPendiente()>0 && cant<=p.getPendiente()) {
				p.setPendiente(p.getPendiente()-cant);
				if(p.getPendiente()==0) {
					p.setEstado(Estado.E);
				}
			}else {
				System.out.println("pedido sin entregas pendientes// cantidad a entregar mayor a la solicitada");
			}
			 	 
		 }else {
			 System.out.println("Nro de pedido no existe");
		 }
		 
		 System.out.println(p.toString());
	 }
	 
	 
}
