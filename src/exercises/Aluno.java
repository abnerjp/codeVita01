package exercises;

public class Aluno {
	
	private Integer valor;
	private Aluno prox = null;
	private Aluno ant = null;
	
	public Aluno(Integer valor, Aluno prox, Aluno ant) {
		this.valor = valor;
		this.prox = prox;
		this.ant = ant;
	}
	
	public Aluno(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Aluno getProx() {
		return prox;
	}
	public void setProx(Aluno prox) {
		this.prox = prox;
	}
	public Aluno getAnt() {
		return ant;
	}
	public void setAnt(Aluno ant) {
		this.ant = ant;
	}
	
	public boolean isPar() {
		return (this.valor % 2) == 0;
	}
	
	public Aluno getCopy() {
		return new Aluno (this.valor, this.prox, this.ant);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
