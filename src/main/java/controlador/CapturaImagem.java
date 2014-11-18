/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JImage.JIResizeImage;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private String diretorio; 
    private String observacao; 
    private WebCamForm webCamForm;
    
    CapturaImagem(String diretorio, String observacao, WebCamForm webCamForm){
        this.diretorio = diretorio; 
        this.observacao = observacao;
        this.webCamForm = webCamForm;
    }
    
    public void run() {
        String imagem;
        int[] a = new int[1080000];
        for(int i = 0; i < a.length; i++) {
            FrameGrabbingControl fgc = (FrameGrabbingControl) webCamForm.player.getControl("javax.media.control.FrameGrabbingControl");
            Buffer buffer = fgc.grabFrame();
            BufferToImage bti = new BufferToImage((VideoFormat) buffer.getFormat());
            Image image = bti.createImage(buffer);
            JIResizeImage resize = new JIResizeImage();
            webCamForm.bi = (BufferedImage) image;
            //Image imageresize = resize.rescale(webCamForm.bi, 240, 240);
            boolean dir = new File(diretorio + observacao).mkdir();
            String caminho = diretorio + observacao;
            System.out.println("imagem[" + i + "]");
            FileDialog fd = new FileDialog(webCamForm, "Save Image", FileDialog.SAVE);
            imagem = "imagem[" + i + "]";
            fd.setDirectory(caminho);
            fd.setFile(imagem);
            if (fd.getFile() != null) {
                webCamForm.nfile = fd.getDirectory() + fd.getFile() + ".jpg";
                try {
                    File make = new File(webCamForm.nfile);
                    try {
                        ImageIO.write(webCamForm.bi, "jpg", make);
                    } catch (IOException ex) {
                        Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception ex) {
                    System.out.println("!! ERRO: "+ex);
                }
            }
        }
    }
    
}
