package clases;

public class Pedido {
	
	private int nPedido;
	private int codigoArt;
	private int cant;
	private int importe;
	private int pendiente;
	private Estado estado;
	
	
	public Pedido(int nPedido, int codigoArt, int cant, int importe, int pendiente, Estado estado) {
		this.nPedido = nPedido;
		this.codigoArt = codigoArt;
		this.cant = cant;
		this.importe = importe;
		this.pendiente = pendiente;
		this.estado = estado;
	}


	public int getnPedido() {
		return nPedido;
	}

	public int dameMonto() {
		return importe;
	}


	public int getPendiente() {
		return pendiente;
	}


	public void setPendiente(int pendiente) {
		this.pendiente = pendiente;
	}





	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Pedido [nPedido=" + nPedido + ", codigoArt=" + codigoArt + ", cant=" + cant + ", importe=" + importe
				+ ", pendiente=" + pendiente + ", estado=" + estado + "]";
	}
	
	
	
	
	
}
