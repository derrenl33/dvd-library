/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assessment2.controller;
import com.mycompany.assessment2.dao.Dao;
import com.mycompany.assessment2.dao.DaoException;
import com.mycompany.assessment2.dto.DVD;
import com.mycompany.assessment2.ui.View;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Darren
 */
public class Controller {
    
    private View view;
    private Dao dao;
    
    public Controller(Dao dao, View view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        }catch (DaoException ex){
            view.displayErrorMessage(ex.getMessage());
        }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDVD() throws DaoException{
        Scanner myScanner = new Scanner(System.in);
        String runAgain;
        boolean again = false;
        do{
            view.displayCreateDVDbanner();
            DVD newDVD = view.getNewDVDinfo();
            dao.addDVD(newDVD.getTitle(), newDVD);
            view.displayCreateSuccessBanner();
            runAgain = myScanner.nextLine();
            if (runAgain.equals("Y")){
                again = true;
            }else{
                again = false;
            }
        }while(again);
    }
    
    private void listDVDs() throws DaoException{
        view.displayListBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDlist(dvdList);
    }
    
    private void viewDVD() throws DaoException{
        view.displaySpecificDVDbanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }
    
    private void removeDVD() throws DaoException{
        Scanner myScanner = new Scanner(System.in);
        String runAgain;
        boolean again = false;
        do{
            view.displayRemoveDVDbanner();
            String title = view.getTitleChoice();
            DVD removedDVD = dao.removeDVD(title);
            view.displayRemoveResult(removedDVD);
            runAgain = myScanner.nextLine();
            if (runAgain.equals("Y")){
                again = true;
            }else{
                again = false;
            }
        }while(again);
    }

    private void editDVD() throws DaoException{
        Scanner myScanner = new Scanner(System.in);
        String runAgain;
        boolean again = false;
        do{
            //remove
            String title = view.getTitleChoice();
            dao.editDVDremove(title);
            //replace
            view.displayEditDVDbanner();
            DVD newDVD = view.getEditDVDinfo();
            dao.editDVDreplace(newDVD.getTitle(), newDVD);
            view.displayEditResult();
            runAgain = myScanner.nextLine();
            if (runAgain.equals("Y")){
                again = true;
            }else{
                again = false;
            }
        }while(again);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}