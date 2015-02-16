/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.ui;

import com.myhomeapps.nikkido.diarymodel.Diary;

/**
 *
 * @author Prifiz
 */
public interface UserView {
   
    /**
     * Shows start menu items
     */
    public void showStartMenu();
    /**
     * Shows the Help.txt file content
     */
    public void showHelp();
    /**
     * Shows the menu which offers the user to return to main menu or exit
     */
    public void showReturnSubmenu();
    /**
     * Shows all diary content
     * @param diary - the diary object which content is to be shown
     */
    public void showAllDiary(Diary diary);
    /**
     * Shows the menu with knowledge sources variants
     */
    public void showAddKnowledgeSourceSubmenu();
}
