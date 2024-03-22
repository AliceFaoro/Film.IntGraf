package filmGI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import film.Film;

public class ButtonAggiungi implements ActionListener {

	Finestra f1;
	
	public ButtonAggiungi (Finestra finestra) {
		this.f1 = finestra;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		String url = "jdbc:mysql://localhost:3306/"; 
		String dbName = "newDB"; 
		String user = "root"; 
		String password = "Topolino.16"; 
		String insertQuery= "SELECT * FROM film";
	
	
		String titolo = f1.campo1.getText();
		String regista = f1.campo2.getText();;
		String genere = f1.campo3.getText();
		int anno = Integer.parseInt(f1.campo4.getText());
		
		String insertQuery1 = "INSERT INTO film (titolo, regista, genere, anno) VALUES (?, ?, ?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url + dbName, user, password);
			PreparedStatement stmt = conn.prepareStatement(insertQuery1);
			
			stmt.setString(1, titolo);
			stmt.setString(2, regista);
			stmt.setString(3, genere);
			stmt.setInt(4, anno);
			
			int rowsAffected = stmt.executeUpdate();
			
		} catch (SQLException i) {

			System.out.println("Errore durante l'inserimento dei dati nella tabella 'film':");
			i.printStackTrace();
		}

	}

}
