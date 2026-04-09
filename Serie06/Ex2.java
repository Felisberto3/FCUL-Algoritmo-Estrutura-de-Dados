package Serie06;

public class Ex2 {
    public static void main(String[] args) {
        ArrayQueue<String> q = new ArrayQueue<>();
        q.enqueue("Fe");
        q.enqueue("lis");

        ArrayQueue<String> r = new ArrayQueue<>(q);
        System.out.println("q: " + q);
        System.out.println("r: " + r);
        r.dequeue();
        System.out.println("q: " + q);
        System.out.println("r: " + r);
    }
}
