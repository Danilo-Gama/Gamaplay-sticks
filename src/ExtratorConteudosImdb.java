import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudosImdb implements ExtratorConteudo {
			
	public List<Conteudo> extraiConteudos(String json){
			
	// extrair dados relevantes, titulos, poster, avaliacao.
	var parser = new JsonParser();
	List<Map<String, String>> listaAtributos = parser.parse(json);
	        
	List<Conteudo> conteudos = new ArrayList<>();
       
	for (Map<String, String> atributos : listaAtributos) {
	   	String titulo = atributos.get("title");
	   	String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");;
	   	var conteudo = new Conteudo(titulo, urlImagem);
	   	conteudos.add(conteudo);
	}
	return conteudos;
			
		}

	}
