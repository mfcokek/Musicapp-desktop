/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import javax.swing.*;


public class DMainGui {

    JFrame jf = null;
    JPanel jp = null;
    KumandaGui kg = null;

    public DMainGui() {
        getJp().setBackground(Color.getHSBColor(0.5f, 0.5f, 0.8f).darker());
        getJp().add(getKg().getJp());
        getJf().setVisible(true);
    }

    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("MusicPlayer");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocation(600, 450);
            jf.setSize(400, 400);
            jf.setContentPane(getJp());
            jf.setResizable(false);
        }
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setLayout(null);
        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

       public KumandaGui getKg() {
        if (kg == null) {
            kg = new KumandaGui(this);
        }
        return kg;
    }

    public void setKg(KumandaGui kg) {
        this.kg = kg;
    }
}
