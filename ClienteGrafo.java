import java.io.*;
import java.util.*;
/**
 *
 *
 *
 * Integrantes:
 * @autor Maria Bracamonte 10-11147
 * @autor Edwin Franco 12-10630
 *
 * El codigo {@code ClienteGrado} Prueba. 
 *
 * Compilacion: make
 */

import java.util.*;
//Descomente esta parte del codigo para probar el funcionamiento de las funciones no mostradas 
//y comente el codigo que esta debajo de este

/*public class ClienteGrafo {
  public static void main(String [] args) {
  	int peso=100;
  	System.out.println("Grafo Dirigido");
  	Digrafo DG = new Digrafo();
  	System.out.println(DG.cargarGrafo(args[0]));
  	System.out.println(DG.toString());
  	Vertice a =new Vertice("ID vertice1",peso);
  	Vertice b =new Vertice("ID vertice2",peso);
  	System.out.println(DG.agregarVertice(a)); 
  	System.out.println(DG.agregarVertice(b));
  	Arco l = new Arco("IDLado", peso, a,b);
  	System.out.println(DG.agregarArco(l));
  	System.out.println(DG.toString());
  	
  	System.out.println("Grafo NO Dirigido");
  	GrafoNoDirigido ND = new GrafoNoDirigido();
  	System.out.println(ND.cargarGrafo(args[0]));
  	System.out.println(ND.toString());
  	Vertice c =new Vertice("ID vertice1",peso);
  	Vertice d =new Vertice("ID vertice2",peso);
  	System.out.println(ND.agregarVertice(c));
  	System.out.println(ND.agregarVertice(d)); 
  	Arista ar = new Arista("IDLado", peso, c,d);
  	System.out.println(ND.agregarArista(ar));

  }
}*/

class ClienteGrafo {

