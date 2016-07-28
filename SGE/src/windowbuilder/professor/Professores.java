package windowbuilder.professor;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;

import projeto.Professor;

import bancodedados.ProfessorDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import java.awt.Window.Type;

public class Professores {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Professores() {
		initialize();
		frame.setTitle("Professores");
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
		
		VisualizarProfessores visualizar = new VisualizarProfessores();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 659, 421);
		tabbedPane.add(new CadastrarProfessores(visualizar, 0), "Cadastrar Professor");
		tabbedPane.add(visualizar, "Ver todos");
		frame.getContentPane().add(tabbedPane);
		

	}
}
