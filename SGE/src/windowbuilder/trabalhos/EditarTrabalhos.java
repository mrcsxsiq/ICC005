package windowbuilder.trabalhos;

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

public class EditarTrabalhos extends JPanel{
	
	private int idTrabalho;
	private JFrame frame;

	public EditarTrabalhos(int id) {
		this.idTrabalho = id;
		initialize();
		frame.setTitle("Editar Trabalho");
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
		tabbedPane.add(new CadastrarTrabalhos(null, idTrabalho), "Editar");
		frame.getContentPane().add(tabbedPane);
		

	}
}
