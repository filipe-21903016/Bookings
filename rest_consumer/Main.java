import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String email = null;
    public static boolean checkDateRange(String in, String out)
    {
        try{
            LocalDate dateIn = LocalDate.parse(in, DateTimeFormatter.ofPattern("d/MM/yyyy"));
            LocalDate dateOut = LocalDate.parse(out, DateTimeFormatter.ofPattern("d/MM/yyyy"));
            return dateIn.isBefore(dateOut);
        }catch (DateTimeParseException e) {
            return false;
        }
    }

    public static String getMenu() {
        String authenticated = "";
        if (email != null)
            authenticated = "Autenticado como " + email;

        String menu = "HOTEL CHARME\n" +
                authenticated +
                "\n" +
                "1 - Menu Inicial\n" +
                "2 - Reservar Quarto\n" +
                "3 - Cancelar Quarto\n" +
                "4 - Listar Quartos\n" +
                "5 - Registar Utilizador\n" +
                "6 - Log In\n" +
                "7 - Minhas reservas\n" +
                "0 – Sair\n";
        return menu;
    }

    private static String ask(String output){
        Scanner in = new Scanner(System.in);
        System.out.print(output);
        String line = in.nextLine();
        while(line != null){
            break;
        }
        return line;
    }

    private static boolean isNumeric(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int option;
        RestHandler handler = new RestHandler();
        System.out.println(getMenu());
        do {

            String input;
            do {
                input = ask("Opção?\n");
                if (!isNumeric(input)) {
                    System.out.println("Opção Inválida. Prima 1 para ver o menu.\n");
                }
            } while (!isNumeric(input));
            option = Integer.parseInt(input);

            switch (option) {
                case 1:
                    System.out.println(getMenu());
                    break;

                case 2:
                    String dataInicial;
                    String dataFinal;
                    String numeroPessoas = "";
                    String roomId = "";
                    if (email == null){
                        System.out.println("Crie conta ou faça log in\n");
                        System.out.println(getMenu());
                        break;
                    }

                    do{
                        dataInicial = ask("Introduza a data inicial: (dd/MM/yyyy)\n");
                        dataFinal = ask("Introduza a data final: (dd/MM/yyyy)\n");
                        if (!checkDateRange(dataInicial, dataFinal))
                        {
                            System.out.println("Introduza as datas corretamente");
                            continue;
                        }
                        numeroPessoas = ask("Introduza o número de Pessoas:\n");
                        roomId = ask("Introduza o número do quarto:\n");
                        String res = handler.bookRoom(dataInicial, dataFinal, email, Integer.parseInt(numeroPessoas),
                                Integer.parseInt(roomId));
                        if (res != null && !res.equals("null"))
                            System.out.println("A reserva foi realizada com sucesso, para mais informações consulte \"Minhas Reservas\"");
                        else
                            System.out.println("Não foi possível efetuar a reserva");
                    }while(!isNumeric(numeroPessoas) || !isNumeric(roomId) || dataFinal.length() != 10
                            || dataInicial.length() != 10);
                    break;

                case 3:
                    if (email == null){
                        System.out.println("Crie conta ou faça log in\n");
                        System.out.println(getMenu());
                        break;
                    }
                    do{
                        roomId = ask("Introduza o id da reserva:\n");
                        if (handler.cancel(roomId))
                        {
                            System.out.println("A reserva foi cancelada com sucesso");
                            break;
                        }
                        else
                            System.out.println("Ocorreu um erro. Não foram efetuadas alterações");
                    }while(!isNumeric(roomId));
                    break;

                case 4:
                    do{
                        dataInicial = ask("Introduza a data inicial: (dd/MM/yyyy)\n");
                        dataFinal = ask("Introduza a data final: (dd/MM/yyyy)\n");
                        if (!checkDateRange(dataInicial, dataFinal))
                        {
                            dataInicial = "";
                            dataFinal = "";
                            System.out.println("Ocorreu um erro na escolha das datas");
                            continue;
                        }
                        ArrayList<String> quartos =  handler.listRooms(dataInicial, dataFinal);
                        if (quartos == null)
                            System.out.println("Não existem quartos disponiveis");
                        else
                        {
                            for (String quarto: quartos)
                            {
                                JSONObject object = handler.getFloorAndCapacity(Integer.parseInt(quarto));
                                System.out.println("Id: " + quarto +
                                        " | Capacity: " + object.get("capacity").toString() +
                                        " | Floor: " + object.get("floor").toString());
                            }

                        }
                    }while(dataFinal.length() != 10 || dataInicial.length() != 10);
                    break;

                case 5:
                    String username;
                    String pass;
                    boolean registered = false;
                    do{
                        username = ask("email: ");
                        pass = ask("password: ");
                        registered = handler.register(username, pass);
                    }while(!registered);
                    email = username;
                    System.out.println("");
                    System.out.println(getMenu());
                    break;

                case 6:
                    System.out.println("Log in:");
                    do{
                        username = ask("email: ");
                        pass = ask("password: ");
                        if (handler.login(username, pass))
                            email = username;
                    }while(email == null);
                    System.out.println("");
                    System.out.println(getMenu());
                    break;

                case 7:
                    ArrayList<JSONObject> reservas = handler.bookingByEmail(email);
                    System.out.println("Reservas:");
                    for (JSONObject reserva:reservas) {
                        System.out.println("Id:" + reserva.get("id") +
                                " | CheckIn Date: " + reserva.get("checkInDate") +
                                " | CheckOut Date: " + reserva.get("checkOutDate") +
                                " | roomId: " + reserva.get("roomId"));
                    }
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opção Inválida. Prima 1 para ver o menu.\n");
                    break;
            }
        } while (option != 0);

    }

}

