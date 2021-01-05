package exercises;

public class CirculoAluno {

	private Aluno dozeHoras = null;
	private int estudantes;
	private int turnos;
	private int vizinho;

	public CirculoAluno(int s, int t, int m) {
		this.estudantes = s >= 3 && s <= 10000 ? s : -1;
		this.turnos = t > 0 && t < 10000 ? t : -1;
		this.vizinho = m > 0 && m < 1000 ? m : -1;
		criarCirculo();
	}

	private boolean isValido() {
		return this.estudantes != -1 && this.turnos != -1 && this.vizinho != -1;
	}

	private boolean criarCirculo() {
		if (!isValido()) {
			return false;
		}

		Aluno ultimo, novoAluno;
		this.dozeHoras = new Aluno(1);
		ultimo = this.dozeHoras;
		for (int i = 2; i <= this.estudantes; i++) {
			novoAluno = new Aluno(i, this.dozeHoras, ultimo);
			this.dozeHoras.setAnt(novoAluno);
			ultimo.setProx(novoAluno);
			ultimo = novoAluno;
		}
		
		return true;
	}

	private void movimentar(int qtde) {
		for (int i = 0; i < qtde; i++) {
			if (this.dozeHoras.isPar()) {
				movimentaDireita();
			} else {
				movimentaEsquerda();
			}
		}
	}

	private void movimentaDireita() {
		Aluno posAtual;

		if (this.estudantes % 2 == 0) {
			posAtual = this.dozeHoras;
		} else {
			posAtual = this.dozeHoras.getAnt();
		}
		Aluno posUltimo = posAtual.getProx();
		boolean circulou = false;

		// direita
		int auxiliar;
		while (!posAtual.equals(posUltimo) && !circulou) {
			auxiliar = posAtual.getValor();
			posAtual.setValor(posAtual.getAnt().getValor());
			posAtual.getAnt().setValor(auxiliar);
			posAtual = posAtual.getAnt().getAnt();
			
			circulou = posAtual.equals(this.dozeHoras);
		}
	}

	private void movimentaEsquerda() {
		Aluno posAtual = this.dozeHoras;
		Aluno posUltimo = posAtual.getAnt();
		boolean circulou = false;

		// esquerda
		int auxiliar;
		while (!posAtual.equals(posUltimo) && !circulou) {
			//if (posAtual.getProx().equals(this.dozeHoras) {
			auxiliar = posAtual.getValor();
			posAtual.setValor(posAtual.getProx().getValor());
			posAtual.getProx().setValor(auxiliar);
			posAtual = posAtual.getProx().getProx();
			
			circulou = posAtual.equals(this.dozeHoras);
		}
	}

	private Aluno buscarAluno(int alvo) {
		if (!isValido()) {
			return null;
		}

		Aluno posAtual = this.dozeHoras;
		boolean circulou = false;
		while (!circulou && posAtual.getValor() != alvo) {
			posAtual = posAtual.getProx();
			circulou = posAtual.equals(this.dozeHoras);
		}

		return circulou ? null : posAtual;
	}

	private String exibeVizinhos() {
		Aluno alunoEncontrado = buscarAluno(this.vizinho);
		String msg = alunoEncontrado != null
				? String.valueOf(alunoEncontrado.getProx().getValor()) + " "
						+ String.valueOf(alunoEncontrado.getAnt().getValor())
				: "aluno null";
		return msg;
	}

	public String start() {
		if (!isValido()) {
			return "erro";
		}

		movimentar(this.turnos);
		return exibeVizinhos();
	}

	public int getAlunoAlvo() {
		return this.vizinho;
	}

	public void exibeAlunos() {
		System.out.println("---- Lista de alunos ----");
		if (!isValido()) {
			System.out.println("vazio");
		} else {
			Aluno posAtual = this.dozeHoras;
			boolean circulou = false;
			while (!circulou) {
				System.out.println(String.valueOf(posAtual.getValor()));
				posAtual = posAtual.getProx();
				circulou = posAtual.equals(this.dozeHoras);
			}
		}
	}
}
