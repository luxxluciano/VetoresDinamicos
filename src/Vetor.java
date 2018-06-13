

/*Implemente, utilizando a linguagem Java, uma classe que
 apresente o comportamento de um vetor din�mico, com os seguinte m�todos:

inserefinal(valor)
insereInicio(valor)
insere(indice, valor) 
get(indice) -> valor
set(indice)
removeFinal()
removeInicio()
remove(indice)

Regras de implementa��o:
Com exce��o da classe utilizada para teste do vetor,
nenhuma outra classe pode utilizar qualquer classe do pacote java.util.

Como o vetor "sabe" o n�mero de elementos que possui, e controla a �rea de armazenamento de dados,
ele pode extender a sua capacidade de armazenamento quando for necess�rio.

O uso de �ndices deve ser, sempre, validado.

Caso um �ndice seja inv�lido, deve ser gerada uma exce��o ArrayOutOfBoundsException.

Alguns m�todos n�o s�o necess�rios para o funcionamento da estrutura de dados, por�m
s�o muito �teis para o desenvolvimento de aplica��es, e devem ser implementados:

size() -> int : retorna o n�mero de elementos armazenados no vetor.
capacity() -> int : retorna a capacidade de armazenamento do vetor.
isEmpty() -> boolean : retorna "true" se o n�mero de elementos for 0 (zero).*/

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
		      throw new IllegalArgumentException("Posi��o inv�lida");
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
		      throw new IllegalArgumentException("Posi��o inv�lida");
		    }
		    return this.alunos[posicao];
		  }

		  private boolean posicaoOcupada(int posicao) {
		    return posicao >= 0 && posicao < this.totalDeAlunos;
		  }

		  public void remove(int posicao) {
		    if (!this.posicaoOcupada(posicao)) {
		      throw new IllegalArgumentException("Posi��o inv�lida");
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
