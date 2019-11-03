/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Warriors;

import Model.Enums.ElementType;
import Model.Enums.WarriorType;
import Model.Piece;
import Model.PlayMusic;
import Model.Warrior;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author nacho
 */
public class Dragon extends Warrior {
    public Dragon(int lvl){
        super(700,"Dragon",1,1,1, 7, lvl, 1, 0, 0, new ArrayList<>(), new ArrayList<>(), null, null,WarriorType.Airborne,5);
        this.setHealth(60+(lvl*0.5));
        this.setDamage(10+(lvl*4));
        this.setRange(7+lvl);
        this.setUnlockLvl(7);
        loadImages();
    }
    
    private void loadImages(){
        ArrayList<ImageIcon> appereance = new ArrayList();
        appereance.add(new ImageIcon("C:\\Users\\nacho\\Desktop\\Proyectos\\Java\\The-War-of-Inheritance\\ShadowsOfPiltover\\src\\main\\java\\View\\DragonAssets\\DragonMove.gif"));
        appereance.add(new ImageIcon("C:\\Users\\nacho\\Desktop\\Proyectos\\Java\\The-War-of-Inheritance\\ShadowsOfPiltover\\src\\main\\java\\View\\DragonAssets\\DragonAttack.gif"));
        appereance.add(new ImageIcon("C:\\Users\\nacho\\Desktop\\Proyectos\\Java\\The-War-of-Inheritance\\ShadowsOfPiltover\\src\\main\\java\\View\\DragonAssets\\DragonDie.gif"));
        appereance.add(new ImageIcon("C:\\Users\\nacho\\Desktop\\Proyectos\\Java\\The-War-of-Inheritance\\ShadowsOfPiltover\\src\\main\\java\\View\\Images\\Grave.png"));
        setAppereance(appereance);
        this.setFrame(new JLabel()); 
        this.getFrame().setIcon(appereance.get(0));
    }
    
    @Override
    public void run(){
        while (getHealth()>0){
            if(deffender != null){
                System.out.println(getPieceName()+",Target: "+deffender.getPieceName());
                attack();
            }
            else{
                setInRange(radarSwap(ElementType.deffense));
                sound();
            }
       
            try {
                sleep((long)getDamageXsecond() *1000);
                while(pause){
                    sleep(1);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Dragon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        die();
    }

    


    @Override
    public void sound() {
        PlayMusic player = new PlayMusic();
        player.playMainMusic("C:\\Users\\nacho\\Desktop\\Proyectos\\Java\\The-War-of-Inheritance\\ShadowsOfPiltover\\src\\main\\java\\View\\DragonSounds.wav");
    }
   
}
