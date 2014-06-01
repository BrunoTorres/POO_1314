/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fitness;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author jmano
 */
public class UserForm extends javax.swing.JFrame {

	/**
	 * Creates new form UserForm
	 *
	 * @param parent
	 * @param fit
	 */
	public UserForm(JFrame parent, FitnessUM fit) {
		initComponents();
		this.setLocationRelativeTo(parent);
		this.u = (User) fit.getActivePerson();
		this.fit = fit;
		this.setTitle(u.getName() + " - Utilizador");
		//this.jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(fit.getActivePerson().getName()));
		//this.jTabbedPane1.addT
		this.currAct = 1;
		this.changeShown10Activity();
		this.allActsCurr = 1;
		this.changeShownActivity();
	}

	public void changeShown10Activity() {
		User u = (User) fit.getActivePerson();
		this.acts = this.fit.getLast10ActivitiesByActivity(u).toArray();
		if (this.acts.length > 0) {
			this.textNAct.setText(this.currAct + "/" + this.acts.length);
			this.text10Act.setText((this.acts[this.currAct - 1]).toString());
		}
	}

	public void changeShownActivity() {
		User u = (User) fit.getActivePerson();
		this.allActs = u.getUserActivitiesAdmin().toArray();
		if (this.allActs.length > 0) {
			this.textNActCons.setText(this.allActsCurr + "/" + this.allActs.length);
			this.textConsultaAct.setText((this.allActs[this.allActsCurr - 1]).toString());
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelMensagens = new javax.swing.JPanel();
        panelVer10Stats = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text10Act = new javax.swing.JTextArea();
        butFirst = new javax.swing.JButton();
        butPrev = new javax.swing.JButton();
        butNext = new javax.swing.JButton();
        butLast = new javax.swing.JButton();
        textNAct = new javax.swing.JTextField();
        butVerAmigos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textConsultaAct = new javax.swing.JTextArea();
        butFirstCons = new javax.swing.JButton();
        butPrevCons = new javax.swing.JButton();
        textNActCons = new javax.swing.JTextField();
        butNextCons = new javax.swing.JButton();
        butLastCons = new javax.swing.JButton();
        butAddActivity = new javax.swing.JButton();
        butVerPedidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frameInicial"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelMensagensLayout = new javax.swing.GroupLayout(panelMensagens);
        panelMensagens.setLayout(panelMensagensLayout);
        panelMensagensLayout.setHorizontalGroup(
            panelMensagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        panelMensagensLayout.setVerticalGroup(
            panelMensagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Home", panelMensagens);

        panelVer10Stats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelVer10StatsFocusGained(evt);
            }
        });

        text10Act.setColumns(20);
        text10Act.setRows(5);
        jScrollPane1.setViewportView(text10Act);

        butFirst.setText("<<");
        butFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFirstActionPerformed(evt);
            }
        });

        butPrev.setText("<");
        butPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPrevActionPerformed(evt);
            }
        });

        butNext.setText(">");
        butNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNextActionPerformed(evt);
            }
        });

        butLast.setText(">>");
        butLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLastActionPerformed(evt);
            }
        });

        textNAct.setEditable(false);

        butVerAmigos.setText("Ver actividades de um amigo");
        butVerAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butVerAmigosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVer10StatsLayout = new javax.swing.GroupLayout(panelVer10Stats);
        panelVer10Stats.setLayout(panelVer10StatsLayout);
        panelVer10StatsLayout.setHorizontalGroup(
            panelVer10StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVer10StatsLayout.createSequentialGroup()
                .addGroup(panelVer10StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVer10StatsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(panelVer10StatsLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(butFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNAct, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butLast)
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelVer10StatsLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(butVerAmigos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVer10StatsLayout.setVerticalGroup(
            panelVer10StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVer10StatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVer10StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butFirst)
                    .addComponent(butPrev)
                    .addComponent(butNext)
                    .addComponent(butLast)
                    .addComponent(textNAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(butVerAmigos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ver 10 últimas atividades", panelVer10Stats);

        textConsultaAct.setColumns(20);
        textConsultaAct.setRows(5);
        jScrollPane2.setViewportView(textConsultaAct);

        butFirstCons.setText("<<");
        butFirstCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFirstConsActionPerformed(evt);
            }
        });

        butPrevCons.setText("<");
        butPrevCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPrevConsActionPerformed(evt);
            }
        });

        textNActCons.setEditable(false);

        butNextCons.setText(">");
        butNextCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNextConsActionPerformed(evt);
            }
        });

        butLastCons.setText(">>");
        butLastCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLastConsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(butFirstCons)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butPrevCons)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNActCons, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butNextCons)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butLastCons)
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butFirstCons)
                    .addComponent(butPrevCons)
                    .addComponent(butNextCons)
                    .addComponent(butLastCons)
                    .addComponent(textNActCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar/Remover atividades", jPanel1);

        butAddActivity.setText("+ ATIVIDADE");
        butAddActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActivityActionPerformed(evt);
            }
        });

        butVerPedidos.setText("Ver pedidos de amizade");
        butVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butVerPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(butAddActivity)
                .addGap(18, 18, 18)
                .addComponent(butVerPedidos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAddActivity)
                    .addComponent(butVerPedidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextActionPerformed
		if (this.currAct < this.acts.length) {
			this.currAct++;
			this.changeShown10Activity();
		}
    }//GEN-LAST:event_butNextActionPerformed

    private void butPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPrevActionPerformed
		if (this.currAct > 1) {
			this.currAct--;
			this.changeShown10Activity();
		}
    }//GEN-LAST:event_butPrevActionPerformed

    private void butFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFirstActionPerformed
		this.currAct = 1;
		this.changeShown10Activity();
    }//GEN-LAST:event_butFirstActionPerformed

    private void butLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLastActionPerformed
		this.currAct = this.acts.length;
		this.changeShown10Activity();
    }//GEN-LAST:event_butLastActionPerformed

    private void butVerAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVerAmigosActionPerformed
		JList listAmigos = new JList();
		Object[] amigos = ((User) this.fit.getActivePerson()).getFriendsList().toArray();
		//ArrayList<String> nomesAmigos = new ArrayList<>();
		Object[] nomesAmigos = new Object[amigos.length];
		int i = 0;
		if (amigos.length > 0) {
			for (Object o : amigos) {
				nomesAmigos[i] = ((Object) fit.getUserByEmail((String) o).getName());
				i++;
			}
			listAmigos = new JList(nomesAmigos);
			listAmigos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listAmigos.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			int res = JOptionPane.showConfirmDialog(this, listAmigos, "Seleccione um amigo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (res == JOptionPane.OK_OPTION) {
				User u = this.fit.getUserByEmail((String) amigos[listAmigos.getSelectedIndex()]);
				this.text10Act.setText("ACTIVIDADES DE " + listAmigos.getSelectedValue() + "\n\n");
			}
		}

    }//GEN-LAST:event_butVerAmigosActionPerformed

    private void butVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVerPedidosActionPerformed
		FriendRequestListForm pedidos = new FriendRequestListForm(this, fit);
		pedidos.setVisible(true);
    }//GEN-LAST:event_butVerPedidosActionPerformed

    private void butAddActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActivityActionPerformed
		AddViewActivityForm addActi = new AddViewActivityForm(this, this.fit, this.fit.getUserByEmail(this.fit.getActivePerson().getEmail()));
		addActi.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_butAddActivityActionPerformed

    private void panelVer10StatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelVer10StatsFocusGained

    }//GEN-LAST:event_panelVer10StatsFocusGained

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void butFirstConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFirstConsActionPerformed
		this.allActsCurr = 1;
		this.changeShownActivity();
    }//GEN-LAST:event_butFirstConsActionPerformed

    private void butPrevConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPrevConsActionPerformed
		if (this.allActsCurr > 1) {
			this.allActsCurr--;
			this.changeShownActivity();
		}
    }//GEN-LAST:event_butPrevConsActionPerformed

    private void butNextConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextConsActionPerformed
		
		AddViewActivityForm view = new AddViewActivityForm(this, this.fit, this.u, (Activity) this.allActs[allActsCurr]);
		view.setVisible(true);
		if (this.allActsCurr < this.allActs.length) {
			this.allActsCurr++;
			this.changeShownActivity();
		}
    }//GEN-LAST:event_butNextConsActionPerformed

    private void butLastConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLastConsActionPerformed
		this.allActsCurr = allActs.length;
		this.changeShownActivity();
    }//GEN-LAST:event_butLastConsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		//FileOutputStream out = null;
		try {
			FileOutputStream out = new FileOutputStream("data.obj");
			ObjectOutputStream oout = new ObjectOutputStream(out);
			oout.writeObject(this.fit);
			oout.flush();
			oout.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage() + " | " + ex.getLocalizedMessage());
		}
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAddActivity;
    private javax.swing.JButton butFirst;
    private javax.swing.JButton butFirstCons;
    private javax.swing.JButton butLast;
    private javax.swing.JButton butLastCons;
    private javax.swing.JButton butNext;
    private javax.swing.JButton butNextCons;
    private javax.swing.JButton butPrev;
    private javax.swing.JButton butPrevCons;
    private javax.swing.JButton butVerAmigos;
    private javax.swing.JButton butVerPedidos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelMensagens;
    private javax.swing.JPanel panelVer10Stats;
    private javax.swing.JTextArea text10Act;
    private javax.swing.JTextArea textConsultaAct;
    private javax.swing.JTextField textNAct;
    private javax.swing.JTextField textNActCons;
    // End of variables declaration//GEN-END:variables
	private FitnessUM fit;
	private User u;
	private int currAct = 0;
	private int allActsCurr = 0;
	private Object[] acts, allActs;
}
