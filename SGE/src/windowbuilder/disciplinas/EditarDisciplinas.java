package windowbuilder.disciplinas;

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

public class EditarDisciplinas extends JPanel{
	
	private int idDisciplina;
	private JFrame frame;

	public EditarDisciplinas(int id) {
		this.idDisciplina = id;
		initialize();
		frame.setTitle("Editar Disciplina");
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
		tabbedPane.add(new CadastrarDisciplinas(null, idDisciplina), "Editar");
		frame.getContentPane().add(tabbedPane);
		
	}
}
