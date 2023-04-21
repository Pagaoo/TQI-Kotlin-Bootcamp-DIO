package set.Exercicio_01;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

import java.util.*;

public class Exercicio_01 {
    public static void main(String[] args) {
        LinkedHashSet<String> coresArcoIris = new LinkedHashSet<>();
        coresArcoIris.add("Vermelho");
        coresArcoIris.add("Laranja");
        coresArcoIris.add("Amarelo");
        coresArcoIris.add("Verde");
        coresArcoIris.add("Azul");
        coresArcoIris.add("Índigo");
        coresArcoIris.add("Violeta");
        System.out.println(coresArcoIris);

        System.out.println("Cores uma abaixo da outra: ");
        for (String cor: coresArcoIris) {
            System.out.println(cor);
        }

        System.out.println("O arco-íris possui " + coresArcoIris.size() + " cores");

        System.out.println("Cores em ordem Alfabetica");
        TreeSet<String> coresArcoIris2 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris2);

        System.out.println("Cores na ordem inversa da informada");
        List<String> ordemInversa = new ArrayList<>(coresArcoIris);
        Collections.reverse(ordemInversa);
        System.out.println(ordemInversa);

        System.out.println("Cores começando com a letra V: ");
        Set<String> coresLetraV = new HashSet<>(Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde","Azul", "Índigo", "Violeta"));

        for (String cores: coresLetraV) {
            if (cores.startsWith("V")) {
                System.out.println(cores);
            }
        }

        System.out.println("Cores que não começam com a letra V: ");
        coresLetraV.removeIf(s -> !s.startsWith("V"));
        System.out.println(coresLetraV);

        coresArcoIris.clear();
        coresArcoIris.isEmpty();
        System.out.println("Conjunto Limpo: " + coresArcoIris);

    }
}
