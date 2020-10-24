package clases;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empresa e = new Empresa("Pedidos");
		e.cargarPedido(23, 5, 15, 343444 );
		e.cargarPedido(233, 9, 7, 333);
		//e.cargarPedido(2, 9, 7, 339876, 7);
		e.cargarPedido(2, 9, 7, 33987699);
		e.cargarPedido(87877, 9, 7, 8);
		e.pedidoMasAlto();
		e.entregar(23, 10);
		e.entregar(23, 10);
		e.entregar(23, 5);
	}

}
