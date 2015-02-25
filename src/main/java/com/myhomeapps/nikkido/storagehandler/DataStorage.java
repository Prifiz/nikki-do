/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.storagehandler;

import com.myhomeapps.nikkido.diarymodel.Diary;

/**
 *
 * @author Prifiz
 */
public interface DataStorage {
    public Diary load(String fileName);
    public void save(Diary diary, String fileName);
}
