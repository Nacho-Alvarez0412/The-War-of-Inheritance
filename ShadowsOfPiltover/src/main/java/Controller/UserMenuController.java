/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataBase;
import View.MenuUser;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
public class UserMenuController 
                    implements ActionListener{
    private MenuUser vista;
    private User modelo;
    private boolean evento;
    private DataBase database;

    public UserMenuController(MenuUser vista, User modelo,DataBase database) {
        this.vista = vista;
        this.modelo = modelo;
        this.evento = false;
        this.database = database;
        _init_();
    }
    
    public void _init_(){
        vista.ContinueJourneyButton.addActionListener(this);
        vista.NewJourneyButton.addActionListener(this);
        vista.setTitle("Dead Tides");
        vista.UsernameTextField.setText(modelo.getUsername());
        vista.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(evento){
            evento = !evento;
            return;
        }
        else if (e.getSource().equals(vista.ContinueJourneyButton)){
            evento = true;
            if(modelo.getCurrentLvl() != 1){
                evento = true;
                SelectArmyController controller = new SelectArmyController(modelo,database);
                controller._init_();
                database.closeDataBase();
                this.vista.dispose();
            }
                
            else
                JOptionPane.showMessageDialog(vista, "There are no adventures available try beginning a new one!");

        }
        else if (e.getSource().equals(vista.NewJourneyButton)){
            evento = true;
            if(modelo.getCurrentLvl()>1)
                modelo.resetStats();
            SelectArmyController controller = new SelectArmyController(modelo,database);
            controller._init_();
            database.closeDataBase();
            this.vista.dispose();

        }
    } 
}
    

