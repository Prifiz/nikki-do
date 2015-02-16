package com.myhomeapps.nikkido.controller;

public class App 
{
    public static void main( String[] args )
    {
        Controller controller = new CommandLineController();
        controller.init();
        controller.activateMainMenu();
    }
}
