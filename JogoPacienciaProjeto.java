//nome: Fabio de Campos Bordin Turma ADS - Projeto ED Estrutura de Dados I 


import java.lang.Math.*;
import javax.swing.*;
import java.lang.*;
import java.lang.String.*;

/// autor 

//classe Carta


class Carta
{

      //declaração variavel

	int numero = 0;
	char naipe = ' ';
	boolean status = false;
	
	Carta(){}
	
	Carta(int num, char naip)
	{
		numero = num;
		naipe = naip;
	}
}

// classe Principal Paciência

public class JogoPacienciaProjeto {
	
    public static void main(String[] args)
	{
		Carta Baralho[] = new Carta[52];
		int opcao = 0;
		Carta cartaBaralho = new Carta();
		String opcaoCarta;
		
		for(int i = 0; i < 52; i = i + 1)
		{
			Baralho[i] = new Carta();
		}
		
		do
		{

                    //opção menu Case

      			opcao = Menu();
			
			switch(opcao)
			{
				case 1: Baralho = PreencherVetor(Baralho);
						imprimir(Baralho);
					break;
					
				case 2: Baralho = Embaralhar(Baralho);
						imprimir(Baralho);
					break;
				
				case 3: Baralho = EmbaralharRecursivo(52,Baralho);
						imprimir(Baralho);
					break;
                               
                                case 4: Baralho = BubbleSort(52,Baralho);
						imprimir(Baralho);
					break;
					
			        
					
				case 6: opcaoCarta = JOptionPane.showInputDialog("Digite uma carta");
						cartaBaralho.numero = 1;//Integer.parseInt(opcaoCarta.charAt(0));
						cartaBaralho.naipe = opcaoCarta.charAt(1);
						BuscarCarta(cartaBaralho, Baralho);
					break;
					
				case 0: System.exit(0); 
					break;
					
				default: JOptionPane.showMessageDialog(null,"Carta Invalida");
					break;
			}
		} while(opcao != 0);
	}

    //Opção de Menus - mgsbox (caixas de texto)	
   
	public static int Menu()
	{
		int opcao;
		String msg = "";
		
		msg = msg + "Digite 1 para preparar as cartas para embaralhar  \n";
		msg = msg + "Digite 2 para embaralhar \n";
		msg = msg + "Digite 3 para embaralhar recursivamente \n";
		msg = msg + "Digite 4 para ordenar em bolha \n";
		msg = msg + "Digite 5 para ordenar em merge \n";
		msg = msg + "Digite 6 para buscar carta \n";
		msg = msg + "Digite 0 para sair \n";
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));
		
		return opcao;
	}
	

   //Função para preencher vetor de Cartas

        
	public static Carta[] PreencherVetor(Carta B[])
	{
		int pos;
		
		for(pos = 0; pos < 13; pos = pos + 1)
		{
			B[pos].numero = pos + 1;
			B[pos].naipe = 'c';
			B[pos+13].numero = pos + 1;
			B[pos+13].naipe = 'p';
			B[pos+26].numero = pos + 1;
			B[pos+26].naipe = 'e';
			B[pos+39].numero = pos + 1;
			B[pos+39].naipe = 'o';
		}

		return B;
	}

          //Função para embaralhar (random)
	
	public static Carta[] Embaralhar(Carta B[])
	{
		int pos, dE, dD;
		Carta aux;
		
		for(pos = 1256; pos >= 188; pos = pos - 2)
		{
			dE = (int)(Math.random() * 52);
			dD = (int)(Math.random() * 52);
			
			aux = B[dD];
			B[dD] = B[dE];
			B[dE] = aux;
		}
		
		return B;
	}
         
              //Embaralhar recursivo
         
	public static Carta[] EmbaralharRecursivo(int vezes, Carta B[])
	{
                int dE, dD;
		Carta aux;
               
                if(vezes == 1 || vezes == 0)
                {
                    return B;
                }
                else
                {
                    dE = (int)(Math.random() * 52);
                    dD = (int)(Math.random() * 52);
			
                    aux = B[dD];
                    B[dD] = B[dE];
                    B[dE] = aux;
                        
                    return EmbaralharRecursivo(vezes-1, B);
                }
	}


        //Ordenar Bolha (bubble sort)


          public static Carta[] BubbleSort (int numeros, Carta B [])
    { 
      int n = B.length;
      Carta aux;
      
      for (int i = 0 ; i < n-1 ; i++)
       {
         for (int j = 0 ; j < n-1-i ; j++)
          {
            if (B[j].numero > B[j+1].numero)
            {
              aux = B[j];
              B[j] = B[j+1];
              B[j+1] = aux;
            }
          }
       }
      return B;
    }
  
public static void merge(int[] a, int inicio, int meio, int fim)
  {  
    int n = fim - inicio + 1;        
    int[] b = new int[n]; 

    int i1 = inicio;         
    int i2 = meio + 1;      
    int j = 0;             

    while (i1 <= meio && i2 <= fim)
     {  
       if (a[i1] < a[i2])
        {  
          b[j] = a[i1];
          i1++;
        }
       else
        {  
          b[j] = a[i2];
          i2++;
        }
       j = j + 1;
     }

    while (i1 <= meio)
     {  
       b[j] = a[i1];
       i1 = i1 + 1;
       j = j + 1;
     }
     
    while (i2 <= fim)
     {  
       b[j] = a[i2];
       i2 = i2 + 1;
       j = j + 1;
     }

    for (j = 0; j < n; j++)
     {
       a[inicio + j] = b[j];
     }
  }

   public static void mergeSort(int[] a, int inicio, int fim)
  {  
    if (inicio == fim) 
     {
       return;
     }
    int meio = (inicio + fim) / 2;
    mergeSort(a, inicio, meio);
    mergeSort(a, meio + 1, fim);
    merge(a, inicio, meio, fim);
  }
    
	 //Função Busca

	public static void BuscarCarta(Carta C, Carta B[])
	{
		int pos = 0;
		boolean encontrou = false;
	
		while(!encontrou && pos < 52)
		{
			if(C.numero == B[pos].numero && C.naipe == B[pos].naipe)
			{
				encontrou = true;
			}
			
			pos = pos + 1;
		}
		
		if(encontrou)
		{
			System.out.println(pos - 1);
		}
		else
		{
			System.out.println("Carta não localizada");
		}
	}
      
         //Mostrar carta

	public static void imprimir(Carta B[])
	{
		int pos;
			
		for(pos = 0; pos <52; pos= pos+1)
		{
			System.out.print(B[pos].numero +"" + B[pos].naipe + "  ");
				if(pos%13 == 12)
					System.out.println("\n");
		}
			
		System.out.println("\n\n");
	}
}
