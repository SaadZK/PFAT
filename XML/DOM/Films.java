import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.*;
import org.w3c.dom.ls.DOMImplementationLS; 
import org.w3c.dom.ls.LSParser; 
import org.w3c.dom.ls.LSInput; 
import org.w3c.dom.ls.LSException;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer; 
import java.io.*;

/**
 *
 * @author jaf@it.uc3m.es
 * @author luiss@it.uc3m.es
 *
 */
public class Films {

    /* Este método lee un fichero XML y devuelve el objeto DOM
     Document que lo representa. */
    private Document loadDocument(String fileName) 
    	throws IOException, DOMException, LSException, 
	       java.lang.ClassNotFoundException, 
	       java.lang.InstantiationException, 
	       java.lang.IllegalAccessException {

		DOMImplementationRegistry registry;
		DOMImplementation domImp;
		DOMImplementationLS domImpLS;
        LSParser parser;
        LSInput lsInp;

		registry = DOMImplementationRegistry.newInstance();
		domImp = registry.getDOMImplementation("LS 3.0");

        if (domImp == null) {
		    System.out.println("No se encuentra el módulo LS v3.0");
		    return null;
		}

        domImpLS = (DOMImplementationLS) domImp;
        parser = domImpLS.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, "http://www.w3.org/TR/REC-xml");
                
		lsInp = domImpLS.createLSInput();
		lsInp.setByteStream(new FileInputStream(fileName));
		return parser.parse(lsInp);
    }

    private String readInput(String prompt) throws IOException {
		System.out.print(prompt);
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		return stdin.readLine();
    }

    /* Método para volcar a un fichero el documento XML representado
       por un objeto Document */
    private void serialize(Document doc, File file) 
		throws IOException, java.lang.ClassNotFoundException, 
	       java.lang.InstantiationException, 
	       java.lang.IllegalAccessException {

		DOMImplementationRegistry registry;
		DOMImplementation domImp;
		DOMImplementationLS domls;

		registry = DOMImplementationRegistry.newInstance();
		domImp = registry.getDOMImplementation("LS 3.0");

        if (domImp == null) {
		    System.out.println("No se encuentra el módulo LS v3.0");
		    return;
		}

        domls = (DOMImplementationLS) domImp;

		LSOutput output = domls.createLSOutput();
		FileOutputStream outStream = new FileOutputStream(file);
		output.setByteStream(outStream);
	    output.setEncoding("UTF-8");
		LSSerializer serializer = domls.createLSSerializer();
		serializer.write(doc, output);
		outStream.close();
    }

    public static void main(String[] args) throws Exception {

		if (args.length != 2) {
		    printHelp();
		    System.exit(1);
		}

		Films films = new Films();
		String file = args[1];
		Document document = films.loadDocument(file);
		Element conjunto = document.getDocumentElement();

		if ("-l".equals(args[0])) {
			/* Listado breve de películas */
		    NodeList peliculas = conjunto.getElementsByTagName("pelicula");
		    for (int i = 0; i < peliculas.getLength(); i++) {
		    	Element pelicula = (Element) peliculas.item(i);
		    	System.out.println("Película: " + (pelicula.getElementsByTagName("titulo").item(0)).getTextContent());
		    }
		} else if ("-L".equals(args[0])) {
			/* Listado detallado de películas */
			NodeList peliculas = conjunto.getElementsByTagName("pelicula");
		    for (int i = 0; i < peliculas.getLength(); i++) {
		    	/* Node contiene información del DOM y Element de la etiqueta XML (atributos). Casting a Element */
		    	Element pelicula = (Element) peliculas.item(i);
		    	/* pelicula.getAttribute('...') devuelve un String con el valor del atributo buscado */
		    	System.out.println("\nPelícula");
		    	System.out.println("\tAño: " + pelicula.getAttribute("anio"));
		    	System.out.println("\tDuración: " + pelicula.getAttribute("duracion"));

		    	/* pelicula.getElementsByTagName('...') devuelve NodeList, obtenemos item 0 (Node) y luego su texto */
		    	System.out.println("\tTítulo: " + (pelicula.getElementsByTagName("titulo").item(0)).getTextContent());
		    	System.out.println("\tDirector: " + (pelicula.getElementsByTagName("director").item(0)).getTextContent());

		    	NodeList actores = pelicula.getElementsByTagName("actor");
		    	for (int j = 0; j < actores.getLength(); j++) {
		    		Element actor = (Element) actores.item(j);
			    	System.out.println("\tActor: ");
			    	System.out.println("\t\tNombre: " + actor.getAttribute("nombre"));
			    	NodeList personajes;
			    	if (((personajes = actor.getElementsByTagName("personaje"))).getLength() == 1) {
			    		System.out.println("\t\tPersonaje: " + (personajes.item(0)).getTextContent());
			    	}
		    	}
				
				NodeList generos = pelicula.getElementsByTagName("genero");
		    	for (int k = 0; k < generos.getLength(); k++) {
		    		System.out.println("\tGénero: " + (generos.item(k)).getTextContent());
		    	}

		    	NodeList nacionalidades = pelicula.getElementsByTagName("nacionalidad");
		    	for (int z = 0; z < nacionalidades.getLength(); z++) {
		    		System.out.println("\tNacionalidad: " + (nacionalidades.item(z)).getTextContent());
		    	}
		    }
		} else if ("-a".equals(args[0])) {
			/* Se pedirán únicamente los datos obligatorios (menos trabajo) */
			System.out.println("Información de la película (vacío para omitir, [*] es requerido)");
			String anio = "", duracion = "", titulo = "", director = "";

			Node pelicula = document.createElement("pelicula");
			Node nTitulo = document.createElement("titulo");
			Node nDirector = document.createElement("director");

			while(anio.isEmpty()) {
				anio = films.readInput("anio [*]: ");
			}
			((Element) pelicula).setAttribute("anio", anio);

			while(duracion.isEmpty()) {
				duracion = films.readInput("duracion [*]: ");
			}
			((Element) pelicula).setAttribute("duracion", duracion);

			while(titulo.isEmpty()) {
				titulo = films.readInput("titulo [*]: ");
			}
			nTitulo.appendChild(document.createTextNode(titulo));

			while(director.isEmpty()) {
				director = films.readInput("director [*]: ");
			}
			nDirector.appendChild(document.createTextNode(director));

			/* Añadimos nodos al DOM */
			pelicula.appendChild(nTitulo);
			pelicula.appendChild(nDirector);
	        conjunto.appendChild(pelicula);

	        /* Creamos el nuevo fichero modificado */
			films.serialize(document, new File("Modificado.xml"));

		} else {
			printHelp();
		    System.exit(1);
		}
    }

    private static void printHelp() {
		System.err.println("Error: wrong command-line arguments");
		System.err.println("java Films [-l|-L|-a] file");
    }
}

