
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
 * El codigo {@code Digrafo} class es la representacion
 * de un Grafo dirigido. Esta realizado mediante la interface
 * de java.
 *
 * Compilacion: make
 */
public class Digrafo implements Grafo
{   private LinkedList<Vertice> vertices;
    private LinkedList<Arco> arcos;
    private int V;
    private int E;

    //Contructor de la clase
    //Pre: true
    //Post: el grafo esta inicializado
    public Digrafo() {
        vertices= new LinkedList<Vertice>();
        arcos= new LinkedList<Arco>();
        this.V=0;
        this.E=0;
        this.vertices=vertices;
        this.arcos=arcos;
    }
    /**
     *Carga en un grafo la informacion almacenada en el archivo de texto cuya direccion viene dada 
     * por @param dirArchivo 
     * @throws IllegalArgumentException if {@code V < 0}
     * @throws IllegalArgumentException if {@code E < 0}
     * @return true si todo fue cargado correctamente y false, si lo contrario.
    */
    //Pre: Archivo cumple con el formato de grafos ya establecido
    //Post: Todo vertice y arco del archivo debe estar en las listas del Grafo
    public boolean cargarGrafo(String dirArchivo) {
        try{
            //Para leer el archivo con un Buffer
            File file = new File(dirArchivo);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            //Leemos la primera linea (Num de vertices)
            line = bufferedReader.readLine();
            int V = Integer.parseInt(line);
            if (V < 0) throw new IllegalArgumentException("El numero de vertices debe ser no negativo");
            this.V=V;
            //Leemos la segunda linea (Num de lados)
            line = bufferedReader.readLine();
            int E = Integer.parseInt(line);
            if (E < 0) throw new IllegalArgumentException("El numero de lados debe ser no negativo");
            this.E=E;
            /** var:
                numVertice= para calcular cuantas lineas contare
                            sabiendo que son los vertices.
                */
            int numVertice=0;
            int numLados=0;
            //Leemos las siguientes lineas para almacenar los vertices leidos
            while (numVertice<V) {
                   line = bufferedReader.readLine();
                   String[] information = line.split(" ");
                   double peso=Double.parseDouble(information[1]);
                   Vertice v= new Vertice(information[0], peso);
                   vertices.add(v);
                   numVertice++;
            }
            while (numLados<E) {
                   line = bufferedReader.readLine();
                   String[] information = line.split(" ");
                   double peso=Double.parseDouble(information[3]);
                   if (peso < 0) throw new IndexOutOfBoundsException("El peso debe ser positivo");
                   Vertice v= new Vertice(information[1], peso);
                   Vertice w= new Vertice(information[2], peso);
                   //Para un grafo
                   Arco a1= new Arco(information[0], peso, v,w);
                   //Para un digrafo
                   arcos.add(a1);
                   numLados++;
            }

            //Si ingresa en la lista todos los vertices y todos lo lados.
            if(vertices.size()==V & arcos.size()==E)return true;
            else return false;

        }catch (Exception e) {
            throw new InputMismatchException("Invalid input format in Digraph constructor");
        }
    }
    
    /**
     *Retorna el numero de vertices del Grafo 
     * @return V, el numero de vertices del grafo.
    */
    //Pre: True
    //Post: V == numero de vertices del grafo
    public int numeroDeVertices() {
        return V;
    }
    /**
     *Retorna el numero de aristas del Grafo 
     * @return E, el numero de aristas del grafo.
    */
    //Pre: True
    //Post: E == numero de arcos del grafo
    public int numeroDeLados() {
        return E;
    }
   /**
     *Retorna true si se agrego correctamente el vertice al Grafo
     * @param V vertice a anadir
     * @return true, si se ingreso correctamente el vertice, false lo contrario.
    */
    //Pre: Parametro de tipo Vertice 
    //Post: ( true = el vertice se ha anadido al grafo) || 
    //              ( false = el vertice no se ha podido anadir al grafo)
    public boolean agregarVertice(Vertice v) {
        for(Vertice i: vertices){
            if(i.getId().equals(v.getId()))
            {
                return false;
            }
        }
        V++;
        return vertices.add(v);
    }
    /**
     *Retorna true si se agrego correctamente el vertice al Grafo
     * @param id ID del vertice
     * @param peso el peso del vertice a anadir
     * @return true, si se ingreso correctamente el vertice, false lo contrario.
    */
    //Pre: Parametro de tipo string y double 
    //Post: ( true = el vertice se ha anadido al grafo) || 
    //              ( false = el vertice no se ha podido anadir al grafo)
    
