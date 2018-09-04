/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import frames.BattleFrame;
import game.units.AbstractUnit;

import java.util.Random;

/**
 * @author DimamoN
 */
public class OLDBattle {

    private BattleFrame battleFrame;
    //ход в бою
    private int turn = 1;

    //Конструктор, на этом фрейме будет отображаться битва
    public OLDBattle() {
    }

    //Битва с выводом победителей
    public AbstractUnit fightWithLog(AbstractUnit one, AbstractUnit two) {

        //Начало битвы вывод в фрейм
        battleFrame.addBattleLog("******\nБитва между " + one.getName() + " и " + two.getName());
        battleFrame.addBattleLog(one.getAllStat());
        battleFrame.addBattleLog(two.getAllStat());
        battleFrame.addBattleLog("******\n");

        if (this.autoFight(one, two)) {
            battleFrame.addBattleLog("*** Конец Боя ***\n Победитель " + one.getName());
            battleFrame.addBattleLog("\n*** Статистика Боя ***");
            battleFrame.addBattleLog(one.BattleFinalInfo());
            battleFrame.addBattleLog(two.BattleFinalInfo());
            return one;
        } else {
            battleFrame.addBattleLog("\n*** Конец Боя ***\n Победитель " + two.getName());
            battleFrame.addBattleLog("\n*** Статистика Боя ***");
            battleFrame.addBattleLog(one.BattleFinalInfo());
            battleFrame.addBattleLog(two.BattleFinalInfo());
            return two;
        }
    }

    //Ручная битва, action: nextTurn, end, restart !!!!
    public boolean manualFight(AbstractUnit one, AbstractUnit two, String action) {

        this.setupHeroesOnFrame(one, two);

        switch (action) {
            case "nextTurn":
                round(one, two);
                break;
            case "end":
                this.autoFight(one, two);
                break; //Возвращает победителя, придумать куда!
            case "restart":
                this.restartBattle(one, two);
                break;
            default:
                break; //Тут нужно сделать вывод об ошибке! (Сделать на фрейме поле статуса)
        }

        return false;
    }

    //Установка параметров героев и их айтемов на фрейме
    public void setupHeroesOnFrame(AbstractUnit one, AbstractUnit two) {
//        battleFrame.setupHeroesInfo(one, two); 
    }

    //Перезапуск битвы
    public void restartBattle(AbstractUnit one, AbstractUnit two) {
        one.resetHealth();
        two.resetHealth();
        battleFrame.clearBattleLog();
        this.setupHeroesOnFrame(one, two);
    }

    //Автоматическая битва Битва, победитель 1 - true, 2 - false
    public boolean autoFight(AbstractUnit one, AbstractUnit two) {

        while (one.getHp() > 0 && two.getHp() > 0) {

            round(one, two);
//            Thread.sleep(1500);
        }

        //обнуляем ход
        turn = 1;
        //Если у первого есть хп - он победил
        return one.isAlive();
    }

    //Один ход битвы, несколько вызовов - несколько ходов
    private void round(AbstractUnit one, AbstractUnit two) {

        battleFrame.addBattleLog("*** " + turn + " ход ***");
        battleFrame.addBattleLog(one.BattleInfo());
        battleFrame.addBattleLog(two.BattleInfo());

        //Сверяем инициативу для первого удара
        if (one.getInit() > two.getInit()) {

            AttackAfterInit(one, two);
        } else if (two.getInit() > one.getInit()) {

            AttackAfterInit(two, one);
        } else if (one.getInit() == two.getInit()) {

            Random rnd = new Random();
            if (rnd.nextBoolean()) AttackAfterInit(one, two);
            else AttackAfterInit(two, one);
        }

        //Увеличиваем ход, и добавляем пустую строку
        turn++;

        //Переход на след. строку
        battleFrame.addBattleLog("");
    }

    //Если урон есть - он отображается (Индикация урона)
    private void AttackLog(AbstractUnit one, AbstractUnit two) {

        //Сама атака и возвращение урона 
        Damage Dmg = one.Attack(two);

        //Если попал
        if (!Dmg.isMiss()) {
            //Если критический
            if (Dmg.isCritical()) {
                //Если есть оружие
                if (Dmg.getWeaponDmg() > 0)
                    battleFrame.addBattleLog(one.getName() + " нанес " + Dmg.getAllDmg() + " урона критическим "
                            + "ударом используя " + one.getWeapon().getName());
                    //Если нет оружия
                else
                    battleFrame.addBattleLog(one.getName() + " нанес " + Dmg.getAllDmg() + " урона критическим "
                            + "ударом");
            }
            //Если не критический
            else {
                //Если есть оружие
                if (Dmg.getWeaponDmg() > 0)
                    battleFrame.addBattleLog(one.getName() + " нанес " + Dmg.getAllDmg() + " урона "
                            + "используя " + one.getWeapon().getName());
                    //Если нет оружия
                else
                    battleFrame.addBattleLog(one.getName() + " нанес " + Dmg.getAllDmg() + " урона");
            }
        }

        //Если промахнулся
        else {
            battleFrame.addBattleLog(one.getName() + " промахнулся");
        }
    }

    //Порядок атак, после сверения инициативы
    private void AttackAfterInit(AbstractUnit one, AbstractUnit two) {

        //1 потом 2
        AttackLog(one, two);
        //Если второй после удара жив, то он атакует в ответ
        if (two.isAlive()) {
            //Атакует второй
            AttackLog(two, one);
            if (!one.isAlive()) battleFrame.addBattleLog(one.getName() + " умер");
        } else {
            battleFrame.addBattleLog(two.getName() + " умер");
        }
    }
}

