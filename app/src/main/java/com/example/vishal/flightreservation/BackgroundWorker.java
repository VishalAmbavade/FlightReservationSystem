package com.example.vishal.flightreservation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        String login_url = "http://vaambavade.000webhostapp.com/login.php";
        String register_url = "http://vaambavade.000webhostapp.com/register.php";
        String ticket_url = "http://vaambavade.000webhostapp.com/ticketConfirm.php";


        if (type.equals("login")) {
            try {
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") +
                        "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                //httpURLConnection.disconnect();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("register")) {
            try {
                String name = params[1];
                String surname = params[2];
                String age = params[3];
                String userName = params[4];
                String password = params[5];

                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8")
                        + "&" + URLEncoder.encode("surname", "UTF-8") + "=" + URLEncoder.encode(surname, "UTF-8")
                        + "&" + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(age, "UTF-8")
                        + "&" + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8")
                        + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("ticket")) {

            try {

                String airline = params[1];
                String flightNo = params[2];
                String source = params[3];
                String destination = params[4];
                String arrivalTime = params[5];
                String deptTime = params[6];
                String name = params[7];
                String phone = params[8];
                String passport = params[9];
                String adhaar = params[10];
                String date = params[11];
                String mail = params[12];
                String Class = params[13];
                String seats = params[14];
                String price = params[15];
                String ticketNumber = params[16];

                URL url = new URL(ticket_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("airline", "UTF-8") + "=" + URLEncoder.encode(airline, "UTF-8")
                        + "&" + URLEncoder.encode("flightNo", "UTF-8") + "=" + URLEncoder.encode(flightNo, "UTF-8")
                        + "&" + URLEncoder.encode("source", "UTF-8") + "=" + URLEncoder.encode(source, "UTF-8")
                        + "&" + URLEncoder.encode("destination", "UTF-8") + "=" + URLEncoder.encode(destination, "UTF-8")
                        + "&" + URLEncoder.encode("arrivalTime", "UTF-8") + "=" + URLEncoder.encode(arrivalTime, "UTF-8")
                        + "&" + URLEncoder.encode("deptTime", "UTF-8") + "=" + URLEncoder.encode(deptTime, "UTF-8")
                        + "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8")
                        + "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8")
                        + "&" + URLEncoder.encode("passport", "UTF-8") + "=" + URLEncoder.encode(passport, "UTF-8")
                        + "&" + URLEncoder.encode("adhaar", "UTF-8") + "=" + URLEncoder.encode(adhaar, "UTF-8")
                        + "&" + URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")
                        + "&" + URLEncoder.encode("mail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8")
                        + "&" + URLEncoder.encode("Class", "UTF-8") + "=" + URLEncoder.encode(Class, "UTF-8")
                        + "&" + URLEncoder.encode("seats", "UTF-8") + "=" + URLEncoder.encode(seats, "UTF-8")
                        + "&" + URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8")
                        + "&" + URLEncoder.encode("ticketNumber", "UTF-8") + "=" + URLEncoder.encode(ticketNumber, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();


        if (result.equals("Login successful")) {
            Intent intent = new Intent(context, MenuActivity.class);
            context.startActivity(intent);
        }

        if (result.equals("User added")) {
            Intent intent2 = new Intent(context, MainActivity.class);
            context.startActivity(intent2);
        }

        if (result.equals("Ticket Booked!!!")) {
            Toast.makeText(context, "Ticket Booked", Toast.LENGTH_SHORT).show();
            Intent intent3 = new Intent(context, FinishActivity.class);
            context.startActivity(intent3);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
