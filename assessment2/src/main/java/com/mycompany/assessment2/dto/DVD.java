/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assessment2.dto;

/**
 *
 * @author Darren
 */
public class DVD {
    private String title;
    private String releaseDate;
    private String mpaa;
    private String directorName;
    private String studio;
    private String userNote;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return releaseDate;
    }

    public void setDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getMPAA() {
        return mpaa;
    }

    public void setMPAA(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getDirector() {
        return directorName;
    }
    
    public void setDirector(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }   
    
    public String getNote() {
        return userNote;
    }

    public void setNote(String userNote) {
        this.userNote = userNote;
    }
}
