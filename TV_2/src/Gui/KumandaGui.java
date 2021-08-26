/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Logic.Actions;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KumandaGui {

    JPanel jp = null;
    JButton onOff = null;
    JButton baslat = null;
    JButton durdur = null;
    JButton basaal = null;
    JButton seskis = null;
    JButton sesac = null;
    JButton mute = null;
    JLabel sarkiadi = null;
    Actions a = new Actions(this);

    public JLabel getSarkiadi() {
        if (sarkiadi == null) {
            sarkiadi = new JLabel();
            sarkiadi.setBounds(0, 25, 500, 50);
            sarkiadi.setForeground(Color.red);
            sarkiadi.setOpaque(true);
            sarkiadi.setVisible(true);
            sarkiadi.setBackground(Color.BLUE);
        }
        return sarkiadi;
    }
    public void setSarkiadi(JLabel sarkiadi) {
        this.sarkiadi = sarkiadi;
    }
    public JButton getMute() {
        if (mute == null) {
            mute = new JButton();
            mute.setBackground(Color.white);
            Icon onB = new ImageIcon(getClass().getResource("mute.png"));
            mute.setIcon(onB);
            mute.setBounds(315, 300, 50, 50);
            mute.addActionListener(a);
        }
        return mute;
    }
    public void setMute(JButton mute) {
        this.mute = mute;
    }
    public JButton getSesac() {
        if (sesac == null) {
            sesac = new JButton();
            sesac.setBackground(Color.WHITE);
            Icon onB = new ImageIcon(getClass().getResource("up.png"));
            sesac.setIcon(onB);
            sesac.setBounds(265, 300, 50, 50);
            sesac.addActionListener(a);
            sesac.setBackground(Color.WHITE);
        }
        return sesac;
    }
    public void setSesac(JButton sesac) {
        this.sesac = sesac;
    }
    public JButton getSeskis() {
        if (seskis == null) {
            seskis = new JButton();
            seskis.setBackground(Color.white);
            Icon onB = new ImageIcon(getClass().getResource("low.png"));
            seskis.setIcon(onB);
            seskis.setBounds(215, 300, 50, 50);
            seskis.addActionListener(a);
        }
        return seskis;
    }
    public void setSeskis(JButton seskis) {
        this.seskis = seskis;
    }
    public JButton getBasaal() {
        if (basaal == null) {
            basaal = new JButton();
            basaal.setBackground(Color.white);
            Icon onB = new ImageIcon(getClass().getResource("stop.png"));
            basaal.setIcon(onB);
            basaal.setBounds(165, 300, 50, 50);
            basaal.addActionListener(a);
        }
        return basaal;
    }
    public void setBasaal(JButton basaal) {
        this.basaal = basaal;
    }
    public JButton getDurdur() {
        if (durdur == null) {
            durdur = new JButton();
            durdur.setBackground(Color.white);
            Icon onB = new ImageIcon(getClass().getResource("pause.png"));
            durdur.setIcon(onB);
            durdur.setBounds(115, 300, 50, 50);
            durdur.addActionListener(a);
        }
        return durdur;
    }
    public void setDurdur(JButton durdur) {
        this.durdur = durdur;
    }
    public KumandaGui(DMainGui eg) {
        getJp().add(getOnOff());
        getJp().add(getBaslat());
        getJp().add(getDurdur());
        getJp().add(getBasaal());
        getJp().add(getSeskis());
        getJp().add(getSesac());
        getJp().add(getMute());
        getJp().add(getSarkiadi());
    }
    public JButton getBaslat() {
        if (baslat == null) {
            baslat = new JButton();
            baslat.setBackground(Color.white);
            Icon onB = new ImageIcon(getClass().getResource("icon2.png"));
            baslat.setIcon(onB);
            baslat.setBounds(65, 300, 50, 50);
            baslat.addActionListener(a);
        }
        return baslat;
    }
    public void setBaslat(JButton baslat) {
        this.baslat = baslat;
    }
    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(0, 0, 400, 400);
            jp.setBackground(Color.LIGHT_GRAY);
            jp.setLayout(null);
        }
        return jp;
    }
    public void setJp(JPanel jp) {
        this.jp = jp;
    }
    public JButton getOnOff() {
        if (onOff == null) {
            onOff = new JButton();
            onOff.setBackground(Color.white);
            Icon onB = new ImageIcon(getClass().getResource("icon.png"));
            onOff.setIcon(onB);
            onOff.setBounds(15, 300, 50, 50);
            onOff.addActionListener(a);
        }
        return onOff;
    }
    public void setOnOff(JButton onOff) {
        this.onOff = onOff;
    }
}