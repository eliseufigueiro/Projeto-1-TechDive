package servicos;

public class ValidaCPF {

    public static boolean validaCPF(String cpf) {
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") ||
                cpf.equals("33333333333") ||
                cpf.equals("44444444444") ||
                cpf.equals("55555555555") ||
                cpf.equals("66666666666") ||
                cpf.equals("77777777777") ||
                cpf.equals("88888888888") ||
                cpf.equals("99999999999") ||
                (cpf.length() != 11)) {
            return false;
        } else {
            return true;
        }
    }

    public static String removeCaracteresEspeciais(String cpf) {
        if (cpf.contains(".")) {
            cpf = cpf.replace(".", "");
        }
        if (cpf.contains("-")) {
            cpf = cpf.replace("-", "");
        }
        if (cpf.contains("/")) {
            cpf = cpf.replace("/", "");
        }
        return cpf;
    }

    public static String imprimeCPF(String cpf) {
        return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
    }
}
