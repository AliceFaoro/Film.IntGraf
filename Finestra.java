package filmGI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Finestra extends JFrame  {
	
	JLabel label1;
	JTextField campo1;
	JLabel label2;
	JTextField campo2;
	JLabel label3;
	JTextField campo3;
	JLabel label4;
	JTextField campo4;
	JButton mostra;
	JButton aggiungi;
	JButton cancella;
	JButton cerca;
	JPanel panel;
	
	
	
	public Finestra ( String titolo) {
		super (titolo);

		this.setSize(550, 500);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);
		
		label1 = new JLabel("Titolo");
		campo1 = new JTextField(20);
		label2 = new JLabel("Regista");
		campo2 = new JTextField(20);
		label3 = new JLabel("Genere");
		campo3 = new JTextField(20);
		label4 = new JLabel("Anno");
		campo4 = new JTextField(20);
		
		mostra = new JButton("Mostra Film");
		mostra.addActionListener(new ButtonMostra(this));
		
		aggiungi = new JButton("Aggiungi Film");
		aggiungi.addActionListener(new ButtonAggiungi(this));
		
		cancella = new JButton("Cancella Film");
		cancella.addActionListener(new ButtonCancella(this));
		
		cerca = new JButton("Cerca Film");
		cerca.addActionListener(new ButtonCerca(this));
		
		
		panel = new JPanel();
		
		panel.add(label1);
		panel.add(campo1);
		panel.add(label2);
		panel.add(campo2);
		panel.add(label3);
		panel.add(campo3);
		panel.add(label4);
		panel.add(campo4);
		panel.add(mostra);
		panel.add(aggiungi);
		panel.add(cancella);
		panel.add(cerca);
		
		this.add(panel);
		
		this.setVisible(true);
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Finestra finestra = new Finestra("Films");

	}

}
