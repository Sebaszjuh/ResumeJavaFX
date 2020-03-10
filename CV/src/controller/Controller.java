package controller;

import View.View;

import java.io.*;

public class Controller {

    //--- JavaFX ---
    private View view = new View();
    //--- JavaFX ---
    public Controller() {
    }

    public void NAW() {
        try {
            readFile(new File("NAW.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Skills() {
        try {
            readFile(new File("Skills.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Werkervaring() {
        try {
            readFile(new File("Werkervaring.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Opleidingen() {
        try {
            readFile(new File("Opleidingen.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(File file) throws IOException {
        StringBuilder contents = new StringBuilder();
        BufferedReader reader;

        reader = new BufferedReader(new FileReader(file));
        String text;

        // repeat until all lines is read
        while ((text = reader.readLine()) != null) {
            contents.append(text).append(System.getProperty("line.separator"));
        }
        reader.close();
        view.getText().setText(contents.toString());
    }

}

