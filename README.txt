Proyecto 1
Laboratorio Estructura de Algoritmos 3
Integrantes:
Maria Bracamonte
Edwin Franco
Universidad Simon Bolivar.



OBJETIVO

El objetivo de este proyecto es la familiarizacion con las operaciones basicas de los Tipos Abstractos de Datos (TADs) Grafo, Grafo No Dirigido y Grafo Dirigido. Para ello se desea que implemente los siguientes TADs usando el lenguaje de programacion JAVA y tambien que desarrolle una aplicacion cliente que permita probar los TADs. A continuacion se describen los TADs que se deben implementar:

TAD VERTICE
TAD LADO
TAD ARCO
TAD ARISTA
TAD GRAFO
TAD GRADO NO DIRIGIFO
TAD GRAFO DIRIGIDO

TADs Grafo Dirigido y Grafo No Dirigido, estan realizados como listas de adyacencias. Se provee de un conjunto de archivos con las firmas cuya implementacon debe ser completada. Los archivos son: Lado.java, Arco.java, Arista.java, Vertice.java, Grafo.java, Digrafo.java, GrafoNoDirigido.java y ClienteGrafo.java. El archivo ClienteGrafo.java tiene como objetivo servir como un cliente en el
cual se puedan probar las funcionalidades de los TADs.
TADs Grafo Dirigido y Grafo No Dirigido, como listas de adyacencias. Se pro-
vee de un conjunto de archivos con las firmas cuya implementaci ́on debe ser completada. Los archivos son:
Lado.java, Arco.java, Arista.java, Vertice.java, Grafo.java, Digrafo.java, GrafoNoDirigido.java
y ClienteGrafo.java. El archivo ClienteGrafo.java tiene como objetivo servir como un cliente en el
cual se puedan probar las funcionalidades de los TADs.

FUNCIONALIDAD:

1. Para compilar todos los archivos coloque en la consola el comando:
make
2. Para ejecucion coloque en la consola el comando:
java ClienteGrafo
3.Elija la opcion de su preferencia.


Observacion:
1. Los codigos fueron probados con la version de java:
java version "1.7.0_95"
Y funciono correctamente todos los codigos. 

2. Para funciones como agregarVertice(para grafos dirigidos y no dirigidos), agregarArco(para dirigidos) y agregarArista(para no dirigidos) para los parametros previamente creados como un Vertice/Arco/Arista se debe implementar en el main del cliente para su prueba. Colocando: 

agregarVertice(Vertice v) donde v tendra que inicializarce como:
Vertice v= new Vertice(IDNuevoVertice, PesoNuevoVertice) donde 
IDNuevoVertice es una cadena de caracteres y  PesoNuevoVertice es un double.
Esta retornara un true si fue guardado correctamente.

agregarArco(Arco a) donde  a tendra que inicializarce como:
Arco v= new Arco(IDNuevoLado, PesoLado,IDVerticeInicial, IDVerticeFinal) donde 
IDNuevoLado es una cadena de caracteres
IDVerticeInicial,IDVerticeFinal son de tipo Vertices 
PesoLado es un double.
Esta retornara un true si fue guardado correctamente.

agregarArista(Arista a) donde  a tendra que inicializarce como:
Arista v= new Arista(IDNuevoLado, PesoLado,IDVerticeInicial, IDVerticeFinal) donde 
IDNuevoLado es una cadena de caracteres
IDVerticeInicial,IDVerticeFinal son de tipo Vertices 
PesoLado es un double.
Esta retornara un true si fue guardado correctamente.




