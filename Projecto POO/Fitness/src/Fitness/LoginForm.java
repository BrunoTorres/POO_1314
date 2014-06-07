
package Fitness;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.GregorianCalendar;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Classe para a criação de janelas
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class LoginForm extends javax.swing.JFrame {

	/**
	 * Creates new form MenuInicial
	 */
	public LoginForm() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.textEmail.grabFocus();
		fitness = new FitnessUM();
		try {
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream("data.obj"));
			fitness = new FitnessUM((FitnessUM) objInput.readObject());
		} catch (IOException ex) {
			User u1 = new User("anr@di.uminho.pt", "FCPorto", "António Nestor Ribeiro", 'M', new GregorianCalendar(1939, 7, 13), 178, 100, "Futebol");
			User u2 = new User("jas@di.uminho.pt", "jas", "João Alexandre Saraiva", 'M', new GregorianCalendar(1969, 4, 11), 180, 80, "Corrida");
			User u3 = new User("als@di.uminho.pt", "als", "António Luís Sousa", 'M', new GregorianCalendar(1980, 1, 9), 185, 90, "Pólo");
			User u4 = new User("jbb@di.uminho.pt", "jbb", "José Bernardo Barros", 'M', new GregorianCalendar(1964, 3, 10), 178, 65, "Orientação");
			User u5 = new User("jsp@di.uminho.pt", "jsp", "Jorge Sousa Pinto", 'M', new GregorianCalendar(1974, 4, 7), 175, 75, "Badminton");
			User u6 = new User("mjf@di.uminho.pt", "mjf", "Maria João Frade", 'F', new GregorianCalendar(1978, 0, 5), 167, 55, "Yoga");
			User u7 = new User("fmm@di.uminho.pt", "fmm", "Fernando Mário Martins", 'M', new GregorianCalendar(1906, 5, 6), 166, 66.6, "Snowboard");
			User u8 = new User("a69854@alunos.uminho.pt", "123", "João Mano", 'M', new GregorianCalendar(1991, 10, 15), 170, 68, "Futebol");
			User u9 = new User("a69303@alunos.uminho.pt", "123", "Bruno Torres", 'M', new GregorianCalendar(1988, 7, 28), 181, 78, "Futebol");
			User u10 = new User("a66822@alunos.uminho.pt", "123", "Miguel Guimarães", 'M', new GregorianCalendar(1991, 6, 23), 168, 55, "Aeróbica");
			Admin a1 = new Admin("admin", "admin", "admin", 'M', new GregorianCalendar(1991, 10, 15));
			u1.addActivity(new Running("Corrida", new GregorianCalendar(), 120, 8, "Chuva"), "Running");
			u1.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 200, 20, 0.001, "Sol"), "MountainBiking");
			u1.addActivity(new Football("Futebolada", new GregorianCalendar(), 90, 0, 7, "Sol"), "Football");
			u2.addActivity(new Running("Corrida1", new GregorianCalendar(), 90, 20, "Sol"), "Running");
			u2.addActivity(new Running("Corrida2", new GregorianCalendar(), 60, 9, "Sol"), "Running");
			u2.addActivity(new Running("Corrida3", new GregorianCalendar(), 78, 15, "Sol"), "Running");
			u2.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 240, 60, 0.180, "Sol"), "MountainBiking");
			u3.addActivity(new Polo("Polo", new GregorianCalendar(), 60, 10, 5, "Sol"), "Polo");
			u3.addActivity(new Running("Corrida1", new GregorianCalendar(), 45,	5, "Sol"), "Running");
			u3.addActivity(new Running("Corrida2", new GregorianCalendar(), 52, 4.9, "Chuva"), "Running");
			u3.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 200, 30, 0.040, "Sol"), "MountainBiking");
			u4.addActivity(new Running("Corrida1", new GregorianCalendar(), 60, 15, "Sol"), "Running");
			u4.addActivity(new Running("Corrida2", new GregorianCalendar(), 126, 43, "Chuva"), "Running");
			u4.addActivity(new Running("Corrida3", new GregorianCalendar(), 63, 25, "Sol"), "Running");
			u4.addActivity(new Running("Corrida4", new GregorianCalendar(), 55, 14, "Sol"), "Running");
			u4.addActivity(new Running("Corrida5", new GregorianCalendar(), 61, 23, "Chuva"), "Running");
			u4.addActivity(new Running("Corrida6", new GregorianCalendar(), 65, 23, "Sol"), "Running");
			u4.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 400, 80, 1.2, "Sol"), "MountainBiking");
			u4.addActivity(new Orienteering("Orienta", new GregorianCalendar(), 60, 20, "Sol"), "Orienteering");
			u5.addActivity(new Running("Corrida1", new GregorianCalendar(), 90, 17, "Sol"), "Running");
			u5.addActivity(new Running("Corrida2", new GregorianCalendar(), 60, 10, "Chuva"), "Running");
			u5.addActivity(new Running("Corrida3", new GregorianCalendar(), 61, 9, "Sol"), "Running");
			u5.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 200, 20, 0.070, "Sol"), "MountainBiking");
			u5.addActivity(new Badminton("Badminton", new GregorianCalendar(), 90, 10, 20), "Orienteering");
			u6.addActivity(new Running("Corrida1", new GregorianCalendar(), 60, 7, "Sol"), "Running");
			u6.addActivity(new Running("Corrida2", new GregorianCalendar(), 75, 8, "Chuva"), "Running");
			u6.addActivity(new Running("Corrida3", new GregorianCalendar(), 80, 9, "Sol"), "Running");
			u6.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 200, 19, 0.040, "Sol"), "MountainBiking");
			u6.addActivity(new Yoga("Yoga", new GregorianCalendar(), 50), "Yoga");
			u7.addActivity(new Running("Corrida", new GregorianCalendar(), 150, 8, "Chuva"), "Running");
			u7.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 400, 14, 0.003, "Sol"), "MountainBiking");
			u8.addActivity(new Running("Corrida1", new GregorianCalendar(), 60, 10, "Sol"), "Running");
			u8.addActivity(new Running("Corrida2", new GregorianCalendar(), 90, 12, "Chuva"), "Running");
			u8.addActivity(new Running("Corrida3", new GregorianCalendar(), 120, 17, "Sol"), "Running");
			u8.addActivity(new Running("Corrida4", new GregorianCalendar(), 59, 10, "Sol"), "Running");
			u8.addActivity(new Running("Corrida5", new GregorianCalendar(), 60, 11, "Chuva"), "Running");
			u8.addActivity(new Running("Corrida6", new GregorianCalendar(), 55, 9, "Sol"), "Running");
			u8.addActivity(new Running("Corrida6", new GregorianCalendar(), 61, 10, "Sol"), "Running");
			u8.addActivity(new Football("Futebolada", new GregorianCalendar(), 90, 7, 0, "Sol"), "Football");
			u8.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 400, 60, 1.2, "Sol"), "MountainBiking");
			u9.addActivity(new Running("Corrida1", new GregorianCalendar(), 60, 10, "Sol"), "Running");
			u9.addActivity(new Running("Corrida2", new GregorianCalendar(), 90, 12, "Chuva"), "Running");
			u9.addActivity(new Running("Corrida3", new GregorianCalendar(), 120, 17, "Sol"), "Running");
			u9.addActivity(new Running("Corrida4", new GregorianCalendar(), 59, 10, "Sol"), "Running");
			u9.addActivity(new Running("Corrida5", new GregorianCalendar(), 60, 11, "Chuva"), "Running");
			u9.addActivity(new Running("Corrida6", new GregorianCalendar(), 55, 9, "Sol"), "Running");
			u9.addActivity(new Running("Corrida6", new GregorianCalendar(), 61, 10, "Sol"), "Running");
			u9.addActivity(new Football("Futebolada", new GregorianCalendar(), 90, 7, 0, "Sol"), "Football");
			u9.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 400, 60, 1.2, "Sol"), "MountainBiking");
			u10.addActivity(new Running("Corrida", new GregorianCalendar(), 300, 13, "Chuva"), "Running");
			u10.addActivity(new MountainBiking("BTT", new GregorianCalendar(), 400, 14, 0.003, "Sol"), "MountainBiking");
			fitness.addUserByUser(u1);
			fitness.addUserByUser(u2);
			fitness.addUserByUser(u3);
			fitness.addUserByUser(u4);
			fitness.addUserByUser(u5);
			fitness.addUserByUser(u6);
			fitness.addUserByUser(u7);
			fitness.addUserByUser(u8);
			fitness.addUserByUser(u9);
			fitness.addUserByUser(u10);
			fitness.addAdmin(a1.getEmail(), a1.getPassword(), a1.getName(), a1.getGender(), a1.getDate());
			fitness.sendFriendRequest(fitness.getUserByEmail("fmm@di.uminho.pt"), fitness.getUserByEmail("anr@di.uminho.pt"));
			fitness.sendFriendRequest(fitness.getUserByEmail("jbb@di.uminho.pt"), fitness.getUserByEmail("jsp@di.uminho.pt"));
			fitness.sendFriendRequest(fitness.getUserByEmail("jbb@di.uminho.pt"), fitness.getUserByEmail("mjf@di.uminho.pt"));
			fitness.setFitnessPerson(a1);
			Marathon m = new Marathon("MaratonaUM", "UMinho - Braga", 10, new GregorianCalendar(), new GregorianCalendar(2014, 5, 5));
			m.addUser(u1);
			m.addUser(u2);
			m.addUser(u3);
			m.addUser(u4);
			m.addUser(u5);
			m.addUser(u6);
			m.addUser(u7);
			m.addUser(u8);
			m.addUser(u9);
			m.addUser(u10);
			fitness.addEvent(m);
			
			Halfmarathon t = new Halfmarathon("MeiaUM", "UMinho - Braga", 10, new GregorianCalendar(), new GregorianCalendar(2014, 5, 5));
			t.addUser(u1);
			t.addUser(u2);
			t.addUser(u3);
			t.addUser(u4);
			t.addUser(u5);
			t.addUser(u6);
			t.addUser(u7);
			t.addUser(u8);
			t.addUser(u9);
			t.addUser(u10);
			fitness.addEvent(t);
			
			MarathonBTT mBTT = new MarathonBTT("Maratona de BTT - UM", "UMinho - Braga", 10, new GregorianCalendar(), new GregorianCalendar(2014, 5, 5), 40);
			mBTT.addUser(u1);
			mBTT.addUser(u2);
			mBTT.addUser(u3);
			mBTT.addUser(u4);
			mBTT.addUser(u5);
			mBTT.addUser(u6);
			mBTT.addUser(u7);
			mBTT.addUser(u8);
			mBTT.addUser(u9);
			mBTT.addUser(u10);
			fitness.addEvent(mBTT);
		} catch (ClassCastException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        butOK = new javax.swing.JButton();
        butLimpar = new javax.swing.JButton();
        textPw = new javax.swing.JPasswordField();
        labelRegistar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FitnessUM");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "LOGIN"));

        jLabel2.setText("Email");

        jLabel3.setText("Password");

        textEmail.setMaximumSize(new java.awt.Dimension(156, 25));
        textEmail.setMinimumSize(new java.awt.Dimension(156, 25));
        textEmail.setNextFocusableComponent(textPw);
        textEmail.setPreferredSize(new java.awt.Dimension(156, 25));

        butOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fitness/group.png"))); // NOI18N
        butOK.setText("Entrar");
        butOK.setToolTipText("Entrar na aplicação");
        butOK.setIconTextGap(10);
        butOK.setMargin(new java.awt.Insets(2, 9, 2, 9));
        butOK.setNextFocusableComponent(butLimpar);
        butOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOKActionPerformed(evt);
            }
        });

        butLimpar.setText("Limpar");
        butLimpar.setToolTipText("Limpar campos");
        butLimpar.setIconTextGap(10);
        butLimpar.setMargin(new java.awt.Insets(2, 9, 2, 9));
        butLimpar.setNextFocusableComponent(textEmail);
        butLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLimparActionPerformed(evt);
            }
        });

        textPw.setMaximumSize(new java.awt.Dimension(156, 25));
        textPw.setMinimumSize(new java.awt.Dimension(156, 25));
        textPw.setNextFocusableComponent(butOK);
        textPw.setPreferredSize(new java.awt.Dimension(156, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butOK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(textPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        labelRegistar.setText("Registar");
        labelRegistar.setToolTipText("Criar nova conta na aplicação");
        labelRegistar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRegistar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegistarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelRegistar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRegistar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLimparActionPerformed
		this.textEmail.setText("");
		this.textPw.setText("");
    }//GEN-LAST:event_butLimparActionPerformed

    private void labelRegistarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistarMouseClicked
		RegistarUserForm reg = new RegistarUserForm(this, this.fitness);
		reg.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_labelRegistarMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
		Font font = this.labelRegistar.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		this.labelRegistar.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_formWindowGainedFocus

    private void butOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOKActionPerformed
		String email = this.textEmail.getText();
		String pw = String.copyValueOf(this.textPw.getPassword());
		if (fitness.existPassAndUser(email, pw)) {
			//Person p = fitness.getPersonByEmail(email);
			if (!fitness.isAdmin(email)) {
				fitness.setFitnessPerson(fitness.getUserByEmail(email));
				UserForm userForm = new UserForm(this, this.fitness, fitness.getUserByEmail(email));
				userForm.setVisible(true);
				this.dispose();
			} else {
				fitness.setFitnessPerson(fitness.getAdminByEmail(email));
				AdminForm adminForm = new AdminForm(this, this.fitness, fitness.getAdminByEmail(email));
				adminForm.setVisible(true);
				this.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Login incorreto...", "Login", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_butOKActionPerformed

	/**
	 *
	 * @return
	 */
	public FitnessUM getFitness() {
		return this.fitness;
	}

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
			java.util.logging.Logger.getLogger(LoginForm.class
					.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class
					.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class
					.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class
					.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginForm().setVisible(true);
			}
		});
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butLimpar;
    private javax.swing.JButton butOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelRegistar;
    private javax.swing.JTextField textEmail;
    private javax.swing.JPasswordField textPw;
    // End of variables declaration//GEN-END:variables
	private FitnessUM fitness;
}
