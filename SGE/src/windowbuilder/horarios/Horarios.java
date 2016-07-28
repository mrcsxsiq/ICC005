package windowbuilder.horarios;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import projeto.Disciplina;
import bancodedados.DisciplinaDAO;

public class Horarios {
	
	private JScrollPane scrollPane;
	private JFrame frame;
	private JTable table;
	
	public void atualizarTabela(){
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.conecta();
		ArrayList<Disciplina> lista = disciplinaDAO.listarDisciplinas();
		
		String[][] dados = new String[lista.size()][7];
		for (int linha = 0; linha < lista.size(); linha++){
				
			if (lista.get(linha).getDiasSemana().contains("Dom")){
				dados[linha][0] = lista.get(linha).getNome();
			} else {
				dados[linha][0] = "-";
			}
			
			if (lista.get(linha).getDiasSemana().contains("Seg")){
				dados[linha][1] = lista.get(linha).getNome();
			} else {
				dados[linha][1] = "-";
			}
			
			if (lista.get(linha).getDiasSemana().contains("Ter")){
				dados[linha][2] = lista.get(linha).getNome();
			} else {
				dados[linha][2] = "-";
			}
			
			if (lista.get(linha).getDiasSemana().contains("Qua")){
				dados[linha][3] = lista.get(linha).getNome();
			} else {
				dados[linha][3] = "-";
			}
			
			if (lista.get(linha).getDiasSemana().contains("Qui")){
				dados[linha][4] = lista.get(linha).getNome();
			} else {
				dados[linha][4] = "-";
			}
			
			if (lista.get(linha).getDiasSemana().contains("Sex")){
				dados[linha][5] = lista.get(linha).getNome();
			} else {
				dados[linha][5] = "-";
			}
			
			if (lista.get(linha).getDiasSemana().contains("Sab")){
				dados[linha][6] = lista.get(linha).getNome();
			} else {
				dados[linha][6] = "-";
			}

		}
		
		String[] colunas = new String[] 
				{"Domingo","Segunda","Terça","Quarta", "Quinta", "Sexta", "Sábado"};
		
		table = new JTable(dados,colunas);
		scrollPane.setViewportView(table);
		
		disciplinaDAO.desconecta();
	}

	/**
	 * Create the application.
	 */
	public Horarios() {
		initialize();
		frame.setTitle("Horários");
		frame.setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		atualizarTabela();
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 398);
		

	}

}
