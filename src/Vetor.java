

/*Implemente, utilizando a linguagem Java, uma classe que
 apresente o comportamento de um vetor dinâmico, com os seguinte métodos:

inserefinal(valor)
insereInicio(valor)
insere(indice, valor) 
get(indice) -> valor
set(indice)
removeFinal()
removeInicio()
remove(indice)

Regras de implementação:
Com exceção da classe utilizada para teste do vetor,
nenhuma outra classe pode utilizar qualquer classe do pacote java.util.

Como o vetor "sabe" o número de elementos que possui, e controla a área de armazenamento de dados,
ele pode extender a sua capacidade de armazenamento quando for necessário.

O uso de índices deve ser, sempre, validado.

Caso um índice seja inválido, deve ser gerada uma exceção ArrayOutOfBoundsException.

Alguns métodos não são necessários para o funcionamento da estrutura de dados, porém
são muito úteis para o desenvolvimento de aplicações, e devem ser implementados:

size() -> int : retorna o número de elementos armazenados no vetor.
capacity() -> int : retorna a capacidade de armazenamento do vetor.
isEmpty() -> boolean : retorna "true" se o número de elementos for 0 (zero).*/

public class Vetor {
	
	// Declarando e Inicializando um array de Aluno com capacidade 8.
	  private Aluno[] alunos = new Aluno[8];
	
	  private int totalDeAlunos = 0;

	  public void adiciona(Aluno aluno) {
		    this.garantaEspaco();
		    this.alunos[this.totalDeAlunos] = aluno;
		    this.totalDeAlunos++;
		  }

	  public void adiciona(int posicao, Aluno aluno) {
		    this.garantaEspaco();
		    if (!this.posicaoValida(posicao)) {
		      throw new IllegalArgumentException("Posição inválida");
		    }

		    for (int i = this.totalDeAlunos - 1; i >= posicao; i-=1) {
		      this.alunos[i + 1] = this.alunos[i];
		    }

		    this.alunos[posicao] = aluno;
		    this.totalDeAlunos++;
		  }

		  private boolean posicaoValida(int posicao) {
		    return posicao >= 0 && posicao <= this.totalDeAlunos;
		  }

		  public Aluno pega(int posicao) {
		    if (!this.posicaoOcupada(posicao)) {
		      throw new IllegalArgumentException("Posição inválida");
		    }
		    return this.alunos[posicao];
		  }

		  private boolean posicaoOcupada(int posicao) {
		    return posicao >= 0 && posicao < this.totalDeAlunos;
		  }

		  public void remove(int posicao) {
		    if (!this.posicaoOcupada(posicao)) {
		      throw new IllegalArgumentException("Posição inválida");
		    }
		    for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
		      this.alunos[i] = this.alunos[i + 1];
		    }
		    this.totalDeAlunos--;
		  }

		  public boolean contem(Aluno aluno) {
			  for (int i = 0; i < this.totalDeAlunos; i++) {
				  if (aluno.equals(this.alunos[i])) {
					  return true;
			      }
			    }
			    return false;
			  }

		  public int tamanho() {
			  return this.totalDeAlunos;
			  }
		  
		  private void garantaEspaco() {
			  if (this.totalDeAlunos == this.alunos.length) {
				  Aluno[] novoArray = new Aluno[this.alunos.length * 2];
			      for (int i = 0; i < this.alunos.length; i++) {
			    	  novoArray[i] = this.alunos[i];
			      }
			      this.alunos = novoArray;
			    }
			  }
		  
		  
		  public String toString() {
			  if (this.totalDeAlunos == 0) {
			    return "[]";
			  }

			  StringBuilder builder = new StringBuilder();
			  builder.append("[");

			  for (int i = 0; i < this.totalDeAlunos - 1; i++) {
			    builder.append(this.alunos[i]);
			    builder.append(", ");
			  }

			  builder.append(this.alunos[this.totalDeAlunos - 1]);
			  builder.append("]");

			  return builder.toString();
			}


	

}
