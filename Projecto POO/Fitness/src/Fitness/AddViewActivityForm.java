/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fitness;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author jmano
 */
public class AddViewActivityForm extends javax.swing.JFrame {

	/**
	 * Creates new form AddActivityForm
	 *
	 * @param parent
     * @param fit
     * @param u
	 */
	public AddViewActivityForm(UserForm parent, FitnessUM fit, User u) {
		initComponents();
		this.parent = parent;
		this.fit = fit;
		this.u = u;
		this.setName("add");
		this.setLocationRelativeTo(parent);
		this.cboxSports.setSelectedIndex(12);
		int dia = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		int mes = new GregorianCalendar().get(Calendar.MONTH);
		int ano = new GregorianCalendar().get(Calendar.YEAR);
		this.cboxDia.setSelectedItem(dia);
		this.cboxMes.setSelectedIndex(mes);
		this.cboxAno.setSelectedItem(ano);

	}

    /**
     *
     * @param parent
     * @param fit
     * @param u
     * @param act
     */
    public AddViewActivityForm(UserForm parent, FitnessUM fit, User u, Activity act) {
		initComponents();
		this.parent = parent;
		this.fit = fit;
		this.u = u;
		this.a = act;
		this.setLocationRelativeTo(parent);
		this.setName("view");
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
		this.textCalorias.setEnabled(true);
		this.textCalorias.setText(String.valueOf(act.getCalories()));
		this.butOKAddAct.setText("ELIMINAR");

		this.cboxDia.setEnabled(false);
		this.cboxMes.setEnabled(false);
		this.cboxAno.setEnabled(false);
		this.cboxSports.setEnabled(false);
		this.textName.setEditable(false);
		this.textClima.setEditable(false);
		this.textHoras.setEditable(false);
		this.textMins.setEditable(false);
		this.textDistanciaH.setEditable(false);
		this.textDistanciaH.setEnabled(false);
		this.textDistanciaV.setEditable(false);
		this.textDistanciaV.setEnabled(false);
		this.spinnerAdversario.setEnabled(false);
		this.spinnerPessoal.setEnabled(false);

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

	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jPanel2 = new javax.swing.JPanel();
        textClima = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        textDistanciaH = new javax.swing.JTextField();
        textDistanciaV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        spinnerPessoal = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        spinnerAdversario = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textCalorias = new javax.swing.JTextField();
        butOKAddAct = new javax.swing.JButton();
        butCancelAddAct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NOVA ATIVIDADE"));

        labelName.setText("Nome");

        jLabel2.setText("Desporto");

        labelDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDay.setText("Dia");

        labelMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonth.setText("Mês");

        labelYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelYear.setText("Ano");

        labelTime.setText("Duração");

        labelDate.setText("Data");

        textName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cboxSports.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yoga", "Aerobics", "Swimming", "Indoor Cycling", "Handball", "Basketball", "Table Tennis", "Boxing", "Badminton", "Volleyball", "Football", "Beach Volleyball", "Running", "Skating", "Sailing", "Walking", "Tennis", "Skiing", "Cycling", "Mountain Biking", "Orienteering", "Snowboarding", "Polo" }));
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
        cboxDia.setMaximumSize(new java.awt.Dimension(45, 21));
        cboxDia.setMinimumSize(new java.awt.Dimension(45, 21));
        cboxDia.setPreferredSize(new java.awt.Dimension(45, 21));

        cboxMes.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        cboxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));

        cboxAno.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        cboxAno.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014}));

        textHoras.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textMins.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Clima"));

        textClima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textClima.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textClima, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textClima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Distância"));

        textDistanciaH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textDistanciaH.setEnabled(false);

        textDistanciaV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textDistanciaV.setEnabled(false);

        jLabel4.setText("KMs");

        jLabel8.setText("KMs");

        jLabel5.setText("Vertical");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textDistanciaH, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textDistanciaV, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jLabel5))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDistanciaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDistanciaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pontuação"));

        spinnerPessoal.setEnabled(false);

        jLabel9.setText("Pessoal");

        spinnerAdversario.setEnabled(false);

        jLabel10.setText("Adversário");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinnerAdversario)
                    .addComponent(spinnerPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerAdversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Calorias");

        textCalorias.setEditable(false);
        textCalorias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCalorias.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelTime)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textMins, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(labelDate))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(textName)
                            .addComponent(cboxSports, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxSports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDate)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDay)
                            .addComponent(labelMonth)
                            .addComponent(labelYear))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCalorias)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTime)
                        .addComponent(textHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        butOKAddAct.setText("ADICIONAR");
        butOKAddAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOKAddActActionPerformed(evt);
            }
        });

        butCancelAddAct.setText("CANCELAR");
        butCancelAddAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelAddActActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butCancelAddAct)
                .addGap(18, 18, 18)
                .addComponent(butOKAddAct)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butOKAddAct)
                    .addComponent(butCancelAddAct))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		this.parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void butOKAddActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOKAddActActionPerformed
		if (this.getName().equals("add")) {
			boolean ok = true;
			ArrayList<Component> comps = (ArrayList<Component>) AddViewActivityForm.getAllComponents(this);
			for (int i = 0; i < comps.size() && ok; i++) {
				Component c = comps.get(i);
				if (c.isEnabled()) {
					if (c instanceof JTextField) {
						JTextField text = (JTextField) c;
						if (text.getText().isEmpty()) {
							ok = false;
						}
					}
				}
			}

			if (ok) {
				try {
					String name = this.textName.getText();
					String sport = (String) this.cboxSports.getSelectedItem();
					int day = Integer.parseInt(this.cboxDia.getSelectedItem().toString());
					int month = this.cboxMes.getSelectedIndex();
					int year = Integer.parseInt(this.cboxAno.getSelectedItem().toString());
					GregorianCalendar date = new GregorianCalendar(year, month, day);
					int horas = Integer.parseInt(this.textHoras.getText());
					int mins = Integer.parseInt(this.textMins.getText());
					int time = (horas * 60) + mins;
					boolean insere = false;

					switch (sport) {
						case "Running":
						case "Cycling":
						case "Walking":
						case "Sailing":
						case "Skating":
						case "Orienteering": {
							String clima = this.textClima.getText();
							double distanciaH = Double.parseDouble(this.textDistanciaH.getText());
							switch (sport) {
								case "Running":
									insere = u.addActivity(new Running(name, date, time, distanciaH, clima), "Running");
									break;
								case "Cycling":
									insere = u.addActivity(new Cycling(name, date, time, distanciaH, clima), "Cycling");
									break;
								case "Walking":
									insere = u.addActivity(new Walking(name, date, time, distanciaH, clima), "Walking");
									break;
								case "Sailing":
									insere = u.addActivity(new Sailing(name, date, time, distanciaH, clima), "Sailing");
									break;
								case "Skating":
									insere = u.addActivity(new Skating(name, date, time, distanciaH, clima), "Skating");
									break;
								case "Orienteering":
									insere = u.addActivity(new Orienteering(name, date, time, distanciaH, clima), "Orienteering");
									break;
								default:
									break;
							}
							break;
						}

						case "Snowboarding":
						case "Mountain Biking":
						case "Skiing": {
							String clima = this.textClima.getText();
							double distanciaH = Double.parseDouble(this.textDistanciaH.getText());
							double distanciaV = Double.parseDouble(this.textDistanciaV.getText());
							switch (sport) {
								case "Snowboarding":
									insere = u.addActivity(new Snowboarding(name, date, time, distanciaH, distanciaV, clima), "Snowboarding");
									break;
								case "Mountain Biking":
									insere = u.addActivity(new MountainBiking(name, date, time, distanciaH, distanciaV, clima), "MountainBiking");
									break;
								case "Skiing":
									insere = u.addActivity(new Skiing(name, date, time, distanciaH, distanciaV, clima), "Skiing");
									break;
								default:
									break;
							}
							break;
						}
						case "Swimming":
						case "Indoor Cycling": {
							double distanciaH = Double.parseDouble(this.textDistanciaH.getText());
							switch (sport) {
								case "Swimming":
									insere = u.addActivity(new Swimming(name, date, time, distanciaH), "Swimming");
									break;
								case "Indoor Cycling":
									insere = u.addActivity(new IndoorCycling(name, date, time, distanciaH), "IndoorCycling");
									break;
								default:
									break;
							}
							break;
						}
						case "Football":
						case "Polo":
						case "Beach Volleyball":
						case "Tennis": {
							String clima = this.textClima.getText();
							int score = (int) this.spinnerPessoal.getValue();
							int scoreAdv = (int) this.spinnerAdversario.getValue();
							switch (sport) {
								case "Football":
									insere = u.addActivity(new Football(name, date, time, score, scoreAdv, clima), "Football");
									break;
								case "Polo":
									insere = u.addActivity(new Polo(name, date, time, score, scoreAdv, clima), "Polo");
									break;
								case "Beach Volleyball":
									insere = u.addActivity(new VolleyBallBeach(name, date, time, score, scoreAdv, clima), "VolleyBallBeach");
									break;
								case "Tennis":
									insere = u.addActivity(new Tennis(name, date, time, score, scoreAdv, clima), "Tennis");
									break;
								default:
									break;
							}
							break;
						}
						case "Handball":
						case "Basketball":
						case "Table Tennis":
						case "Boxing":
						case "Badminton":
						case "Volleyball": {
							int score = (int) this.spinnerPessoal.getValue();
							int scoreAdv = (int) this.spinnerAdversario.getValue();
							switch (sport) {
								case "Handball":
									insere = u.addActivity(new Handball(name, date, time, score, scoreAdv), "Handball");
									break;
								case "Basketball":
									insere = u.addActivity(new Basketball(name, date, time, score, scoreAdv), "Basketball");
									break;
								case "Table Tennis":
									insere = u.addActivity(new TableTennis(name, date, time, score, scoreAdv), "TableTennis");
									break;
								case "Boxing":
									insere = u.addActivity(new Boxing(name, date, time, score, scoreAdv), "Boxing");
									break;
								case "Badminton":
									insere = u.addActivity(new Badminton(name, date, time, score, scoreAdv), "Badminton");
									break;
								case "Volleyball":
									insere = u.addActivity(new VolleyBallIndoor(name, date, time, score, scoreAdv), "VolleyBallIndoor");
									break;
								default:
									break;
							}
							break;
						}
						case "Yoga":
						case "Aerobics":
							switch (sport) {
								case "Yoga":
									insere = u.addActivity(new Yoga(name, date, time), "Yoga");
									break;
								case "Aeorobics":
									insere = u.addActivity(new Aerobics(name, date, time), "Aerobics");
									break;
								default:
									break;
							}
							break;
					}

					if (insere) {
						parent.setVisible(true);
						parent.changeActivities("add");

						this.dispose();
						JOptionPane.showMessageDialog(this, "Atividade adicionada com sucesso...");
					} else {
						JOptionPane.showMessageDialog(this, "Ocorreu um erro. A atividade não foi adicionada...");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Dados inseridos incorretamente...");
				}
			}
		} else if (this.getName().equals("view")) {
			boolean rem = this.u.removeActivity(this.a.getName());
			if (rem) {
				JOptionPane.showMessageDialog(this, "Atividade removida com sucesso...");
				this.parent.setVisible(true);
				this.parent.changeActivities("remove");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Atividade não removida...");
			}
		} else {
			JOptionPane.showMessageDialog(this, "ERRO!");
		}
    }//GEN-LAST:event_butOKAddActActionPerformed

    /**
     *
     * @param c
     * @return
     */
    public static List<Component> getAllComponents(final Container c) {
		Component[] comps = c.getComponents();
		List<Component> compList = new ArrayList<Component>();
		for (Component comp : comps) {
			compList.add(comp);
			if (comp instanceof Container) {
				compList.addAll(getAllComponents((Container) comp));
			}
		}
		return compList;
	}

    private void cboxSportsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxSportsItemStateChanged
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			String sport = this.cboxSports.getSelectedItem().toString();
			if (sport.equals("Running") || sport.equals("Cycling") || sport.equals("Walking") || sport.equals("Sailing") || sport.equals("Skating") || sport.equals("Orienteering")) {
				this.textClima.setEnabled(true);
				this.textDistanciaH.setEnabled(true);
				this.textDistanciaV.setEnabled(false);
				this.spinnerAdversario.setEnabled(false);
				this.spinnerPessoal.setEnabled(false);
			} else if (sport.equals("Snowboarding") || sport.equals("Mountain Biking") || sport.equals("Skiing")) {
				this.textClima.setEnabled(true);
				this.textDistanciaH.setEnabled(true);
				this.textDistanciaV.setEnabled(true);
				this.spinnerAdversario.setEnabled(false);
				this.spinnerPessoal.setEnabled(false);
			} else if (sport.equals("Swimming") || sport.equals("Indoor Cycling")) {
				this.textClima.setEnabled(false);
				this.textDistanciaH.setEnabled(true);
				this.textDistanciaV.setEnabled(false);
				this.spinnerAdversario.setEnabled(false);
				this.spinnerPessoal.setEnabled(false);
			} else if (sport.equals("Football") || sport.equals("Polo") || sport.equals("Beach Volleyball") || sport.equals("Tennis")) {
				this.textClima.setEnabled(true);
				this.textDistanciaH.setEnabled(false);
				this.textDistanciaV.setEnabled(false);
				this.spinnerAdversario.setEnabled(true);
				this.spinnerPessoal.setEnabled(true);
			} else if (sport.equals("Handball") || sport.equals("Basketball") || sport.equals("Table Tennis") || sport.equals("Boxing") || sport.equals("Badminton") || sport.equals("Volleyball")) {
				this.textClima.setEnabled(false);
				this.textDistanciaH.setEnabled(false);
				this.textDistanciaV.setEnabled(false);
				this.spinnerAdversario.setEnabled(true);
				this.spinnerPessoal.setEnabled(true);
			} else {
				this.textClima.setEnabled(false);
				this.textDistanciaH.setEnabled(false);
				this.textDistanciaV.setEnabled(false);
				this.spinnerAdversario.setEnabled(false);
				this.spinnerPessoal.setEnabled(false);
			}
		}
    }//GEN-LAST:event_cboxSportsItemStateChanged

    private void butCancelAddActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelAddActActionPerformed
		this.parent.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_butCancelAddActActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		if (this.getName().equals("view")) {
			ArrayList<Component> comps = (ArrayList<Component>) AddViewActivityForm.getAllComponents(this);
			for (Component c : comps) {
				if (c instanceof JTextField) {
					JTextField text = (JTextField) c;
					text.setEditable(false);
				}
				if (c instanceof JComboBox) {
					JComboBox box = (JComboBox) c;
					box.setEnabled(false);
				}
				if (c instanceof JSpinner) {
					JSpinner spin = (JSpinner) c;
					spin.setEnabled(false);
				}
			}
		}
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancelAddAct;
    private javax.swing.JButton butOKAddAct;
    private javax.swing.JComboBox cboxAno;
    private javax.swing.JComboBox cboxDia;
    private javax.swing.JComboBox cboxMes;
    private javax.swing.JComboBox cboxSports;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelMonth;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelYear;
    private javax.swing.JSpinner spinnerAdversario;
    private javax.swing.JSpinner spinnerPessoal;
    private javax.swing.JTextField textCalorias;
    private javax.swing.JTextField textClima;
    private javax.swing.JTextField textDistanciaH;
    private javax.swing.JTextField textDistanciaV;
    private javax.swing.JTextField textHoras;
    private javax.swing.JTextField textMins;
    private javax.swing.JTextField textName;
    // End of variables declaration//GEN-END:variables
	private UserForm parent;
	private Activity a;
	private FitnessUM fit;
	private User u;
}
