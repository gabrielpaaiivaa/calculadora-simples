// Crie um programa que pergunte dois números e uma operação ao usuário
// (+, -, *, ou /). Em guidance, exiba o resultado da operação escolhida.
//
// Exemplo de entrada:
//
// Número 1: 10
// Número 2: 5
// Operação: +
// Exemplo de saída:
//
// Resultado: 15

package exercicios_if_else;

import java.util.InputMismatchException;
import java.util.Scanner;

public class calculadora_simples {

    public static double calcular(double num1, double num2, String operador){
        if (operador.equals("+")){
            return num1 + num2;
        }
        else if (operador.equals("-")){
            return num1 - num2;
        }
        else if (operador.equals("/")){
            if (num2 == 0){
                throw new ArithmeticException("Erro. A divisão por zero não é permitida.");
            }
            return num1 / num2;
        }
        else if (operador.equals("*")){
            return num1 * num2;
        }
        else {
           throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }

    public static void main(String[] args) {

        double num1 = 0, num2 = 0;
        String operador = "";

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Digite o primeiro número: ");
                num1 = sc.nextDouble();
                System.out.println("Digite o segundo número: ");
                num2 = sc.nextDouble();
                // Por causa do buffer preciso fazer isso:
                sc.nextLine();
                System.out.println("Digite o operador que você quer: ");
                operador = sc.nextLine();

                //Verificar se o operador é valido:
                if (!operador.equals("+") && !operador.equals("-") && !operador.equals("*") && !operador.equals("/")) {
                    throw new IllegalArgumentException("Operador inválido: " + operador);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro. Você deve digitar um número.");
                sc.nextLine();
            }
        }

        try{
            double resultado = calcular(num1, num2, operador);
            System.out.println("Resultado: "+ resultado);
        }
        catch(IllegalArgumentException e){
            // O getMessage() pega a mensagem que eu informei no throw
            System.out.println(e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
