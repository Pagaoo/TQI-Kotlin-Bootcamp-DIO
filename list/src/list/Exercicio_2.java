package list;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Exercicio_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> respostas = new ArrayList<>();

        System.out.println("Começando interrogatorio: ");
        System.out.print("Você telefonou para a vítima? ");
        String resposta = sc.next();
        respostas.add(resposta);
        System.out.print("Esteve no local do crime? ");
        resposta = sc.next();
        respostas.add(resposta);
        System.out.print("Mora perto da vitima? ");
        resposta = sc.next();
        respostas.add(resposta);
        System.out.print("Devia para a vítima? ");
        resposta = sc.next();
        respostas.add(resposta);
        System.out.print("Já trabalhou com a vítima? ");
        resposta = sc.next();
        respostas.add(resposta);

        int count = 0;
        Iterator<String> itaretor = respostas.iterator();
        while (itaretor.hasNext()) {
            String simNao = itaretor.next();
            if (simNao.contains("s")) {
                count++;
            }
        }
        if (count < 2) {
            System.out.println("INOCENTE");
        } else if (count < 3) {
            System.out.println("SUSPEITA");
        } else if (count < 5) {
            System.out.println("CÚMPLICE");
        } else {
            System.out.println("CULPADO");
        }
    }
}
