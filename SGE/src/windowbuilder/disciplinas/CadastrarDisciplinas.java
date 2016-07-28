package windowbuilder.disciplinas;

import javax.swing.JFrame;

import bancodedados.DisciplinaDAO;
import bancodedados.ProfessorDAO;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import projeto.Disciplina;
import projeto.Professor;
import projeto.Trabalho;
import windowbuilder.provas.Provas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;

public class CadastrarDisciplinas extends JPanel {

	private int idDisciplina;

	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JTextField textFieldNome;
	private JTextField textFieldSigla;
	private JTextField textFieldCargaHoraria;
	private JCheckBox chckbxDomingo;
	private JCheckBox chckbxSegunda;
	private JCheckBox chckbxTerca;
	private JCheckBox chckbxQuarta;
	private JCheckBox chckbxQuinta;
	private JCheckBox chckbxSexta;
	private JCheckBox chckbxSabado;

	/**
	 * Create the application.
	 * @param visualizar 
	 */
	public CadastrarDisciplinas(final VisualizarDisciplinas visualizar, int id) {
		setLayout(null);
		this.idDisciplina = id;
		Disciplina disciplina = null;
		if (id != 0){
			DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
			disciplinaDAO.conecta();
			disciplina = disciplinaDAO.disciplinaPorCodigo(id);
			disciplinaDAO.desconecta();
		}
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(24, 24, 257, 26);
		add(lblNewLabel_2);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(20, 55, 310, 28);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		if (id != 0) textFieldNome.setText(disciplina.getNome());

		textFieldSigla = new JTextField();
		textFieldSigla.setBounds(386, 55, 234, 26);
		add(textFieldSigla);
		textFieldSigla.setColumns(10);
		if (id != 0) textFieldSigla.setText(disciplina.getSigla());

		JLabel lblNewLabel_3 = new JLabel("Sigla:");
		lblNewLabel_3.setBounds(391, 29, 61, 16);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Carga Hor\u00E1ria:");
		lblNewLabel_4.setBounds(391, 93, 160, 16);
		add(lblNewLabel_4);

		textFieldCargaHoraria = new JTextField();
		textFieldCargaHoraria.setBounds(386, 122, 233, 28);
		add(textFieldCargaHoraria);
		textFieldCargaHoraria.setColumns(10);
		if (id != 0) textFieldCargaHoraria.setText(disciplina.getCargaHoraria());

		JLabel lblNewLabel_5 = new JLabel("Professor:");
		lblNewLabel_5.setBounds(24, 93, 139, 16);
		add(lblNewLabel_5);
		
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.conecta();
		ArrayList<Professor> lista = professorDAO.listarProfessor();
		
		String[] comboBoxArray = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++){
			comboBoxArray[i] = lista.get(i).getNome();
		}
		
		final JComboBox comboBoxProfessor = new JComboBox(comboBoxArray);
		comboBoxProfessor.setBounds(24, 124, 306, 27);
		add(comboBoxProfessor);
		if (id != 0) {
			Professor p = professorDAO.professoPorCodigo(disciplina.getProfessor());
			comboBoxProfessor.getEditor().setItem(p.getNome());
		}
		professorDAO.desconecta();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel_1 = new JPanel();
		tabbedPane.add(panel_1, "Dias Semana:");
		panel_1.setLayout(null);

		chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(6, 6, 128, 23);
		panel_1.add(chckbxDomingo);

		chckbxQuinta = new JCheckBox("Quinta-feira");
		chckbxQuinta.setBounds(6, 44, 128, 23);
		panel_1.add(chckbxQuinta);

		chckbxSegunda = new JCheckBox("Segunda-feira");
		chckbxSegunda.setBounds(152, 6, 128, 23);
		panel_1.add(chckbxSegunda);

		chckbxSexta = new JCheckBox("Sexta-feira");
		chckbxSexta.setBounds(152, 44, 128, 23);
		panel_1.add(chckbxSexta);

		chckbxTerca = new JCheckBox("Ter\u00E7a-feira");
		chckbxTerca.setBounds(292, 6, 128, 23);
		panel_1.add(chckbxTerca);

		chckbxQuarta = new JCheckBox("Quarta-feira");
		chckbxQuarta.setBounds(429, 6, 128, 23);
		panel_1.add(chckbxQuarta);

		chckbxSabado = new JCheckBox("S\u00E1bado");
		chckbxSabado.setBounds(292, 44, 128, 23);
		panel_1.add(chckbxSabado);
		tabbedPane.setBounds(24, 163, 584, 150);
		add(tabbedPane);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBoxProfessor.getSelectedIndex() < 0){
					JOptionPane.showMessageDialog(null, "Selecione um professor");
				} else {
					String segunda = "";
					String terca = "";
					String quarta = "";
					String quinta = "";
					String sexta = "";
					String sabado = "";
					String domingo = "";
					
					if (chckbxDomingo.isSelected()) domingo = "Dom ";
					
					if (chckbxSegunda.isSelected()) segunda = "Seg ";

					if (chckbxTerca.isSelected()) terca = "Ter ";
					
					if (chckbxQuarta.isSelected()) quarta = "Qua ";

					if (chckbxQuinta.isSelected()) quinta = "Qui ";

					if (chckbxSexta.isSelected()) sexta = "Sex ";

					if (chckbxSabado.isSelected()) sabado = "Sab ";
					
					String nomeProfessor = comboBoxProfessor.getSelectedItem().toString();
					
					ProfessorDAO professorDAO = new ProfessorDAO();
					professorDAO.conecta();
					Professor p = professorDAO.professoPorNome(nomeProfessor);
					professorDAO.desconecta();
					
					Disciplina d = new Disciplina (idDisciplina ,p.getID(), textFieldNome.getText().toString(), textFieldSigla.getText().toString(), textFieldCargaHoraria.getText().toString(), domingo+segunda+terca+quarta+quinta+sexta+sabado);
					
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
					disciplinaDAO.conecta();
					disciplinaDAO.cadastrarDisciplina(d);
				
					if (idDisciplina == 0){
						disciplinaDAO.cadastrarDisciplina(d);
						JOptionPane.showMessageDialog(null, "Disciplina cadastrado com sucesso!");
					} else {
						disciplinaDAO.atualizarDisciplina(d);
						JOptionPane.showMessageDialog(null, "Disciplina atualizado com sucesso!");
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
						frame.dispose();
						new Disciplinas();
					}
					disciplinaDAO.desconecta();
					
					if (visualizar != null)
					visualizar.atualizarTabela();
								
					textFieldNome.setText("");
					textFieldSigla.setText("");
					textFieldCargaHoraria.setText("");
					chckbxDomingo.setSelected(false);
					chckbxSegunda.setSelected(false);
					chckbxTerca.setSelected(false);
					chckbxQuarta.setSelected(false);
					chckbxQuinta.setSelected(false);
					chckbxSexta.setSelected(false);
					chckbxSabado.setSelected(false);
				
				}
				
			}
		});
		btnSalvar.setBounds(503, 325, 117, 29);
		add(btnSalvar);
	}
}
