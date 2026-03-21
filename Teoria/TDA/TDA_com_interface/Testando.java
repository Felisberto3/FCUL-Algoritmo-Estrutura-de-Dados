package Teoria.TDA.TDA_com_interface;

public class Testando {
    public static void main(String[] args) {
        Stack<Integer> pilha = new LinkedStack<>();
        Stack<Integer> pilha2 = new ArrayStack<>();

        System.out.println(pilha.isEmpty());
        System.out.println(pilha2.isEmpty());
        pilha.push(2);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        pilha2.push(4);
        System.out.println(pilha.isEmpty());
        System.out.println(pilha2.isEmpty());

        System.out.println(pilha.peek());
        System.out.println(pilha2.peek());

        pilha.pop();
        pilha2.pop();

        System.out.println(pilha.isEmpty());
        System.out.println(pilha2.isEmpty());

    }
}
