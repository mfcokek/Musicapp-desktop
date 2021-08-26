/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Gui.KumandaGui;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Actions implements ActionListener {

    boolean durum = false;
    KumandaGui kumGui = null;
    Frame frame = new JFrame();
    JFileChooser jFileChooser = new JFileChooser();
    String path;
    FileInputStream fileInputStream;
    FileFilter filter;
    MediaPlayer mediaPlayer;
    Media m;
    MediaPlayer mp;
    String dosyaadi;
    ChangeListener<Duration> progressChangeListener;
    double vol1 = 0.5;

    public Actions(KumandaGui a) {
        setKumGui(a);
    }

    public KumandaGui getKumGui() {
        return kumGui;
    }

    public void setKumGui(KumandaGui kumGui) {
        this.kumGui = kumGui;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == getKumGui().getOnOff()) {

            if (mp == null) {
                
                jFileChooser.setCurrentDirectory(new File("."));
                filter = new FileNameExtensionFilter("MP3 Files", "mp3");
                jFileChooser.setFileFilter(filter);
                frame.setBounds(400, 500, 0, 0);
                frame.add(jFileChooser);
                frame.setVisible(false);
                jFileChooser.showOpenDialog(frame);
                path = jFileChooser.getSelectedFile().getAbsolutePath();
                dosyaadi = jFileChooser.getSelectedFile().getName();
                getKumGui().getSarkiadi().setText("       " + dosyaadi);
            } else {
                mp.pause();
                mp = null;
                jFileChooser.setCurrentDirectory(new File("."));
                filter = new FileNameExtensionFilter("MP3 Files", "mp3");
                jFileChooser.setFileFilter(filter);
                frame.setBounds(400, 500, 0, 0);
                frame.add(jFileChooser);
                frame.setVisible(false);
                jFileChooser.showOpenDialog(frame);
                path = jFileChooser.getSelectedFile().getAbsolutePath();
                dosyaadi = jFileChooser.getSelectedFile().getName();
                getKumGui().getSarkiadi().setText(null);
                getKumGui().getSarkiadi().setText("       " + dosyaadi);
                
            }

        } else if (ae.getSource() == getKumGui().getBaslat()) {
            System.out.println("proje başladı");
            com.sun.javafx.application.PlatformImpl.startup(new Runnable() {

                @Override
                public void run() {
                    Thread thread;
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (mp == null) {
                                    m = new Media(new File(path).toURI().toString());
                                    mp = new MediaPlayer(m);
                                    progressChangeListener = new ChangeListener<Duration>() {
                                        @Override
                                        public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
                                            System.out.println(mp.getCurrentTime().toSeconds());
                                        }
                                    };
                                    mp.currentTimeProperty().addListener(progressChangeListener);
                                }

                                if (!mp.isAutoPlay()) {
                                    System.out.println("çalıştırıldı.");

                                    mp.play();

                                    System.out.println("çalışma bitti");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    });
                    thread.start();

                }
            });

        } else if (ae.getSource() == getKumGui().getDurdur()) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("durdurucak");
                        mp.pause();
                        System.out.println("durdurdu");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });

            thread.start();

        } else if (ae.getSource() == getKumGui().getBasaal()) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("çalıştı");
                        mp.currentTimeProperty().removeListener(progressChangeListener);
                        mp.stop();
                        System.out.println("çalışmayı bitirdi");
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }

            });

            thread.start();
        } else if (ae.getSource() == getKumGui().getSeskis()) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (vol1 >= 0) {
                            vol1 = vol1 - 0.1;
                        }
                        mp.setVolume(vol1);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }

            });

            thread.start();
        } else if (ae.getSource() == getKumGui().getSesac()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (vol1 <= 1) {
                            vol1 = vol1 + 0.1;
                        }
                        mp.setVolume(vol1);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }

            });

            thread.start();
        } else if (ae.getSource() == getKumGui().getMute()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        vol1 = 0;
                        mp.setVolume(vol1);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }

            });

            thread.start();
        }
    }

}
