package windowbuilder.notas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import bancodedados.DisciplinaDAO;
import bancodedados.NotasDAO;

import projeto.Disciplina;
import projeto.Nota;
import javax.swing.JFormattedTextField;

public class CadastrarNotas extends JPanel{
	
	private int idNota;
	private JFormattedTextField textFieldNota;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Create the application.
	 * @param visualizar 
	 */
	public CadastrarNotas(final VisualizarNotas visualizar, int id) {
		setLayout(null);
		this.idNota = id;
		Nota nota = null;
		if (id != 0){
			NotasDAO notasDAO = new NotasDAO();
			notasDAO.conecta();
			nota = notasDAO.notaPorCodigo(id);
		}
		
		JLabel lblNewLabel_2 = new JLabel("Disciplina:");
		lblNewLabel_2.setBounds(24, 24, 257, 26);
		add(lblNewLabel_2);
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.conecta();
		ArrayList<Disciplina> lista = disciplinaDAO.listarDisciplinas();
		
		String[] comboBoxArray = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++){
			comboBoxArray[i] = lista.get(i).getNome();
		}
		final JComboBox comboBoxDisciplinas = new JComboBox(comboBoxArray);
		comboBoxDisciplinas.setBounds(24, 56, 369, 27);
		add(comboBoxDisciplinas);
		if (id != 0) {
			Disciplina d = disciplinaDAO.disciplinaPorCodigo(nota.getDisciplina());
			comboBoxDisciplinas.getEditor().setItem(d.getNome());
		}
		disciplinaDAO.desconecta();
		
		JLabel lblNewLabel_3 = new JLabel("Nota:");
		lblNewLabel_3.setBounds(24, 95, 61, 16);
		add(lblNewLabel_3);
		
		textFieldNota = new JFormattedTextField();
		textFieldNota.setBounds(24, 123, 369, 28);
		add(textFieldNota);
		if (id != 0) textFieldNota.setText(String.valueOf(nota.getNota()));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDisciplina = comboBoxDisciplinas.getSelectedItem().toString();
				
				DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
				disciplinaDAO.conecta();
				Disciplina d = disciplinaDAO.disciplinaPorNome(nomeDisciplina);
				disciplinaDAO.desconecta();
				
				int idDisciplina = d.getId();
				Nota n = new Nota(idNota, idDisciplina, Double.valueOf(textFieldNota.getText()));
				NotasDAO notasDAO = new NotasDAO();
				notasDAO.conecta();
				if (idNota == 0){
					notasDAO.cadastrarNota(n);
					JOptionPane.showMessageDialog(null, "Nota cadastrado com sucesso!");
				} else {
					notasDAO.atualizarNota(n);
					JOptionPane.showMessageDialog(null, "Nota atualizado com sucesso!");
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
					frame.dispose();
					new Notas();
				}
				if (visualizar != null)
					visualizar.atualizarTabela();
				textFieldNota.setText("");
				notasDAO.desconecta();
	
			}
		});
		btnSalvar.setBounds(503, 325, 117, 29);
		add(btnSalvar);
		
		
		
		
	}
}
