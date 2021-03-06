/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Deffenses;

import Model.*;
import Model.Enums.DeffenseType;
import Model.Enums.ElementType;
import Model.Enums.WarriorType;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author nacho
 */
public class Tower extends Deffense {
    
    public Tower(int lvl,Piece[][] warzone) {
        super("Tower", 1, 1, 1, 5, lvl, 1, 0, 0, new ArrayList<>(), new ArrayList<>(), null, warzone, new ArrayList<>(), DeffenseType.Tower);
        this.setDamage(10+(lvl*2));
        this.setHealth(110+(lvl*2.5));
        this.setDamageXsecond(5);
        
        ArrayList<ImageIcon> appereance = new ArrayList();
        appereance.add(new ImageIcon("C:\\Users\\nacho\\Desktop\\Proyectos\\Java\\The-War-of-Inheritance\\ShadowsOfPiltover\\src\\main\\java\\View\\DeffenseAssets\\SniperTower.png")); 
        appereance.add(new ImageIcon("C:\\Users\\nacho\\Desktop\\Proyectos\\Java\\The-War-of-Inheritance\\ShadowsOfPiltover\\src\\main\\java\\View\\DeffenseAssets\\Debris.png"));
        setAppereance(appereance);
        this.setFrame(new JLabel());
        this.getFrame().setIcon(appereance.get(0));
        
        this.setUnlockLvl(4);
        this.objective.add(WarriorType.Hero);
        this.objective.add(WarriorType.Ranged);
        this.objective.add(WarriorType.Meele);
        this.objective.add(WarriorType.Beast);
        this.objective.add(WarriorType.Airborne);
    }
@Override
    public void run(){
        while (getHealth()>0){
            if(attacker != null){
                System.out.println(getPieceName()+",Targeted: "+ attacker.getPieceName());
                attack();
            }
            else{
                setInRange(this.radarSwap(ElementType.warrior));
                targetObjective();
            }
       
            try {
                sleep((long)getDamageXsecond() *1000);
                while(pause){
                    sleep(1);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Tower.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        die();
    }

    @Override
    public void move() {
    }

    @Override
    public void attack() {
        if(attacker.getHealth()>0){
            attacker.setHealth(attacker.getHealth()-getDamage());
        }
        else{
            System.out.println(attacker.getPieceName()+",Objetivo abatido");
            attacker = null;
            
        }
    }
    

    @Override
    public void die() {
        getWarzone()[getX()][getY()] = null;
        this.getFrame().setIcon(appereance.get(1));
        System.out.println(getPieceName()+",Fui Destruido...");
    }

    @Override
    public void sound() {
    }
    
}
