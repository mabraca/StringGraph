/**
 *
 *
 *
 * Integrantes:
 * @autor Maria Bracamonte 10-11147
 * @autor Edwin Franco 12-10630
 *
 * El codigo {@code Arco} class es la representacion
 * de los arcos de un grafo. Esta realizado mediante la clase abstracta
 * de java.
 *
 * Compilacion: make
 */

public class Arco extends Lado
{
	private Vertice extremoInicial;
	private Vertice extremoFinal;
	private String id;
	private double peso;
	/*
	Pre: True
	Post: this.id == id && this.peso == peso && 
	this.extremoInicial = extremoInicial && this.extremoFinal = extremoFinal
	*/
	public Arco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal) {
				super(id,peso);
				this.id=id;
				this.peso=peso;
				this.extremoInicial=extremoInicial;
				this.extremoFinal=extremoFinal;
				

	}
	//Metodo que devuelve la identificacion del vertice 
	//Pre: True
	//Post: Retorna id
	 public String getId() {
			return id;
		}

	public double getPeso() {
			return peso;
		}
	//Metodo que devuelve el peso del vertice 
	//Pre: True
	//Post: Retorna peso
	public Vertice getExtremoInicial() {
		return extremoInicial;
	}
	//Metodo que devuelve el vertice inicial del arco
	//Pre: True
	//Post: Retorna extremoInicial
	public Vertice getExtremoFinal() {
		return extremoFinal;
	}
	//Metodo que devuelve el Arco en forma de string consultando el metodo abstracto Lado
	//Pre: True
	//Post: str == "Arco:\n" + id + "\nPeso:\n" + peso
	public String toString() {
		return "Arco: "+ id + " - Peso: "+ peso;
	}

}