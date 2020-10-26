import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CalC {

    File nf;
    LinkedList<String> templ = new LinkedList<>();
    ListIterator<String > iterT = templ.listIterator();

    public CalC(File nf){

        this.nf = nf;

    }

    public void addToList() throws IOException {

        Scanner scn = new Scanner(this.nf);

        List<String> searchF = Files.readAllLines(Path.of(String.valueOf(this.nf)));

        for (String srchF : searchF){

            if (srchF.matches("")){
                continue;
            }
            else if (srchF.matches("^[0-9]+$")){

                templ.add(srchF);

            }
            else{

                JOptionPane.showMessageDialog(null, "Woah Woah Woah You Pleb This Is " +
                        "Not A Fully Numbered File");

                failF();

            }

        }

    }

    private void failF() {

        this.templ = null;

    }

    public double meanC(){

        int totalC = 0;
        double meanT = 0.0,
        count = 0.0;

        if (templ == null){meanT = 0.0;}
        else{

            for (String s : templ) {

                totalC += Integer.parseInt(s);
                count++;

            }

            meanT = totalC/count;
        }

        if (templ == null){meanT = 0.0;}

        return meanT;

    }

    public double stndC(){

        double meanT = meanC(),
                stndDev = 0.0,
                count = 0.0;

        if (templ == null){return 0.0;}
        else {

            for (String s : templ) {

                stndDev += Math.pow(Integer.parseInt(s) - meanT, 2);
                count++;

            }

            return Math.sqrt(stndDev/count);
        }

    }



}
