import com.fasterxml.jackson.databind.node.BooleanNode;
import com.treasure_data.model.TableSchema;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class RestHandler {
    private String url;

    public RestHandler() {
        this.url = "http://localhost:8080/HotelREST/rest";
    }

    public ArrayList<String> listRooms(String inDate, String outDate) {
        try {
            URL url = new URL(this.url + "/rooms?checkInDate="+ inDate +"&checkOutDate="+outDate);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            Scanner scanner;
            String response;
            if (conn.getResponseCode() != 200) {
                return null;
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            response = scanner.next();
            scanner.close();
            conn.disconnect();
            ArrayList<String> roomsIds = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length();i++)
                roomsIds.add(jsonArray.get(i).toString());
            return roomsIds;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String bookRoom(String checkInDate, String checkOutDate, String clientEmail, int numberOfPeople, int roomId){
        try {
            URL url = new URL(this.url + "/book");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"Book\":{\"checkInDate\":\"" + checkInDate + "\",\"checkOutDate\":\"" + checkOutDate +
                    "\",\"clientEmail\":\"" + clientEmail + "\",\"numberOfPeople\":" + numberOfPeople +
                    ",\"roomId\":"+roomId+"}}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            Scanner scanner;
            String response;
            if (conn.getResponseCode() != 200) {
                return null;
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            response = scanner.next();
            scanner.close();
            conn.disconnect();
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.get("id").toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean cancel(String id){
        try {
            URL url = new URL(this.url + "/cancel");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"Book\":{\"id\":\""+ id +"\"}}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            Scanner scanner;
            String response;
            if (conn.getResponseCode() != 200) {
                return false;
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            response = scanner.next();
            scanner.close();
            conn.disconnect();
            JSONObject jsonObject = new JSONObject(response);
            return Boolean.parseBoolean(jsonObject.get("response").toString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean register(String email, String password) {
        try {
            URL url = new URL(this.url + "/register");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"Client\":{\"email\":\""+ email+"\",\"password\":\""+password+"\"}}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            Scanner scanner;
            String response;
            if (conn.getResponseCode() != 200) {
                return false;
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            response = scanner.next();
            scanner.close();
            conn.disconnect();
            JSONObject jsonObject = new JSONObject(response);
            return Boolean.parseBoolean(jsonObject.get("response").toString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean login(String email, String password) {
        try {
            URL url = new URL(this.url + "/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"Client\":{\"email\":\""+ email+"\",\"password\":\""+password+"\"}}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            Scanner scanner;
            String response;
            if (conn.getResponseCode() != 200) {
                return false;
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            response = scanner.next();
            scanner.close();
            conn.disconnect();
            JSONObject jsonObject = new JSONObject(response);
            return Boolean.parseBoolean(jsonObject.get("response").toString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<JSONObject> bookingByEmail(String email) {
        try {
            URL url = new URL(this.url + "/books");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"Client\":{\"email\":\"" + email + "\"}}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            Scanner scanner;
            String response;
            if (conn.getResponseCode() != 200) {
                return null;
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            response = scanner.next();
            scanner.close();
            conn.disconnect();

            ArrayList<JSONObject> bookings = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length();i++) {
                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                bookings.add(jsonObject);
            }
            return bookings;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getFloorAndCapacity(int roomId)
    {
        try {
            URL url = new URL(this.url + "/room?roomId="+ roomId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            Scanner scanner;
            String response;
            if (conn.getResponseCode() != 200) {
                return null;
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            response = scanner.next();
            scanner.close();
            conn.disconnect();
            return new JSONObject(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
