import java.awt.Color;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class OperacoesPontuaisTRES {

    //Uma imagem é uma matriz de pixels, em que cada coordenada possui um RGB
    // O Buffered Image é criado a partir de um objeto Image ou de uma matriz de pixels.
    // Ele aloca um buffer de memória com tamanho suficiente para armazenar todos os pixels da imagem.
    // // Cada pixel é representado por um valor inteiro que indica a cor do pixel.

    // O negativo subtrai 255 do valor do RGB do pixel
    public static BufferedImage Negativo(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for (int h = 0; h < altura; ++h) {
            for (int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
               imgSaida.setRGB(w, h, 255 - cor.getRGB());

            }
        }

        return imgSaida;
    }

    // CinzaVermelho, CinzaVerde, CinzaAzul, CinzaMedia

    // Colocar o valor da banda em todas as demais
    public static BufferedImage CinzaVermelho(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h); //24bits OU 3bytes
                Color cor = new Color(rgb);
                int red = cor.getRed();
               Color novaCor = new Color(red, red, red);
               imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }

        return imgSaida;

    }

    public static BufferedImage CinzaVerde(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h); //24bits OU 3bytes
                Color cor = new Color(rgb);
                int green = cor.getGreen();
                Color novaCor = new Color(green, green, green);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }

        return imgSaida;

    }

    public static BufferedImage CinzaAzul(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h); //24bits OU 3bytes
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                Color novaCor = new Color(blue, blue, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }

        return imgSaida;

    }

    public static BufferedImage CinzaMedio(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;
                Color novaCor = new Color(media, media, media);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }

        return imgSaida;

    }

    public static BufferedImage Binarizacao(BufferedImage imgEntrada, int limiar) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3; // LUMINÂNCIA

                int novoValor = (media > limiar) ? 255 : 0;

                Color novaCor = new Color(novoValor, novoValor, novoValor);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }

        return imgSaida;

    }


    public static BufferedImage BrilhoAdd(BufferedImage imgEntrada, int valor) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                red = ValidaLimiteRGB(red, valor);
                green = ValidaLimiteRGB(green, valor);
                blue = ValidaLimiteRGB(blue, valor);

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());


            }
        }
        return imgSaida;

    }


    public static int ValidaLimiteRGB(int banda, int valor) {

        banda += valor;

        if(banda > 255) {
            banda = 255;
        }
        if(banda < 0) {
            banda = 0;
        }
        return banda;
    }

    //converter de rgb para yiq
    //faz as operações em Y
    //converte novamente para rgb
    //valida os valores de rgb

    public static BufferedImage NegativoYIQ(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                double Y = OperacaoY(red, green, blue);
                double I = OperacaoI(red, green, blue);
                double Q = OperacaoQ(red, green, blue);

                 double neg = 255 - Y;
                // Operação...

                red = ValidaLimiteRGB(OperacaoRed(neg, I, Q));
                green = ValidaLimiteRGB(OperacaoGreen(neg, I, Q));
                blue = ValidaLimiteRGB(OperacaoBlue(neg, I, Q));

                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imgSaida;
    }

    private static double OperacaoY(int red, int green, int blue) {
        return (0.299 * red) + (0.587 * green) + (0.114 * blue);
    }

    private static double OperacaoI(int red, int green, int blue) {
        return (0.596 * red) - (0.274 * green) - (0.322 * blue);
    }

    private static double OperacaoQ(int red, int green, int blue) {
        return (0.211 * red) - (0.523 * green) + (0.312 * blue);
    }

    private static double OperacaoRed(double Y, double I, double Q) {
        return (1.000 * Y) + (0.956 * I) + (0.621 * Q);
    }

    private static double OperacaoGreen(double Y, double I, double Q) {
        return (1.000 * Y) - (0.272 * I) - (0.647 * Q);
    }

    private static double OperacaoBlue(double Y, double I, double Q) {
        return (1.000 * Y) - (1.106 * I) + (1.703 * Q);
    }

    private static int ValidaLimiteRGB(double banda) {
        if(banda > 255) {
            banda = 255;
        }
        if(banda < 0) {
            banda = 0;
        }
        return (int)banda;
    }
}
