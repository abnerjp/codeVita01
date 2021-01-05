package exercises;

public class SolutionA {

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();

		// CirculoAluno teste = new CirculoAluno(7, 2, 7);
		CirculoAluno teste = new CirculoAluno(10000, 1, 999);
		System.out.println(teste.start());
		long tempoFinal = System.currentTimeMillis();
		System.out.println(String.valueOf((tempoFinal - tempoInicial) / 1000f));

	}

}
