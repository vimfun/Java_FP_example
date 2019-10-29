import java.util.*;
import io.vavr.collection.Array;

class FunctionalProgramming {

    public static void main(String[] args) {

        Map<String, Class> ctm = new HashMap<String, Class>();

        Array<String> fields = Array.of( "pay_time", "created_time" );

        for (String f : fields) {
            ctm.put(f, String.class);
        }

        System.out.printf("ctm  ->  ");
        System.out.println(ctm);
    }
}
