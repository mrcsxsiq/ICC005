package windowbuilder.provas;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Provas {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Provas() {
		initialize();
		frame.setTitle("Provas");
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
		
		VisualizarProvas visualizar = new VisualizarProvas();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 659, 421);
		tabbedPane.add(new CadastrarProvas(visualizar, 0), "Cadastrar Prova");
		tabbedPane.add(visualizar, "Ver todos");
		frame.getContentPane().add(tabbedPane);
		

	}
}
