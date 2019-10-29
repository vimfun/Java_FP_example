import java.util.*;
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
        Array<String> fields = Array.of( "pay_time", "created_time" );

        Map<String, Class> _ctm = fields.toJavaStream()
        
            .map(f -> new Tuple2<String, Class>(f, String.class))

            .reduce(
                new HashMap<String, Class>(),

                (m, fc) -> {
                    m.put(fc._1, fc._2);
                    return m;
                },

                (m1, m2) -> {
                    HashMap<String, Class> m = new HashMap<>();
                    m.putAll(m1);
                    m.putAll(m2);
                    return m;
                }
            );

        Map<String, Class> ctm2 = new HashMap<>();
        ctm2.putAll(ctm);
        ctm2.putAll(_ctm);
        return ctm2;
    }

    public static Map<String, Class> removeModelFields(Map<String, Class> ctm) {
        Array<String> fields = Array.of( "pay_time", "created_time" );

        Map<String, Class> _ctm = fields.toJavaStream()
        
            .map(f -> new Tuple2<String, Class>(f, String.class))

            .reduce(
                new HashMap<String, Class>(),

                (m, fc) -> {
                    m.put(fc._1, fc._2);
                    return m;
                },

                (m1, m2) -> {
                    HashMap<String, Class> m = new HashMap<>();
                    m.putAll(m1);
                    m.putAll(m2);
                    return m;
                }
            );

        Map<String, Class> ctm2 = new HashMap<>();
        ctm2.putAll(ctm);
        fields.forEach(f -> ctm2.remove(f));

        return ctm2;
    }
}