	public static void main(String [] args)
	throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        int res1;//variable que contiene la respuesta
        while(true){
	        System.out.println("Indique que tipo de grafo quiere cargar:");
	        System.out.println("1-Grafo Dirigido");
	        System.out.println("2-Grafo No Dirigido\n");
	        res1 = Integer.parseInt(br.readLine());
	        System.out.println("Ha elegido la opcion: "+res1);
	        if (res1 == 1 || res1 == 2){
	        	break;
	        }
	        else{
	        	System.out.println("Opcion invalida");
	        }
	        
	    }
	    System.out.println("Indique el nombre del archivo a cargar: ");
	    String file = br.readLine();
	    boolean p2 = true;
	    int res2;//variable que toma la respuesta 2
	    String id;
	    double p;
	    String vi;
	    String vf;
	    String str;
	    if (res1 == 1){
	    	Digrafo g = new Digrafo();
	    	System.out.println("Por favor espere mientras se carga su Grafo");
	    	System.out.println(g.cargarGrafo(file));
	    	while (p2){
	    		System.out.println("\n\nSeleccione una opcion:");
	    		System.out.println("1-Agregar Vertice");
	    		System.out.println("2-Agregar Arco");
	    		System.out.println("3-Eliminar Vertice");
	    		System.out.println("4-Eliminar Arco");
	    		System.out.println("5-Obtener Numero de Vertices");
	    		System.out.println("6-Obtener Numero de Lados");
	    		System.out.println("7-Obtener el Grado Total de un Vertice");
	    		System.out.println("8-Obtener el Grado Interior de un Vertice");
	    		System.out.println("9-Obtener el Grado Exterior de un Vertice");
	    		System.out.println("10-Obtener los Vertices Adyacentes a un Vertice");
	    		System.out.println("11-Obtener los Arcos Incidentes a un Vertice");
	    		System.out.println("12-Obtener los Vertices Sucesores de un Vertice");
	    		System.out.println("13-Obtener los Vertices Predecesores de un Vertice");
	    		System.out.println("14-Imprimir Grafo");
	    		System.out.println("15-Clonar Grafo");
	    		System.out.println("16-Salir\n");
	    		res2 = Integer.parseInt(br.readLine());
	    		//Caso Agregar Vertice
	    		if (res2 == 1){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("Indique el Peso del Vertice: ");
	    			p = Double.parseDouble(br.readLine());
	    			System.out.println("El Vertice se ha Agregado al Grafo? "+ g.agregarVertice(id,p));
	    		}
	    		//Caso Agregar Arco
	    		else if (res2 == 2){
	    			System.out.println("Indique el Identificador del Arco: ");
	    			id = br.readLine();
	    			System.out.println("Indique el Peso del Arco: ");
	    			p = Double.parseDouble(br.readLine());
	    			System.out.println("Indique el Identificador del Vertice Inicial: ");
	    			vi = br.readLine();
	    			System.out.println("Indique el Identificador del Vertice Final: ");
	    			vf = br.readLine();
	    			System.out.println("El Arco se ha Agregado al Grafo? "+ g.agregarArco(id,p,vi,vf));
	    		}
	    		//Caso Eliminar Vertice
	    		else if(res2 == 3){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("El Vertice se ha Eliminado? " + g.eliminarVertice(id));
	    			
	    		}
	    		//Caso Eliminar Arco
	    		else if(res2 == 4){
	    			System.out.println("Indique el Identificador del Arco: ");
	    			id = br.readLine();
	    			vi = g.obtenerArco(id).getExtremoInicial().getId();
	    			vf = g.obtenerArco(id).getExtremoFinal().getId();
	    			System.out.println("El Arco se ha Eliminado? " + g.eliminarArco(id));
	    		}
	    		//Caso Numero de Vertices
	    		else if(res2 == 5){
	    			System.out.println("El Grafo Tiene " + g.numeroDeVertices() + " Vertices");
	    		}
	    		//Caso Numero de Lados
	    		else if(res2 == 6){
	    			System.out.println("El Grafo Tiene " + g.numeroDeLados() + " Arcos");
	    		}
	    		//Caso Grado del Vertice
	    		else if (res2 == 7){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("El Vertice " + id + " es de Grado " + g.grado(id));	
	    		}
	    		//Caso Grado Interior del Vertice
	    		else if (res2 == 8){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("El Vertice " + id + " es de Grado Interior " + g.gradoInterior(id));
	    		}
	    		//Caso Grado Exterior del Vertice
	    		else if (res2 == 9){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("El Vertice " + id + " es de Grado Exterior " + g.gradoExterior(id));
	    		}
	    		//Caso Obtener Adyacentes
	    		else if (res2 == 10){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			List<Vertice> lista = new  LinkedList<Vertice>();
	    			lista = g.adyacentes(id);
	    			System.out.println("Los Adyacentes a " + id + " son:");
	    			for(Vertice i: lista){
	    				System.out.println(" ID: " + i.getId() + " Peso: " + i.getPeso());
	    			}
	    		}
	    		//Caso Obtener Incidentes
	    		else if (res2 == 11){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			List<Lado> lista = new LinkedList<Lado>();
	    			lista=g.incidentes(id);
	    			System.out.println("Los Incidentes a " + id + " son:");
	    			for(Lado i: lista){
	    				System.out.println(" ID: " + i.getId() + " Peso: " + i.getPeso());
	    			}
	    		}
	    		//Caso Obtener Sucesores
	    		else if (res2 == 12){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			List<Vertice> lista = new LinkedList<Vertice>();
	    			lista=g.sucesores(id);
	    			System.out.println("Los Sucesores a " + id + " son:");
	    			for(Vertice i: lista){
	    				System.out.println(" ID: " + i.getId() + " Peso: " + i.getPeso());
	    			}
	    		}
	    		//Caso Obtener Predecesores
	    		else if (res2 == 13){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			List<Vertice> lista = new LinkedList<Vertice>();
	    			lista=g.predecesores(id);
	    			System.out.println("Los Predecesores a " + id + " son:");
	    			for(Vertice i: lista){
	    				System.out.println(" ID: " + i.getId() + " Peso: " + i.getPeso());
	    			}
	    		}
	    		//Caso Imprimir
	    		else if(res2 == 14){
	    			System.out.println(g.toString());
	    		}
	    		//Caso Salir
	    		else if (res2 == 15){
	    			Object Nuevo= new Digrafo();
	    			Nuevo=g.clone();
	    			System.out.println("El nuevo Grafo Clonado es= " + Nuevo);
	    		}
	    		else if (res2 == 16){
	    			System.out.println("Hasta Pronto!");
	    			p2 = false;
	    		}
	    		else{
	    			System.out.println("Opcion Invalida");
	    		}
	    	}
	    }
	    if (res1 == 2){
	    	GrafoNoDirigido g = new GrafoNoDirigido();
	    	System.out.println("Porfavor espere mientras se carga su Grafo");
	    	System.out.println("Se ha cargado su Grafo exitosamente? " + g.cargarGrafo(file)+ "\n");
	    	while (p2){
	    		System.out.println("\n Seleccione una opcion:");
	    		System.out.println("1-Agregar Vertice");
	    		System.out.println("2-Agregar Arista");
	    		System.out.println("3-Eliminar Vertice");
	    		System.out.println("4-Eliminar Arista");
	    		System.out.println("5-Obtener Numero de Vertices");
	    		System.out.println("6-Obtener Numero de Lados");
	    		System.out.println("7-Obtener el Grado Total de un Vertice");
	    		System.out.println("8-Obtener los Vertices Adyacentes a un Vertice");
	    		System.out.println("9-Obtener las Aristas Incidentes a un Vertice");
	    		System.out.println("10-Imprimir Grafo");
	    		System.out.println("11-Clonar Grafo");
	    		System.out.println("12-Salir\n");
	    		res2 = Integer.parseInt(br.readLine());
	    		//Caso Agregar Vertice
	    		if (res2 == 1){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("Indique el Peso del Vertice: ");
	    			p = Double.parseDouble(br.readLine());
	    			System.out.println("El Vertice se ha Agregado al Grafo? "+ g.agregarVertice(id,p));
	    		}
	    		//Caso Agregar Arista
	    		else if (res2 == 2){
	    			System.out.println("Indique el Identificador del Arista: ");
	    			id = br.readLine();
	    			System.out.println("Indique el Peso del Arista: ");
	    			p = Double.parseDouble(br.readLine());
	    			System.out.println("Indique el Identificador del Vertice Inicial: ");
	    			vi = br.readLine();
	    			System.out.println("Indique el Identificador del Vertice Final: ");
	    			vf = br.readLine();
	    			System.out.println("El Arista se ha Agregado al Grafo? "+g.agregarArista(id,p,vi,vf));
	    		}
	    		//Caso Eliminar Vertice
	    		else if(res2 == 3){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("El Vertice se ha Eliminado? "+ g.eliminarVertice(id));
	    		}
	    		//Caso Eliminar Arista
	    		else if(res2 == 4){
	    			System.out.println("Indique el Identificador del Arista: ");
	    			id = br.readLine();
	    			System.out.println("El Arista se ha Eliminado? "+g.eliminarArista(id));
	    		}
	    		//Caso Numero de Vertices
	    		else if(res2 == 5){
	    			System.out.println("El Grafo Tiene " + g.numeroDeVertices() + " Vertices");
	    		}
	    		//Caso Numero de Lados
	    		else if(res2 == 6){
	    			System.out.println("El Grafo Tiene " +  g.numeroDeLados() + " Aristas");
	    		}
	    		//Caso Grado del Vertice
	    		else if (res2 == 7){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			System.out.println("El Vertice " + id + " es de Grado " + g.grado(id));
	    		}
	    		//Caso Obtener Adyacentes
	    		else if (res2 == 8){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			List<Vertice> lista = new LinkedList<Vertice>();
	    			lista=g.adyacentes(id);
	    			System.out.println("Los Adyacentes a " + id + " son:");
	    			for(Vertice i: lista){
	    				System.out.println(" ID: " + i.getId() + " Peso: " + i.getPeso());
	    			}
	    		}
	    		//Caso Obtener Incidentes
	    		else if (res2 == 9){
	    			System.out.println("Indique el Identificador del Vertice: ");
	    			id = br.readLine();
	    			List<Lado> lista = new LinkedList<Lado>();
	    			lista= g.incidentes(id);
	    			System.out.println("Los Incidentes a " + id + " son:");
	    			for(Lado i: lista){
	    				System.out.println(" ID: " + i.getId() + " Peso: " + i.getPeso());
	    			}
	    		}
	    		//Caso Imprimir
	    		else if(res2 == 10){
	    			System.out.println(g.toString());
	    		}
	    		//Caso clonar
	    		else if (res2 == 11){
	    			Object Nuevo= new GrafoNoDirigido();
	    			Nuevo=g.clone();
	    			System.out.println("El nuevo Grafo Clonado es= " + Nuevo);
	    		}
	    		//Caso Salir
	    		else if (res2 == 12){
	    			System.out.println("Hasta Pronto!");
	    			p2 = false;
	    		}
	    		else{
	    			System.out.println("Opcion Invalida");
	    		}
	    	}
	    }

	}
}
