import java.lang.Math;
import java.util.function.Function;


public class Main {

    public static Function<Double, Double> function;

    public static void main(String[] args) throws Exception {

        function = x -> x * x * x - x - 2; // x^3 -x -2

        try{
            calcularRaizMetodoBolzano(1.0, 2.0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static double calcularRaizMetodoBolzano(double a, double b) throws Exception {
        // Verificar si es posible aplicar el metodo.
        double a1 = aplicarValorEnFuncion(a);
        double b1 = aplicarValorEnFuncion(b);
        double valorIzquierda = a;
        double valorDerecha = b;
        if((a1 > 0 && b1 > 0) || (a1 < 0 && b1 < 0)){
            throw new Exception("No se puede calcular raiz");
        }

        double media = (a+b)/2;
        double c = aplicarValorEnFuncion(media);
        System.out.println(c);

        while(true){
            if((a1 < 0 && c < 0) || (a1>0 && c>0)){
                a1 = aplicarValorEnFuncion(media);
                valorIzquierda = media;
            }else{
                b1 = aplicarValorEnFuncion(media);
                valorDerecha = media;
            }

            media = (valorIzquierda + valorDerecha)/2;
            c = aplicarValorEnFuncion(media);
            System.out.println(c);
        }



    }
    // Realizar el calculo.
    public static double aplicarValorEnFuncion(double valor){
        return(function.apply(valor));
    }

    public static double calcularPuntoFijo(double x0){
        
    }

}