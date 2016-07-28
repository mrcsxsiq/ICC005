package windowbuilder.notas;

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
import projeto.Nota;
import projeto.Professor;
import bancodedados.DisciplinaDAO;
import bancodedados.NotasDAO;
import bancodedados.ProfessorDAO;

public class VisualizarNotas extends JPanel {

	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textFieldNome;
	private JLabel lblNewLabel_1;
	private JTextField textFieldEmail;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	
	public void atualizarTabela(){
		NotasDAO notasDAO = new NotasDAO();
		notasDAO.conecta();
		ArrayList<Nota> lista = notasDAO.listarNotas();
		notasDAO.desconecta();
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.conecta();
		
		String[][] dados = new String[lista.size()][3];
		int limite = lista.size();
		for (int linha = 0; linha < limite; linha++){
			Disciplina d =  disciplinaDAO.disciplinaPorCodigo(lista.get(linha).getDisciplina());
			dados[linha][0] = String.valueOf(lista.get(linha).getId());
			dados[linha][1] = d.getNome();
			dados[linha][2] = String.valueOf(lista.get(linha).getNota());
		}
		
		disciplinaDAO.desconecta();
		
		String[] colunas = new String[] {"ID","Disciplina","Nota"};
		
		table = new JTable(dados,colunas);
		scrollPane.setViewportView(table);
	}

	/**
	 * Create the application.
	 */
	public VisualizarNotas() {
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
					
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
					NotasDAO notasDAO = new NotasDAO();
					notasDAO.conecta();
					if (notasDAO.removerNota(Integer.valueOf(id))){
						atualizarTabela();
						JOptionPane.showMessageDialog(null, "Nota removida com sucesso!");
					}
					notasDAO.desconecta();
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma nota!");	
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
					new EditarNotas(id);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma nota!");	
				}
			}
		});
		add(btnNewButton_1);
		
		
	}
}
