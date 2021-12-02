package constantes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constantes {

	//quantidade de elementos e tipos de arquivos
    //public static  final Integer[] NOME_ARQUIVO = {500, 1000, 5000, 10000, 50000};
	public static  final Integer[] NOME_ARQUIVO = {500, 1000};
	public static final String[] TIPO_ARQUIVO = {"alea", "inv", "ord"};	
	
	//localização-destino de pastas dos arquivos
	public static final String CAMINHO_TESTE = "src\\arquivos\\";
	public static final String CAMINHO_PROCESSADO = "src\\arquivos\\processado\\";
	public static final String CAMINHO_RELATORIO = "src\\relatorio\\";
	
	//escolhas menu principal
	public static final int TODOS = 1;
	public static final int INSERCAO = 2;
	public static final int QUICKSORT = 3;
	public static final int SHELLSORT = 4;
	public static final int QUICKSORT_COM_INSERCAO = 5;
	public static final int SAIR = 6;
	
	//escolhas arvores menu principal
	public static final int ABB = 2;
	public static final int AVL = 3;
	public static final int HASHING = 4;
		
	//etapas
	public static final int ETAPA_UM_METODOS_ORDENACAO = 1;
	public static final int ETAPA_DOIS_METODOS_PESQUISA = 2;
	
	//iteracoes padrões para gravação de tempo ordenação
	public static final int QUANTIDADE_ITERACOES_PADRAO = 1;
	
	//Posicao informação nos arquivo de texto	
	public static final int NOME_CLIENTE = 0;
	public static final int CPF_CLIENTE = 1;
	public static final int DATA_CLIENTE = 2;
	public static final int VALOR_CLIENTE = 3;
	
	//Informações nos arquivos sobre Clientes Especiais
	public static final int DADOS_CLIENTE_ESPECIAL = 5;
	public static final int VALE_COMPRA_CLIENTE_ESPECIAL = 2;
	public static final int DATA_CLIENTE_ESPECIAL = 3;
	public static final int VALOR_CLIENTE_ESPECIAL = 4;
	
	//info posição datas
	public static final int DIA = 0;
	public static final int MES = 1;
	public static final int ANO = 2;
	
	public static final DateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");
	
	

}
