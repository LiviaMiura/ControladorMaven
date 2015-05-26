/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.controlador.swing;

import java.io.IOException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.NoPlayerException;
import javax.media.CannotRealizeException;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.Manager;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.image.BufferedImage;


public class WebCamForm extends javax.swing.JFrame {    
    Controlador conn = new Controlador();
    Arduino connArduino = new Arduino();
    CapturaImagem capturaImagem;
    Player player;
    String nfile;
    BufferedImage bi;

    public WebCamForm() {
        initComponents();
        try {
      
            initCamera();
                connArduino.resetPantilt();
            
        } catch (IOException ex) {
            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initCamera() throws IOException, NoPlayerException, CannotRealizeException {
         
        MediaLocator m1 = new MediaLocator("vfw://0");
        player = Manager.createRealizedPlayer(m1);
        this.tbcamera.add(player.getVisualComponent());
        player.start();
        System.out.println("");

    }

    private void setImageButton(JToggleButton tbutton, Image image) {
        tbutton.setIcon(new ImageIcon(image));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jAzimute = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tbcamera = new javax.swing.JToggleButton();
        bCapture = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        jBLeft = new javax.swing.JButton();
        JTextGraus = new javax.swing.JTextField();
        jBDown = new javax.swing.JButton();
        jBUp = new javax.swing.JButton();
        jBRight = new javax.swing.JButton();
        jBClose = new javax.swing.JButton();
        jBCameraON = new javax.swing.JButton();
        jBCameraOFF = new javax.swing.JButton();
        jBResetpt = new javax.swing.JButton();
        BotaoAzimute = new javax.swing.JButton();
        BotaoElevacao = new javax.swing.JButton();

        jButton1.setText("Elevação");

        jAzimute.setText("Azimute");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("PROJETO LEONA");

        bCapture.setText("Capture");
        bCapture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCaptureMouseClicked(evt);
            }
        });
        bCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCaptureActionPerformed(evt);
            }
        });

        bSave.setText("Stop");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        jBLeft.setText("LEFT");
        jBLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBLeftMouseClicked(evt);
            }
        });
        jBLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLeftActionPerformed(evt);
            }
        });

        JTextGraus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextGrausActionPerformed(evt);
            }
        });

        jBDown.setText("DOWN");
        jBDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBDownMouseClicked(evt);
            }
        });
        jBDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDownActionPerformed(evt);
            }
        });

        jBUp.setText("UP");
        jBUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBUpMouseClicked(evt);
            }
        });
        jBUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpActionPerformed(evt);
            }
        });

        jBRight.setText("RIGHT");
        jBRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBRightMouseClicked(evt);
            }
        });
        jBRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRightActionPerformed(evt);
            }
        });

        jBClose.setText("Sair");
        jBClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCloseMouseClicked(evt);
            }
        });

        jBCameraON.setText("Camera ON");
        jBCameraON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCameraONMouseClicked(evt);
            }
        });
        jBCameraON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCameraONActionPerformed(evt);
            }
        });

        jBCameraOFF.setText("Camera OFF");
        jBCameraOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCameraOFFMouseClicked(evt);
            }
        });
        jBCameraOFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCameraOFFActionPerformed(evt);
            }
        });

        jBResetpt.setText("Reset");
        jBResetpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBResetptMouseClicked(evt);
            }
        });
        jBResetpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetptActionPerformed(evt);
            }
        });

        BotaoAzimute.setText("Azimute");
        BotaoAzimute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoAzimuteMouseClicked(evt);
            }
        });
        BotaoAzimute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAzimuteActionPerformed(evt);
            }
        });

        BotaoElevacao.setText("Elevação");
        BotaoElevacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoElevacaoMouseClicked(evt);
            }
        });
        BotaoElevacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoElevacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbcamera, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jBResetpt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBLeft, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBClose, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBRight)
                                    .addComponent(jBDown))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bCapture)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBCameraON))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBCameraOFF))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(BotaoAzimute)
                        .addGap(27, 27, 27)
                        .addComponent(JTextGraus, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(BotaoElevacao)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbcamera, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBUp)
                    .addComponent(jBDown))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLeft)
                    .addComponent(jBRight)
                    .addComponent(jBCameraON))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave)
                    .addComponent(jBResetpt)
                    .addComponent(jBClose)
                    .addComponent(jBCameraOFF))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextGraus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoAzimute)
                    .addComponent(BotaoElevacao))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void bCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCaptureActionPerformed
             
        if ("Capture".equals(evt.getActionCommand())) {
             capturaImagem = new CapturaImagem(this);                  
             capturaImagem.start();
         }
          else{
               if ("Stop".equals(evt.getActionCommand())) {
                  System.out.println("**************Cancela de capturar imagens**********");
            }
         }
   
    }//GEN-LAST:event_bCaptureActionPerformed
  
    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        System.out.println("********************************parar de tirar fotos*******************************");
         capturaImagem.stop();
    }//GEN-LAST:event_bSaveActionPerformed

    private void bCaptureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCaptureMouseClicked
         // TODO add your handling code here:        
    }//GEN-LAST:event_bCaptureMouseClicked

    private void jBLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLeftMouseClicked

        String graus = String.valueOf(JTextGraus.getText());
        connArduino.comunicacaoArduino(jBLeft, graus);
    }//GEN-LAST:event_jBLeftMouseClicked

    private void jBLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBLeftActionPerformed

    private void JTextGrausActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextGrausActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextGrausActionPerformed

    private void jBDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDownMouseClicked

        String graus = String.valueOf(JTextGraus.getText());
        connArduino.comunicacaoArduino(jBDown, graus);
    }//GEN-LAST:event_jBDownMouseClicked

    private void jBDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBDownActionPerformed

    private void jBUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBUpMouseClicked

        String graus = String.valueOf(JTextGraus.getText());
        connArduino.comunicacaoArduino(jBUp, graus);
    }//GEN-LAST:event_jBUpMouseClicked

    private void jBUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBUpActionPerformed

    private void jBRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBRightMouseClicked

        String graus = String.valueOf(JTextGraus.getText());
        connArduino.comunicacaoArduino(jBRight, graus);
    }//GEN-LAST:event_jBRightMouseClicked

    private void jBRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRightActionPerformed

    private void jBCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCloseMouseClicked

        String graus = String.valueOf(JTextGraus.getText());
        connArduino.comunicacaoArduino(jBClose, graus);

        System.exit(0);//fecha a aplicação
    }//GEN-LAST:event_jBCloseMouseClicked

    private void jBCameraONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCameraONMouseClicked
   //     String graus = String.valueOf(JTextGraus.getText());
        connArduino.cameraON();
    }//GEN-LAST:event_jBCameraONMouseClicked

    private void jBCameraOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCameraOFFMouseClicked

     connArduino.cameraOFF();
    }//GEN-LAST:event_jBCameraOFFMouseClicked

    private void jBResetptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBResetptMouseClicked
        String graus = String.valueOf(JTextGraus.getText());
        connArduino.comunicacaoArduino(jBResetpt, graus);
    }//GEN-LAST:event_jBResetptMouseClicked

    private void BotaoElevacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoElevacaoActionPerformed

    }//GEN-LAST:event_BotaoElevacaoActionPerformed

    private void BotaoAzimuteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAzimuteMouseClicked
         String graus = String.valueOf(JTextGraus.getText());
        connArduino.calculoAzimute(BotaoAzimute, graus);
    }//GEN-LAST:event_BotaoAzimuteMouseClicked

    private void BotaoElevacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoElevacaoMouseClicked
             String graus = String.valueOf(JTextGraus.getText());
        connArduino.calculoElevacao(BotaoElevacao, graus);
    }//GEN-LAST:event_BotaoElevacaoMouseClicked

    private void jBCameraONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCameraONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCameraONActionPerformed

    private void jBCameraOFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCameraOFFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCameraOFFActionPerformed

    private void jBResetptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBResetptActionPerformed

    private void BotaoAzimuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAzimuteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoAzimuteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WebCamForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAzimute;
    private javax.swing.JButton BotaoElevacao;
    private javax.swing.JTextField JTextGraus;
    private javax.swing.JButton bCapture;
    private javax.swing.JButton bSave;
    private javax.swing.JButton jAzimute;
    private javax.swing.JButton jBCameraOFF;
    private javax.swing.JButton jBCameraON;
    private javax.swing.JButton jBClose;
    private javax.swing.JButton jBDown;
    private javax.swing.JButton jBLeft;
    private javax.swing.JButton jBResetpt;
    private javax.swing.JButton jBRight;
    private javax.swing.JButton jBUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton tbcamera;
    // End of variables declaration//GEN-END:variables
}
