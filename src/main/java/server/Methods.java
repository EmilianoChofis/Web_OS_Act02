package server;

public class Methods {

    String operacion;
    String num1;
    String num2;
    String resultado;


    public String suma(double num1, double num2){
        return num1 +" + "+num2 +" = "+ (num1+num2) +"\n";
    }
    public String resta(double num1, double num2){
        return num1 +" menos "+num2 +" = "+ (num1-num2) +"\n";
    }
    public String multi(double num1, double num2){
        return num1 +" * "+num2 +" = "+ (num1*num2) +"\n";
    }
    public String division(double num1, double num2){
        return num1 +" / "+num2 +" = "+ (num1/num2) +"\n";
    }
    public String potencia(double num1, double num2){
        return num1 +" elevado al "+num2 +" = "+ (Math.pow(num1, num2)) +"\n";
    }
    public String raiz(double num1, double num2){
        return num1 +" a la raiz "+num2 +" = "+ (Math.pow(num1, 1/num2)) +"\n";
    }

    public Methods() {
    }

    public Methods(String operacion, String num1, String num2, String resultado) {
        this.operacion = operacion;
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = resultado;
    }

    public boolean subida(String operacion, String num1, String num2, String resultado) {
        DaoServer daoServer = new DaoServer();
        return daoServer.saveOperation(operacion, num1, num2, resultado);
    }
}
