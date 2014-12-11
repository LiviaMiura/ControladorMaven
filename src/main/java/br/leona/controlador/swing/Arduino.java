/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.controlador.swing;

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
    private int AzGraus, ElGraus;
    private String left, right, down, up;

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

    /*
     *Calculo da Azimute
     */
    public int calculoAzimute(JButton button, String grausDigitado) {

        int graus = Integer.parseInt(grausDigitado);

        try {
            if ("Azimute".equals(button.getActionCommand())) {
                System.out.println("*****************AZIMUTE*******************");
                if (graus >= 0 && graus < 340) {

                    if (AzGraus < graus) {
                        int c = graus - AzGraus;
                        System.out.println("Calculo =" + graus + "-" + AzGraus + " = " + c);
                        right(c);
                    } else if (AzGraus > graus) {
                        int dif = AzGraus - graus;
                        System.out.println("Calculo =" + AzGraus + "-" + graus + " = " + dif);
                        left(dif);
                    } else if (graus == 0) {
                        int dif = AzGraus - AzGraus;
                        System.out.println("Calculo =" + AzGraus + "-" + AzGraus + " = " + dif);
                        left(dif);
                    }

                }
                AzGraus = graus;

            }
            System.out.println("Azimute graus digitado =" + AzGraus);
        } catch (Exception e) {
            System.out.println("*****Erro ao calcular azimute 0º a 340º*  e Elevação 0 a 60º*****");
        }
        return 1;
    }
    /*
     *Calculo Elevação
     */

    public int calculoElevacao(JButton button, String grausDigitado) {
        int graus = Integer.parseInt(grausDigitado);
        try {
            if ("Elevação".equals(button.getActionCommand())) {
                System.out.println("**************ELEVAÇÃO*********************");
                if (graus >= 0 && graus <= 85) {
                    if (ElGraus < graus) {
                   
                        int c = graus - ElGraus;
                        System.out.println("Calculo elevação =" + graus + "-" + ElGraus + " = " + c);
                        up(c);
                    } else if (ElGraus > graus) {
                          int dif = ElGraus - graus;
                        System.out.println("Calculo elevação =" + ElGraus + "-" + graus + " = " + dif);
                        down(dif);

                    } else if (graus == 0) {
                        int dif = ElGraus - ElGraus;
                        System.out.println("Calculo =" + ElGraus + "-" + ElGraus + " = " + dif);
                        down(dif);
                    }
                }

                ElGraus = graus;
            }
            System.out.println("Elevação digitado graus =" + ElGraus);
        } catch (Exception e) {
            System.out.println("*****Erro ao calcular azimute 0º a 340º*  e Elevação 0 a 60º*****");
        }
        return 1;
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

            } else if (grausDigitado >= 10 && grausDigitado < 100) {
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

        }
        if ("RIGHT".equals(button.getActionCommand())) {

            if (grausDigitado < 10) {
                String right = "R*";
                String x1 = "!00" + graus + right;
                System.out.println("RIGHT < 10 = " + x1);
                arduino.enviaDados(x1);

            } else if (grausDigitado >= 10 && grausDigitado < 100) {
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

        }
        if ("DOWN".equals(button.getActionCommand()) && grausDigitado < 85) {
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
        }
        if ("Camera ON".equals(button.getActionCommand())) {
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
        }
        if ("Close".equals(button.getActionCommand())) {
            arduino.close();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!Fechou a comunicação serial!!!!!!!!!!!!!!!!!!!");
            System.out.println(button.getText());//Imprime o nome do botão pressionado
        }
    }

    /*
     *Move para Esquerda
     */
    public int left(int graus) {
        if (graus < 340) { //limite de elevação 270º
            if (graus < 10) {
                left = "!00" + graus + "L*";
                System.out.println("LEFT = " + left);
                arduino.enviaDados(left);
            } else if (graus >= 10 && graus < 100) {
                left = "!0" + graus + "L*";
                System.out.println("LEFT = " + left);
                arduino.enviaDados(left);
            } else {
                left = "!" + graus + "L*";
                System.out.println("LEFT = " + left);
                arduino.enviaDados(left);
            }
        } else {
            System.out.println(" EXCEDE O LIMITE DE AZIMUTE left PERMITIDO");
        }
        return 1;
    }
    /*
     *Move para Direita
     */

    public int right(int graus) {
        if (graus <= 340) { //limite de elevação 270º
            if (graus < 10) {
                right = "!00" + graus + "R*";
                System.out.println("RIGHT = " + right);
                arduino.enviaDados(right);
            } else if (graus >= 10 && graus < 100) {
                String right2 = "!0" + graus + "R*";
                System.out.println("RIGHT = " + right2);
                arduino.enviaDados(right2);
            } else {
                String right3 = "!" + graus + "R*";
                System.out.println("RIGHT = " + right3);
                arduino.enviaDados(right3);
            }
        } else {
            System.out.println(" EXCEDE O LIMITE DE AZIMUTE right PERMITIDO");
        }
        return 1;
    }

    /*
     *Move para Cima
     */
    public int up(int graus) {
        if (graus < 85) { //limite de elevação 85º
            if (graus < 10) {
                up = "!00" + graus + "U*";
                System.out.println("UP = " + up);
                arduino.enviaDados(up);

            } else {
                String up2 = "!0" + graus + "U*";
                System.out.println("UP = " + up2);
                arduino.enviaDados(up2);
            }
        } else {
            System.out.println(" EXCEDE O LIMITE DE ELEVAÇÃO up PERMITIDO");
        }
        return 1;
    }

    /*
     *Move para Baixo
     */
    public int down(int graus) {
        if (graus < 85) { //limite de elevação 85º
            if (graus < 10) {
                String down = "!00" + graus + "D*";
                System.out.println("DOWN = " + down);
                arduino.enviaDados(down);
            } else {
                String x3 = "!0" + graus + "D*";
                System.out.println("DOWN = " + x3);
                arduino.enviaDados(x3);
            }
        } else {
            System.out.println(" EXCEDE O LIMITE DE ELEVAÇÃO down PERMITIDO");
        }
        return 1;

    }

    /*
     *Liga e desliga a camera
     */
    public int camera(int valor) {
        System.out.println("camera");
        if (valor == 1) {
            arduino.enviaDados("!111O*");//camera ON
        } else {
            arduino.enviaDados("!111F*"); //camera OFF
        }
        return 1;
    }

    /*
     *Liga e desliga a camera teste swing
     */
    public int cameraON() {
        System.out.println("camera on");

        arduino.enviaDados("!111O*");//camera ON

        return 1;
    }

    public int cameraOFF() {
        System.out.println("camera off");
        arduino.enviaDados("!111F*");//camera ON
        return 1;
    }

    /*
     *Reset o pantilt para 0º e camera (a definir a posição) para Posição Inicial
     */
    public int reset() {
        System.out.println("Reset");
        arduino.enviaDados("!111S*");
        return 1;
    }

    /*
     *Reset o pantilt azinmute 0º 
     */
    public int resetAzimute() {
        System.out.println("Reset Azimute");
        left = "!270L*";
        arduino.enviaDados(left);

        return 1;
    }
/*
     *Reset o pantilt elevação 0º 
     */
    public int resetElevacao() {
        System.out.println("reset elevação");
        down = "!085D*";
        System.out.println("Reset elevação para 0º = " + down);
        arduino.enviaDados(down);
        return 1;
    }
    
    /*
     *Reset o pantilt para 0º e camera 0º para Posição Inicial
     */
     public int resetPantilt() {
        down = "!085D*";
        arduino.enviaDados(down);
        left = "!270L*";
        arduino.enviaDados(left);
        return 1;
    }

    /*
     * Chamada do método que fecha a comunicação com a porta serial
     */
    public int close() {
        System.out.println("close");
        arduino.close();
        return 1;
    }

}
