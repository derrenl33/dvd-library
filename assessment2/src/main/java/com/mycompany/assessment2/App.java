/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assessment2;
import com.mycompany.assessment2.controller.Controller;
import com.mycompany.assessment2.dao.*;
import com.mycompany.assessment2.ui.*;

/**
 *
 * @author Darren
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        View myView = new View(myIo);
        Dao myDao = new DaoFileImpl();
        Controller controller = new Controller(myDao, myView);
        controller.run();
    }   
}
