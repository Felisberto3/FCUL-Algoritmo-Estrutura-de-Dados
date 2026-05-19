package Teoria.Comparable.CompareClass;

import java.util.List;

public class Turma {

    public static void main(String[] args) {
        List<Aluno> alunos = List.of(
                new Aluno("FElis", 3, "LEI"),
                new Aluno("Alberto", 5, "LEI"),
                new Aluno("Kalenhe", 8, "LEI"),
                new Aluno("MUkinda", 4, "LEI"),
                new Aluno("FElis", 9, "LEI"));

        alunos.sort((x, y) -> (x.id() - y.id()));
        alunos.forEach(System.out::print);
    }
}