    public boolean agregarVertice(String id, double peso) {
        for(Vertice i: vertices){
                if(i.getId().equals(id))
                {
                    return false;
                }
            }
        Vertice v= new Vertice(id, peso);
        V++;
        return vertices.add(v);
    }
    /**
     *Retorna el vertise querido a traves del ID del vertice
     * @param id ID del vertice
     * @return v vertice querido
    */
    //Pre: Parametro de tipo string
    //Post: Vertide con identificador id.
    public Vertice obtenerVertice(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");
        Vertice c= new Vertice(id,0);
        for(Vertice i: vertices){
                if(i.getId().equals(id)){
                    System.out.println("hola");
                    return i;
                }
        }
        return c;
    }
    /**
     *Retorna true si el vertice esta en el grafo
     * @param id ID del vertice
     * @return true si el vertice esta, false lo contrario
    */
    //Pre Parametro tipo string
    //Post true si existe un vertice con identificador id
    public boolean estaVertice(String id) {
        for(Vertice i: vertices){
            if(i.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    /** 
     *{@code estaLado} funciona de tal manera de que itera en la lista
     *de aristas, luego por cada Arco que este compara su extremo 1 y 
     *su extremo2 si concuerda con los parametros de entrada @u y @v 
     *entonces el lado existe
     *@return true si el Lado esta en el grafo, false lo contrario
    */
    //Pre Parametros (u,v) tipo string
    //Post true si el Lado(u,v) exite en la lista de arcos
    public boolean estaLado(String u, String v){
        boolean a=false,b=false;
        for(Arco i: arcos){
            if(i.getExtremoInicial().getId().equals(u)){
                a=true;
            }
             if(i.getExtremoFinal().getId().equals(v)){
                b=true;
             }
             if((a==true) &  (b==true)) return true;
        }
        return false;
    }
    /**
    * Retorna true si se elimino correctamente el vertice
    * Se va comparando cada vertice por su ID y cuando coincida con 
    * el @param id descontamos a la variable <em>V</em> y removemos
    * de la lista de vertices
    * @return true si se elimino correctamente, false lo contrario
    * @throws NoSuchElementException si el vertice no se encuentra en el grafo
    */
    //Pre Parametro tipo string && el vertice con ese string debe existir
    //Post El vertice id no debe estar en la lista de vertices && sus Lados no deben estar en la lista de arcos
    public boolean eliminarVertice(String id) {
         if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");
         int m=0,n=0;
         int cantidadLados=0;
        for(Vertice i: vertices){
            m++;
            if(i.getId().equals(id)){
                for(Arco j: arcos){
                    n++;
                    if(j.getExtremoInicial().getId().equals(id)){
                        cantidadLados++;
                    }
                }
                V--;
                E=E-cantidadLados;
                arcos.remove(n-1);
                vertices.remove(m-1);
                return true;

            }
        }
        return false;
    }
    /** 
     * Retorna la lista de vertices
     *  @return La lista que contiene todos los vertices
     */
    //Pre True
    //Post numero de vertices en el grafo
    public List<Vertice> vertices() {
        return vertices;
    }
    /** 
     * Retorna la lista los lados del grafo
     *  @return La lista que contiene todos los lados
     */
    //Pre True
    //Post numero de lados en el grafo
    public List<Lado> lados() {
        LinkedList<Lado> lis = new LinkedList<Lado>();
        for(Arco i: arcos){
              lis.add(i);
        }
        return lis;
    }
    /** 
     * Retorna el grado del vertice 
     *  @param id vertice en el cual queremos saber el grado
     *  @return un entero que es el grado del vertice
    */
    //Pre Parametro tipo string
    //Post Grado=Cantidad de lados interior + Cantidad de lados exterior
    public int grado(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");
        int grado;
        grado=gradoInterior(id)+gradoExterior(id);
        return grado;
    }
    /** 
     * Retorna la lista los lados adyacentes de un vertice
     *  @param id ID der vertice en el cual queremos saber sus vertices adyacentes 
     *  @return La lista que contiene todos los lados adyacentes del vertice
     * {@code adyacentes} Compara si en las aristas hay un nodo
     * extremo con el parametro de entrada <em>id</em> y si lo consigue, busca luego 
     * en la lista de vertices el lado extremo del parametro(que sera el adyacente)
     * y lo agrega a la nueva lista de vertices creada en la funcion
     * @throws NoSuchElementException si el vertice no se encuentra en el grafo
     */
    // Pre Parametro tipo string y el id del vertice debe existir en la lista de vertices
    // Post result= vertices que sean adyacentes al vertice con identificador id.
    public List<Vertice> adyacentes(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");        
        LinkedList<Vertice> result = new LinkedList<Vertice>();
        for(Arco i: arcos){
            if (i.getExtremoInicial().getId().equals(id)){
                for(Vertice j: vertices){
                    if(j.getId().equals(i.getExtremoFinal().getId())){
                        result.add(j);
                    }
                }
            }
        }
        return result;
    }
    /** 
     * Retorna los lados incidentes del vertice 
    * @param id ID del vertice a buscar los lados incidentes de el
    * @return los lados incidentes al vertice de entrada
    * @throws NoSuchElementException si el vertice no se encuentra en el grafo
    */
    //Pre Parametro string
    // Post l= lados que inciden en el vertice con identificador id
    public List<Lado> incidentes(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");
        LinkedList<Lado> l = new LinkedList<Lado>();
        for(Arco i: arcos){
            if(i.getExtremoFinal().getId().equals(id)){
                Arco arc = new Arco(i.getId(),i.getPeso(), i.getExtremoInicial(), i.getExtremoFinal());
                l.add(arc);
            }
        }
        return l;
    }

    /** 
    * Retorna true si de agregaron correctamente el arco 
    * @param a Arco a agragar
    * @return true si se agrego correctamente, false lo contrario
    * @throws NoSuchElementException si algun vertice de extremo no se encuentra en el grafo
    */
    //Pre Parametro de tipo Arco y el id del arco para agregar no debe estar en los id de la lista de arcos
    //Post true si se agrego el arco en la lista de arcos
    public boolean agregarArco(Arco a) {
    
    //verifico si estan los vertices para hacer el arco
        if(estaVertice(a.getExtremoInicial().getId())==false) throw new NoSuchElementException("El vertice con que quiere hacer el arco no se encuentra");
        if(estaVertice(a.getExtremoFinal().getId())==false) throw new NoSuchElementException("El vertice con que quiere hacer el arco no se encuentra");
    //verifico si ya se encuentra el arco
        boolean esta=false;
        for(Arco i: arcos){
            if(i.getId().equals(a.getId()))
            {
                esta=true;
            }
        }
       if(esta==false){
        E++;
        return arcos.add(a);
        }
        else return false;
    } 
    /** 
    * Retorna true si de agregaron correctamente el arco
    * @param id ID de la Arco a agregar
    * @param peso peso del arco
    * @param u extremo del arco
    * @param v extremo del arco
    * @return true si se agrego correctamente, false lo contrario
    */
    //Pre Parametro string, double, string, string y verificar si los vertices extremos del arco existan
    //Post El Arco u->v se agrego en la lista de arcos
    public boolean agregarArco(String id, double peso, String u, String v) {
        //verifico si estan los vertices para hacer el arco
        if(estaVertice(u)==false) throw new NoSuchElementException("El vertice "+ u +" no se encuentra");
        if(estaVertice(v)==false) throw new NoSuchElementException("El vertice " + v +" no se encuentra");
        //verifico si ya se encuentra el nombre del arco
        boolean esta=false;
        
        for(Arco i: arcos){
            if(i.getId().equals(id)){
                esta=true;break;
            }
        }
        //Si no esta el nombre del arco procedo a agregarlo
           if(esta==false){
            double peso1=0,peso2=0;
                    for(Vertice i: vertices){
                        if(i.getId().equals(u)){
                            peso1=i.getPeso(); 
                            break;                  
                            
                        }
                    }
                    for(Vertice i: vertices){
                        if(i.getId().equals(v)){
                            peso2=i.getPeso();
                            break;
                        }
                    }
            Vertice b= new Vertice(u,peso1);
            Vertice c= new Vertice(v,peso2);
            Arco a = new Arco(id,peso,b,c);
            E++;
            return arcos.add(a);
            }
        return false;
    }
        
    
    /** 
     * Retorna el grado exterior del vertice
     * @return entero que indica el grado interior del vertice
     */
    //Pre paramentro string y el id debe estar en la lista de id de los vertices 
    //Post cantidad de arcos que salen del vertice con identificar id
    public int gradoExterior(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");
        int grado=0;
        for(Arco i: arcos){
            if(i.getExtremoInicial().getId().equals(id)){
                grado++;
            }
        }
        return grado;
    }
    /** 
     * Retorna el grado interior del vertice
     * @return entero que indica el grado exterior del vertice
     */
    //Pre Parametro tipo string y el id debe estar en la lista de id de los vertices  
    //Post cantidad de arcos que entran al vertice con identificar id
    public int gradoInterior(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");
        int grado=0;
        for(Arco i: arcos){
            if(i.getExtremoFinal().getId().equals(id)){
                grado++;
            }
        }
        return grado;
    }
    /** 
     * Retorna una lista de sucesores del vertice
     * @return retorna una lista de sucesores del vertice
     * @throw NoSuchElementException cuando el vertice no esta
     */
    //Pre Parametro de tipo string y el vertice con el identificador id debe estar en la lista de vertices
    //Post Lista de vertices que son adyacentes al vertice con identificador id 
    public List<Vertice> sucesores(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");        
        List<Vertice> result = new LinkedList<Vertice>();
        result= adyacentes(id);
        return result;
    }
    /** 
     * Retorna una lista de predecesores del vertice
     * @return retorna una lista de sucesores del vertice
     * @throw NoSuchElementException cuando el vertice no esta
     */
    //Pre Parametro de tipo string y el vertice con el identificador id debe estar en la lista de vertices
    //Post Lista de vertices que son extremo inicial del vertice final con identificador id 
    public List<Vertice> predecesores(String id) {
        if(estaVertice(id)==false) throw new NoSuchElementException("El vertice no se encuentra");        
        LinkedList<Vertice> result = new LinkedList<Vertice>();
        for(Arco i: arcos){
            if (i.getExtremoFinal().getId().equals(id)){
                for(Vertice j: vertices){
                    if(j.getId().equals(i.getExtremoInicial().getId())){
                        result.add(j);
                    }
                }
            }
        }
        return result;
    }
    /** 
     * Retorna true si se elimino correctamente el arco
     * @return true si se elimino correctamente, false lo contrario
     * @throw NoSuchElementException cuando el arco no esta
     */
    //Pre Parametro de tipo string y el arco con identificador id debe existir en la lista de arcos
    //Post El arco con identificador id no debe estar en la lista de arcos
    public boolean eliminarArco(String id) {
        boolean esta=false;
        int j=0;
        for(Arco i: arcos){
            j++;
            if(i.getId().equals(id)){
                esta=true;break;
            }
        }

        if(esta==false){
           throw new NoSuchElementException("El arco no se encuentra");        
       }
        else {
                arcos.remove(j-1);
                E--;
            return true;}
    }
    /**
    * Retorna el arco buscado a traves de 
    * @param id y
    * @return el arco buscado
    * @throw NoSuchElementException si no existe el arco
    */
    //Pre Parametro tipo string del arco
    //Post Arco con identificador id
    public Arco obtenerArco(String id) {
        for(Arco i : arcos){
            if(i.getId().equals(id)){
                    return i;
            }

        } 
        throw new NoSuchElementException("El arco no se encuentra");
    }	

    /**
    * Retorna un grafo con los mismos datos que el de entrada
    * @return grafo 
    */
    public Object clone() {
        Digrafo G= new Digrafo();
        for(Vertice i: vertices){
            G.agregarVertice(i);
        }
        for(Arco i: arcos){
            G.agregarArco(i);
        }
        return G;
    }
    /**
    * Retorna la impresion de un grafo
    * @return String de caracteres del grafo
    */
    public String toString() {
        String b="";
        String a="";
        b= "\n IDVerticeInicial PesoVerticeInicial :  IDVerticeFinal PesoVerticeFinal IDArco PesoArco \n" + b;
        a=a+b;
        for (Vertice j: vertices){
            b= j.getId() +" Peso: " + j.getPeso() +"  -->  \n" ;
            a=a+b; 
           for(Arco i: arcos){
                for(Vertice k:vertices){
                    if(j.getId().equals(i.getExtremoInicial().getId()) & i.getExtremoFinal().getId().equals(k.getId()))
                    {
                        b= k.getId() + "  Peso: " + k.getPeso()+ " || Arco : "+ i.getId()+" "+i.getPeso()  +"\n " ;
                        a=a+b;
                    }
                }
            } b= "\n"; a=a+b;
        }
        return a;
    }


}