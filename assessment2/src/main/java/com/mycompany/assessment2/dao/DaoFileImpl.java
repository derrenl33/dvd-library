/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assessment2.dao;
import com.mycompany.assessment2.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Darren
 */
public class DaoFileImpl implements Dao{
    
    private Map<String, DVD> dvds = new HashMap<>();
    public static final String LIBRARY_FILE = "library.txt";

    @Override
    public DVD addDVD(String title, DVD dvd) throws DaoException{
        loadLibrary();
        DVD prevDVD = dvds.put(title, dvd);
        writeLibrary();
        return prevDVD;
}
    @Override
    public List<DVD> getAllDVDs() throws DaoException{
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DaoException{
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DaoException{
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editDVDremove(String title) throws DaoException{
        loadLibrary();
        DVD editDVDrmv = dvds.remove(title);
        writeLibrary();
        return editDVDrmv;
    }
    
    @Override
    public DVD editDVDreplace(String title, DVD dvd) throws DaoException{
        loadLibrary();
        DVD editDVDrpl = dvds.put(title, dvd);
        writeLibrary();
        return editDVDrpl;
    }
    
    private DVD unmarshallDVD(String dvdAsText){
        String[] dvdTokens = dvdAsText.split("::");
        String title = dvdTokens[0];

        DVD dvdFromFile = new DVD(title);

        dvdFromFile.setDate(dvdTokens[1]);

        dvdFromFile.setMPAA(dvdTokens[2]);

        dvdFromFile.setDirector(dvdTokens[3]);

        dvdFromFile.setStudio(dvdTokens[4]);

        dvdFromFile.setNote(dvdTokens[5]);

        return dvdFromFile;
    }
    
    private void loadLibrary() throws DaoException {
        Scanner myScanner;

        try {
            // Create Scanner for reading the file
            myScanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException ex) {
            throw new DaoException(
                    "Could not load DVD data into memory.", ex);
        }

        String currentLine;
        DVD currentDVD;
        while (myScanner.hasNextLine()) {
            currentLine = myScanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        myScanner.close();
    }
    
    private String marshallDVD(DVD aDVD){

        String dvdAsText = aDVD.getTitle() + "::";

        dvdAsText += aDVD.getDate() + "::";

        dvdAsText += aDVD.getMPAA() + "::";

        dvdAsText += aDVD.getDirector() + "::";
        
        dvdAsText += aDVD.getStudio() + "::";

        dvdAsText += aDVD.getNote();

        return dvdAsText;
    }
    
    private void writeLibrary() throws DaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException ex) {
            throw new DaoException(
                    "Could not save DVD data.", ex);
        }

        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        // Clean up
        out.close();
    }
}
