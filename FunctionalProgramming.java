import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import io.vavr.collection.Array;
import io.vavr.Tuple2;

class FunctionalProgramming {

    public static void main(String[] args) {

        Map<String, Class> ctm = new HashMap<String, Class>();

        Map<String, Class> ctm2 = addModelFields(ctm);

        System.out.printf("ctm  ->  %s\n", ctm  );
        System.out.printf("ctm2 ->  %s\n", ctm2 );

        System.out.printf("--------------------------------------------------------------------------------\n");

        Map<String, Class> ctm3 = removeModelFields(ctm2);

        System.out.printf("ctm  ->  %s\n", ctm  );
        System.out.printf("ctm2 ->  %s\n", ctm2 );
        System.out.printf("ctm3 ->  %s\n", ctm3 );
    }

    public static Map<String, Class> addModelFields(Map<String, Class> ctm) {
        return modifyModelFields(ctm).apply(ctm2 -> f -> ctm2.put(f, String.class));
    }

    public static Map<String, Class> removeModelFields(Map<String, Class> ctm) {
        return modifyModelFields(ctm).apply(ctm2 -> f -> ctm2.remove(f));
    }

    private static Function<Function<Map<String, Class>, Consumer<String>>, Map<String, Class>> modifyModelFields(Map<String, Class> ctm) {
        return ffn -> {
            Array<String> fields = Array.of( "pay_time", "created_time" );
            Map<String, Class> ctm2 = new HashMap<>();
            ctm2.putAll(ctm);
            fields.forEach( ffn.apply(ctm2) );
            return ctm2;
        };
    }
}
