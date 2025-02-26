import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println(" ");

            System.out.println("Por favor selecione a numeração do exercício desejado!");
            System.out.println(" 01 - Cadastro de Usuário Completo");
            System.out.println(" 02 - Calculadora de Média de Notas");
            System.out.println(" 03 - Conversor de Moedas");
            System.out.println(" 04 - Calculadora de Idade em Dias");
            System.out.println(" 05 - Calculadora de Descontos Progressivos");
            System.out.println(" 06 - Verificador de Ano Bissexto");
            System.out.println(" 07 - Calculadora de Imposto de Renda");
            System.out.println(" 08 - Classificação de Triângulos");
            System.out.println(" 09 - Validador de Senha");
            System.out.println(" 10 - Jogo de Adivinhação");
            System.out.println(" 11 - Sequência Numérica Personalizada");
            System.out.println(" 12 - Contagem de Palavras");

            System.out.println(" 00 - Sair");

            String exercise = sc.nextLine();


            if (!numberValidator(exercise)) {
                System.out.println("Digite apenas o número da opção!");
                System.out.println(" ");
                continue;
            }

            int CExercise = stringToInt(exercise);
            System.out.println(" ");

            if (CExercise == 0) {
                break;
            }
            else if (CExercise == 1) {
                try {
                    System.out.print("Agora iremos realizar seu cadastro!");
                    System.out.println(" ");
                    while (true) {
                        System.out.println(" ");
                        System.out.print("Digite seu nome completo: ");
                        String name = sc.nextLine();

                        if (!stringValidator(name)) {
                            System.out.println("Nome inválido - Retorme o processo e digite os dados corretamente!");
                            continue;
                        }

                        System.out.print("Digite a sua idade: ");
                        String age = sc.nextLine();

                        if (!numberValidator(age)) {
                            System.out.println("Idade inválida - Retorme o processo e digite os dados corretamente!");
                            continue;
                        }

                        System.out.print("Digite o nome completo da sua mãe: ");
                        String motherName = sc.nextLine();

                        if (!stringValidator(motherName)) {
                            System.out.println("Nome da mãe inválido - Retorme o processo e digite os dados corretamente!");
                            continue;
                        }

                        System.out.print("Digite o nome completo do seu pai: ");
                        String fatherName = sc.nextLine();

                        if (!stringValidator(fatherName)) {
                            System.out.println("Nome do pai inválido - Retorme o processo e digite os dados corretamente!");
                            continue;
                        }

                        int NSName = name.replaceAll(" ", "").length();
                        int NSMotherName = motherName.replaceAll(" ", "").length();
                        int NSFatherName = fatherName.replaceAll(" ", "").length();

                        System.out.println(" ");
                        System.out.println("***Dados registrados*** \n" +
                                "Nome: " + name + "\n" +
                                "Idade: " + age + "\n" +
                                "Nome da mãe: " + motherName + "\n" +
                                "Nome do pai: " + fatherName);

                        if (NSName > NSFatherName && NSName > NSMotherName) {
                            System.out.println("Seu nome é maior que o do seu pai e da sua mãe!");
                        } else if (NSName < NSFatherName && NSName > NSMotherName) {
                            System.out.println("Seu nome é maior que o da sua mãe, e menor que o do seu pai!");
                        } else if (NSName > NSFatherName && NSName < NSMotherName) {
                            System.out.println("Seu nome é maior que o do seu pai, mas menor que o da sua mãe");
                        } else if (NSName < NSFatherName && NSName < NSMotherName) {
                            System.out.println("Seu nome é menor que o do seu pai e da sua mãe!");
                        } else {
                            System.out.println("Os nomes de vocês três são exatamente do mesmo tamanho, Uau!");
                        }

                        break;
                    }
                } catch (Exception ex) {
                    System.out.print(String.format("Ocorreu um erro: %s.", ex.getMessage()));
                }
            }
            else if (CExercise == 2) {

                try {
                    while (true) {

                        System.out.println("Digite 4 notas bimestrais de 0 à 10 com espaçamento entre elas: (Formato X X X X)");
                        String grades = sc.nextLine();

                        if (!numberValidatorTwo(grades)) {
                            System.out.println("Valor inválido!");
                            System.out.println(" ");
                            continue;
                        }

                        String[] numbers = grades.split(" ");
                        int[] CNumbers = new int[numbers.length];

                        for (int i = 0; i < numbers.length; i++) {
                            CNumbers[i] = Integer.parseInt(numbers[i]);
                        }

                        double CGrade = Arrays.stream(CNumbers).average().orElse(0);

                        System.out.println(" ");
                        System.out.println("Sua média é: " + CGrade);

                        if (CGrade < 5) {
                            System.out.println("Você foi reprovado!");
                        } else if (CGrade >= 7) {
                            System.out.println("Você foi aprovado!");
                        } else {
                            System.out.println("Você está em recuperação");
                        }

                        break;
                    }
                } catch (Exception ex) {
                    System.out.print(String.format("Ocorreu um erro: %s ", ex.getMessage()));
                }

            }
            else if (CExercise == 3) {
                try {
                    while (true) {

                        Map<Integer, Moeda> moedas = new HashMap<>();
                        moedas.put(1, new Moeda(1, "Dólar Americano", "USD", 5.75));
                        moedas.put(2, new Moeda(2, "Euro", "EUR", 6.05));
                        moedas.put(3, new Moeda(3, "Libra Esterlina", "GBP", 7.29));


                        System.out.print("Digite o montante em reais: R$ ");
                        String currency = sc.nextLine();

                        if (!numberValidator(currency)) {
                            System.out.println("Valor inválido!");
                            System.out.println(" ");
                            continue;
                        }

                        double CCurrency = stringToDouble(currency);

                        System.out.println(" ");
                        System.out.println("Para qual moeda você deseja converter (Digite o número correspondente) ?");
                        System.out.println("01 - USD");
                        System.out.println("02 - EURO");
                        System.out.println("03 - Libra Esterlina");
                        String currencyConvertion = sc.nextLine();

                        if (!numberValidator(currencyConvertion)) {
                            System.out.println("Valor inválido - inicie o processo novamente!");
                            System.out.println(" ");
                            continue;
                        }

                        int CCurrencyConvertion = stringToInt(currencyConvertion);
                        double converted;

                        if (CCurrencyConvertion == 1) {
                            converted = CCurrency / moedas.get(CCurrencyConvertion).getValue();
                        } else if (CCurrencyConvertion == 2) {
                            converted = CCurrency / moedas.get(CCurrencyConvertion).getValue();
                        } else if (CCurrencyConvertion == 3) {
                            converted = CCurrency / moedas.get(CCurrencyConvertion).getValue();
                        } else {
                            System.out.println("Valor inválido - inicie o processo novamente");
                            System.out.println(" ");
                            continue;
                        }

                        DecimalFormat df = new DecimalFormat("#.00");

                        System.out.println(" ");
                        System.out.println("O câmbio para " + moedas.get(CCurrencyConvertion).getName() +
                                " está em " + moedas.get(CCurrencyConvertion).getValue() +
                                ". Para R$ " + df.format(CCurrency) + " reais, o montante final é de " +
                                "" + moedas.get(CCurrencyConvertion).getAcronym() + " " + df.format(converted));

                        break;
                    }
                } catch (Exception ex) {
                    System.out.println(String.format("Ocorreu um erro: %s", ex.getMessage()));
                }
            }
            else if (CExercise == 4) {
                try
                {
                    while (true)
                    {

                        LocalDate now = LocalDate.now();                        System.out.println("Digite a sua data de nascimento (Formato XX/XX/XXXX): ");
                        String birthday = sc.nextLine();

                        if (!dateValidator(birthday)){
                            System.out.println("Data fora do padrão!");
                            System.out.println(" ");
                            continue;
                        }

                        LocalDate CBirtday = dateConverter(birthday);


                        long difDays = now.toEpochDay() - CBirtday.toEpochDay();

                        System.out.println(" ");
                        System.out.println(String.format("Voce tem %s dias vividos.", difDays));

                        break;
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(String.format("Ocorreu um errro: %s", ex.getMessage()));
                }
            }
            else if (CExercise == 5) {
                try
                {
                    while (true) {
                        System.out.print("Digite o valor da sua compra: ");
                        String value = sc.nextLine();
                        System.out.println(" ");

                        if (!numberValidator(value)) {
                            System.out.println("Valor inválido!");
                            System.out.println(" ");
                            continue;
                        }

                        double CValue = stringToDouble(value);

                        double discount;

                        if (CValue > 1000)
                        {
                            discount = CValue * 0.1;

                        } else if (CValue > 500 && CValue <= 1000)
                        {
                            discount = CValue * 0.05;
                        } else
                        {
                            discount = 0;
                        }

                        DecimalFormat df = new DecimalFormat("#.00");
                        double totalToPay = CValue - discount;

                        System.out.print("O valor total da sua compra: R$ " + df.format(CValue) +
                                           "\nNesta compra voce teve R$ " + df.format(discount) + " de desconto.\n" +
                                           "Valor total para pagamento: R$ " + df.format(totalToPay));
                        System.out.println(" ");

                        break;

                    }

                } catch (Exception ex)
                {
                    System.out.println(String.format("Ocorreu um erro: %s", ex.getMessage()));
                }
            }
            else if (CExercise == 6) {
                try
                {
                    while(true)
                    {
                        System.out.print("Digite um ano (Formato XXXX): ");
                        String year = sc.nextLine();
                        System.out.println(" ");

                        if (!numberValidator(year))
                        {
                            System.out.println("Valor inválido!");
                            System.out.println(" ");
                            continue;
                        }

                        int CYear = stringToInt(year);

                        if ((CYear % 4 == 0 && CYear % 100 != 0) || CYear % 400 == 0)
                        {
                            System.out.println("Ano Bissexto (366 dias)!");
                        }
                        else{
                            System.out.println("Ano Regular (365 dias)");
                        }

                        break;

                    }
                } catch (Exception ex)
                {
                    System.out.printf(String.format("Ocorreu um erro: %s.", ex.getMessage()));
                }
            }
            else if (CExercise == 7) {
                try
                {
                    while (true)
                    {
                        //https://www.creditas.com/exponencial/tabela-imposto-de-renda/
                        System.out.print("Digite seu salario anual (Formato X.XX): R$ ");
                        String yearlyWage = sc.nextLine();
                        System.out.println(" ");

                        if (!numberValidator(yearlyWage))
                        {
                            System.out.println("Valor inválido!");
                            System.out.println(" ");
                            continue;
                        }


                        double CYearlyWage = stringToDouble(yearlyWage);
                        double discount;
                        int category;

                        if (CYearlyWage <= 27870.40)
                        {
                            discount = 0;
                            category = 1;
                        }
                        else if(CYearlyWage >= 27870.41 && CYearlyWage <= 37751.55)
                        {
                            discount = CYearlyWage * 0.075 - 2089.83;
                            category = 2;
                        }
                        else if (CYearlyWage >= 37751.56 && CYearlyWage <= 50148.25)
                        {
                            discount = CYearlyWage * 0.15 - 5268.16;
                            category = 3;
                        }
                        else if(CYearlyWage >= 50148.26 && CYearlyWage <= 64259.59)
                        {
                            discount = CYearlyWage * 0.225 - 9576.05;
                            category = 4;
                        }
                        else
                        {
                            discount = CYearlyWage * 0.275 - 13932.41;
                            category = 5;
                        }

                        double liquidValue = CYearlyWage - discount;

                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ganho anual: R$ " + df.format(CYearlyWage) +
                                           "\nDesconto IRPF: R$ " + df.format(discount) +
                                           "\nDesconto categoria: " + category +
                                           "\nValor líquido anual: R$ " + df.format(liquidValue));

                        break;

                    }
                }
                catch (Exception ex)
                {
                    System.out.println(String.format("Ocorreu um erro: %s.", ex.getMessage()));
                }
            }
            else if (CExercise == 8) {
                try
                {
                    while (true)
                    {
                        System.out.print("Digite tres números espaçados para o lado A, B e C do triângulo  (Formato X X X): ");
                        String sides = sc.nextLine();

                        if (!numberValidatorTwo(sides))
                        {
                            System.out.println("Valor inválido!");
                            System.out.println(" ");
                            continue;
                        }

                        String[] numbers = sides.split(" ");
                        double[] CNumbers = new double[numbers.length];

                        for (int i = 0; i < numbers.length; i++){
                            CNumbers[i] = Double.parseDouble(numbers[i]);
                        }

                        double sideA = CNumbers[0];
                        double sideB = CNumbers[1];
                        double sideC = CNumbers[2];

                        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)
                        {
                            System.out.println("Os lados formam um triângulo válido.");
                            System.out.println(" ");

                            if (sideA == sideB && sideB == sideC)
                            {
                                System.out.println("Triângulo Equilátero: Todos os lados são iguais.");
                                break;
                            }
                            else if (sideA == sideB || sideA == sideC || sideB == sideC)
                            {
                                System.out.println("Triângulo Isósceles: Dois lados são iguais.");
                                break;
                            }
                            else
                            {
                                System.out.println("Triângulo Escaleno: Todos os lados são diferentes.");
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("Os lados NÃO formam um triângulo válido, tente novamente.");
                            System.out.println(" ");
                            continue;
                        }



                    }
                }
                catch (Exception ex)
                {
                    System.out.println(String.format("Ocorreu um erro: %s", ex.getMessage()));
                }
            }
            else if (CExercise == 9) {
                try
                {
                    System.out.print("Digite uma senha: ");
                    String password = sc.nextLine();
                    System.out.println(" ");

                    int count = 3;

                    while(count > 0) {
                        System.out.print("Confirme a sua senha: ");
                        String passwordCheck = sc.nextLine();

                        if (Objects.equals(passwordCheck, password))
                        {
                            System.out.println("Senha confirmada com sucesso!");
                            System.out.println(" ");
                            break;
                        }
                        count--;

                        if(count == 0){
                            System.out.println("tentativas excedidas!");
                            System.out.println(" ");
                            break;
                        }

                        String trying = count == 1 ? "tentativa" : "tentativas";
                        System.out.println("Tente novamente, voce possui mais " + count + " " + trying);
                        System.out.println(" ");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(String.format(ex.getMessage()));
                }

            }
            else if (CExercise == 10) {
                try
                {
                    int random = (int)(Math.random()* 101);

                    int count = 5;
                    while (count > 0)
                    {
                        System.out.println(String.format("Digite um chute, voce tem %s tentativas.", count));
                        String guess = sc.nextLine();

                        if (!numberValidator(guess))
                        {
                            System.out.println("Valor inválido!");
                            System.out.println(" ");
                            continue;
                        }

                        int CGuess = Integer.parseInt(guess);

                        if(CGuess == random)
                        {
                            System.out.println(String.format("Acertou, o número misterioso era %s mesmo!.", CGuess));
                            break;
                        }
                        else if (CGuess < random)
                        {
                            System.out.println("Seu chute foi abaixo, tente um pouco mais pra cima!");
                            count--;
                            continue;
                        }
                        else if (CGuess > random)
                        {
                            System.out.println("Seu chute foi acima, tente um pouco mais pra baixo!");
                            count--;
                            continue;
                        }
                    }
                    if (count == 0)
                    {
                        System.out.println(String.format("Ops, suas tentativas se esgotaram :/, o número misterioso era %s.", random));
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(String.format("Ocorreu um erro: %s", ex.getMessage()));
                }
            }
            else if (CExercise == 11) {
                try
                {
                    System.out.print("Digite um valor inteiro para ser incrementado: ");
                    String value = sc.nextLine();

                    if (!numberValidator(value))
                    {
                        System.out.println("Valor inválido!");
                        System.out.println(" ");
                        continue;
                    }

                    System.out.print("Agora digite um valor inteiro para ser o incremento: ");
                    String increment = sc.nextLine();

                    if (!numberValidator(increment))
                    {
                        System.out.println("Valor inválido!");
                        System.out.println(" ");
                        continue;
                    }

                    int CValue = stringToInt(value);
                    int CIncrement = stringToInt(increment);

                    for (  ; CValue <= 100 + CIncrement; CValue += CIncrement){
                        System.out.println(String.format("%s, %s", value, CValue));
                    }

                }
                catch (Exception ex)
                {
                    System.out.println(String.format("Ocorreu um erro: %s.", ex.getMessage()));
                }
            }
            else if (CExercise == 12) {
                try
                {
                    System.out.println("Digite uma frase aleatoria com, ao menos, 5 palavras!");
                    String phrase = sc.nextLine();

                    String[] CPhrase = phrase.trim().split("\\s+");

                    int wordCount = CPhrase.length;

                    System.out.println(" ");
                    System.out.println(String.format("Sua frase contem %s palavras!", wordCount));

                }
                catch (Exception ex)
                {
                    System.out.println(String.format("Ocorreu um erro: %s.", ex.getMessage()));
                }
            }
        }
        sc.close();
    }


    public static boolean stringValidator(String str) {
        return str.matches("[a-zA-Z\\s!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]*");
    }

    public static boolean numberValidator(String num) {
        return num.matches("^(-?\\d+(\\.\\d+)?)$");
    }

    public static boolean numberValidatorTwo(String num) {
        return num.matches("^(-?\\d+)(\\s-?\\d+)*$");
    }

    public static int stringToInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static double stringToDouble(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }


    public static boolean dateValidator(String str) {
        return str.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }

    public static LocalDate dateConverter(String str) throws NumberFormatException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(str, formatter);
    }
}

