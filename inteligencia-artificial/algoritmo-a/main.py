distanciaEnLineaRectaABucarest = {"arad": 366, "bucharest": 0, "craiova": 160, "dobreta": 242, "eforie": 161,
                                  "fagaras": 178, "giurgiu": 77, "hirsova": 151, "iasi": 226, "lugoj": 244,
                                  "mehadia": 241, "neamt": 234, "oradea": 380, "pitesti": 98, "rimnicu-vilcea": 193,
                                  "sibiu": 253, "timisoara": 329, "urziceni": 80, "vasiui": 199, "zerind": 374}


class Nodo:
    nodosAdyacentes = []

    def __init__(self, nombre):
        self.nombre = nombre;


class NodoAdyacente:
    def __init__(self, nombre, distancia):
        self.nombre = nombre;
        self.distancia = distancia;


nodos = [];

leyendoDatos = True;

corte = 'fin';

mejorRuta = ['timisoara'];

distanciaMejorRuta = 0;

ciudadFinal = "bucharest";


def leerLista():
    while (leyendoDatos):
        nombreCiudad = input();

        if (nombreCiudad == corte):
            break;

        nuevoNodo = Nodo('');
        nuevoNodo.nombre = nombreCiudad;

        while True:
            nuevoNodoAdyacente = NodoAdyacente('', 0)

            nombreCiudad = input()

            if (nombreCiudad == corte):
                break;

            nuevoNodoAdyacente.nombre = nombreCiudad;
            nuevoNodoAdyacente.distancia = int(input());

            nuevoNodo.nodosAdyacentes.append(nuevoNodoAdyacente)

        nodos.append(nuevoNodo);


def calcularDistanciaDirectaABucharest(nodo):
    return distanciaEnLineaRectaABucarest[nodo.nombre];


def costeEstimadoDeCamino(nodoInicial, nodoFinal):
    for nodo in nodos:
        if (nodoInicial.nombre == nodo.nombre):
            for nodoAdyacente in nodo.nodosAdyacentes:
                if (nodoFinal.nombre == nodoAdyacente.nombre):
                    return nodoAdyacente.distancia;


def costoTotal(nodoInicial, nodoFinal):
    return calcularDistanciaDirectaABucharest(nodoFinal) + costeEstimadoDeCamino(nodoInicial, nodoFinal);


def mostrarMejorRuta():
    for ciudad in mejorRuta:
        print(ciudad)

    print(ciudadFinal)
    print(str(distanciaMejorRuta) + 'km')


def algoritmoA:
    ciudadActual = mejorRuta[len(mejorRuta)-1]

    while True:
        for nodoActual in nodos:
            if(nodoActual.nombre == ciudadActual):
                ciudadAdyacenteElegida = 'ciudadAdyacenteElegida';
                distanciaAdyacenteElegida = 999999999999;
                for nodoAdyacente in nodoActual.nodosAdyacentes:
                    if(nodoAdyacente.nombre == ciudadFinal):
                        mejorRuta.append(ciudadFinal)
                        nodoAdyacente
                        return;
                    if(costoTotal(nodoActual, nodoAdyacente)<distanciaAdyacenteElegida):



leerLista();

print(costoTotal(Nodo('timisoara'), Nodo('arad')));

mostrarMejorRuta()
