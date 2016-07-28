package windowbuilder.disciplinas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import projeto.Disciplina;
import projeto.Professor;
import bancodedados.DisciplinaDAO;
import bancodedados.ProfessorDAO;

public class VisualizarDisciplinas extends JPanel {

	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textFieldNome;
	private JLabel lblNewLabel_1;
	private JTextField textFieldEmail;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	
	public void atualizarTabela(){
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.conecta();
		ArrayList<Disciplina> lista = disciplinaDAO.listarDisciplinas();
		
		String[][] dados = new String[lista.size()][6];
		for (int linha = 0; linha < lista.size(); linha++){
			dados[linha][0] = String.valueOf(lista.get(linha).getId());
			dados[linha][1] = lista.get(linha).getNome();
			dados[linha][2] = lista.get(linha).getSigla();
			dados[linha][3] = lista.get(linha).getCargaHoraria();
			dados[linha][4] = lista.get(linha).getDiasSemana();
			dados[linha][5] = disciplinaDAO.disciplinaProfessor(lista.get(linha).getProfessor());
		}
		
		String[] colunas = new String[] {"ID","Nome","Sigla","Carga Horária", "Dias Semana", "Professor"};
		
		table = new JTable(dados,colunas);
		scrollPane.setViewportView(table);
		
		disciplinaDAO.desconecta();
	}

	/**
	 * Create the application.
	 */
	public VisualizarDisciplinas() {
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 623, 329);
		add(scrollPane);
		
		atualizarTabela();
		
		JButton btnNewButton_2 = new JButton("Remover selecionado");
		btnNewButton_2.setBounds(452, 339, 177, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1){
					int dialogResult = JOptionPane.showConfirmDialog (null, "Esta disciplina será removido. Tem certeza?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){	
						String id = table.getValueAt(table.getSelectedRow(), 0).toString();
						DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
						disciplinaDAO.conecta();
						disciplinaDAO.removerDisciplina(Integer.valueOf(id));
						disciplinaDAO.desconecta();
						atualizarTabela();
						JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma disciplina!");	
				}
			}
		});
		add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Editar selecionado");
		btnNewButton_1.setBounds(6, 339, 159, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1){
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
					frame.dispose();
					int id = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					new EditarDisciplinas(id);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma disciplina!");	
				}
			}
		});
		add(btnNewButton_1);
		
	}
}
