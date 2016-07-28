package windowbuilder.principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import windowbuilder.disciplinas.Disciplinas;
import windowbuilder.horarios.Horarios;
import windowbuilder.notas.Notas;
import windowbuilder.professor.Professores;
import windowbuilder.provas.Provas;
import windowbuilder.trabalhos.Trabalhos;

import java.awt.Font;
import javax.swing.ImageIcon;


public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Principal window = new Principal();
					window.frame.setTitle("Sistema para Gestão de Estudos");
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 664, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnNewButton = new JButton("Professores");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/windowbuilder/icons/professor.png")));
		btnNewButton.setBounds(16, 50, 315, 135);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Professores();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Disciplinas");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/windowbuilder/icons/disciplinas.png")));
		btnNewButton_1.setBounds(331, 50, 315, 135);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Disciplinas();
			}
		});
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Provas");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/windowbuilder/icons/provas.png")));
		btnNewButton_2.setBounds(16, 186, 315, 135);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Provas();
			}
		});
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Trabalhos");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/windowbuilder/icons/trabalhos.png")));
		btnNewButton_3.setBounds(331, 186, 315, 135);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Trabalhos();
			}
		});
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Hor\u00E1rios");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_4.setIcon(new ImageIcon(Principal.class.getResource("/windowbuilder/icons/horarios.png")));
		btnNewButton_4.setBounds(16, 320, 315, 135);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Horarios();
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNotas = new JButton("Notas");
		btnNotas.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNotas.setIcon(new ImageIcon(Principal.class.getResource("/windowbuilder/icons/notas.png")));
		btnNotas.setBounds(331, 320, 315, 135);
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Notas();
			}
		});
		frame.getContentPane().add(btnNotas);
		
		JLabel lblNewLabel = new JLabel("Sistema Gerenciador de Estudos");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 652, 40);
		frame.getContentPane().add(lblNewLabel);

	}
}
