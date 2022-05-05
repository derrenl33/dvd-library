/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assessment2.ui;
import com.mycompany.assessment2.dto.DVD;
import java.util.List;

/**
 *
 * @author Darren
 */
public class View {

    private UserIO io;
    
    public View(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD to Collection");
        io.print("2. Remove DVD from Collection");
        io.print("3. Edit Existing DVD");
        io.print("4. List DVDs in Collection");
        io.print("5. Display Particular DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDinfo() {
        String title = io.readString("Please enter Title of DVD");
        String releaseDate = io.readString("Please enter Release Date of DVD");
        String mpaa = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director Name");
        String studio = io.readString("Please enter the associated Studio");
        String userNote = io.readString("Please enter a User Note/Rating");
        DVD currentDVD = new DVD(title);
        currentDVD.setDate(releaseDate);
        currentDVD.setMPAA(mpaa);
        currentDVD.setDirector(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setNote(userNote);
        return currentDVD;
    }
    
    public void displayCreateDVDbanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.print("DVD successfully created.  Create another DVD? Y/N(Exceptions also mean N)");
    }
    
    public void displayDVDlist(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String dvdInfo = String.format("%s : %s , %s , %s , %s , %s",
                  currentDVD.getTitle(),
                  currentDVD.getDate(),
                  currentDVD.getMPAA(),
                  currentDVD.getDirector(),
                  currentDVD.getStudio(),
                  currentDVD.getNote());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayListBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displaySpecificDVDbanner () {
        io.print("=== Display Particular DVD ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getDate());
            io.print("MPAA Rating: " + dvd.getMPAA());
            io.print("Director Name: " + dvd.getDirector());
            io.print("Studio Name: " + dvd.getStudio());
            io.print("User Note/Rating: " + dvd.getNote());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDVDbanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
          io.print("DVD successfully removed.");
        }else{
          io.print("No such DVD.");
        }
        io.print("Remove another DVD? Y/N(Exceptions also mean N)");
    }
    
    public void displayEditDVDbanner () {
        io.print("=== Edit DVD ===");
    }
    
    public void displayEditResult() {
        io.print("Successfully edited DVD. Edit another DVD? Y/N(Exceptions also mean N)");
    }        
    
    public DVD getEditDVDinfo() {
        String title = io.readString("New Title");
        String releaseDate = io.readString("New Release Date");
        String mpaa = io.readString("New MPAA Rating");
        String directorName = io.readString("New Director Name");
        String studio = io.readString("New associated Studio");
        String userNote = io.readString("New User Note/Rating");
        DVD currentDVD = new DVD(title);
        currentDVD.setDate(releaseDate);
        currentDVD.setMPAA(mpaa);
        currentDVD.setDirector(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setNote(userNote);
        return currentDVD;
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
