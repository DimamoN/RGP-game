/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author dimamon
 */
public class TurnInfo {
    
    Damage damage;
    
    //Один статус
    String status;
    
    public TurnInfo(Damage damage, String status) {
        this.damage = damage;
        this.status = status;
    }
    
}
