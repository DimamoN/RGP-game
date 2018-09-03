/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.units;

import java.text.DecimalFormat;

public class BattleStat {

    //Число попаданий
    private int hitCount = 0;
    //Число уклонений
    private int missCount = 0;

    public int getMissCount() {
        return missCount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void addHit() {
        this.hitCount++;
    }

    public void addMiss() {
        this.missCount++;
    }

    public String getHitPerc() {

        if (hitCount == 0 && missCount == 0) {
            return "-";
        }

        double sum = hitCount + missCount;
        double hitStat = hitCount / sum;
        hitStat = hitStat * 100;
        String formattedHitStat = new DecimalFormat("#0.00").format(hitStat);
        return formattedHitStat + " %";
    }

    //Вернуть Статистику Попаданий
    public String getHitStat() {
        return "Попаданий: " + this.hitCount + " Промахов: " + this.missCount + " Процент попаданий: " + this.getHitPerc();
    }

    public void resetStats() {
        this.missCount = 0;
        this.hitCount = 0;
    }

}
