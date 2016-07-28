package windowbuilder.notas;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import windowbuilder.disciplinas.VisualizarDisciplinas;

public class Notas {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Notas() {
		initialize();
		frame.setTitle("Notas");
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
		
		VisualizarNotas visualizar = new VisualizarNotas();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 659, 421);
		tabbedPane.add(new CadastrarNotas(visualizar, 0), "Cadastrar Notas");
		tabbedPane.add(visualizar, "Ver todos");
		frame.getContentPane().add(tabbedPane);
		

	}
}
