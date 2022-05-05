/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assessment2.dao;
import com.mycompany.assessment2.dto.DVD;
import java.util.List;

/**
 *
 * @author Darren
 */
public interface Dao {
    DVD addDVD(String title, DVD dvd) throws DaoException;
    List<DVD> getAllDVDs() throws DaoException;
    DVD getDVD(String title) throws DaoException;
    DVD removeDVD(String title) throws DaoException;
    DVD editDVDremove(String title) throws DaoException;
    DVD editDVDreplace(String title, DVD dvd) throws DaoException;
}
