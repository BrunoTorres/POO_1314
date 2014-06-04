/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fitness;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author jmano
 */
public class FriendRequestListForm extends javax.swing.JFrame {

	/**
	 * Creates new form PedidosAmizade
     * @param parent
     * @param fit
	 */
	public FriendRequestListForm(UserForm parent, FitnessUM fit) {
		initComponents();
		this.setLocationRelativeTo(parent);
		this.fit = fit;
		this.parent = parent;
		parent.setEnabled(false);
		this.preenchePedidos();
		
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPedidosAmizade = new javax.swing.JList();
        butAddAmigo = new javax.swing.JButton();
        butRejeitaAmigo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("framePedidosAmizade"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pedidos de Amizade"));

        listPedidosAmizade.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listPedidosAmizade);

        butAddAmigo.setText("OK");
        butAddAmigo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        butAddAmigo.setMaximumSize(new java.awt.Dimension(40, 29));
        butAddAmigo.setMinimumSize(new java.awt.Dimension(40, 29));
        butAddAmigo.setPreferredSize(new java.awt.Dimension(40, 29));
        butAddAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddAmigoActionPerformed(evt);
            }
        });

        butRejeitaAmigo.setText("CAN");
        butRejeitaAmigo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        butRejeitaAmigo.setMaximumSize(new java.awt.Dimension(40, 25));
        butRejeitaAmigo.setMinimumSize(new java.awt.Dimension(40, 25));
        butRejeitaAmigo.setPreferredSize(new java.awt.Dimension(40, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(butRejeitaAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(butAddAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butRejeitaAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butAddAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butAddAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddAmigoActionPerformed
		if (!this.listPedidosAmizade.isSelectionEmpty()) {
			String mailUser = ((User) this.fit.getActivePerson()).getEmail();
			String[] info = this.listPedidosAmizade.getSelectedValue().toString().split(":");
			String mail = info[1].trim();
			this.fit.acceptFriend(this.fit.getUserByEmail(mailUser), mail);
			this.removePedido(mailUser, mail);
			this.parent.preencheTabAmigos();
		}
    }//GEN-LAST:event_butAddAmigoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		this.parent.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

	private void preenchePedidos() {
		User u = this.fit.getUserByEmail(this.fit.getActivePerson().getEmail());
		ArrayList<String> msgsUser = new ArrayList<>(u.getMessage());
		ArrayList<String> msgs = new ArrayList<>();
		for (String s : msgsUser) {
			msgs.add(s);
		}
		if (msgs.size() > 0) {
			int i;
			for (i = 0; i < msgs.size(); i++) {
				String mail = msgs.get(i);
				msgs.set(i, this.fit.getUserByEmail(mail).getName() + " : " + mail);
			}
			this.listPedidosAmizade.setListData(msgs.toArray());
		} else {
			this.listPedidosAmizade.setListData(msgs.toArray());
		}
	}

	private void removePedido(String userMail, String email) {
		User u = this.fit.getUserByEmail(userMail);
		u.removeFriendFromMessage(email);
		this.preenchePedidos();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAddAmigo;
    private javax.swing.JButton butRejeitaAmigo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listPedidosAmizade;
    // End of variables declaration//GEN-END:variables
	FitnessUM fit;
	UserForm parent;
}
