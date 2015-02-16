/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.controller;

import com.myhomeapps.nikkido.diarymodel.Aphorism;
import com.myhomeapps.nikkido.diarymodel.Diary;
import com.myhomeapps.nikkido.diarymodel.Knowledge;
import com.myhomeapps.nikkido.ui.ConsoleView;
import com.myhomeapps.nikkido.ui.UIConstants;
import com.myhomeapps.nikkido.ui.UserView;
import com.myhomeapps.nikkido.diarymodel.KnowledgeEntry;
import com.myhomeapps.nikkido.diarymodel.Record;
import com.myhomeapps.nikkido.diarymodel.AbstractRecordField;
import com.myhomeapps.nikkido.diarymodel.ApplicationArea;
import com.myhomeapps.nikkido.diarymodel.KnowledgeSource;
import com.myhomeapps.nikkido.diarymodel.Thoughts;
import com.myhomeapps.nikkido.diarymodel.ThoughtsEntry;
import java.io.InputStream;
import java.util.Scanner;
import org.joda.time.DateTime;

/**
 *
 * @author Prifiz
 */
public class CommandLineController implements Controller {

    UserView userView;
    AbstractRecordField knowledge;
    AbstractRecordField thoughts;
    AbstractRecordField aphorism;
    Diary diary;

    @Override
    public void init() {
        diary = new Diary();
        userView = new ConsoleView();
    }

    @Override
    public void activateMainMenu() {
        boolean correct = false;
        while (!correct) {
            userView.showStartMenu();
            correct = checkMainMenuCommand(System.in);
        }
    }

    @Override
    public void activateReturnSubmenu() {
        boolean correct = false;
        while (!correct) {
            userView.showReturnSubmenu();
            correct = checkReturnSubmenuCommand(System.in);
        }
    }

    protected boolean checkReturnSubmenuCommand(InputStream commandInputStream) {
        Scanner scanner = new Scanner(commandInputStream);
        switch (scanner.nextLine()) {
            case UIConstants.BACK_TO_MAIN: {
                activateMainMenu();
            }
            case UIConstants.EXIT_COMMAND: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    protected boolean addAnotherEntrySubmenu(String displayName) {
        System.out.println("Add another " + displayName + " entry? (y/n)");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toLowerCase()) {
            case "n":
                return false;
            case "y":
                return true;
            default:
                return addAnotherEntrySubmenu(displayName);
        }
    }

//    protected boolean addThoughtsEntrySubmenu() {
//        
//    }
    protected String chooseKnowledgeSourceType() {
        userView.showAddKnowledgeSourceSubmenu();
        Scanner scanner = new Scanner(System.in);
        String result = "";
        boolean isCorrect = true;
        while (!isCorrect) {
            switch (scanner.nextInt()) {
                case 1: {
                    result = "Book";
                    isCorrect = true;
                    break;
                }
                case 2: {
                    result = "Web Site";
                    isCorrect = true;
                    break;
                }
                case 3: {
                    result = "From Friend";
                    isCorrect = true;
                    break;
                }
                default: {
                    isCorrect = false;
                }
            }
        }
        return result;
    }

    protected void addKnowledgeEntrySubmenu(Knowledge knowledge) {
        Scanner scanner = new Scanner(System.in);
        KnowledgeEntry knowledgeEntry = new KnowledgeEntry();
        System.out.println("KNOWLEDGE");

        System.out.println("Enter description:");
        String description = scanner.nextLine();
        if (UIConstants.CANCEL_COMMAND.equals(description)) {
            return;
        }
        knowledgeEntry.setShortDescription(description);

        System.out.println("Enter content:");
        String content = scanner.nextLine();
        if (UIConstants.CANCEL_COMMAND.equals(content)) {
            return;
        }
        knowledgeEntry.setContent(content);

        KnowledgeSource knowledgeSource = new KnowledgeSource();
        knowledgeSource.setType(chooseKnowledgeSourceType());
        String howToFindSource = scanner.nextLine();
        if (UIConstants.CANCEL_COMMAND.equals(howToFindSource)) {
            return;
        }
        knowledgeSource.setHowToFind(howToFindSource);
        knowledgeEntry.setSource(knowledgeSource);

        System.out.println("Enter application area:");
        String applicationArea = scanner.nextLine();
        if (UIConstants.CANCEL_COMMAND.equals(applicationArea)) {
            return;
        }
        knowledgeEntry.setApplicationArea(new ApplicationArea(applicationArea));

        knowledgeEntry.setChangeDate(DateTime.now());

        knowledge.addKnowledgeEntry(knowledgeEntry);
    }

    protected void addThoughtsEntrySubmenu(Thoughts thoughts) {
        Scanner scanner = new Scanner(System.in);
        ThoughtsEntry thoughtsEntry = new ThoughtsEntry();
        System.out.println("THOUGHTS");
        System.out.println("Enter content:");
        String content = scanner.nextLine();
        if (UIConstants.CANCEL_COMMAND.equals(content)) {
            return;
        }
        thoughtsEntry.setThoughts(content);
        thoughtsEntry.setChangeDate(DateTime.now());
        thoughts.addThoughtsEntry(thoughtsEntry);
    }

    protected void addKnowledge(Knowledge knowledgeToAdd) {
        boolean addMoreKnowledge = true;
        while (addMoreKnowledge) {
            addKnowledgeEntrySubmenu(knowledgeToAdd);
            addMoreKnowledge = addAnotherEntrySubmenu(
                    knowledgeToAdd.getDisplayName());
        }
    }

    protected void addThoughts(Thoughts thoughtsToAdd) {
        boolean addMoreThoughts = true;
        while (addMoreThoughts) {
            addThoughtsEntrySubmenu(thoughtsToAdd);
            addMoreThoughts = addAnotherEntrySubmenu(
                    thoughtsToAdd.getDisplayName());
        }
    }

    protected void addAphorism(Aphorism aphorism) {
        Scanner scanner = new Scanner(System.in);
        String content;
        System.out.println("APHORISM");
        //while (content.length() > aphorism.getMaxLength()) {
            System.out.println("Enter content:");
            content = scanner.nextLine();
            if (UIConstants.CANCEL_COMMAND.equals(content)) {
                return;
            }
        //}
        aphorism.setAphorismEntry(content);
        aphorism.setChangeDate(DateTime.now());
    }

    protected boolean checkMainMenuCommand(InputStream commandInputStream) {

        Scanner scanner = new Scanner(commandInputStream);
        switch (scanner.nextLine()) {
            case UIConstants.EXIT_COMMAND: {
                return true;
            }
            case UIConstants.HELP_COMMAND: {
                userView.showHelp();
                activateReturnSubmenu();
                return true;
            }
            case UIConstants.SHOW_ALL_COMMAND: {
                userView.showAllDiary(diary);
                activateReturnSubmenu();
                return true;
            }
            case UIConstants.REMOVE_ALL_COMMAND: {
                diary.removeAllRecords();
                activateReturnSubmenu();
                return true;
            }
            case UIConstants.ADD_COMMAND: {

                thoughts = new Thoughts();
                aphorism = new Aphorism();
                knowledge = new Knowledge();

                addKnowledge((Knowledge) knowledge);
                addThoughts((Thoughts) thoughts);
                addAphorism((Aphorism) aphorism);

                diary.addRecord(new Record(knowledge, thoughts, aphorism));
                activateMainMenu();
                return true;
            }
            default: {
                System.out.println(UIConstants.INCORRECT_COMMAND);
                return false;
            }
        }
    }
}
