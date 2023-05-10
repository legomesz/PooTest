public static void main(String[] args) {
    
    Reservatorio reservatorio = new Reservatorio(1, "São Paulo", 100000000);
    
    reservatorio.sangrar(1, 60);
    reservatorio.sangrar(2, 30);
    reservatorio.abastecer(500000);
    
    reservatorio.mostrarDados();
}