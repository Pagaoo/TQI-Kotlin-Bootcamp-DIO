/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

import java.util.*;

public class Exercicio_01 {
    public static void main(String[] args) {
        Map<String, Integer> estadosNE = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println("Estados do Nordeste " + estadosNE);
        estadosNE.put("RN", 3534165);
        System.out.println("Estados do Nordeste com a mudança de RN " + estadosNE);

        estadosNE.put("PB", 4039277);
        System.out.println("Estados do Nordeste com PB: " + estadosNE);

        System.out.println("População do estado de PE: " + estadosNE.get("PE"));

        Map<String, Integer> estadosNE2 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};

        System.out.println("Informando os estados na ordem de inserção: " + estadosNE2);

        Map<String, Integer> estadosNE3 = new TreeMap<>(estadosNE2);
        System.out.println("Estados em ordem alfabetica: " + estadosNE3);

        Collection<Integer> populacao = estadosNE3.values();
        String maiorPopulacao = "";
        String menorPopulacao = "";

        for (Map.Entry<String, Integer> popu: estadosNE3.entrySet()) {
            if (popu.getValue().equals(Collections.max(populacao))) maiorPopulacao = popu.getKey();
            if (popu.getValue().equals(Collections.min(populacao))) menorPopulacao = popu.getKey();
        }
        System.out.println("Estado com menor população: " + menorPopulacao + " " + Collections.min(populacao));
        System.out.println("Estado com maior população: " + maiorPopulacao + " " + Collections.max(populacao));

        int soma = 0;
        for (Integer integer : estadosNE3.values()) {
            soma += integer;
        }
        System.out.println("Soma de população dos estados: " + soma);

        System.out.println("Soma de população dos estados: " + soma/estadosNE3.size());

        estadosNE3.values().removeIf(integer -> integer <= 4000000);

        System.out.println("Estados com população acima de 4 000 000: " + estadosNE3);

        estadosNE3.clear();

        System.out.println("Lista de estados vaiza: " + estadosNE3);

        System.out.println("A lista está vazia? " + estadosNE3.isEmpty());
    }
}
