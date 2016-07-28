package windowbuilder.notas;

import bancodedados.ProfessorDAO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import projeto.Professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarNotas extends JPanel{
	
	private int idNota;
	private JFrame frame;

	public EditarNotas(int id) {
		this.idNota = id;
		initialize();
		frame.setTitle("Editar Nota");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 671, 455);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 659, 421);
		tabbedPane.add(new CadastrarNotas(null, idNota), "Editar");
		frame.getContentPane().add(tabbedPane);
		

	}
}
