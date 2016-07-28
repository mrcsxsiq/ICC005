package windowbuilder.provas;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import bancodedados.DisciplinaDAO;
import bancodedados.ProvasDAO;

import projeto.Disciplina;
import projeto.Prova;

public class CadastrarProvas extends JPanel{
	
	private int idProva;
	
	private JTextField textFieldDataMarcada;
	private JTextField textFieldDataAgendada;

	/**
	 * Create the application.
	 * @param visualizar 
	 */
	public CadastrarProvas(final VisualizarProvas visualizar, int id) {
		setLayout(null);
		this.idProva = id;
		Prova prova = null;
		if (id != 0){
			ProvasDAO provaDAO = new ProvasDAO();
			provaDAO.conecta();
			prova = provaDAO.provaPorCodigo(id);
			provaDAO.desconecta();
		}
		
		JLabel lblNewLabel_2 = new JLabel("Disciplina:");
		lblNewLabel_2.setBounds(24, 24, 257, 26);
		add(lblNewLabel_2);
		
		textFieldDataMarcada = new JTextField();
		textFieldDataMarcada.setBounds(20, 123, 187, 28);
		add(textFieldDataMarcada);
		textFieldDataMarcada.setColumns(10);
		if (id != 0) textFieldDataMarcada.setText(prova.getDataMarcada());
		
		JLabel lblNewLabel_3 = new JLabel("Data marcada:");
		lblNewLabel_3.setBounds(24, 95, 138, 16);
		add(lblNewLabel_3);
		
		textFieldDataAgendada = new JTextField();
		textFieldDataAgendada.setColumns(10);
		textFieldDataAgendada.setBounds(279, 124, 187, 28);
		add(textFieldDataAgendada);
		if (id != 0) textFieldDataAgendada.setText(prova.getDataAgendada());
		
		JLabel lblDataAgendada = new JLabel("Data agendada:");
		lblDataAgendada.setBounds(281, 97, 138, 16);
		add(lblDataAgendada);
		
		final JTextArea textAreaAssuntos = new JTextArea();
		textAreaAssuntos.setBounds(25, 193, 435, 121);
		add(textAreaAssuntos);
		if (id != 0) textAreaAssuntos.setText(prova.getAssunto());
		
		JLabel lblAssuntos = new JLabel("Assuntos:");
		lblAssuntos.setBounds(25, 168, 138, 16);
		add(lblAssuntos);
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.conecta();
		ArrayList<Disciplina> lista = disciplinaDAO.listarDisciplinas();

		String[] comboBoxArray = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++){
			comboBoxArray[i] = lista.get(i).getNome();
		}
		
		final JComboBox comboBoxDisciplinas = new JComboBox(comboBoxArray);
		comboBoxDisciplinas.setBounds(24, 56, 257, 27);
		add(comboBoxDisciplinas);
		if (id != 0) {
			Disciplina d = disciplinaDAO.disciplinaPorCodigo(prova.getDisciplina());
			comboBoxDisciplinas.getEditor().setItem(d.getNome());
		}
		disciplinaDAO.desconecta();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeDisciplina = comboBoxDisciplinas.getSelectedItem().toString();
				
				DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
				disciplinaDAO.conecta();
				Disciplina d = disciplinaDAO.disciplinaPorNome(nomeDisciplina);
				disciplinaDAO.desconecta();
				
				int idDisciplina = d.getId();
				
				Prova p = new Prova(idProva, idDisciplina, textFieldDataMarcada.getText(), textFieldDataAgendada.getText(),  textAreaAssuntos.getText());
				ProvasDAO provasDAO = new ProvasDAO();
				provasDAO.conecta();
				
				if (idProva == 0){
					provasDAO.cadastrarProva(p);
					JOptionPane.showMessageDialog(null, "Prova cadastrado com sucesso!");
				} else {
					provasDAO.atualizarProva(p);
					JOptionPane.showMessageDialog(null, "Prova atualizado com sucesso!");
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
					frame.dispose();
					new Provas();
				}
				provasDAO.desconecta();
				
				if (visualizar != null)
				visualizar.atualizarTabela();
				
				textFieldDataMarcada.setText("");
				textFieldDataAgendada.setText("");
				textAreaAssuntos.setText("");
		
			}
		});
		btnSalvar.setBounds(503, 325, 117, 29);
		add(btnSalvar);
	}
}
