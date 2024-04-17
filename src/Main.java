import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] Args) {
        BufferedImage imagem = ManipulaImagem.abrirImagem("CASA.jpg");

        ManipulaImagem.exibirImagem(OperacoesPontuaisTRES.NegativoYIQ(imagem));


    }
}