package set.Exercicio_02;

import java.util.*;

public class Exercicio_02 {
    public static void main(String[] args) {
        Set<Linguagem> linguagem = new LinkedHashSet<>();
        linguagem.add(new Linguagem("Python", 1991, "Pycharm"));
        linguagem.add(new Linguagem("Java", 1995, "IntelliJ"));
        linguagem.add(new Linguagem("TypeScript", 2012, "Visual Studio Code"));
        linguagem.add(new Linguagem("Kotlin", 2012, "Android Studio"));
        linguagem.add(new Linguagem("Java", 1995, "Android Studio"));


        System.out.println("------------------------------------------------------------");
        System.out.println("Ordem de inserção: " + linguagem);

        System.out.println("------------------------------------------------------------");
        System.out.println("Ordem natural por nome:");
        Set<Linguagem> linguagemOrdemNatural = new TreeSet<>(linguagem);
        for (Linguagem linguagem1: linguagemOrdemNatural) System.out.println(linguagem1);

        System.out.println("------------------------------------------------------------");
        System.out.println("Comparar pela IDE em ordem: ");
        Set<Linguagem> linguagemIDE = new TreeSet<>(new CompareIde());
        linguagemIDE.addAll(linguagem);
        for (Linguagem lang: linguagemIDE) System.out.println(lang);

        System.out.println("------------------------------------------------------------");
        System.out.println("Comparar por Ano de criação se forem iguais, por Nome: ");
        Set<Linguagem> linguagemAnoNome = new TreeSet<>(new CompareAnoNome());
        linguagemAnoNome.addAll(linguagem);
        for (Linguagem ano: linguagemAnoNome) System.out.println(ano);

        System.out.println("------------------------------------------------------------");
        System.out.println("Comparar por Nome se forem iguais, por Ano de criação, se o Ano de criação forem iguais, por IDE: ");
        Set<Linguagem> linguagemAnoNomeIde = new TreeSet<>(new CompareNomeAnoIde());
        linguagemAnoNomeIde.addAll(linguagem);
        for (Linguagem compare: linguagemAnoNomeIde) System.out.println(compare);
    }
}

class Linguagem implements Comparable<Linguagem> {
    public String nome;
    public Integer anoDeCriacao;
    public String IDE;

    public Linguagem(String nome, Integer anoDeCriacao, String IDE) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.IDE = IDE;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIDE() {
        return IDE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linguagem linguagem = (Linguagem) o;
        return Objects.equals(nome, linguagem.nome) && Objects.equals(anoDeCriacao, linguagem.anoDeCriacao) && Objects.equals(IDE, linguagem.IDE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, IDE);
    }

    @Override
    public String toString() {
        return "Linguagem{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", IDE='" + IDE + '\'' +
                '}';
    }

    @Override
    public int compareTo(Linguagem linguagem) {
        return this.nome.compareTo(linguagem.nome);
    }
}

class CompareIde implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem l1, Linguagem l2) {
        return l1.getIDE().compareTo(l2.getIDE());
    }
}

class CompareAnoNome implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem l1, Linguagem l2) {
        int ano =  Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if (ano != 0 ) return ano;
        return l1.getNome().compareToIgnoreCase(l2.getNome());
    }
}

class CompareNomeAnoIde implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem l1, Linguagem l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        if (nome != 0) return nome;

        int ano = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if (ano != 0) return ano;

        return l1.getIDE().compareToIgnoreCase(l2.getIDE());
    }
}
