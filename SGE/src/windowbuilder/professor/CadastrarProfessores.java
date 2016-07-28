package windowbuilder.professor;

import bancodedados.ProfessorDAO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import projeto.Professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarProfessores extends JPanel{

	private int idProfessor;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;

	/**
	 * Create the application.
	 * @param visualizar 
	 */
	public CadastrarProfessores(final VisualizarProfessores visualizar, int id) {
		setLayout(null);
		this.idProfessor = id;
		Professor professor = null;
		if (id != 0){
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.conecta();
			professor = professorDAO.professoPorCodigo(id);
			professorDAO.desconecta();
		}
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(24, 24, 257, 26);
		add(lblNewLabel_2);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(20, 55, 373, 28);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		if (id != 0) textFieldNome.setText(professor.getNome());
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(20, 123, 373, 28);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		if (id != 0) textFieldEmail.setText(professor.getEmail());
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(24, 95, 61, 16);
		add(lblNewLabel_3);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor p = new Professor(idProfessor, textFieldNome.getText(), textFieldEmail.getText());
				ProfessorDAO professorDAO = new ProfessorDAO();
				professorDAO.conecta();
				if (idProfessor == 0){
					professorDAO.cadastrarProfessor(p);
					JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
				} else {
					professorDAO.atualizarProfessor(p);
					JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
					frame.dispose();
					new Professores();
				}
				professorDAO.desconecta();
				
				if (visualizar != null)
				visualizar.atualizarTabela();
				
				textFieldNome.setText("");
				textFieldEmail.setText("");
				
			}
		});
		btnSalvar.setBounds(503, 325, 117, 29);
		add(btnSalvar);
	}
}
