/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import game.factories.ArmorFactory;
import game.items.armor.Armor;
import game.items.weapons.Weapon;
import game.factories.UnitFactory;
import game.units.AbstractUnit;
import game.units.SimpleMan;
import game.factories.WeaponFactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 * @author DimamoN
 */
public class GameMap extends javax.swing.JFrame {

    UnitFactory units = new UnitFactory();  //Юниты слева
//    UnitFactory units = new UnitFactory(); //Юниты справа

    WeaponFactory weapons = new WeaponFactory();
    ArmorFactory armors = new ArmorFactory();

    /**
     * Creates new form GameMap
     */
    public GameMap() {
        initComponents();

        this.setLocation(300, 300);

        this.setVisible(true);

        this.setTitle("RPG GAME | MANAGER");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/img/icon.png")).getImage());

        //Установка значений в комбоБоксы из Фабрик
        this.comboBoxHero1.setModel(new DefaultComboBoxModel<>(units.getNames()));
        this.comboBoxHero2.setModel(new DefaultComboBoxModel<>(units.getNames()));

        this.comboBoxEditHero.setModel(new DefaultComboBoxModel<>(units.getNames()));

        this.comboBoxWeapon.setModel(new DefaultComboBoxModel<>(weapons.getNames()));
        this.comboBoxArmor.setModel(new DefaultComboBoxModel<>(armors.getNames()));

        StartBattleTabSetup();
        EditTabSetup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        createBattlePanel = new javax.swing.JPanel();
        comboBoxHero1 = new javax.swing.JComboBox<>();
        comboBoxHero2 = new javax.swing.JComboBox<>();
        btnStartBattle = new javax.swing.JButton();
        labelVertus = new javax.swing.JLabel();
        hero2Image = new javax.swing.JLabel();
        hero1Image = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        comboBoxEditHero = new javax.swing.JComboBox<>();
        SaveEditedUnit = new javax.swing.JButton();
        labelHitpoints = new javax.swing.JLabel();
        labelStr = new javax.swing.JLabel();
        labelAgl = new javax.swing.JLabel();
        hitPoints = new javax.swing.JTextField();
        labelWeapon = new javax.swing.JLabel();
        labelArmor = new javax.swing.JLabel();
        comboBoxSTR = new javax.swing.JComboBox<>();
        comboBoxWeapon = new javax.swing.JComboBox<>();
        comboBoxAGL = new javax.swing.JComboBox<>();
        comboBoxArmor = new javax.swing.JComboBox<>();
        heroEditImage = new javax.swing.JLabel();
        heroEditArmorImage = new javax.swing.JLabel();
        heroEditWeaponImage = new javax.swing.JLabel();
        labelInfoEdit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboBoxHero1.setMaximumRowCount(10);
        comboBoxHero1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxHero1MouseClicked(evt);
            }
        });
        comboBoxHero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxHero1ActionPerformed(evt);
            }
        });

        comboBoxHero2.setMaximumRowCount(10);
        comboBoxHero2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxHero2MouseClicked(evt);
            }
        });
        comboBoxHero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxHero2ActionPerformed(evt);
            }
        });

        btnStartBattle.setText("Начать битву");
        btnStartBattle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartBattleActionPerformed(evt);
            }
        });

        labelVertus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVertus.setText("Против");
        labelVertus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVertusMouseClicked(evt);
            }
        });

        hero2Image.setText("Hero2Image");

        hero1Image.setText("Hero1Image");

        javax.swing.GroupLayout createBattlePanelLayout = new javax.swing.GroupLayout(createBattlePanel);
        createBattlePanel.setLayout(createBattlePanelLayout);
        createBattlePanelLayout.setHorizontalGroup(
                createBattlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createBattlePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnStartBattle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(createBattlePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(comboBoxHero1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hero1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelVertus, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(hero2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxHero2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );
        createBattlePanelLayout.setVerticalGroup(
                createBattlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createBattlePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createBattlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hero1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBoxHero1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hero2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBoxHero2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelVertus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                                .addComponent(btnStartBattle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Создать битву", createBattlePanel);

        comboBoxEditHero.setMaximumRowCount(10);
        comboBoxEditHero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxEditHeroMouseClicked(evt);
            }
        });
        comboBoxEditHero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEditHeroActionPerformed(evt);
            }
        });

        SaveEditedUnit.setText("Сохранить");
        SaveEditedUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveEditedUnitActionPerformed(evt);
            }
        });

        labelHitpoints.setText("Хит-поинты:");

        labelStr.setText("Сила:");

        labelAgl.setText("Ловкость:");

        hitPoints.setText("HP");

        labelWeapon.setText("Оружие:");

        labelArmor.setText("Броня:");

        comboBoxSTR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));

        comboBoxWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxWeaponActionPerformed(evt);
            }
        });

        comboBoxAGL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));

        comboBoxArmor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxArmorActionPerformed(evt);
            }
        });

        heroEditImage.setText("Image");

        heroEditArmorImage.setText("Image");

        heroEditWeaponImage.setText("Image");

        labelInfoEdit.setText("Сохранение работает до выключения менеджера");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(comboBoxEditHero, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelHitpoints)
                                                                        .addComponent(labelStr)
                                                                        .addComponent(labelAgl))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(hitPoints)
                                                                        .addComponent(comboBoxAGL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(comboBoxSTR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(heroEditImage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelWeapon)
                                                                        .addComponent(labelArmor))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(comboBoxArmor, 0, 126, Short.MAX_VALUE)
                                                                        .addComponent(comboBoxWeapon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(heroEditArmorImage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(heroEditWeaponImage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 47, Short.MAX_VALUE)
                                                                .addComponent(labelInfoEdit))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(SaveEditedUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(comboBoxEditHero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(23, 23, 23)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(labelHitpoints)
                                                                        .addComponent(hitPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(labelAgl)
                                                                        .addComponent(comboBoxAGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(heroEditImage, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelStr)
                                                        .addComponent(comboBoxSTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(labelInfoEdit)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(labelWeapon)
                                                                        .addComponent(comboBoxWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(36, 36, 36))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(heroEditWeaponImage, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelArmor)
                                                        .addComponent(comboBoxArmor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(heroEditArmorImage, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(SaveEditedUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Редактор персонажей", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1)
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxHero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHero2ActionPerformed
        getSecondUnit();
    }//GEN-LAST:event_comboBoxHero2ActionPerformed

    private void comboBoxHero2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxHero2MouseClicked

    }//GEN-LAST:event_comboBoxHero2MouseClicked

    private void comboBoxHero1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxHero1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxHero1MouseClicked

    private void comboBoxHero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHero1ActionPerformed
        getFirstUnit();
    }//GEN-LAST:event_comboBoxHero1ActionPerformed

    //Запуск битвы, с выбранными юнитами
    private void btnStartBattleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartBattleActionPerformed

        BattleFrame BattleFrame = new BattleFrame(getFirstUnit(), getSecondUnit());

    }//GEN-LAST:event_btnStartBattleActionPerformed

    private void comboBoxEditHeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxEditHeroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEditHeroMouseClicked

    private void comboBoxEditHeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEditHeroActionPerformed
        EditTabSetup();
    }//GEN-LAST:event_comboBoxEditHeroActionPerformed

    //Выбор оружия
    private void comboBoxWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxWeaponActionPerformed
        getWeaponEdit();
    }//GEN-LAST:event_comboBoxWeaponActionPerformed

    //Выбор брони
    private void comboBoxArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxArmorActionPerformed
        getArmorEdit();
    }//GEN-LAST:event_comboBoxArmorActionPerformed

    private void SaveEditedUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveEditedUnitActionPerformed

        // Сохранить юнита   
        AbstractUnit unit = getEditUnit();

        //Установить значения из полей
        unit.setsHp(Integer.parseInt(this.hitPoints.getText()));
        unit.setStr(Integer.parseInt(this.comboBoxSTR.getSelectedItem() + ""));
        unit.setAgl(Integer.parseInt(this.comboBoxAGL.getSelectedItem() + ""));

        unit.setWeapon(getWeaponEdit());
        unit.setArmor(getArmorEdit());

        //Сохранить юнит (ДВАРФ) ?????? (Сохраняет всех)
//        this.units.getUnits().set(4, unit);

        this.units.getUnitMap().replace(unit.getName(), unit);


    }//GEN-LAST:event_SaveEditedUnitActionPerformed

    private void labelVertusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVertusMouseClicked

    }//GEN-LAST:event_labelVertusMouseClicked

    //Установка иконок для героев первой вкладки
    public void StartBattleTabSetup() {
        getFirstUnit();
        getSecondUnit();
    }

    //Установка иконок для героя вкладки редактирования
    public void EditTabSetup() {

        //Берет выбраного в комбобоксе юнита
        AbstractUnit unit = this.getEditUnit();

        //Установка значений в комбоБоксы в зависимости от выбраного юнита
        this.hitPoints.setText(unit.getsHp() + "");

        this.comboBoxAGL.setSelectedIndex(unit.getAgl());
        this.comboBoxSTR.setSelectedIndex(unit.getStr());

        this.comboBoxWeapon.setSelectedItem(unit.getWeapon().getName());
        this.comboBoxArmor.setSelectedItem(unit.getArmor().getName());

        getWeaponEdit();
        getArmorEdit();
    }

    //Возвращает юнита выбранного на комбобоксе (и устанавливает картинку)
    private AbstractUnit getFirstUnit() {

        String selectedItem = this.comboBoxHero1.getSelectedItem() + "";

        for (AbstractUnit unit : units.getUnits()) {
            if (selectedItem.equals(unit.getName())) {

                this.hero1Image.setIcon(unit.getImage()); //Так себе

                return unit.clone();
            }

        }

        return new SimpleMan();
    }

    //Возвращает юнита выбранного на комбобоксе (и устанавливает картинку)
    private AbstractUnit getSecondUnit() {

        String selectedItem = this.comboBoxHero2.getSelectedItem() + "";

        for (AbstractUnit unit : units.getUnits()) {
            if (selectedItem.equals(unit.getName())) {

                this.hero2Image.setIcon(unit.getImage()); //Так себе

                return unit;
            }

        }

        return new SimpleMan();
    }

    //Возвращает юнита выбранного на комбобоксе (и устанавливает картинку)
    private AbstractUnit getEditUnit() {

        String selectedItem = this.comboBoxEditHero.getSelectedItem() + "";

        for (AbstractUnit unit : units.getUnits()) {
            if (selectedItem.equals(unit.getName())) {

                this.heroEditImage.setIcon(unit.getImage()); //Так себе

                return unit;
            }

        }

        return new SimpleMan();
    }

    //Возвращает оружие выбранное на комбобоксе (и устанавливает картинку)
    private Weapon getWeaponEdit() {

        String selectedItem = this.comboBoxWeapon.getSelectedItem() + "";

        for (Weapon weapon : weapons.getWeapons()) {
            if (selectedItem.equals(weapon.getName())) {

                this.heroEditWeaponImage.setIcon(weapon.getImage()); //Так себе

                return weapon;
            }

        }

        return new Weapon();
    }

    //Возвращает юнита выбранного на комбобоксе (и устанавливает картинку)
    private Armor getArmorEdit() {

        String selectedItem = this.comboBoxArmor.getSelectedItem() + "";

        for (Armor armor : armors.getArmors()) {
            if (selectedItem.equals(armor.getName())) {

                this.heroEditArmorImage.setIcon(armor.getImage()); //Так себе

                return armor;
            }

        }

        return new Armor();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveEditedUnit;
    private javax.swing.JButton btnStartBattle;
    private javax.swing.JComboBox<String> comboBoxAGL;
    private javax.swing.JComboBox<String> comboBoxArmor;
    private javax.swing.JComboBox<String> comboBoxEditHero;
    private javax.swing.JComboBox<String> comboBoxHero1;
    private javax.swing.JComboBox<String> comboBoxHero2;
    private javax.swing.JComboBox<String> comboBoxSTR;
    private javax.swing.JComboBox<String> comboBoxWeapon;
    private javax.swing.JPanel createBattlePanel;
    private javax.swing.JLabel hero1Image;
    private javax.swing.JLabel hero2Image;
    private javax.swing.JLabel heroEditArmorImage;
    private javax.swing.JLabel heroEditImage;
    private javax.swing.JLabel heroEditWeaponImage;
    private javax.swing.JTextField hitPoints;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAgl;
    private javax.swing.JLabel labelArmor;
    private javax.swing.JLabel labelHitpoints;
    private javax.swing.JLabel labelInfoEdit;
    private javax.swing.JLabel labelStr;
    private javax.swing.JLabel labelVertus;
    private javax.swing.JLabel labelWeapon;
    // End of variables declaration//GEN-END:variables
}
