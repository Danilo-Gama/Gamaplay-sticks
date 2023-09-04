import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorSticks {
    
    void criar(InputStream inputStream, String nomeArquivo, InputStream inputStreamGplay) throws Exception{

        // Ler a imagem da url

        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@.jpg").openStream();
        
        BufferedImage iOriginal = ImageIO.read(inputStream);

        //criar nova imagem com transparencia e com tamanho novo

        int largura = iOriginal.getWidth();
        int altura = iOriginal.getHeight();
        int novaAltura = altura + 400;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova em memoria

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(iOriginal, 0, 0, null);
        
        BufferedImage gplay = ImageIO.read(inputStreamGplay);
        int gplayy = novaAltura - 700;
        graphics.drawImage(gplay, 0, gplayy, null);

        //configurar fonte
        var fontTexto = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(fontTexto);
        graphics.setColor(Color.GREEN);

        
        //escrever mensagem engracada na imagem

        graphics.drawString("LANÇAMENTO", 200, novaAltura-300);
        
        //escrever imagem nova em um aquivo

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
