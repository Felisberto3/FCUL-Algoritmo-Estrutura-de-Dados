package Teoria.TDA.TDA_sem_interface;

public class Testando {
    public static void main(String[] args) {
        LinkedStack<Integer> pilha = new LinkedStack<>();
        System.out.println(pilha.isEmpty());
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        System.out.println(pilha.isEmpty());
        System.out.println(pilha.peek());
        pilha.pop();
        // pilha.pop();
        // pilha.pop();
        // pilha.pop();
        System.out.println(pilha.peek());
    }
}
