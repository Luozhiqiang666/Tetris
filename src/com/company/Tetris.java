package com.company;

import com.company.Modle.GameData;
import com.company.View.Window;

public class Tetris {

    public static void main(String[] args) {
        GameData.InitialData();
        new Window().Play();
    }
}
