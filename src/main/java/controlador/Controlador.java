/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.media.NoPlayerException;
//import javax.media.CannotRealizeException;
//import javax.media.MediaLocator;
import javax.media.Player;
//import javax.media.Manager;
import javax.media.control.FrameGrabbingControl;
//import javax.swing.ImageIcon;
//import javax.swing.JToggleButton;
import javax.media.Buffer;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import JImage.JIResizeImage;
import java.awt.image.BufferedImage;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import javax.imageio.ImageIO;
//import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author livia.miura
 */
public class Controlador {

    Player player;
    String nfile;
    BufferedImage bi;
    //FileDialog fd;

    public void comunicacaoCamera(JButton button) {
        String diretorio = "C:/ProjetoLeona/Observações/";
        String observacao = "Evento ";
        String imagem;

        if ("Capture".equals(button.getActionCommand())) {
            int[] a = new int[1080000];
            for (int i = 0; i < a.length; i++) {
                FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
                Buffer buffer = fgc.grabFrame();

                BufferToImage bti = new BufferToImage((VideoFormat) buffer.getFormat());
                Image image = bti.createImage(buffer);

                JIResizeImage resize = new JIResizeImage();

                bi = (BufferedImage) image;
                //Image imageresize = resize.rescale(bi, 240, 240);

                boolean dir = new File(diretorio + observacao).mkdir();

                String caminho = diretorio + observacao;

                System.out.println("imagem[" + i + "]");
                FileDialog fd =new FileDialog(new Frame(),"Select file...",FileDialog.SAVE);
              
              //  FileDialog fd = new FileDialog(Controlador.this, "Save Image", FileDialog.SAVE);

                imagem = "imagem[" + i + "]";
                fd.setDirectory(caminho);
                // fd.setTitle("Save Image");
                fd.setFile(imagem);

                if (fd.getFile() != null) {
                    nfile = fd.getDirectory() + fd.getFile() + ".jpg";
                    try {

                        File make = new File(nfile);
                        try {

                            ImageIO.write(bi, "jpg", make);
                        } catch (IOException ex) {

                            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        } else {
            if ("Stop".equals(button.getActionCommand())) {
                System.out.println("**************Cancela de capturar imagens**********");
            }
        }
    }

}
