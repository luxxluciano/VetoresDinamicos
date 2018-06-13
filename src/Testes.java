import java.util.Scanner;

public class Testes {
	

		  public void main(String[] args) {
			  
			  while(true) menu();
			  
		}
		  
		  
//		  /	----------	MENU  -------------
			public void menu() {
				String str = "\n-----------------";
				str += "\nMENU";
				str += "\n-----------------";
				str += "\n1- AdicionaNoFim";
				str += "\n2- AdicionaPorPosicao";
				str += "\n3- PegaPorPosicao";
				str += "\n4- RemovePorPosicao";
				str += "\n5- ContemAluno()";
				str += "\n6- TamanhoLista()";
				str += "\n7- AdicionaInicio";
				str += "\n-----------------";
				str += "\nEscolha: ";

				int resp = Integer.parseInt(teclado(str));

				switch(resp){
					case 1: AdicionaNoInicio();		break;
					case 2: AdicionaPorPosicao();	break;
					case 3: PegaPorPosicao();		break;
					case 4: RemovePorPosicao();		break;
					case 5: ContemAluno();			break;
					case 6: TamanhoLista();			break;
					case 7: AdicionaNoFim();		break;
			
				}//--fecha switch
			}//--fecha menu
		  
		  
		  
		public void AdicionaNoInicio() {
			
		}
		  

		  public void AdicionaNoFim() {
		    Aluno a1 = new Aluno();
		    Aluno a2 = new Aluno();

		    a1.setNome("João");
		    a2.setNome("José");

		    Vetor lista = new Vetor();

		    lista.adiciona(a1);
		    lista.adiciona(a2);

		    System.out.println(lista);
		  }
		  
		  
		  public void AdicionaPorPosicao() {
			    Aluno a1 = new Aluno();
			    Aluno a2 = new Aluno();
			    Aluno a3 = new Aluno();

			    a1.setNome("Rafael");
			    a2.setNome("Paulo");
			    a3.setNome("Ana");

			    Vetor lista = new Vetor();

			    lista.adiciona(a1);
			    lista.adiciona(0, a2);
			    lista.adiciona(1, a3);

			    System.out.println(lista);
			  }

		  
		  public void PegaPorPosicao() {
			    Aluno a1 = new Aluno();
			    Aluno a2 = new Aluno();

			    a1.setNome("Rafael");
			    a2.setNome("Paulo");

			    Vetor lista = new Vetor();

			    lista.adiciona(a1);
			    lista.adiciona(a2);

			    Aluno aluno1 = lista.pega(0);
			    Aluno aluno2 = lista.pega(1);
			    
			    System.out.println(aluno1);
			    System.out.println(aluno2);
			  }
		  
		  public void RemovePorPosicao() {
			    Aluno a1 = new Aluno();
			    Aluno a2 = new Aluno();

			    a1.setNome("Rafael");
			    a2.setNome("Paulo");

			    Vetor lista = new Vetor();

			    lista.adiciona(a1);
			    lista.adiciona(a2);

			    lista.remove(0);
			    
			    System.out.println(lista);
			  }
		  
		  
		  public void ContemAluno() {
			    Aluno a1 = new Aluno();
			    Aluno a2 = new Aluno();

			    a1.setNome("Rafael");
			    a2.setNome("Paulo");

			    Vetor lista = new Vetor();

			    lista.adiciona(a1);
			    lista.adiciona(a2);

			    System.out.println(lista.contem(a1));

			    System.out.println(lista.contem(a2));

			    Aluno aluno = new Aluno();
			    aluno.setNome("Ana");

			    System.out.println(lista.contem(aluno));
			  }
		  
		  
		  public void TamanhoLista() {
			    Aluno a1 = new Aluno();
			    Aluno a2 = new Aluno();
			    Aluno a3 = new Aluno();

			    a1.setNome("Rafael");
			    a2.setNome("Paulo");

			    Vetor lista = new Vetor();

			    lista.adiciona(a1);
			    lista.adiciona(a2);

			    System.out.println(lista.tamanho());
			        
			    lista.adiciona(a3);

			    System.out.println(lista.tamanho());
			  }
		  
		  
		  
//			TECLADO
@SuppressWarnings("resource")
private static String teclado(String str) {
	System.out.println(str);
	return new Scanner(System.in).next();
}

		  
		  
		  
		  
}// fecha Testes