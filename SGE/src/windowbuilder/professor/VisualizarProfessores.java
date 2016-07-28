package windowbuilder.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import projeto.Professor;
import bancodedados.ProfessorDAO;

public class VisualizarProfessores extends JPanel {

	private JTable table;
	private JScrollPane scrollPane;
	
	public void atualizarTabela(){
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.conecta();
		ArrayList<Professor> lista = professorDAO.listarProfessor();
		professorDAO.desconecta();
		
		String[][] dados = new String[lista.size()][3];
		for (int linha = 0; linha < lista.size(); linha++){
			dados[linha][0] = String.valueOf(lista.get(linha).getID());
			dados[linha][1] = lista.get(linha).getNome();
			dados[linha][2] = lista.get(linha).getEmail();
		}
		
		String[] colunas = new String[] {"ID","Nome","Email"};
		
		table = new JTable(dados,colunas);
		scrollPane.setViewportView(table);
	}

	/**
	 * Create the application.
	 */
	public VisualizarProfessores() {
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
					
					int dialogResult = JOptionPane.showConfirmDialog (null, "Este professor será removido. Tem certeza?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						String id = table.getValueAt(table.getSelectedRow(), 0).toString();
						ProfessorDAO professorDAO = new ProfessorDAO();
						professorDAO.conecta();
						if (professorDAO.removerProfessor(Integer.valueOf(id))){
							atualizarTabela();
							JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Não é possível remover este professor!\nProfessor alocado em disciplina");	
						}
						professorDAO.desconecta();	
					}
					
	
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um professor!");	
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
					new EditarProfessores(id);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um professor!");	
				}
			}
		});
		add(btnNewButton_1);
		
	}
}
