import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.json.simple.*;

public class Main {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://datos.gijon.es/doc/transporte/busgijontr.json");
		String result = target.request().get().readEntity(String.class);
		System.out.println(result);
		
		//Imprimimos todo el flujo JSON recibido en formato cadena.
		System.out.println("-----------TODOS----------------");
		System.out.println(result);
		//Procesamos el texto JSON y lo pasamos a formato SIMPLE-JSON
		Object obj=JSONValue.parse(result);
		JSONArray pisos = (JSONArray)obj;
		//Imprimimos el contacto tercero (2) transformándolo a formato cadena.
		System.out.println("----------- PISO ----------------");
		System.out.println(pisos.get(2).toString());
		System.out.println("----------- CIUDAD DE UN PISO ----------------");
		JSONObject unPiso = (JSONObject) JSONValue.parse(pisos.get(2).toString());
		String ciudad = (String)unPiso.get("Ciudad");
		System.out.println(ciudad);
		
	}

	
	public Main() {
		super();
	}

}