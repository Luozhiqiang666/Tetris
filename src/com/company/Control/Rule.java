package com.company.Control;

import com.company.Modle.Block;
import com.company.Modle.GameData;
import com.company.View.Window;

public class Rule {
    public static void RemoveLine(int line){
        for(int i=line; i>1; i--){
            for(int x=0; x<12; x++){
                GameData.data[x][i] = GameData.data[x][i-1];
            }
            Window.gamePanel.repaint();
        }
    }

    public static int Remove(Block block){
        int numMovedLine=0;
        int line;
        boolean flag;
        for(int y=2; y<21; y++){
            flag = true;
            for(int x=0; x<12; x++){
                if( GameData.data[x][y] == false){
                    flag = false;
                    break;
                }
            }
            if (flag == true){
                RemoveLine(y);
                numMovedLine++;
            }
        }

        GameData.score += numMovedLine*10;
        System.out.println(GameData.score);
        return numMovedLine;

    }

    public static boolean isEnd(){
        for(int x=0; x<12; x++){
            if(GameData.data[x][1] == true){
                return true;
            }
        }
        return false;
    }
}
