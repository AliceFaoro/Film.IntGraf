package filmGI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ButtonCerca implements ActionListener {

	Finestra f1;

	public ButtonCerca (Finestra finestra) {
		this.f1=finestra;
	}

	public void actionPerformed(ActionEvent e) {

		String url = "jdbc:mysql://localhost:3306/"; 
		String dbName = "newDB"; 
		String user = "root"; 
		String password = "Topolino.16"; 
		String insertQuery= "SELECT * FROM film";

		String scelta = JOptionPane.showInputDialog(null, "Inserisci il genere che vuoi cercare:");

		String queryGen = "SELECT * FROM film WHERE genere = (?)";

		try {
			Connection conn = DriverManager.getConnection(url + dbName, user, password);
			PreparedStatement stmt = conn.prepareStatement(queryGen);
			stmt.setString(1, scelta);
			ResultSet rs = stmt.executeQuery();
			
			String lista2 = " ";
			while (rs.next()) {
				int id = rs.getInt("id");
				String titolo = rs.getString("titolo");
				String regista = rs.getString("regista");
				String genere = rs.getString("genere");
				int anno = rs.getInt("anno");
				
				String lista = id + " " + titolo + " " + regista + " " + genere + " " + anno;
				lista2 +=  lista + "\n";
				
			}
			
			JOptionPane.showMessageDialog(null, lista2);
			
		} catch (SQLException i) {
			System.out.println("Errore durante l'inserimento dei dati nella tabella 'film':");
			i.printStackTrace();
		}
	}
}


