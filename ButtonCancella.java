package filmGI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ButtonCancella implements ActionListener {

	Finestra f1;
	
	public ButtonCancella(Finestra finestra) {
		this.f1 = finestra;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		String url = "jdbc:mysql://localhost:3306/"; 
		String dbName = "newDB"; 
		String user = "root"; 
		String password = "Topolino.16"; 
		String insertQuery= "SELECT * FROM film";
		
		 int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci l'id"));
		
		String query3 = "DELETE FROM film WHERE id = (?)";
		
		try {
		Connection conn = DriverManager.getConnection(url + dbName, user, password);
		PreparedStatement stmt = conn.prepareStatement(query3);
		
		stmt.setInt(1, id); 

		int rowsAffected = stmt.executeUpdate();
		

		
		} catch (SQLException i) {
			// Gestione dell'eccezione per la connessione al database o l'esecuzione della
			// query
			System.out.println("Errore durante l'inserimento dei dati nella tabella 'film':");
			i.printStackTrace();
		}

	}

}
