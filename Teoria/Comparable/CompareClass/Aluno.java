package Teoria.Comparable.CompareClass;

public record Aluno(String nome, int id, String curso) implements Comparable<Aluno> {
    @Override
    public int compareTo(Aluno that) {
        return (int) (this.id - that.id);
    }
}
