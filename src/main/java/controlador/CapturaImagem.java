/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JImage.JIResizeImage;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

/**
 *
 * @author Admin
 */
class CapturaImagem extends Thread {

    private WebCamForm webCamForm;
    String nfile;
    BufferedImage bi;
    LocalDateTime agora;

    CapturaImagem(WebCamForm webCamForm) {
        // this.diretorio = diretorio;
        //  this.observacao = observacao;
        this.webCamForm = webCamForm;
    }

    public void run() {

        String diretorio = "C:/ProjetoLeona/Observações/Evento";

        String imagem;

        int[] a = new int[1080000];
        File dir = new File("C:/ProjetoLeona/Observações/Evento");
        

        FrameGrabbingControl fgc = (FrameGrabbingControl) webCamForm.player.getControl("javax.media.control.FrameGrabbingControl");
        Buffer buffer = fgc.grabFrame();

        BufferToImage bti = new BufferToImage((VideoFormat) buffer.getFormat());
        Image image = bti.createImage(buffer);
        bi = (BufferedImage) image;

        if (dir.mkdirs()) {

            for (int i = 0; i < a.length; i++) {

                agora = LocalDateTime.now();

                FileDialog fd = new FileDialog(new Frame(), " ", FileDialog.SAVE);
                imagem = "[" + i + "]";
                System.out.println("imagem[" + i + "]  - " + agora);
                fd.setDirectory(diretorio);

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
             File dir1 = new File("C:\\ProjetoLeona\\Observações\\EventoElse");
            
            dir1.mkdir();
             for (int i = 0; i < a.length; i++) {

                agora = LocalDateTime.now();

                FileDialog fd = new FileDialog(new Frame(), " ", FileDialog.SAVE);
                imagem = "[" + i + "]";
                System.out.println("imagem[" + i + "]  - " + agora);
                fd.setDirectory(diretorio);

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
            System.out.println("Nao foi possivel criar o diretorio");
        }
    }
}
