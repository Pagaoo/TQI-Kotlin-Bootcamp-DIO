package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

/*Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

public class Exercicio_1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> temperaturas = new ArrayList<>();

        int count = 0;
        do {
            System.out.println("Temperatura média deste mês: ");
            Double temp = sc.nextDouble();
            temperaturas.add(temp);
            count++;
        } while (count < 6);
        System.out.println(temperaturas);

        Double sum = 0d;
        for (Double temperature : temperaturas) {
            sum += temperature;
        }

        double media = 0d;
        media = (sum) / temperaturas.size();
        System.out.printf("A média das temperaturas é de %.1f\n", media);

        Double finalMedia = media;
        temperaturas.stream().filter(t -> t > finalMedia).forEach(t -> System.out.printf("Essas são as temperaturas acima da média: %.1f\n", t));

        Iterator<Double> iterator = temperaturas.iterator();

        count = 0;
        while (iterator.hasNext()) {
            Double temp = iterator.next();
            if (temp > finalMedia) {
                switch (count) {
                    case (0) -> System.out.println("Mês: " + (count + 1) + " JANEIRO " + temp);
                    case (1) -> System.out.println("Mês: " + (count + 1) + " FEVEREIRO" + temp);
                    case (2) -> System.out.println("Mês: " + (count + 1) + " MARÇO " + temp);
                    case (3) -> System.out.println("Mês: " + (count + 1) + " ABRIL " + temp);
                    case (4) -> System.out.println("Mês: " + (count + 1) + " MAIO " + temp);
                    case (5) -> System.out.println("Mês: " + (count + 1) + " JUNHO " + temp);
                    default -> System.out.println("Não houve temperatura acima da média");
                }
            }
            count++;
        }
    }
}
