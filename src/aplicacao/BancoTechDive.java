package aplicacao;

import entidades.Conta;
import servicos.MenuPrincipal;

import java.util.ArrayList;
import java.util.Locale;

public class BancoTechDive {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        boolean menu = false;

        while (menu == false) {
            int menuOpc = menuPrincipal.menu();
            menu = menuPrincipal.menuPrincipalEscolha(menuOpc);
        }
    }
}
