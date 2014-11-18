/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;
import javax.swing.JButton;

/**
 * @author klauder
 */
public final class Arduino {

    private ControlePorta arduino;
    CommPortIdentifier cpi = null;
    private String portaCOM;

    /**
     * Construtor da classe Arduino
     */
    public Arduino() {
        porta();
        arduino = new ControlePorta(portaCOM, 9600);
    }
    
    
    /*
     * Descobre quais portas de comunicação estão disponíveis
     */

    public void porta() {
        try {
            Enumeration pList = CommPortIdentifier.getPortIdentifiers();
            System.out.println("Porta =: " + pList.hasMoreElements());

            while (pList.hasMoreElements()) {
                cpi = (CommPortIdentifier) pList.nextElement();

                System.out.println("Portas " + cpi.getName() + " ");
                portaCOM = cpi.getName();


            }
            System.out.println("PortA ESCOLHIDA =" + portaCOM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Envia o comando para a porta serial
     *
     * @param button - Botão que é clicado na interface Java
     * @param graus - Botão que é clicado na interface Java
     */
    public void comunicacaoArduino(JButton button, String graus) {

        int grausDigitado = Integer.parseInt(graus);


        if ("LEFT".equals(button.getActionCommand())) {
                    
           if (grausDigitado < 10) {
                String right = "L*";
                String x0 = "!00" + graus + right;
                System.out.println("LEFT < 10 = " + x0);
                arduino.enviaDados(x0);
           
            }else  if (grausDigitado >= 10 &&grausDigitado < 100 ) {
                String left = "L*";
                String w0 = "!0" + graus + left;
                System.out.println("LEFT >= 10 and < 100 = " + w0);
                arduino.enviaDados(w0);
                
            } else {
                String left = "L*";
                String y0 = "!" + graus + left;
                System.out.println("LEFT > 100 = " + y0);
                arduino.enviaDados(y0);

            }

        } if ("RIGHT".equals(button.getActionCommand())) {
            
            if (grausDigitado < 10) {
                String right = "R*";
                String x1 = "!00" + graus + right;
                System.out.println("RIGHT < 10 = " + x1);
                arduino.enviaDados(x1);
           
                
            }else  if (grausDigitado >= 10 &&grausDigitado < 100 ) {
                String right = "R*";
                String w1 = "!0" + graus + right;
                System.out.println("RIGHT >= 10 and < 100 = " + w1);
                arduino.enviaDados(w1);

            } else {
                String right = "R*";
                String y1 = "!" + graus + right;
                System.out.println("RIGHT  > 100= " + y1);
                arduino.enviaDados(y1);

            }
        } 
        if ("UP".equals(button.getActionCommand()) && grausDigitado < 85) {
            if (grausDigitado < 10) {
                String up = "U*";
                String x2 = "!00" + graus + up;
                System.out.println("up = " + x2);
                arduino.enviaDados(x2);
            } else {
                String up = "U*";
                String y2 = "!0" + graus + up;
                System.out.println(" do else up = " + y2);
                arduino.enviaDados(y2);
            }

        }  if ("DOWN".equals(button.getActionCommand()) && grausDigitado < 85) {
            if (grausDigitado < 10) {
                String down = "D*";
                String x3 = "!00" + graus + down;
                System.out.println("down = " + x3);
                arduino.enviaDados(x3);


            } else {
                String down = "D*";
                String x3 = "!0" + graus + down;
                System.out.println(" do else down = " + x3);
                arduino.enviaDados(x3);
            }
        }  if ("Camera ON".equals(button.getActionCommand())) {
            arduino.enviaDados("!111O*");
            System.out.println(button.getText());
        }
        if ("Camera OFF".equals(button.getActionCommand())) {
            arduino.enviaDados("!111F*");
            System.out.println(button.getText());
        }
        if ("Reset".equals(button.getActionCommand())) {
            arduino.enviaDados("!111S*");
            System.out.println(button.getText());
        } if ("Close".equals(button.getActionCommand())) {
            arduino.close();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!Fechou a comunicação serial!!!!!!!!!!!!!!!!!!!");
            System.out.println(button.getText());//Imprime o nome do botão pressionado
        }
    }
}