import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Impares {
    public static List<Integer> gen_pares(Integer n) {
        return IntStream.iterate(1, x -> x + 1).filter(x -> x % 2 == 0).limit(n).boxed().collect(Collectors.toList());
    }

    public static List<Integer> gen_impares(Integer n) {
        return IntStream.iterate(1, x -> x + 1).filter(x -> x % 2 != 0).limit(n).boxed().collect(Collectors.toList());
    }

    public static List<Integer> gen_cuadrados(Integer n) {
        return IntStream.iterate(1, x -> x + 1).map(x -> x * x).limit(n).boxed().collect(Collectors.toList());
    }

    public static List<Integer> gen_numeros(Function<Integer, List<Integer>> generador, Integer n) {
        return generador.apply(n);
    }

    public static void main(String[] args) {
        /*
         * System.out.println(gen_pares(47));
         * System.out.println(gen_impares(47));
         * System.out.println(gen_cuadrados(5));
         */
        Function<Integer, List<Integer>> gen_pares2 = n -> IntStream.iterate(1, x -> x + 1).filter(x -> x % 2 == 0)
                .limit(n).boxed().collect(Collectors.toList());

        System.out.println(gen_numeros(Impares::gen_pares, 7));
        System.out.println(gen_numeros(Impares::gen_impares, 7));
        System.out.println(gen_numeros(Impares::gen_cuadrados, 7));
        System.out.println(gen_pares2.apply(7));
    }
}
