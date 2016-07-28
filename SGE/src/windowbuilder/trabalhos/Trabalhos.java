package windowbuilder.trabalhos;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;

import windowbuilder.provas.CadastrarProvas;
import windowbuilder.provas.VisualizarProvas;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Trabalhos {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Trabalhos() {
		initialize();
		frame.setTitle("Trabalhos");
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
		
		VisualizarTrabalhos visualizar = new VisualizarTrabalhos();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 659, 421);
		tabbedPane.add(new CadastrarTrabalhos(visualizar, 0), "Cadastrar Trabalho");
		tabbedPane.add(visualizar, "Ver todos");
		frame.getContentPane().add(tabbedPane);
		

	}
}
