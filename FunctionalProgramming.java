import java.util.*;
import io.vavr.collection.Array;
import io.vavr.Tuple2;

class FunctionalProgramming {

    public static void main(String[] args) {

        Map<String, Class> ctm = new HashMap<String, Class>();

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

        ctm.putAll( _ctm );

        System.out.printf("ctm  ->  ");
        System.out.println(ctm);
    }
}
