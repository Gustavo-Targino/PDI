import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class OperacoesPontuaisDois {

    public static BufferedImage exibeVermelho(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {

            for(int w = 0; w < largura; ++w) {

                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();

                Color novaCor = new Color(red, 0, 0);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }

        }

        return imgSaida;

    }

    public static BufferedImage exibeVerde(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {

            for(int w = 0; w < largura; ++w) {

                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int green = cor.getGreen();

                Color novaCor = new Color(0, green, 0);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }

        }

    return imgSaida;

    }

    public static BufferedImage exibeAzul(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {

            for(int w = 0; w < largura; ++w) {

                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                Color novaCor = new Color(0 , 0, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }

        }

        return imgSaida;

    }

    public static BufferedImage negativo(BufferedImage imgEntrada) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                Color novaCor = new Color(cor.getRed(), cor.getGreen(), cor.getBlue());
                imgSaida.setRGB(w, h, 255 - novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    public static BufferedImage cinzaVermelho(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {

            for(int w = 0; w < largura; ++w) {

                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();

                Color novaCor = new Color(red, red, red);

                imgSaida.setRGB(w, h, novaCor.getRGB());

            }

        }

        return imgSaida;

    }

    public static BufferedImage cinzaVerde(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {

            for(int w = 0; w < largura; ++w) {

                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int green = cor.getGreen();

                Color novaCor = new Color(green, green, green);

                imgSaida.setRGB(w, h, novaCor.getRGB());


            }

        }

        return imgSaida;

    }

    public static BufferedImage cinzaAzul(BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {

            for(int w = 0; w < largura; ++w) {

                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int azul = cor.getBlue();

                Color novaCor = new Color(azul, azul, azul);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }

        }

        return imgSaida;

    }

    public static BufferedImage cinzaMedia(BufferedImage imgEntrada) {

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

    public static BufferedImage binarizacao(BufferedImage imgEntrada, int limiar) {

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
                int novaCorPixel;

                // Quanto maior o limiar, mais escura a imagem
                novaCorPixel = (media > limiar) ? 255 : 0;

                Color novaCor = new Color(novaCorPixel, novaCorPixel, novaCorPixel);

                imgSaida.setRGB(w, h, novaCor.getRGB());


            }


        }

        return imgSaida;

    }

    public static BufferedImage AlterarTonalidade(BufferedImage imgEntrada, String banda, int valor) {

        if(!banda.equalsIgnoreCase("red")
                && !banda.equalsIgnoreCase("green")
                && !banda.equalsIgnoreCase("blue")
        )  {
            throw new IllegalArgumentException("A banda deve ser red, green ou blue");
        }

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

                if(banda.equalsIgnoreCase("red")) {
                    red = ValidaTonalidade(red, valor);
                }

                if(banda.equalsIgnoreCase("green")) {
                    green = ValidaTonalidade(green, valor);
                }

                if(banda.equalsIgnoreCase("blue")) {
                    blue = ValidaTonalidade(blue, valor);
                }

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }

        return imgSaida;
    }

    private static int ValidaTonalidade(int valorBanda, int acrescimo) {
       valorBanda += acrescimo;
        if(valorBanda > 255) {
           valorBanda = 255;
        }
        else if(valorBanda < 0)  {
            valorBanda =  0;
        }
        return valorBanda;
    }

    private static int ValidaTonalidade(int valorBanda, double acrescimo) {
        valorBanda = (int)((float)valorBanda * acrescimo);
        if(valorBanda > 255) {
            valorBanda = 255;
        }
        else if(valorBanda < 0)  {
            valorBanda =  0;
        }
        return valorBanda;
    }

    public static BufferedImage BrilhoAditivo(BufferedImage imgEntrada, int valor) {

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

                red = ValidaTonalidade(red, valor);
                green = ValidaTonalidade(green, valor);
                blue = ValidaTonalidade(blue, valor);

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imgSaida;
    }

    public static BufferedImage BrilhoMultiplicativo(BufferedImage imgEntrada, double valor) {

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

                red = ValidaTonalidade(red, valor);
                green = ValidaTonalidade(green, valor);
                blue = ValidaTonalidade(blue, valor);

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imgSaida;
    }

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

                double Y = OperacaoY(red,green, blue);
                double I = OperacaoI(red, green, blue);
                double Q = OperacaoQ(red, green, blue);

                double neg = 255 - Y;
                red = ValidaLimite(OperacaoRed(neg, I, Q));
                green = ValidaLimite(OperacaoGreen(neg, I, Q));
                blue = ValidaLimite(OperacaoBlue(neg, I, Q));

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());


            }

        }

        return imgSaida;

    }

    public static BufferedImage BrilhoAddYIQ(BufferedImage imgEntrada, int valor) {

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

                double Y = OperacaoY(red,green, blue);
                double I = OperacaoI(red, green, blue);
                double Q = OperacaoQ(red, green, blue);

                double add = Y + valor;
                red = ValidaLimite(OperacaoRed(add, I, Q));
                green = ValidaLimite(OperacaoGreen(add, I, Q));
                blue = ValidaLimite(OperacaoBlue(add, I, Q));

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());


            }

        }

        return imgSaida;

    }

    public static BufferedImage BrilhoMultiYIQ(BufferedImage imgEntrada, int valor) {

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

                double Y = OperacaoY(red,green, blue);
                double I = OperacaoI(red, green, blue);
                double Q = OperacaoQ(red, green, blue);

                double add = Y * valor;
                red = ValidaLimite(OperacaoRed(add, I, Q));
                green = ValidaLimite(OperacaoGreen(add, I, Q));
                blue = ValidaLimite(OperacaoBlue(add, I, Q));

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());


            }

        }

        return imgSaida;

    }

    public static int ValidaLimite(double valor) {
        if(valor > 255) {
            return 255;
        }
        if(valor < 0) {
            return 0;
        }
        return (int)valor;
    }

    public static double OperacaoY(int red, int green, int blue) {
      return (0.299 * red) + (0.587 * green) + (0.114 * blue);
    }

    public static double OperacaoI(int red, int green, int blue) {
        return (0.596 * red) - (0.274 * green) - (0.322 * blue);
    }

    public static double OperacaoQ(int red, int green, int blue) {
        return (0.211 * red) - (0.523 * green) + (0.312 * blue);
    }

    public static double OperacaoRed(double Y, double I, double Q) {
        return (1.000 * Y) + (0.956 * I) + (0.621 * Q);
    }

    public static double OperacaoGreen(double Y, double I, double Q) {
       return (1.000 * Y) - (0.272 * I) - (0.647 * Q);
    }

    public static double OperacaoBlue(double Y, double I, double Q) {
       return (1.000 * Y) - (1.106 * I) + (1.703 * Q);

    }



}
