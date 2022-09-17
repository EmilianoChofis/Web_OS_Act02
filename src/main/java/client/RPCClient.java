package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.Methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Scanner;

public class RPCClient {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config =  new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client =  new XmlRpcClient();
        client.setConfig(config);
        String option, num1, num2;
        Methods guardado = new Methods();
        boolean result;
        do {
            System.out.println("elija de acuerdo a lo que desea \n" +
                    "1. + \n" +
                    "2. - \n" +
                    "3. * \n" +
                    "4. / \n" +
                    "5. ^ \n" +
                    "6. √ \n" +
                    "7. salir" );
            option =  sc.next();
            if (isNumber(option)){
                switch (Integer.parseInt(option)){
                    case 1:
                        do {
                            System.out.println("ingresa el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));
                        do {
                            System.out.println("ingresa el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        //llamada al servicio
                        Object [] numbers = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        String response = (String) client.execute("Methods.suma",numbers);
// Ortiz hernandez Emiliano
                        System.out.println(response);


                         result = guardado.subida("suma", num1, num2, response);
                        if (result!=false){
                            System.out.println("Subida ok");
                        }else{
                            System.out.println("subida ok'nt");
                        }
                        break;
                    case 2:
                        do {
                            System.out.println("ingresa el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));
                        do {
                            System.out.println("ingresa el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        Object [] numbersResta = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        response = (String) client.execute("Methods.resta",numbersResta);
                        System.out.println(response);

                       result = guardado.subida("resta", num1, num2, response);
                        if (result!=false){
                            System.out.println("Subida ok");
                        }else{
                            System.out.println("subida ok'nt");
                        }
                        break;
                    case 3:
                        do {
                            System.out.println("ingresa el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));
                        do {
                            System.out.println("ingresa el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        Object [] numbersMulti = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        response = (String) client.execute("Methods.multi",numbersMulti);
                        System.out.println(response);

                        result = guardado.subida("multiplicacion", num1, num2, response);
                        if (result!=false){
                            System.out.println("Subida ok");
                        }else{
                            System.out.println("subida ok'nt");
                        }
                        break;
                    case 4:
                        do {
                            System.out.println("ingresa el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));
                        do {
                            System.out.println("ingresa el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        if (num2.equals("0")){
                            System.out.println("No se puede dividir entre 0");
                        }else{
                            Object [] numbersDivision = {Double.parseDouble(num1), Double.parseDouble(num2)};
                            response = (String) client.execute("Methods.division",numbersDivision);
                            System.out.println(response);

                            result = guardado.subida("division", num1, num2, response);
                            if (result!=false){
                                System.out.println("Subida ok");
                            }else{
                                System.out.println("subida ok'nt");
                            }
                        }


                        break;
                    case 5:
                        do {
                            System.out.println("ingresa el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));
                        do {
                            System.out.println("ingresa el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        Object [] numbersPotencia = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        response = (String) client.execute("Methods.potencia",numbersPotencia);
                        System.out.println(response);

                        result = guardado.subida("potencia", num1, num2, response);
                        if (result!=false){
                            System.out.println("Subida ok");
                        }else{
                            System.out.println("subida ok'nt");
                        }
                        break;
                    case 6:
                        do {
                            System.out.println("ingresa el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));
                        do {
                            System.out.println("ingresa el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        if (Integer.parseInt(num2)<0){
                            System.out.println("no se puede una raiz negativa");
                        }else{
                            Object [] numbersRaiz = {Double.parseDouble(num1), Double.parseDouble(num2)};
                            response = (String) client.execute("Methods.raiz",numbersRaiz);
                            System.out.println(response);

                            result = guardado.subida("raiz", num1, num2, response);
                            if (result!=false){
                                System.out.println("Subida ok");
                            }else{
                                System.out.println("subida ok'nt");
                            }
                        }

                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Ingresa una opcion valida");
                        break;
                }
            }else{
                System.out.println("ingrese un valor valido");
            }
        }while(!option.equals("7"));




    }
    public static boolean isNumber(String number){
        try{
            double num = Double.parseDouble(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }

}
