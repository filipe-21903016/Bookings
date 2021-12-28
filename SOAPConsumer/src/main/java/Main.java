
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
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
                "0 - Sair\n";
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
  
    
    public static void main(String[] args){
        int option;
        SOAPHandler handler = new SOAPHandler();
        System.out.println(getMenu());
        do {
            String input;
            do {
                input = ask("Opcao?\n");
                if (!isNumeric(input)) {
                    System.out.println("Opcao Invalida. Prima 1 para ver o menu.\n");
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
                        System.out.println("Crie conta ou faca log in\n");
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
                        numeroPessoas = ask("Introduza o numero de Pessoas:\n");
                        roomId = ask("Introduza o numero do quarto:\n");
                        String res = handler.bookRoom(dataInicial, dataFinal, email, Integer.parseInt(numeroPessoas),
                                Integer.parseInt(roomId));
                        if (res != null)
                            System.out.println("A reserva foi realizada com sucesso, para mais informacoes consulte \"Minhas Reservas\"");
                        else
                            System.out.println("Nao foi efetuar a reserva");
                    }while(!isNumeric(numeroPessoas) || !isNumeric(roomId) || dataFinal.length() != 10
                            || dataInicial.length() != 10);
                    break;

                case 3:
                    if (email == null){
                        System.out.println("Crie conta ou faca log in\n");
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
                            System.out.println("Ocorreu um erro. Nao foram efetuadas alteracoes");
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
                            System.out.println("Nao existem quartos disponiveis");
                        else
                        {
                            for (String quarto: quartos)
                            {
                                String response = handler.getFloorAndCapacity(Integer.parseInt(quarto));
                                String[] data = response.split(",");
                                System.out.println("Id: " + quarto +
                                        " | Capacity: " + data[0] +
                                        " | Floor: " + data[1]);
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
                	List<String> reservas = handler.bookingByEmail(email);
                    System.out.println("Reservas:");
                    for (String reserva:reservas) {
                    	String[] reserva_details = reserva.split(",");
                        System.out.println("Id:" + reserva_details[3] +
                                " | CheckIn Date: " + reserva_details[0] +
                                " | CheckOut Date: " + reserva_details[1] +
                                " | roomId: " + reserva_details[2]);
                    }
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opcao Invalida. Prima 1 para ver o menu.\n");
                    break;
            }
        } while (option != 0);

    }
}

