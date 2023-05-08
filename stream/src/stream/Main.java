package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> randomNumbers = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        randomNumbers.stream().skip(3).forEach(System.out::println);

        System.out.println("Retirando os números repetidos da lista, quantos números ficam?");

        long list2 = randomNumbers.stream().distinct().count();
        System.out.println(list2);

        System.out.print("Mostre o menor valor da lista: ");
        randomNumbers.stream().mapToInt(Integer::parseInt).min().ifPresent(System.out::println);

        System.out.println("Pegue apenas os números pares e some: ");
        int somaPares = randomNumbers.stream().mapToInt(Integer::parseInt).filter(i -> i % 2 == 0).sum();
        System.out.println(somaPares);

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> randomNumbersI = randomNumbers.stream().map(Integer::parseInt).toList();
        List<Integer> ordemNumerica = randomNumbersI.stream().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(ordemNumerica);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        Map<Boolean, List<Integer>> multiplo3e5 = randomNumbersI.stream()
                .collect(Collectors.groupingBy(n -> (n % 3 == 0) || (n % 5 == 0)));
        System.out.println(multiplo3e5);
    }
}
