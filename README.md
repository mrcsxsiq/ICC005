 ICC005 Técnicas de Programação UFAM

 SISTEMA PARA GESTÃO DE ESTUDOS

 03/02/2014

 Descrição do conteúdo:
 SGE.zip = Código fonte do projeto java no eclipse
 SGE.sql = Dump do banco de dados para teste
 Telas   = Screenshots da interface

 Configuração do Banco de Dados:
 Ver a classe BancoDeDados.java

 ==========================================================

 Descrição: SISTEMA PARA GESTÃO DE ESTUDOS

 Professor:
 * Nome
 * Email

 Disciplinas:
 * Nome
 * Sigla
 * Carga Horária
 * (FK) Professor
 * Dias semana

 Notas:
 * (FK) Disciplina
 * Nota

 Trabalhos Agendados:
 * (FK) Disciplina
 * Data marcada
 * Data entrega
 * Obrservações

 Provas Agendados:
 * (FK) Disciplina
 * Data marcada
 * Data realização
 * Assuntos

 Horários
 * Visualização em grid semanal o horário das disciplinas
