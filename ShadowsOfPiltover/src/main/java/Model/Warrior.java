/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public abstract class Warrior extends Element {
    //Atributos
    Warriors type;
    
    Warrior(String name,Warriors type, ArrayList appereance, int health, int attack, int attackSpeed, int lvl, int occupancy, int unlockLvl, int x, int y, int range){
        super(appereance,health,attack,attackSpeed,lvl,occupancy,unlockLvl,x,y,range,name);
        this.type = type;
    }
}