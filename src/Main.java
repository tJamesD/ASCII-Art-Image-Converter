import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ImageLoader imageLoader = new ImageLoader(args[0]);
        //imageLoader.getOnePixel();
        //imageLoader.getAllPixels();
        imageLoader.fillRgbArray();
        imageLoader.fillBrightnessArray();
        //imageLoader.printBrightnessArray();
        //imageLoader.printRgbArray();
        //imageLoader.printSingleSlot();
        //System.out.println();
        //System.out.println(imageLoader.convertToBrightness("1 209 116"));
        //imageLoader.printAsciiBaseLength();
        imageLoader.printImage();
    }
}