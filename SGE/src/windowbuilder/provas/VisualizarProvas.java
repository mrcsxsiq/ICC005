package windowbuilder.provas;

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

import projeto.Disciplina;
import projeto.Professor;
import projeto.Prova;
import bancodedados.DisciplinaDAO;
import bancodedados.ProfessorDAO;
import bancodedados.ProvasDAO;

public class VisualizarProvas extends JPanel {

	private JTable table;
	private JScrollPane scrollPane;
	
	public void atualizarTabela(){
		ProvasDAO provaDAO = new ProvasDAO();
		provaDAO.conecta();
		ArrayList<Prova> lista = provaDAO.listarProvas();
		provaDAO.desconecta();
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.conecta();
		
		String[][] dados = new String[lista.size()][5];
		for (int linha = 0; linha < lista.size(); linha++){
			Disciplina d =  disciplinaDAO.disciplinaPorCodigo(lista.get(linha).getDisciplina());
			dados[linha][0] = String.valueOf(lista.get(linha).getId());
			dados[linha][1] = d.getNome();
			dados[linha][2] = lista.get(linha).getDataMarcada();
			dados[linha][3] = lista.get(linha).getDataAgendada();
			dados[linha][4] = lista.get(linha).getAssunto();
		}
		
		disciplinaDAO.desconecta();
		
		String[] colunas = new String[] {"ID","Disciplina","Data Marcada", "Data Agendada", "Assuntos"};
		
		table = new JTable(dados,colunas);
		scrollPane.setViewportView(table);
	}

	/**
	 * Create the application.
	 */
	public VisualizarProvas() {
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
					
					int dialogResult = JOptionPane.showConfirmDialog (null, "Esta prova será removida. Tem certeza?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						String id = table.getValueAt(table.getSelectedRow(), 0).toString();
						ProvasDAO provasDAO = new ProvasDAO();
						provasDAO.conecta();
						if (provasDAO.removerProva(Integer.valueOf(id))){
							atualizarTabela();
							JOptionPane.showMessageDialog(null, "Prova removido com sucesso!");
						} 
						provasDAO.desconecta();	
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma prova!");	
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
					new EditarProvas(id);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma prova!");	
				}
			}
		});
		add(btnNewButton_1);
	}
}
