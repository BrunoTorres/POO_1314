/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fitness;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author jmano
 */
public class RegistarUserForm extends javax.swing.JFrame {

	/**
	 * Creates new form RegistarUserForm
	 */
	public RegistarUserForm(LoginForm parent, FitnessUM fit) {
		initComponents();
		this.setLocationRelativeTo(parent);
		this.parent = parent;
		this.fit = fit;
		this.textNome.setForeground(Color.LIGHT_GRAY);
		this.textEmail.setForeground(Color.LIGHT_GRAY);
		this.textDespFav.setForeground(Color.LIGHT_GRAY);
		this.textPW.setForeground(Color.LIGHT_GRAY);
		this.textConfPW.setForeground(Color.LIGHT_GRAY);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        cboxSexo = new javax.swing.JComboBox();
        cboxDia = new javax.swing.JComboBox();
        labelDay = new javax.swing.JLabel();
        cboxMes = new javax.swing.JComboBox();
        labelMonth = new javax.swing.JLabel();
        cboxAno = new javax.swing.JComboBox();
        labelYear = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textDespFav = new javax.swing.JTextField();
        textPW = new javax.swing.JPasswordField();
        textConfPW = new javax.swing.JPasswordField();
        butCancel = new javax.swing.JButton();
        butOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textAltura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textPeso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTAR UTILIZADOR"));

        jLabel4.setText("Data de Nascimento");

        jLabel9.setText("Password");

        jLabel10.setText("Confirmação de Password");

        textNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textNome.setText("Nome");
        textNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textNomeFocusLost(evt);
            }
        });

        textEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textEmail.setText("Email");
        textEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textEmailFocusLost(evt);
            }
        });

        cboxSexo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F"}));

        cboxDia.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        cboxDia.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}));

        labelDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDay.setText("Dia");

        cboxMes.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        cboxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));

        labelMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonth.setText("Mês");

        cboxAno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        cboxAno.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014}));

        labelYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelYear.setText("Ano");

        jLabel1.setText("Sexo");

        textDespFav.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textDespFav.setText("Desporto Favorito");
        textDespFav.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textDespFavFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textDespFavFocusLost(evt);
            }
        });

        textPW.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textConfPW.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        butCancel.setText("Cancelar");
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });

        butOK.setText("OK");
        butOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOKActionPerformed(evt);
            }
        });

        jLabel2.setText("Altura");

        jLabel3.setText("Peso");

        textAltura.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("kg");

        jLabel6.setText("cms");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butOK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5))
                                .addComponent(textDespFav, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(cboxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(12, 12, 12)
                                                        .addComponent(jLabel2)
                                                        .addGap(57, 57, 57))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelYear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3))))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(textPW, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(textConfPW, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelYear)
                    .addComponent(labelMonth)
                    .addComponent(labelDay))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAltura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(textPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textDespFav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textConfPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butCancel)
                    .addComponent(butOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textNomeFocusLost
		if (this.textNome.getText().isEmpty()) {
			this.textNome.setForeground(Color.LIGHT_GRAY);
			this.textNome.setText("Nome");
		}
    }//GEN-LAST:event_textNomeFocusLost

    private void textNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textNomeFocusGained
		if (this.textNome.getText().equals("Nome")) {
			this.textNome.setText("");
			this.textNome.setForeground(Color.BLACK);
		}
    }//GEN-LAST:event_textNomeFocusGained

    private void textEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmailFocusGained
		if (this.textEmail.getText().equals("Email")) {
			this.textEmail.setText("");
			this.textEmail.setForeground(Color.BLACK);
		}
    }//GEN-LAST:event_textEmailFocusGained

    private void textEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmailFocusLost
		if (this.textEmail.getText().isEmpty()) {
			this.textEmail.setText("Email");
			this.textEmail.setForeground(Color.LIGHT_GRAY);
		}
    }//GEN-LAST:event_textEmailFocusLost

    private void textDespFavFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDespFavFocusGained
		if (this.textDespFav.getText().equals("Desporto Favorito")) {
			this.textDespFav.setText("");
			this.textDespFav.setForeground(Color.BLACK);
		}
    }//GEN-LAST:event_textDespFavFocusGained

    private void textDespFavFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDespFavFocusLost
		if (this.textDespFav.getText().isEmpty()) {
			this.textDespFav.setText("Desporto Favorito");
			this.textDespFav.setForeground(Color.LIGHT_GRAY);
		}
    }//GEN-LAST:event_textDespFavFocusLost

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
		this.parent.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_butCancelActionPerformed

    private void butOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOKActionPerformed
		boolean ok = true;
		String name = this.textNome.getText();
		String mail = this.textEmail.getText();
		String despFav = this.textDespFav.getText();
		String pw = String.copyValueOf(this.textPW.getPassword());
		String confpw = String.copyValueOf(this.textConfPW.getPassword());
		String sexo = (String) this.cboxSexo.getSelectedItem().toString();
		String peso = this.textPeso.getText();
		String altura = this.textAltura.getText();
		GregorianCalendar date = new GregorianCalendar(Integer.parseInt(cboxAno.getSelectedItem().toString()), cboxMes.getSelectedIndex(), Integer.parseInt(cboxDia.getSelectedItem().toString()));
		double pesoDouble = 0.0;
		int alturaInt = 0;
		
		if (name.isEmpty() || mail.isEmpty() || despFav.isEmpty() || peso.isEmpty() || altura.isEmpty() || pw.isEmpty()|| confpw.isEmpty()) {
			ok = false;
			JOptionPane.showMessageDialog(this, "Preencha todos os campos...");
		} else if (!pw.equals(confpw)) {
			ok = false;
			JOptionPane.showMessageDialog(this, "As passwords não coincidem...");
			this.textPW.setText("");
			this.textConfPW.setText("");
		} else if(date.after(new GregorianCalendar())){
			ok = false;
			JOptionPane.showMessageDialog(this, "Data de nascimento inválida...");
		} else{
			try{
				pesoDouble = Double.parseDouble(peso);
				alturaInt = Integer.parseInt(altura);
			}
			catch(NumberFormatException e){
				ok = false;
				JOptionPane.showMessageDialog(this, "Peso e/ou altura inválidos...");
			}
		}
		
		if(ok){
			User u = new User(mail, pw, name, sexo.charAt(0), date, alturaInt, pesoDouble, despFav);
			boolean success = parent.getFitness().addUserByUser(u);
			if(success){
				JOptionPane.showMessageDialog(this, "Utilizador registado com sucesso!");
				this.parent.setVisible(true);
				this.dispose();
			} else{
				JOptionPane.showMessageDialog(this, "Email já existente na aplicação...");
			}
			
		}
    }//GEN-LAST:event_butOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butOK;
    private javax.swing.JComboBox cboxAno;
    private javax.swing.JComboBox cboxDia;
    private javax.swing.JComboBox cboxMes;
    private javax.swing.JComboBox cboxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelMonth;
    private javax.swing.JLabel labelYear;
    private javax.swing.JTextField textAltura;
    private javax.swing.JPasswordField textConfPW;
    private javax.swing.JTextField textDespFav;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNome;
    private javax.swing.JPasswordField textPW;
    private javax.swing.JTextField textPeso;
    // End of variables declaration//GEN-END:variables

	private LoginForm parent;
	private FitnessUM fit;
}
