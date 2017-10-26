/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.gui;

import dkeep.logic.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

/**
 *
 * @author GonçaloSilva
 */
public class Interface extends javax.swing.JFrame {

    public int[][] dragonPos;
    public State s1;

    /**
     * Creates new form Interface
     */
    public Interface() {
    	dragonPos=new int[6][2];
		dragonPos[0][0]=4;
		dragonPos[0][1]=1;
		dragonPos[1][0]=8;
		dragonPos[1][1]=8;
		dragonPos[2][0]=1;
		dragonPos[2][1]=7;
		dragonPos[3][0]=8;
		dragonPos[3][1]=1;
		dragonPos[4][0]=8;
		dragonPos[4][1]=4;
		dragonPos[5][0]=5;
		dragonPos[5][1]=6;

        initComponents();
        setLocationRelativeTo(null); //coloca no centro do ecra
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        btnLeft = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnExit = new javax.swing.JButton();
        checkBox = new javax.swing.JCheckBox();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Number of Dragons");

        txtNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumber.setText("1");
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        btnLeft.setText("LEFT");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnNewGame.setText("NEW GAME");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnUp.setText("UP");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnRight.setText("RIGHT");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        btnDown.setText("DOWN");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("Can start a New Game");

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        
        checkBox = new JCheckBox("New check box");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
        					.addGap(0, 225, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(18)
        					.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(366, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnLeft)
        							.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
        							.addComponent(btnRight)
        							.addContainerGap())
        						.addGroup(layout.createSequentialGroup()
        							.addGap(0, 65, Short.MAX_VALUE)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(btnUp)
        									.addGap(85))
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        										.addComponent(btnExit)
        										.addComponent(btnDown))
        									.addGap(73))))))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(checkBox)
        					.addPreferredGap(ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
        					.addComponent(btnNewGame)
        					.addGap(49))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(9)
        					.addComponent(checkBox)
        					.addGap(5)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addGap(80)
        					.addComponent(btnUp)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnLeft)
        						.addComponent(btnRight))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnDown)
        					.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
        					.addComponent(btnExit)
        					.addGap(61))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(68)
        			.addComponent(btnNewGame)
        			.addContainerGap(309, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        s1 = new State();
        int numDragons = Integer.parseInt(txtNumber.getText());
        if (numDragons > 6 || numDragons < 1) {
            JOptionPane.showMessageDialog(null, "Numero de Drag�es entre 1 e 6");
            return;
        }  
        s1.new_game(numDragons, dragonPos);
        if(checkBox.isSelected()) {
        	s1.getM1().setTipoMov(true);
        }
        else {
        	s1.getM1().setTipoMov(false);
        }
       imprimir(s1.getE1(), s1.getListD(), s1.getH1(), s1.getS1(),s1.getM1().getMap());


    }//GEN-LAST:event_btnNewGameActionPerformed
    private void gameLogic(String move) {
        if (s1.isState()) {
            if (s1.movHero(move)) {
                if (s1.isState()) {
                    s1.movDragon();
                }
               imprimir(s1.getE1(), s1.getListD(), s1.getH1(), s1.getS1(),s1.getM1().getMap());
            }
            if (s1.getM1().getFinish() || !s1.getH1().isLife()) {
                return;
            }
        }
    }

    private void imprimir(Exiit e1, ArrayList<Dragon> dl1, Hero h1, Sword s1,char [][] map) {
        Dragon d1;
	String c = ""; // o que escrever
        String aux = "";
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < dl1.size(); j++) {
                    d1 = dl1.get(j);
                    if (i == h1.getX() && k == h1.getY()) { // representar heroi
                    c = h1.getSimbolo() + "|";
                    } else if (i == s1.getX() && k == s1.getY()) { // representar SWORD
                        if (!h1.isHeroHas()) {
                            if (s1.getX() == d1.getX() && s1.getY() == d1.getY()) {
                                j = dl1.size();
                             c = "F|";
                            } else {
                              c = "S|";
                            }
                        } else {
                          c = map[i][k] + "|";
                            
                        }
                    } else if (i == d1.getX() && k == d1.getY()) { // representar DRAGON
                        if (s1.getX() == d1.getX() && s1.getY() == d1.getY()) {
                            if (h1.isHeroHas()) {
                                j = dl1.size();
                                c = "D|";
                            }
                            // j� escreveu na compara��o da SWORD (em cima)
                        } else {
                            if (d1.getLife()) {
                                j = dl1.size(); // para sair do ciclo, j� n�o precisa de verificar os proximos dragoes
                               c = "D|";
                            } else {
                                c = map[i][k] + "|";
                            }
                        }
                    } else if (i == e1.getX() && k == e1.getY()) { // representar EXIT
                       c = "E|";
                    } else { // representar "X" ou " " (mapa)
                       c = map[i][k] + "|";
                    //   if(map[i][k]==' ') c = c + " ";
                    }
                }
                aux = aux + c;
                //txtArea.add(c, this);

            }
         aux = aux + "\n";
           
        } 
        txtArea.setText(aux);
    }
    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        gameLogic("w");
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        gameLogic("d");
    }//GEN-LAST:event_btnRightActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        gameLogic("s");
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        gameLogic("a");
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtNumber;
    private JCheckBox checkBox;
}
