import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ImageLoader {

    BufferedImage img;
    int width;
    int height;
    String[][] rgbArray;
    String[] asciiBase = {"`","^","\\","\"",",",":",";","I","l","!","i","~","+","_","-","?","]","[","}","{","1",")","(","|","\\","\\","/","t","f","j","r","x","n","u","v","c","z","X","Y","U","J","C","L","Q","0","O","Z","m","w","q","p","d","b","k","h","a","o","*","#","M","W","&","8","%","B","@","$"};



    int[][] brightnessArray;


    public ImageLoader(String fileName) {
        try {
            img = ImageIO.read(new File(fileName));
            width = img.getWidth();
            height = img.getHeight();
            rgbArray = new String[height][width];
            brightnessArray = new int[height][width];
            System.out.println("Sucessfully loaded image!");
            printImageSize();

        } catch(IOException e ) {
            System.out.println("ERROR");

        }
    }

    public void printImageSize() {
        System.out.println(img.getWidth() + "x" + img.getHeight());
    }

    public void getOnePixel() {
        //System.out.println(img.getRGB(0,0));
        int pixel = img.getRGB(0,0);
        Color color = new Color(pixel);
        System.out.println(color.getRed() + " " + color.getGreen() + " " + color.getBlue());
    }

    public void fillRgbArray() {
        int pixel;
        Color colorData;
        for(int row = 0; row<rgbArray.length; row++) {
            for(int col = 0; col<rgbArray[row].length; col++ ) {
                pixel = img.getRGB(col,row);
                colorData = new Color(pixel);
                rgbArray[row][col] = colorData.getRed() + " " + colorData.getBlue() + " " + colorData.getGreen();

            }
        }
    }

    public void fillBrightnessArray() {
        for(int row = 0; row<brightnessArray.length; row++) {
            for (int col = 0; col < brightnessArray[row].length; col++) {
                brightnessArray[row][col] = convertToBrightness(rgbArray[row][col]);
            }
        }
    }

    public int convertToBrightness(String tuple) {
        //int brightness = 0;
        int rgbSum = 0;

        Scanner lineReader = new Scanner(tuple);

        while(lineReader.hasNext()) {
            String value = lineReader.next();
            int rgbValue = Integer.valueOf(value);
            rgbSum = rgbSum + rgbValue;
        }




        return rgbSum/3;
    }

    public String[][] getRgbArray() {
        return rgbArray;
    }

    public void printSingleSlot() {
        System.out.print(rgbArray[0][0]);
    }

    public void printRgbArray() {
        for (int row = 0; row < rgbArray.length; row++) {
            for (int col = 0; col < rgbArray[row].length; col++) {
                System.out.print(rgbArray[row][col] + " ");
            }
        }
    }
    public void printBrightnessArray() {
        for (int row = 0; row < brightnessArray.length; row++) {
            for (int col = 0; col < brightnessArray[row].length; col++) {
                System.out.print(brightnessArray[row][col] + " ");
            }
        }
    }

    public void printImage() {

        //int brightness = 0;
        int asciiBaseIndex = 0;

        System.out.println("BAL: " + brightnessArray.length);
        System.out.println("BAL0: " +brightnessArray[0].length);
        System.out.println("ASCII BASEL: " + asciiBase.length);

        for (int row = 0; row < brightnessArray.length; row++) {
            for (int col = 0; col < brightnessArray[row].length; col++) {
                //System.out.println("ROW: " + row);
                //System.out.println("COL: " + col);
                asciiBaseIndex = (int) (brightnessArray[row][col]/3.8);
                if(asciiBaseIndex >= 67 ) {
                    asciiBaseIndex = 66;
                }
                System.out.print(asciiBase[asciiBaseIndex]);
            }
            System.out.println();
        }
    }

    public void printAsciiBaseLength() {
        System.out.println(asciiBase.length);
        System.out.println(Arrays.toString(asciiBase));
    }
}
