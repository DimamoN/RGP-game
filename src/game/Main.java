/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import frames.GameMap;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            UnitFactory unit = new UnitFactory();
            GameMap map = new GameMap();
//            BattleFrame battleFrame = new BattleFrame(unit.getSoldierHeavy(), unit.getOrk());
        });

    }

}
