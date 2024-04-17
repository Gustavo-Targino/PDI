import java.awt.Color;
import java.awt.image.BufferedImage;

public class OperacoesPontuais {
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

    public static BufferedImage exibeAzul(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int azul = cor.getBlue();
                Color novaCor = new Color(0, 0, azul);
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
                int verde = cor.getGreen();
                Color novaCor = new Color(0, verde, 0);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }


    public static BufferedImage negativo (BufferedImage imgEntrada) {

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {

            for(int w = 0; w < largura; ++w) {

                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                imgSaida.setRGB(w, h, 255 - cor.getRGB());

            }

        }

        return imgSaida;

    }

    public static BufferedImage cinzaVermelho(BufferedImage imgEntrada) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                Color novaCor = new Color(cor.getRed(), cor.getRed(), cor.getRed());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    public static BufferedImage cinzaVerde(BufferedImage imgEntrada) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                Color novaCor = new Color(cor.getGreen(), cor.getGreen(), cor.getGreen());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    public static BufferedImage cinzaBlue(BufferedImage imgEntrada) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                Color novaCor = new Color(cor.getBlue(), cor.getBlue(), cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    public static BufferedImage cinzaMedia(BufferedImage imgEntrada) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int media = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;
                Color novaCor = new Color(media, media, media);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    public static BufferedImage binarizacao(BufferedImage imgEntrada, int limiar) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int media = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;
                int novoValor = media > limiar ? 255 : 0;
                Color novaCor = new Color(novoValor, novoValor, novoValor);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    public static BufferedImage alterarTonalidade(BufferedImage imgEntrada, String banda, int valor) {
        boolean isRed = banda.equalsIgnoreCase("red");
        boolean isGreen = banda.equalsIgnoreCase("green");
        boolean isBlue = banda.equalsIgnoreCase("blue");
        if (!isRed && !isGreen && !isBlue) {
            throw new IllegalArgumentException("Banda inválida");
        } else {
            int largura = imgEntrada.getWidth();
            int altura = imgEntrada.getHeight();
            BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

            for(int h = 0; h < altura; ++h) {
                for(int w = 0; w < largura; ++w) {
                    int rgb = imgEntrada.getRGB(w, h);
                    Color cor = new Color(rgb);
                    int red = cor.getRed();
                    int green = cor.getGreen();
                    int blue = cor.getBlue();
                    if (banda.equalsIgnoreCase("red")) {
                        red = validaLimiteRGB(red, valor);
                    }

                    if (banda.equalsIgnoreCase("green")) {
                        green = validaLimiteRGB(green, valor);
                    }

                    if (banda.equalsIgnoreCase("blue")) {
                        blue = validaLimiteRGB(blue, valor);
                    }

                    cor = new Color(red, green, blue);
                    imgSaida.setRGB(w, h, cor.getRGB());
                }
            }

            return imgSaida;
        }
    }

    public static BufferedImage brilhoAditivo(BufferedImage imgEntrada, int valor) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                red = validaLimiteRGB(red, valor);
                green = validaLimiteRGB(green, valor);
                blue = validaLimiteRGB(blue, valor);
                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    public static BufferedImage brilhoMultiplicativo(BufferedImage imgEntrada, float valor) {
        int largura = imgEntrada.getWidth();
        int altura = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());

        for(int h = 0; h < altura; ++h) {
            for(int w = 0; w < largura; ++w) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                red = validaLimiteRGB(red, valor);
                green = validaLimiteRGB(green, valor);
                blue = validaLimiteRGB(blue, valor);
                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    private static int validaLimiteRGB(int banda, int acrescimo) {
        banda += acrescimo;
        if (banda > 255) {
            banda = 255;
        } else if (banda < 0) {
            banda = 0;
        }

        return banda;
    }

    private static int validaLimiteRGB(int banda, float acrescimo) {
        banda = (int)((float)banda * acrescimo);
        if (banda > 255) {
            banda = 255;
        } else if (banda < 0) {
            banda = 0;
        }

        return banda;
    }
}