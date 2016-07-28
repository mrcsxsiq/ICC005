package windowbuilder.disciplinas;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import windowbuilder.professor.CadastrarProfessores;
import windowbuilder.professor.VisualizarProfessores;

public class Disciplinas {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Disciplinas() {
		initialize();
		frame.setTitle("Disciplinas");
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
		
		VisualizarDisciplinas visualizar = new VisualizarDisciplinas();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 659, 421);
		tabbedPane.add(new CadastrarDisciplinas(visualizar, 0), "Cadastrar Disciplina");
		tabbedPane.add(visualizar, "Ver todos");
		frame.getContentPane().add(tabbedPane);
	}
}
