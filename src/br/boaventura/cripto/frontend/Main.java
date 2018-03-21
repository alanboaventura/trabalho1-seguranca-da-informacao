package br.boaventura.cripto.frontend;

import br.boaventura.cripto.backend.CifraDeBoaventura;
import java.text.Normalizer;
import javax.swing.JOptionPane;

/**
 * @author Alan Boaventura
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEncrypt = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        inputText = new javax.swing.JTextField();
        lblText = new javax.swing.JLabel();
        lblKey = new javax.swing.JLabel();
        inputKey = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);

        btnEncrypt.setText("Criptografar");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        btnDecrypt.setText("Descriptografar");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });

        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("Texto");

        lblKey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKey.setText("Chave");

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Cifra de Boaventura");

        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/boaventura/cripto/icons/info.png"))); // NOI18N
        lblInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInfoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputKey)
                            .addComponent(lblKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEncrypt)
                    .addComponent(btnDecrypt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInfoMouseClicked
        JOptionPane.showMessageDialog(null, "IMPORTANTE:\nAcentos em letras serão desconsiderados.\n\nCriado por: Alan Boaventura\n\nBlumenau, 17 de Março de 2018", null, 1);
    }//GEN-LAST:event_lblInfoMouseClicked

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        if (isFormValid()) {
            String text = inputText.getText();

            // Remove os acentos.
            text = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            int key = Integer.parseInt(inputKey.getText());

            String encryptedText = CifraDeBoaventura.encrypt(text, key);

            JOptionPane.showMessageDialog(null, "Texto criptografado:\n\n" + encryptedText, "Resultado", 1);
        }
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        if (isFormValid()) {
            String text = inputText.getText();

            text = text.replaceAll("\\d", ""); // Remove todos digitos (0-9).
            text = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); // Remove os acentos.
            int key = Integer.parseInt(inputKey.getText());

            String decryptedText = CifraDeBoaventura.decrypt(text, key);

            JOptionPane.showMessageDialog(null, "Texto descriptografado:\n\n" + decryptedText, "Resultado", 1);
        }
    }//GEN-LAST:event_btnDecryptActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    /**
     * Valida as informações inseridas no "formulário", onde caso estejam
     * validas será retornado <code>TRUE</code>, ou <code>FALSE</code> caso
     * contrário.
     *
     * @return <code>TRUE</code> caso as informações inseridas são validas, ou
     * <code>FALSE</code> caso contrário.
     */
    private boolean isFormValid() {
        boolean isValid = true;

        // Valida o campo "Texto".
        String text = inputText.getText();
        if (text == null || text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Texto inválido!", "ERRO", 0);
            isValid = false;
        }

        // Valida o campo "Chave".
        try {
            final int key = Integer.parseInt(inputKey.getText());
            if (key < 1 || key > 25) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Chave inválida!\nFavor informar um número de 1 à 25.", "ERRO", 0);
            isValid = false;
        }

        return isValid;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JTextField inputKey;
    private javax.swing.JTextField inputText;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblKey;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSeparator separator;
    // End of variables declaration//GEN-END:variables
}
