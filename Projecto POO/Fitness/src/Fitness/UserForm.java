/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fitness;

import java.awt.event.ItemEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

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
	 * @param u
	 */
	public UserForm(JFrame parent, FitnessUM fit, User u) {
		initComponents();
		this.setLocationRelativeTo(parent);
		this.u = u;
		this.fit = fit;
		this.setName("user");
		this.setTitle(u.getName() + " - Utilizador");
		this.currAct = 1;
		this.acts10 = new ArrayList<>(fit.getLast10ActivitiesByActivity(u));
		this.allActsCurr = 1;
		this.allActs = new ArrayList<>(u.getActivities());
		this.changeActivities("init");
		this.preencheRunRecords();
		this.preencheTabAmigos();
	}

	/**
	 *
	 * @param op
	 */
	public final void changeActivities(String op) {
		if (op.equals("remove")) {
			if (this.currAct == this.acts10.size()) {
				this.currAct--;
			}
			if (this.allActsCurr == this.allActs.size()) {
				this.allActsCurr--;
			}
			this.acts10 = new ArrayList<>(fit.getLast10ActivitiesByActivity(u));
			this.allActs = new ArrayList<>(u.getActivities());
		} else if (op.equals("add")) {
			this.currAct = 1;
			this.allActsCurr = 1;
			this.acts10 = new ArrayList<>(fit.getLast10ActivitiesByActivity(u));
			this.allActs = new ArrayList<>(u.getActivities());
		}
		Activity act;
		if (this.allActs.size() > 0) {
			this.butRemove.setEnabled(true);
			if (this.but10.isSelected()) {
				act = this.acts10.get(this.currAct - 1);
				this.textNAct.setText(this.currAct + "/" + this.acts10.size());
			} else {
				act = this.allActs.get(this.allActsCurr - 1);
				this.textNAct.setText(this.allActsCurr + "/" + this.allActs.size());
			}
			GregorianCalendar date = act.getDate();
			this.textName.setText(act.getName());
			this.cboxDia.setSelectedItem(date.get(Calendar.DAY_OF_MONTH));
			this.cboxMes.setSelectedIndex(date.get(Calendar.MONTH));
			this.cboxAno.setSelectedItem(date.get(Calendar.YEAR));
			double time = act.getTimeSpent();
			int horas = (int) (time / 60);
			int mins = (int) (time % 60);
			this.textHoras.setText(String.valueOf(horas));
			this.textMins.setText(String.valueOf(mins));
			this.cboxHoraData.setSelectedItem(act.getDate().get(Calendar.HOUR_OF_DAY));
			this.cboxMinsData.setSelectedItem(act.getDate().get(Calendar.MINUTE));
			this.textCalorias.setText(String.valueOf((int) act.getCalories()));
			if (act instanceof Distance || act instanceof VerticalDistance) {
				this.textDistanciaH.setEnabled(true);
				if (act instanceof VerticalDistance) {
					this.textDistanciaV.setEnabled(true);
				}

				if (act instanceof Running) {
					Running r = (Running) act;
					this.cboxSports.setSelectedItem("Running");
					this.textClima.setText(r.getWeather());
					this.textDistanciaH.setText(String.valueOf(r.getDistance()));
				} else if (act instanceof Cycling) {
					Cycling s = (Cycling) act;
					this.cboxSports.setSelectedItem("Cycling");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
				} else if (act instanceof Walking) {
					Walking s = (Walking) act;
					this.cboxSports.setSelectedItem("Walking");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
				} else if (act instanceof Sailing) {
					Sailing s = (Sailing) act;
					this.cboxSports.setSelectedItem("Sailing");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
				} else if (act instanceof Skating) {
					Skating s = (Skating) act;
					this.cboxSports.setSelectedItem("Skating");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
				} else if (act instanceof Orienteering) {
					Orienteering s = (Orienteering) act;
					this.cboxSports.setSelectedItem("Orienteering");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
				} else if (act instanceof Swimming) {
					Swimming s = (Swimming) act;
					this.cboxSports.setSelectedItem("Swimming");
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
					this.textClima.setEnabled(false);
				} else if (act instanceof IndoorCycling) {
					IndoorCycling s = (IndoorCycling) act;
					this.cboxSports.setSelectedItem("Indoor Cycling");
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
					this.textClima.setEnabled(false);
				} else if (act instanceof Snowboarding) {
					Snowboarding s = (Snowboarding) act;
					this.cboxSports.setSelectedItem("Snowboarding");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
					this.textDistanciaV.setText(String.valueOf(s.getVerticalDistance()));
				} else if (act instanceof MountainBiking) {
					MountainBiking s = (MountainBiking) act;
					this.cboxSports.setSelectedItem("Mountain Biking");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
					this.textDistanciaV.setText(String.valueOf(s.getVerticalDistance()));
				} else {
					Skiing s = (Skiing) act;
					this.cboxSports.setSelectedItem("Skiing");
					this.textClima.setText(s.getWeather());
					this.textDistanciaH.setText(String.valueOf(s.getDistance()));
					this.textDistanciaV.setText(String.valueOf(s.getVerticalDistance()));
				}
			} else if (act instanceof UserVs) {
				if (act instanceof Football || act instanceof Polo || act instanceof Tennis) {
					this.textClima.setEnabled(true);
				}
				this.textDistanciaH.setEnabled(false);
				this.textDistanciaV.setEnabled(false);

				if (act instanceof Football) {
					Football r = (Football) act;
					this.cboxSports.setSelectedItem("Football");
					this.textClima.setText(r.getWeather());
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else if (act instanceof Polo) {
					Polo r = (Polo) act;
					this.cboxSports.setSelectedItem("Polo");
					this.textClima.setText(r.getWeather());
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else if (act instanceof Tennis) {
					Tennis r = (Tennis) act;
					this.cboxSports.setSelectedItem("Tennis");
					this.textClima.setText(r.getWeather());
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else if (act instanceof Handball) {
					Handball r = (Handball) act;
					this.cboxSports.setSelectedItem("Handball");
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else if (act instanceof Basketball) {
					Basketball r = (Basketball) act;
					this.cboxSports.setSelectedItem("Basketball");
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else if (act instanceof TableTennis) {
					TableTennis r = (TableTennis) act;
					this.cboxSports.setSelectedItem("Table Tennis");
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else if (act instanceof Boxing) {
					Boxing r = (Boxing) act;
					this.cboxSports.setSelectedItem("Boxing");
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else if (act instanceof Badminton) {
					Badminton r = (Badminton) act;
					this.cboxSports.setSelectedItem("Badminton");
					this.spinnerPessoal.setValue(r.getMyScore());
					this.spinnerAdversario.setValue(r.getOpScore());
				} else {
					VolleyBallIndoor s = (VolleyBallIndoor) act;
					this.cboxSports.setSelectedItem("Volleyball");
					this.spinnerPessoal.setValue(s.getMyScore());
					this.spinnerAdversario.setValue(s.getOpScore());
				}
			} else {
				if (act instanceof Yoga) {
					this.cboxSports.setSelectedItem("Yoga");
				} else {
					this.cboxSports.setSelectedItem("Aerobics");
				}
			}
		} else {
			this.butRemove.setEnabled(false);
			this.clearFields();
		}
	}

	private void clearFields() {
		this.textCalorias.setText("");
		this.textClima.setText("");
		this.textDistanciaH.setText("");
		this.textDistanciaV.setText("");
		this.textHoras.setText("");
		this.textMins.setText("");
		this.textNAct.setText("");
		this.textName.setText("");
		this.cboxSports.setSelectedItem("Running");
		this.cboxAno.setSelectedIndex(0);
		this.cboxDia.setSelectedIndex(0);
		this.cboxMes.setSelectedIndex(0);
		this.cboxHoraData.setSelectedIndex(0);
		this.cboxMinsData.setSelectedIndex(0);
		this.spinnerAdversario.setValue(0);
		this.spinnerPessoal.setValue(0);
	}
	/* This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelMensagens = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelDay = new javax.swing.JLabel();
        labelMonth = new javax.swing.JLabel();
        labelYear = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        cboxSports = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxDia = new javax.swing.JComboBox();
        cboxMes = new javax.swing.JComboBox();
        cboxAno = new javax.swing.JComboBox();
        textHoras = new javax.swing.JTextField();
        textMins = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        textClima = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        textDistanciaH = new javax.swing.JTextField();
        textDistanciaV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        spinnerPessoal = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        spinnerAdversario = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textCalorias = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboxHoraData = new javax.swing.JComboBox();
        cboxMinsData = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        but10 = new javax.swing.JRadioButton();
        butAll = new javax.swing.JRadioButton();
        butFirst = new javax.swing.JButton();
        butPrev = new javax.swing.JButton();
        textNAct = new javax.swing.JTextField();
        butNext = new javax.swing.JButton();
        butLast = new javax.swing.JButton();
        butRemove = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cboxRecordSport = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRecords = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAmigos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        butAddActivity = new javax.swing.JButton();
        butVerPedidos = new javax.swing.JButton();
        butAddAmigo = new javax.swing.JButton();
        butLogout = new javax.swing.JButton();

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
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Home", panelMensagens);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ATIVIDADE"));
        jPanel3.setMaximumSize(new java.awt.Dimension(491, 381));
        jPanel3.setMinimumSize(new java.awt.Dimension(491, 381));

        labelName.setText("Nome");

        jLabel2.setText("Desporto");

        labelDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDay.setText("Dia");
        labelDay.setMaximumSize(new java.awt.Dimension(45, 14));
        labelDay.setMinimumSize(new java.awt.Dimension(45, 14));
        labelDay.setPreferredSize(new java.awt.Dimension(45, 14));

        labelMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonth.setText("Mês");
        labelMonth.setMaximumSize(new java.awt.Dimension(95, 14));
        labelMonth.setMinimumSize(new java.awt.Dimension(95, 14));
        labelMonth.setPreferredSize(new java.awt.Dimension(95, 14));

        labelYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelYear.setText("Ano");
        labelYear.setMaximumSize(new java.awt.Dimension(68, 14));
        labelYear.setMinimumSize(new java.awt.Dimension(68, 14));
        labelYear.setPreferredSize(new java.awt.Dimension(68, 14));

        labelTime.setText("Duração");

        labelDate.setText("Data");

        textName.setEditable(false);
        textName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textName.setMaximumSize(new java.awt.Dimension(244, 28));
        textName.setMinimumSize(new java.awt.Dimension(244, 28));
        textName.setPreferredSize(new java.awt.Dimension(244, 28));

        cboxSports.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yoga", "Aerobics", "Swimming", "Indoor Cycling", "Handball", "Basketball", "Table Tennis", "Boxing", "Badminton", "Volleyball", "Football", "Beach Volleyball", "Running", "Skating", "Sailing", "Walking", "Tennis", "Skiing", "Cycling", "Mountain Biking", "Orienteering", "Snowboarding", "Polo" }));
        cboxSports.setEnabled(false);
        cboxSports.setMaximumSize(new java.awt.Dimension(244, 23));
        cboxSports.setMinimumSize(new java.awt.Dimension(244, 23));
        cboxSports.setPreferredSize(new java.awt.Dimension(244, 23));
        cboxSports.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxSportsItemStateChanged(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Horas");
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 25));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mins");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 25));

        cboxDia.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        cboxDia.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}));
        cboxDia.setEnabled(false);
        cboxDia.setMaximumSize(new java.awt.Dimension(45, 21));
        cboxDia.setMinimumSize(new java.awt.Dimension(45, 21));
        cboxDia.setPreferredSize(new java.awt.Dimension(45, 21));

        cboxMes.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        cboxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        cboxMes.setEnabled(false);
        cboxMes.setMaximumSize(new java.awt.Dimension(95, 21));
        cboxMes.setMinimumSize(new java.awt.Dimension(95, 21));
        cboxMes.setPreferredSize(new java.awt.Dimension(95, 21));

        cboxAno.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        cboxAno.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014}));
        cboxAno.setEnabled(false);
        cboxAno.setMaximumSize(new java.awt.Dimension(68, 21));
        cboxAno.setMinimumSize(new java.awt.Dimension(68, 21));
        cboxAno.setPreferredSize(new java.awt.Dimension(68, 21));

        textHoras.setEditable(false);
        textHoras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textHoras.setMaximumSize(new java.awt.Dimension(45, 28));
        textHoras.setMinimumSize(new java.awt.Dimension(45, 28));
        textHoras.setPreferredSize(new java.awt.Dimension(45, 28));

        textMins.setEditable(false);
        textMins.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textMins.setMaximumSize(new java.awt.Dimension(45, 28));
        textMins.setMinimumSize(new java.awt.Dimension(45, 28));
        textMins.setPreferredSize(new java.awt.Dimension(45, 28));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Clima"));
        jPanel4.setMaximumSize(new java.awt.Dimension(112, 120));
        jPanel4.setMinimumSize(new java.awt.Dimension(112, 120));
        jPanel4.setPreferredSize(new java.awt.Dimension(112, 74));

        textClima.setEditable(false);
        textClima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textClima.setEnabled(false);
        textClima.setMaximumSize(new java.awt.Dimension(76, 28));
        textClima.setMinimumSize(new java.awt.Dimension(76, 28));
        textClima.setPreferredSize(new java.awt.Dimension(76, 28));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textClima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textClima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Distância"));
        jPanel5.setMaximumSize(new java.awt.Dimension(137, 140));
        jPanel5.setMinimumSize(new java.awt.Dimension(137, 120));

        textDistanciaH.setEditable(false);
        textDistanciaH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textDistanciaH.setEnabled(false);
        textDistanciaH.setMaximumSize(new java.awt.Dimension(52, 28));
        textDistanciaH.setMinimumSize(new java.awt.Dimension(52, 28));
        textDistanciaH.setPreferredSize(new java.awt.Dimension(52, 28));

        textDistanciaV.setEditable(false);
        textDistanciaV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textDistanciaV.setEnabled(false);
        textDistanciaV.setMaximumSize(new java.awt.Dimension(52, 28));
        textDistanciaV.setMinimumSize(new java.awt.Dimension(52, 28));
        textDistanciaV.setPreferredSize(new java.awt.Dimension(52, 28));

        jLabel4.setText("KMs");

        jLabel8.setText("KMs");

        jLabel5.setText("Vertical");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(textDistanciaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(textDistanciaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jLabel5))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDistanciaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDistanciaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pontuação"));
        jPanel6.setMaximumSize(new java.awt.Dimension(168, 140));
        jPanel6.setMinimumSize(new java.awt.Dimension(168, 120));
        jPanel6.setPreferredSize(new java.awt.Dimension(168, 140));

        spinnerPessoal.setEnabled(false);
        spinnerPessoal.setMaximumSize(new java.awt.Dimension(59, 28));
        spinnerPessoal.setMinimumSize(new java.awt.Dimension(59, 28));
        spinnerPessoal.setPreferredSize(new java.awt.Dimension(59, 28));

        jLabel9.setText("Pessoal");

        spinnerAdversario.setEnabled(false);
        spinnerAdversario.setMaximumSize(new java.awt.Dimension(59, 28));
        spinnerAdversario.setMinimumSize(new java.awt.Dimension(59, 28));
        spinnerAdversario.setPreferredSize(new java.awt.Dimension(59, 28));

        jLabel10.setText("Adversário");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinnerAdversario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerAdversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Calorias");

        textCalorias.setEditable(false);
        textCalorias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCalorias.setMaximumSize(new java.awt.Dimension(60, 28));
        textCalorias.setMinimumSize(new java.awt.Dimension(60, 28));
        textCalorias.setPreferredSize(new java.awt.Dimension(60, 28));

        jLabel7.setText("Hora");

        cboxHoraData.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        cboxHoraData.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}));
        cboxHoraData.setEnabled(false);
        cboxHoraData.setMaximumSize(new java.awt.Dimension(45, 21));
        cboxHoraData.setMinimumSize(new java.awt.Dimension(45, 21));
        cboxHoraData.setPreferredSize(new java.awt.Dimension(45, 21));

        cboxMinsData.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        cboxMinsData.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59}));
        cboxMinsData.setEnabled(false);
        cboxMinsData.setMaximumSize(new java.awt.Dimension(45, 21));
        cboxMinsData.setMinimumSize(new java.awt.Dimension(45, 21));
        cboxMinsData.setPreferredSize(new java.awt.Dimension(45, 21));

        jLabel11.setText("h");

        jLabel12.setText("m");

        but10.setSelected(true);
        but10.setText("10 Últimas");
        but10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but10ActionPerformed(evt);
            }
        });

        butAll.setText("Todas");
        butAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelTime)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textMins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelName)
                                        .addComponent(labelDate)
                                        .addComponent(jLabel7))
                                    .addGap(45, 45, 45)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cboxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(cboxMinsData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(jLabel12)))
                                            .addGap(25, 25, 25)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboxSports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(cboxHoraData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel11)
                                            .addGap(194, 194, 194))))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(but10)
                                .addComponent(butAll)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelName)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboxSports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDate)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboxHoraData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxMinsData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTime)
                            .addComponent(textHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(textCalorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(but10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

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

        textNAct.setEditable(false);
        textNAct.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        butRemove.setText("REMOVER");
        butRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(butFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNAct, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butLast))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(butRemove)))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addComponent(butRemove)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butFirst)
                    .addComponent(butPrev)
                    .addComponent(butNext)
                    .addComponent(butLast)
                    .addComponent(textNAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Ver Atividades", jPanel2);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "RECORDES"));

        jLabel13.setText("Desporto");

        cboxRecordSport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Running / Walking", "Mountain Biking / Cycling", "Swimming" }));
        cboxRecordSport.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxRecordSportItemStateChanged(evt);
            }
        });

        tableRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Recorde", "Tempo / KMs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRecords.setRowSelectionAllowed(false);
        tableRecords.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableRecords);
        if (tableRecords.getColumnModel().getColumnCount() > 0) {
            tableRecords.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxRecordSport, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboxRecordSport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Recordes", jPanel1);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "SELECIONAR AMIGO"));

        tableAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAmigos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tableAmigos);

        jButton1.setText("Ver amigo");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Amigos", jPanel8);

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

        butAddAmigo.setText("+ AMIGO");
        butAddAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddAmigoActionPerformed(evt);
            }
        });

        butLogout.setText("LOGOUT");
        butLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(butAddActivity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butVerPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butAddAmigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAddActivity)
                    .addComponent(butVerPedidos)
                    .addComponent(butAddAmigo)
                    .addComponent(butLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVerPedidosActionPerformed
		FriendRequestListForm pedidos = new FriendRequestListForm(this, fit);
		pedidos.setVisible(true);
    }//GEN-LAST:event_butVerPedidosActionPerformed

    private void butAddActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActivityActionPerformed
		AddViewActivityForm addActi = new AddViewActivityForm(this, this.fit, this.fit.getUserByEmail(this.fit.getActivePerson().getEmail()));
		addActi.setName("add");
		addActi.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_butAddActivityActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		//FileOutputStream out = null;
		this.guardaEstado();
    }//GEN-LAST:event_formWindowClosing

	private void guardaEstado() {
		try {
			FileOutputStream out = new FileOutputStream("data.obj");
			ObjectOutputStream oout = new ObjectOutputStream(out);
			oout.writeObject(this.fit);
			oout.flush();
			oout.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage() + " | " + ex.getLocalizedMessage());
		}
	}

    private void butAddAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddAmigoActionPerformed
		SearchFriendForm addAmigo = new SearchFriendForm(this, this.u, this.fit);
		addAmigo.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_butAddAmigoActionPerformed

    private void butLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogoutActionPerformed
		this.dispose();
		this.guardaEstado();
		LoginForm login = new LoginForm();
		login.setVisible(true);
    }//GEN-LAST:event_butLogoutActionPerformed

    private void butRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRemoveActionPerformed
		Activity a;
		if (this.but10.isSelected()) {
			a = this.acts10.get(this.currAct - 1);
		} else {
			a = this.allActs.get(this.allActsCurr - 1);
		}
		boolean rem = this.u.removeActivity(a.getName());
		if (rem) {
			JOptionPane.showMessageDialog(this, "Atividade removida com sucesso...");
			this.changeActivities("remove");
		} else {
			JOptionPane.showMessageDialog(this, "Atividade não removida...");
		}
    }//GEN-LAST:event_butRemoveActionPerformed

    private void butLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLastActionPerformed
		if (this.but10.isSelected()) {
			this.currAct = this.acts10.size();
		} else {
			this.allActsCurr = this.allActs.size();
		}
		this.changeActivities("last");
    }//GEN-LAST:event_butLastActionPerformed

    private void butNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextActionPerformed
		if (this.but10.isSelected()) {
			if (this.currAct < this.acts10.size()) {
				this.currAct++;
				this.changeActivities("next");
			}
		} else {
			if (this.allActsCurr < this.allActs.size()) {
				this.allActsCurr++;
				this.changeActivities("next");
			}
		}
    }//GEN-LAST:event_butNextActionPerformed

    private void butPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPrevActionPerformed
		if (this.but10.isSelected()) {
			if (this.currAct > 1) {
				this.currAct--;
				this.changeActivities("prev");
			}
		} else {
			if (this.allActsCurr > 1) {
				this.allActsCurr--;
				this.changeActivities("prev");
			}
		}
    }//GEN-LAST:event_butPrevActionPerformed

    private void butFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFirstActionPerformed
		if (this.but10.isSelected()) {
			this.currAct = 1;
		} else {
			this.allActsCurr = 1;
		}
		this.changeActivities("first");
    }//GEN-LAST:event_butFirstActionPerformed

    private void butAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAllActionPerformed
		this.but10.setSelected(false);
		this.butAll.setSelected(true);
		this.textNAct.setText(this.allActsCurr + "/" + this.allActs.size());
		this.changeActivities("all");
    }//GEN-LAST:event_butAllActionPerformed

    private void but10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but10ActionPerformed
		this.butAll.setSelected(false);
		this.but10.setSelected(true);
		this.textNAct.setText(this.currAct + "/" + this.acts10.size());
		this.changeActivities("10");
    }//GEN-LAST:event_but10ActionPerformed

    private void cboxSportsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxSportsItemStateChanged
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			String sport = this.cboxSports.getSelectedItem().toString();
			switch (sport) {
				case "Running":
				case "Cycling":
				case "Walking":
				case "Sailing":
				case "Skating":
				case "Orienteering":
					this.textClima.setEnabled(true);
					this.textDistanciaH.setEnabled(true);
					this.textDistanciaV.setEnabled(false);
					this.spinnerAdversario.setEnabled(false);
					this.spinnerPessoal.setEnabled(false);
					break;
				case "Snowboarding":
				case "Mountain Biking":
				case "Skiing":
					this.textClima.setEnabled(true);
					this.textDistanciaH.setEnabled(true);
					this.textDistanciaV.setEnabled(true);
					this.spinnerAdversario.setEnabled(false);
					this.spinnerPessoal.setEnabled(false);
					break;
				case "Swimming":
				case "Indoor Cycling":
					this.textClima.setEnabled(false);
					this.textDistanciaH.setEnabled(true);
					this.textDistanciaV.setEnabled(false);
					this.spinnerAdversario.setEnabled(false);
					this.spinnerPessoal.setEnabled(false);
					break;
				case "Football":
				case "Polo":
				case "Beach Volleyball":
				case "Tennis":
					this.textClima.setEnabled(true);
					this.textDistanciaH.setEnabled(false);
					this.textDistanciaV.setEnabled(false);
					this.spinnerAdversario.setEnabled(true);
					this.spinnerPessoal.setEnabled(true);
					break;
				case "Handball":
				case "Basketball":
				case "Table Tennis":
				case "Boxing":
				case "Badminton":
				case "Volleyball":
					this.textClima.setEnabled(false);
					this.textDistanciaH.setEnabled(false);
					this.textDistanciaV.setEnabled(false);
					this.spinnerAdversario.setEnabled(true);
					this.spinnerPessoal.setEnabled(true);
					break;
				default:
					this.textClima.setEnabled(false);
					this.textDistanciaH.setEnabled(false);
					this.textDistanciaV.setEnabled(false);
					this.spinnerAdversario.setEnabled(false);
					this.spinnerPessoal.setEnabled(false);
					break;
			}
		}
    }//GEN-LAST:event_cboxSportsItemStateChanged

    private void cboxRecordSportItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxRecordSportItemStateChanged
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			for (int i = 0; i < this.tableRecords.getRowCount(); i++) {
				for (int j = 0; j < this.tableRecords.getColumnCount(); j++) {
					this.tableRecords.setValueAt(null, i, j);
				}
			}

			String sport = this.cboxRecordSport.getSelectedItem().toString();

			switch (sport) {
				case "Running / Walking":
					this.preencheRunRecords();
					break;
				case "Mountain Biking / Cycling":
					this.preencheBikeRecords();
					break;
				default:
					this.preencheSwimRecords();
					break;
			}
		}
    }//GEN-LAST:event_cboxRecordSportItemStateChanged

	private void preencheRunRecords() {
		TreeMap<String, ListRecords> rec = (TreeMap<String, ListRecords>) this.u.getRecords();
		ArrayList<Record> run = new ArrayList<>();

		for (ListRecords l : rec.values()) {
			switch (l.getName()) {
				case "Running":
				case "Walking":
					run = (ArrayList<Record>) l.clone().getList();
					break;
				default:
					break;
			}
		}

		for (int i = 0; i < run.size(); i++) {
			Record r = run.get(i).clone();
			if (r instanceof DistancePerTime) {
				DistancePerTime dpt = (DistancePerTime) r;
				this.tableRecords.setValueAt(dpt.getName(), i, 0);
				Double dist = dpt.getDistance();
				if (dist > 0.0) {
					this.tableRecords.setValueAt(dpt.getDistance() + " KMs", i, 1);
				} else {
					this.tableRecords.setValueAt("N/A", i, 1);
				}
			} else {
				TimePerDistance tpd = (TimePerDistance) r;
				this.tableRecords.setValueAt(tpd.getName(), i, 0);
				Double time = tpd.getTime();
				if (time > 0.0) {
					this.tableRecords.setValueAt(time + " mins", i, 1);
				} else {
					this.tableRecords.setValueAt("N/A", i, 1);
				}
			}
		}
	}

	private void preencheBikeRecords() {
		TreeMap<String, ListRecords> rec = (TreeMap<String, ListRecords>) this.u.getRecords();
		ArrayList<Record> bike = new ArrayList<>();

		for (ListRecords l : rec.values()) {
			switch (l.getName()) {
				case "Mountain Byking":
				case "Cycling":
					bike = (ArrayList<Record>) l.clone().getList();
					break;
				default:
					break;
			}
		}

		for (int i = 0; i < bike.size(); i++) {
			Record r = bike.get(i).clone();
			if (r instanceof DistancePerTime) {
				DistancePerTime dpt = (DistancePerTime) r;
				this.tableRecords.setValueAt(dpt.getName(), i, 0);
				Double dist = dpt.getDistance();
				if (dist > 0.0) {
					this.tableRecords.setValueAt(dpt.getDistance() + " KMs", i, 1);
				} else {
					this.tableRecords.setValueAt("N/A", i, 1);
				}
			} else {
				TimePerDistance tpd = (TimePerDistance) r;
				this.tableRecords.setValueAt(tpd.getName(), i, 0);
				Double time = tpd.getTime();
				if (time > 0.0) {
					this.tableRecords.setValueAt(time + " mins", i, 1);
				} else {
					this.tableRecords.setValueAt("N/A", i, 1);
				}
			}
		}
	}

	private void preencheSwimRecords() {
		TreeMap<String, ListRecords> rec = (TreeMap<String, ListRecords>) this.u.getRecords();
		ArrayList<Record> swim = new ArrayList<>();

		for (ListRecords l : rec.values()) {
			switch (l.getName()) {
				case "Swimming":
					swim = (ArrayList<Record>) l.clone().getList();
					break;
				default:
					break;
			}
		}

		for (int i = 0; i < swim.size(); i++) {
			Record r = swim.get(i).clone();
			if (r instanceof TimePerDistance) {
				TimePerDistance tpd = (TimePerDistance) r;
				this.tableRecords.setValueAt(tpd.getName(), i, 0);
				Double time = tpd.getTime();
				if (time > 0.0) {
					this.tableRecords.setValueAt(time + " mins", i, 1);
				} else {
					this.tableRecords.setValueAt("N/A", i, 1);
				}
			}
		}
	}

	private void preencheTabAmigos() {
		TreeSet<String> emails = (TreeSet<String>) this.u.getFriendsList();
		//ArrayList<String> emails = new ArrayList<>();
		TreeSet<User> friends = new TreeSet<>(new CompareUserByName());
		for (String e : emails)
			friends.add(this.fit.getUserByEmail(e));
		
		DefaultTableModel dtm = (DefaultTableModel) this.tableAmigos.getModel();
		for(int i = 0; i < friends.size(); i++)
			dtm.addRow(new Object[] { null, null, null});	
		this.tableAmigos.setModel(dtm);
		
		int i = 0;
		for (User u : friends){
			this.tableAmigos.setValueAt(u.getName(), i, 0);
			this.tableAmigos.setValueAt((int) (u.getDate().getTimeInMillis() / 31536E6) + " anos", i, 1);
			this.tableAmigos.setValueAt(u.getEmail(), i, 2);
			i++;
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton but10;
    private javax.swing.JButton butAddActivity;
    private javax.swing.JButton butAddAmigo;
    private javax.swing.JRadioButton butAll;
    private javax.swing.JButton butFirst;
    private javax.swing.JButton butLast;
    private javax.swing.JButton butLogout;
    private javax.swing.JButton butNext;
    private javax.swing.JButton butPrev;
    private javax.swing.JButton butRemove;
    private javax.swing.JButton butVerPedidos;
    private javax.swing.JComboBox cboxAno;
    private javax.swing.JComboBox cboxDia;
    private javax.swing.JComboBox cboxHoraData;
    private javax.swing.JComboBox cboxMes;
    private javax.swing.JComboBox cboxMinsData;
    private javax.swing.JComboBox cboxRecordSport;
    private javax.swing.JComboBox cboxSports;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelMonth;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelYear;
    private javax.swing.JPanel panelMensagens;
    private javax.swing.JSpinner spinnerAdversario;
    private javax.swing.JSpinner spinnerPessoal;
    private javax.swing.JTable tableAmigos;
    private javax.swing.JTable tableRecords;
    private javax.swing.JTextField textCalorias;
    private javax.swing.JTextField textClima;
    private javax.swing.JTextField textDistanciaH;
    private javax.swing.JTextField textDistanciaV;
    private javax.swing.JTextField textHoras;
    private javax.swing.JTextField textMins;
    private javax.swing.JTextField textNAct;
    private javax.swing.JTextField textName;
    // End of variables declaration//GEN-END:variables
	private FitnessUM fit;
	private User u;
	private int currAct = 0;
	private int allActsCurr = 0;
	private ArrayList<Activity> acts10, allActs;
}
