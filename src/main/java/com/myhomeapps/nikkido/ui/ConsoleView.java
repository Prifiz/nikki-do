package com.myhomeapps.nikkido.ui;

import com.myhomeapps.nikkido.diarymodel.Diary;
import com.myhomeapps.nikkido.diarymodel.Record;
import com.myhomeapps.nikkido.storagehandler.filehandler.TextFileHandler;

/**
 *
 * @author Prifiz
 */
public class ConsoleView implements UserView {

    @Override
    public void showStartMenu() {
        System.out.println(UIConstants.line);
        System.out.println("Please, choose the command:");
        System.out.println(UIConstants.HELP_COMMAND);
        System.out.println(UIConstants.SHOW_ALL_COMMAND);
        System.out.println(UIConstants.ADD_COMMAND);
        System.out.println(UIConstants.REMOVE_ALL_COMMAND);
        System.out.println(UIConstants.EXIT_COMMAND);
        System.out.println(UIConstants.line);
    }

    @Override
    public void showReturnSubmenu() {
        System.out.println("Choose the way to proceed:");
        System.out.println(UIConstants.BACK_TO_MAIN);
        System.out.println(UIConstants.EXIT_COMMAND);
        System.out.print("Type the command: ");
    }

    @Override
    public void showHelp() {
        System.out.println(UIConstants.line);
        System.out.println(
                TextFileHandler.fileToString("src/main/resources/Help.txt"));
    }
    
    @Override
    public void showAllDiary(Diary diary) {
        System.out.println(UIConstants.line);
        for (Record record : diary.getEntry()) {
            System.out.println(record.toString());
        }
        System.out.println(UIConstants.line);
    }
    
    @Override
    public void showAddKnowledgeSourceSubmenu() {
        System.out.println(UIConstants.line);
        System.out.println("Choose the knowledge source type:");
        System.out.println("'1' - Book");
        System.out.println("'2' - Web Site");
        System.out.println("'3' - From Friend");
        System.out.print("Type the command: ");
    }
}
