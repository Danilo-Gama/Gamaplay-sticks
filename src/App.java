import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        

        // Fazer uma conexao http com o IMDB, buscar os 250 top moves

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        
        var http = new ClientHttp();
        String json = http.buscaDados(url);
        
                
        //exibir e manipular os dados
        
        /*ExtratorConteudo extrator = new ExtratorConteudosImdb();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);*/
        

        ExtratorConteudo extrator = new ExtratorConteudosNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        var  geradora = new GeradorSticks();
        
        InputStream iGamaplay;
        
        iGamaplay = new FileInputStream(new File("gamaplay/gamaplay.png"));
        
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);
                        
            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            geradora.criar(inputStream, nomeArquivo, iGamaplay);

            System.out.println(conteudo.titulo());
            System.out.println();
            
            /*System.out.println("\u001b[1mTitulo:\u001b[n " + filme.get("title"));
            System.out.println("\u001b[1mURL da imagem:\u001b[n " + filme.get("image"));
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            System.out.print(filme.get("imDbRating"));
            System.out.print(" ");*/
        
            /*int numeroEstrelas = (int) classificacao;
            for(int e = 1; e <= numeroEstrelas; e++) {
                System.out.print("⭐️");
            }
            System.out.println("\n");*/
        }  


    }
}
