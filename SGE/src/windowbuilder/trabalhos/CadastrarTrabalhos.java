package windowbuilder.trabalhos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import bancodedados.DisciplinaDAO;
import bancodedados.TrabalhosDAO;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingUtilities;

import projeto.Disciplina;
import projeto.Trabalho;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CadastrarTrabalhos extends JPanel{
	
	private int idTrabalho;
	
	private JTextField textFieldDataMarcada;
	private JTextField textFieldDataEntrega;

	/**
	 * Create the application.
	 * @param visualizar 
	 */
	public CadastrarTrabalhos(final VisualizarTrabalhos visualizar, int id) {
		setLayout(null);
		this.idTrabalho = id;
		Trabalho trabalho = null;
		if (id != 0){
			TrabalhosDAO trabalhosDAO = new TrabalhosDAO();
			trabalhosDAO.conecta();
			trabalho = trabalhosDAO.trabalhoPorCodigo(id);
			trabalhosDAO.desconecta();
		}
		
		JLabel lblNewLabel_2 = new JLabel("Disciplina:");
		lblNewLabel_2.setBounds(24, 24, 257, 26);
		add(lblNewLabel_2);
		
		textFieldDataMarcada = new JTextField();
		textFieldDataMarcada.setBounds(20, 123, 187, 28);
		add(textFieldDataMarcada);
		textFieldDataMarcada.setColumns(10);
		if (id != 0) textFieldDataMarcada.setText(trabalho.getDataMarcada());
		
		JLabel lblNewLabel_3 = new JLabel("Data marcada:");
		lblNewLabel_3.setBounds(24, 95, 138, 16);
		add(lblNewLabel_3);
		
		textFieldDataEntrega = new JTextField();
		textFieldDataEntrega.setColumns(10);
		textFieldDataEntrega.setBounds(279, 124, 187, 28);
		add(textFieldDataEntrega);
		if (id != 0) textFieldDataEntrega.setText(trabalho.getDataEntrega());
		
		JLabel lblDataAgendada = new JLabel("Data agendada:");
		lblDataAgendada.setBounds(281, 97, 138, 16);
		add(lblDataAgendada);
		
		final JTextArea textAreaObservacoes = new JTextArea();
		textAreaObservacoes.setBounds(25, 193, 435, 121);
		add(textAreaObservacoes);
		if (id != 0) textAreaObservacoes.setText(trabalho.getObservacao());
		
		JLabel lblAssuntos = new JLabel("Observacoes:");
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
			Disciplina d = disciplinaDAO.disciplinaPorCodigo(trabalho.getDisciplina());
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

				Trabalho t = new Trabalho(idTrabalho, idDisciplina, textFieldDataMarcada.getText(), textFieldDataEntrega.getText(),  textAreaObservacoes.getText());
				TrabalhosDAO trabalhosDAO = new TrabalhosDAO();
				trabalhosDAO.conecta();	
				
				if (idTrabalho == 0){
					trabalhosDAO.cadastrarTrabalho(t);
					JOptionPane.showMessageDialog(null, "Trabalho cadastrado com sucesso!");
				} else {
					trabalhosDAO.atualizarTrabalho(t);
					JOptionPane.showMessageDialog(null, "Trabalho atualizado com sucesso!");
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
					frame.dispose();
					new Trabalhos();
				}
				trabalhosDAO.desconecta();
				
				if (visualizar != null)
					visualizar.atualizarTabela();

				textFieldDataMarcada.setText("");
				textFieldDataEntrega.setText("");
				textAreaObservacoes.setText("");	
			}
		});
		btnSalvar.setBounds(503, 325, 117, 29);
		add(btnSalvar);
	}
}
