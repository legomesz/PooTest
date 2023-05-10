private int id;
private String cidade;
private double capacidadeMaxima;
private double capacidadeAtual;
private String situacao;

public Reservatorio(int id, String cidade, double capacidadeMaxima) {
    this.id = id;
    this.cidade = cidade;
    this.capacidadeMaxima = capacidadeMaxima;
    this.capacidadeAtual = 0;
    this.situacao = "Vazio";
}

public void abastecer(double volume) {
    this.capacidadeAtual += volume;
    if(this.capacidadeAtual > this.capacidadeMaxima) {
        this.capacidadeAtual = this.capacidadeMaxima;
    }
    definirSituacao();
}

public void sangrar(int nivelVazao, int minutos) {
    double litrosSangrados;
    if(nivelVazao == 1) {
        litrosSangrados = minutos * 25000;
    } else {
        litrosSangrados = minutos * 50000;
    }
    this.capacidadeAtual -= litrosSangrados;
    if(this.capacidadeAtual < 0) {
        this.capacidadeAtual = 0;
    }
    definirSituacao();
}

private void definirSituacao() {
    double fracao = this.capacidadeAtual / this.capacidadeMaxima;
    if(fracao == 0) {
        this.situacao = "Vazio";
    } else if(fracao <= 0.25) {
        this.situacao = "Mínimo";
    } else if(fracao <= 0.75) {
        this.situacao = "Médio";
    } else {
        this.situacao = "Máximo";
    }
}

public void mostrarDados() {
    System.out.println("ID do reservatório: " + this.id);
    System.out.println("Cidade: " + this.cidade);
    System.out.println("Capacidade máxima: " + this.capacidadeMaxima + " litros");
    System.out.println("Capacidade atual: " + this.capacidadeAtual + " litros");
    System.out.println("Situação: " + this.situacao);
}